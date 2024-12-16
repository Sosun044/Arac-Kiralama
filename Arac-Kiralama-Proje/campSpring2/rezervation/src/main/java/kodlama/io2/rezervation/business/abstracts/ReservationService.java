package kodlama.io2.rezervation.business.abstracts;

import kodlama.io2.rezervation.business.requests.CreateReservationRequest;
import kodlama.io2.rezervation.business.responses.GetAllReservationsResponse;
import kodlama.io2.rezervation.business.responses.GetReservationByIdResponse;

import java.util.List;

public interface ReservationService {
    List<GetAllReservationsResponse> getAll();
    GetReservationByIdResponse getById(int id);
    void add(CreateReservationRequest request);
    void delete(int id);
}
