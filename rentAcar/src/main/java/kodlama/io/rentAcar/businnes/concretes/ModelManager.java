package kodlama.io.rentAcar.businnes.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.rentAcar.businnes.abstracts.ModelService;
import kodlama.io.rentAcar.businnes.request.CreateModelRequest;
import kodlama.io.rentAcar.businnes.response.GetAllModelResponse;
import kodlama.io.rentAcar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentAcar.dataAccess.abstracts.ModelRepository;
import kodlama.io.rentAcar.entities.concretes.Model;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllModelResponse> getAll() {
        List<Model> models = modelRepository.findAll();

        List<GetAllModelResponse> modelsResponse = models.stream()
                .map(model -> this.modelMapperService.forResponse().map(model, GetAllModelResponse.class)).toList();

        return modelsResponse;
    }

    @Override
    public void add(CreateModelRequest createModelRequest) {
       Model model = this.modelMapperService.forRequest().map(createModelRequest, Model.class);
        this.modelRepository.save(model);
    }
    
}
