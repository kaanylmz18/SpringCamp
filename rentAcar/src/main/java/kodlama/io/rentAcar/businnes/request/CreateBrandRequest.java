package kodlama.io.rentAcar.businnes.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateBrandRequest {
    @NotNull
    @NotBlank
    @Size(min = 3,max = 20)
    private String name;
}
