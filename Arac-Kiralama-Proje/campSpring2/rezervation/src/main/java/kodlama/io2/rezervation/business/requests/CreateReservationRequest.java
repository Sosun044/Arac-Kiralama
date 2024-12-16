package kodlama.io2.rezervation.business.requests;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateReservationRequest {
    @NotNull
    private int carId;

    @NotNull
    private int customerId;

    @NotNull
    @Future
    private LocalDate startDate;

    @NotNull
    @Future(message = "Start date must be in the future.")
    private LocalDate endDate;

    @NotNull
    private double dailyPrice;
}
