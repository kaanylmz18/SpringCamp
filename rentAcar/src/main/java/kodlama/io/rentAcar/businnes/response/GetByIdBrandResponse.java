package kodlama.io.rentAcar.businnes.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetByIdBrandResponse {

    private int id;
    private String name;

}
