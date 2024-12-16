package kodlama.io2.rezervation.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "reservations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "car_id", nullable = false)
    private int carId;

    @Column(name = "customer_id", nullable = false)
    private int customerId;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "total_price", nullable = false)
    private double totalPrice;

    @Column(name = "status", nullable = false) // 1 - Active, 2 - Completed, 3 - Cancelled
    private int status;
}
