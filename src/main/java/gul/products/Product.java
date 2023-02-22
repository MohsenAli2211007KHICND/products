package gul.products;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Product {
    private Long id;
    private String productName;
    private String shortDescription;
    private String longDescription;
    private String imageUrl;
    private Double price;

}
