package kodlama.io2.rezervation.business.rules;

import kodlama.io2.rezervation.core.exceptions.BusinessException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ReservationBusinessRules {

    public void checkIfReservationDatesValid(LocalDate startDate, LocalDate endDate) {
        if (endDate.isBefore(startDate)) {
            throw new BusinessException("End date cannot be before start date.");
        }
    }
}
