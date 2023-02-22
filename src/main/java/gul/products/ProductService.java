package gul.products;

import java.util.List;

public interface ProductService {
    Product saveProdcut(Product product);
    Product getAProdcut(Long id);
    Product updateProduct(Product product);
    void deleteAProduct(Long id);
    List<Product> getAllProducts();
}
