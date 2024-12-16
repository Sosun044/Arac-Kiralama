package kodlama.io2.rezervation.business.concretes;

import kodlama.io2.rezervation.business.abstracts.ReservationService;
import kodlama.io2.rezervation.business.requests.CreateReservationRequest;
import kodlama.io2.rezervation.business.responses.GetAllReservationsResponse;
import kodlama.io2.rezervation.business.responses.GetReservationByIdResponse;
import kodlama.io2.rezervation.business.rules.ReservationBusinessRules;
import kodlama.io2.rezervation.core.utilities.mappers.ModelMapperService;
import kodlama.io2.rezervation.dataAccess.abstracts.ReservationRepository;
import kodlama.io2.rezervation.entities.concretes.Reservation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReservationManager implements ReservationService {
    private ReservationRepository reservationRepository;
    private ModelMapperService modelMapperService;
    private ReservationBusinessRules reservationBusinessRules;

    @Override
    public List<GetAllReservationsResponse> getAll() {
        List<Reservation> reservations = reservationRepository.findAll();
        return reservations.stream()
                .map(reservation -> modelMapperService.map(reservation, GetAllReservationsResponse.class)) // map() methodu ile dönüşüm
                .collect(Collectors.toList());
    }

    @Override
    public GetReservationByIdResponse getById(int id) {
        Reservation reservation = reservationRepository.findById(id).orElseThrow();
        return modelMapperService.map(reservation, GetReservationByIdResponse.class); // map() methodu ile dönüşüm
    }

    @Override
    public void add(CreateReservationRequest request) {
        reservationBusinessRules.checkIfReservationDatesValid(request.getStartDate(), request.getEndDate());
        Reservation reservation = modelMapperService.map(request, Reservation.class); // map() methodu ile dönüşüm
        reservation.setStatus(1); // Active
        long daysBetween = ChronoUnit.DAYS.between(request.getStartDate(), request.getEndDate());
        double totalPrice = daysBetween * request.getDailyPrice(); // Günlük fiyat * toplam gün sayısı
        reservation.setTotalPrice(totalPrice);
        reservationRepository.save(reservation);
    }

    @Override
    public void delete(int id) {
        reservationRepository.deleteById(id);
    }
}
