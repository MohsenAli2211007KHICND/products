package gul.products;

import java.util.Optional;

import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;

public class ProductServiceImp implements ProductService{

        private ProductRepository productRepository;
        


    public ProductServiceImp(ProductRepository productRepository) {
            this.productRepository = productRepository;
        }



    public Product saveProdcut(Product product) {
        Optional<Product> savedProduct = productRepository.findByProductName(product.getProductName());
        if(savedProduct.isPresent()){
            throw new InvalidConfigurationPropertyValueException("Name", product.getProductName(), "Product name"+product.getProductName()+" is already exist in database");
        }
        return productRepository.save(product);
    }

}
