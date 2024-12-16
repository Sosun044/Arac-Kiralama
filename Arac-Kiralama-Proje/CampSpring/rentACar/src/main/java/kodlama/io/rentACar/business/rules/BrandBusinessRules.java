package kodlama.io.rentACar.business.rules;

import kodlama.io.rentACar.core.utilities.exceptions.BusinessException;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;


@AllArgsConstructor
@Service
public class BrandBusinessRules {
    private BrandRepository brandRepository;

    public void checkIfBrandNameExists(String name){
        if (this.brandRepository.existsByName(name)){
            throw  new BusinessException("Brand already exists");
        }
    }
    public void checkIfBrandmanufacturingYear(int year){
        if(year < 1990 || year > LocalDate.now().getYear()){
            throw new BusinessException("Invalid manufacturing year");

        }
    }
}
