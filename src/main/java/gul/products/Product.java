package gul.products;

import lombok.Data;

@Data
public class Product {
    private Long id;
    private String productName;
    private String shortDescription;
    private String LongDescription;
    private String imageUrl;
    private Double price;

}
