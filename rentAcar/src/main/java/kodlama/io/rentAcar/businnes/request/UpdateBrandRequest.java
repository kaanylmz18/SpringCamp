package kodlama.io.rentAcar.businnes.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class UpdateBrandRequest {
        private int id;
        private String name;
    }

