package kodlama.io.rentAcar.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.rentAcar.businnes.abstracts.BrandService;
import kodlama.io.rentAcar.businnes.request.CreateBrandRequest;
import kodlama.io.rentAcar.businnes.request.UpdateBrandRequest;
import kodlama.io.rentAcar.businnes.response.GetAllBrandResponse;
import kodlama.io.rentAcar.businnes.response.GetByIdBrandResponse;
import lombok.AllArgsConstructor;

@RestController // ANNOTATİON
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {
    private BrandService brandService;

    @GetMapping()
    public List<GetAllBrandResponse> getAll() {
        return brandService.getAll();
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(CreateBrandRequest createBrandRequest) {
        this.brandService.add(createBrandRequest);
    }

    @GetMapping("/{id}")
    public GetByIdBrandResponse getById(@PathVariable int id) {
        return brandService.getById(id);
    }

    @PutMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void update(@RequestBody UpdateBrandRequest updateBrandRequest) {
        this.brandService.update(updateBrandRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        this.brandService.delete(id);
    }

}
