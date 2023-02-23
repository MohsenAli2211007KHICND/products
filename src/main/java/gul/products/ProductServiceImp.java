package gul.products;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImp implements ProductService{

        private ProductRepository productRepository;
        


    public ProductServiceImp(ProductRepository productRepository) {
            this.productRepository = productRepository;
        }



    public Product saveProdcut(Product product) {
        Optional<Product> savedProduct = productRepository.findByname(product.getName());
        if(savedProduct.isPresent()){
            throw new InvalidConfigurationPropertyValueException("Name", product.getName(), "Product name"+product.getName()+" is already exist in database");
        }
        return productRepository.save(product);
    }
    public Product getAProdcut(Long id){
        return productRepository.getReferenceById(id);
    }
    public Product updateProduct(Product product){
        Optional<Product> savedCart = productRepository.findByname(product.getName());
        if(savedHotel.isEmpty()){
            throw new InvalidConfigurationPropertyValueException("Name",product.getName(), "Product name"+product.getName()+" is not exist in database");
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
