package kodlama.io2.rezervation.webApi.controllers;

import kodlama.io2.rezervation.business.abstracts.ReservationService;
import kodlama.io2.rezervation.business.requests.CreateReservationRequest;
import kodlama.io2.rezervation.business.responses.GetAllReservationsResponse;
import kodlama.io2.rezervation.business.responses.GetReservationByIdResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
@AllArgsConstructor
public class ReservationsController {
    private ReservationService reservationService;

    @GetMapping("/getall")
    public List<GetAllReservationsResponse> getAll() {
        return reservationService.getAll();
    }

    @GetMapping("/{id}")
    public GetReservationByIdResponse getById(@PathVariable int id) {
        return reservationService.getById(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody CreateReservationRequest request) {
        reservationService.add(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        reservationService.delete(id);
    }
}
