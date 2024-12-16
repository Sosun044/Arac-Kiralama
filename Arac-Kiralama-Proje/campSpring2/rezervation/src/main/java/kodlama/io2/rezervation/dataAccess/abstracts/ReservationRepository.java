package kodlama.io2.rezervation.dataAccess.abstracts;

import kodlama.io2.rezervation.entities.concretes.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    // Özel sorgular gerekirse buraya eklenebilir
}
