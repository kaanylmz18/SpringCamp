package kodlama.io.rentAcar.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.rentAcar.businnes.abstracts.ModelService;
import kodlama.io.rentAcar.businnes.request.CreateModelRequest;
import kodlama.io.rentAcar.businnes.response.GetAllModelResponse;
import lombok.AllArgsConstructor;

@RestController // ANNOTATİON
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelsController {
    private ModelService modelService;

    @GetMapping()
    public List<GetAllModelResponse> getAll() {
        return modelService.getAll();
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody CreateModelRequest createModelRequest) {
        this.modelService.add(createModelRequest);
    }

   

}
