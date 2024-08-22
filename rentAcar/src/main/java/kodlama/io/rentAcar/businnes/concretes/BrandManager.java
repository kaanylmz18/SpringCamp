package kodlama.io.rentAcar.businnes.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.rentAcar.businnes.abstracts.BrandService;
import kodlama.io.rentAcar.businnes.request.CreateBrandRequest;
import kodlama.io.rentAcar.businnes.request.UpdateBrandRequest;
import kodlama.io.rentAcar.businnes.response.GetAllBrandResponse;
import kodlama.io.rentAcar.businnes.response.GetByIdBrandResponse;
import kodlama.io.rentAcar.businnes.rules.BrandBusinessRules;
import kodlama.io.rentAcar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentAcar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentAcar.entities.concretes.Brand;
import lombok.AllArgsConstructor;

@Service // bu sınıf bir business nesnesidir
@AllArgsConstructor
public class BrandManager implements BrandService {
    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;
    private BrandBusinessRules brandBusinessRules;

    @Override
    public List<GetAllBrandResponse> getAll() {
        // İŞ KURALLARI
        List<Brand> brands = brandRepository.findAll();

        List<GetAllBrandResponse> brandsResponse = brands.stream()
                .map(brand -> this.modelMapperService.forResponse().map(brand, GetAllBrandResponse.class)).toList();

        return brandsResponse;

    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());
        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public GetByIdBrandResponse getById(int id) {
        Brand brand = this.brandRepository.findById(id).orElseThrow();
        GetByIdBrandResponse response = this.modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);

        return response;

    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
        this.brandRepository.save(brand);

    }

    @Override
    public void delete(int id) {
        this.brandRepository.deleteById(id);

    }

}
