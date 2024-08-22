package kodlama.io.rentAcar.businnes.rules;

import org.springframework.stereotype.Service;

import kodlama.io.rentAcar.core.utilities.exceptions.BusinessException;
import kodlama.io.rentAcar.dataAccess.abstracts.BrandRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BrandBusinessRules {
    private BrandRepository brandRepository;
    
    public void checkIfBrandNameExists(String name){
        if (this.brandRepository.existsByName(name)) {
            throw new BusinessException("Brand Already Exists");
        }

    }
    
}
