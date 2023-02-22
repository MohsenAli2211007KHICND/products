package gul.products;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Product {
    private Long id;
    private String productName;
    private String shortDescription;
    private String LongDescription;
    private String imageUrl;
    private Double price;

}
