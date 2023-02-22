package gul.products;

public interface ProductService {
    Product saveProdcut(Product product);
    Product getAProdcut(Long id);
    Product updateProduct(Product product);
}
