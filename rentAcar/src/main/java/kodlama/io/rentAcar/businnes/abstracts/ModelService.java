package kodlama.io.rentAcar.businnes.abstracts;

import java.util.List;

import kodlama.io.rentAcar.businnes.request.CreateModelRequest;
import kodlama.io.rentAcar.businnes.response.GetAllModelResponse;

public interface ModelService {
    List<GetAllModelResponse> getAll();
    void add(CreateModelRequest createModelRequest);
    
}
