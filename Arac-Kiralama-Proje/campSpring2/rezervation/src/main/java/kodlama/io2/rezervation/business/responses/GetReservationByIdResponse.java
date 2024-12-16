package kodlama.io2.rezervation.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetReservationByIdResponse {
    private int id;
    private int carId;
    private int customerId;
    private String startDate;
    private String endDate;
    private double totalPrice;
    private int status;
}
