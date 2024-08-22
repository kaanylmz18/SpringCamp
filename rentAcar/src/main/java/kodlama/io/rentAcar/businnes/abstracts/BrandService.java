package kodlama.io.rentAcar.businnes.abstracts;

import java.util.List;

import kodlama.io.rentAcar.businnes.request.CreateBrandRequest;
import kodlama.io.rentAcar.businnes.request.UpdateBrandRequest;
import kodlama.io.rentAcar.businnes.response.GetAllBrandResponse;
import kodlama.io.rentAcar.businnes.response.GetByIdBrandResponse;

public interface BrandService {
    List<GetAllBrandResponse> getAll();
    GetByIdBrandResponse getById(int id);
    void add(CreateBrandRequest createBrandRequest);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete(int id);
}
