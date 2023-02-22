package gul.products;

import java.util.List;
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
    public Product getAProdcut(Long id){
        return productRepository.getReferenceById(id);
    }
    public Product updateProduct(Product product){
        Optional<Product> savedHotel = productRepository.findByProductName(product.getProductName());
        if(savedHotel.isEmpty()){
            throw new InvalidConfigurationPropertyValueException("Name",product.getProductName(), "Product name"+product.getProductName()+" is not exist in database");
        }
        return productRepository.save(product);
    }
    public void deleteAProduct(Long id){
        productRepository.deleteById(id);
    }
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
}
