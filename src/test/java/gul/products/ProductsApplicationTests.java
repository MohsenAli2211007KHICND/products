package gul.products;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductsApplicationTests {

	@Mock
	private ProductRepository productRepository;
	@InjectMocks
	private ProductServiceImp productServiceImp;

	@Test
	void contextLoads() {
	}
	@Test
	void getAndSetProductId(){
		Long id = 1L;
		Product pro = new Product();
		pro.setId(id);
		assertEquals(id, pro.getId());
	}
	@Test
	void getAndSetProductName(){
		String productName = "Ruby Slippers";
		Product pro = new Product();
		pro.setProductName(productName);
		assertEquals(productName, pro.getProductName());
	}
	@Test
	void getAndSetProductShortDescription(){
		String productShortDescription = "An impressive pair of slippersfeaturingthousands of real rubies";
		Product pro = new Product();
		pro.setShortDescription(productShortDescription);
		assertEquals(productShortDescription, pro.getShortDescription());
	}
	
	@Test
	void getAndSetProductLongDescription(){
		String productLongDescription = "An impressive pair of slippersfeaturingthousands of real rubies impressive pair of slippersfeaturingthousands of real rubies";
		Product pro = new Product();
		pro.setLongDescription(productLongDescription);
		assertEquals(productLongDescription, pro.getLongDescription());
	}
	@Test
	void getAndSetProductImageUrl(){
		String productImageUrl = "https://raw.githubusercontent.com/jeff-lent/Alisnobba/main/Capstone/ActualRubyRubySlippers.jpg";
		Product pro = new Product();
		pro.setImageUrl(productImageUrl);
		assertEquals(productImageUrl	, pro.getImageUrl());
	}
	@Test
	void getAndSetProductPrice(){
		Double price = 68475000D;
		Product pro = new Product();
		pro.setPrice(price);
		assertEquals(price	, pro.getPrice());
	}
	@Test
	void getAllArgsConstructor(){
		Long id = 1L;
		String productName = "Ruby Slippers";
		String productShortDescription = "An impressive pair of slippersfeaturingthousands of real rubies";
		String productLongDescription = "An impressive pair of slippersfeaturingthousands of real rubies impressive pair of slippersfeaturingthousands of real rubies";
		String productImageUrl = "https://raw.githubusercontent.com/jeff-lent/Alisnobba/main/Capstone/ActualRubyRubySlippers.jpg";
		Double price = 68475000D;
		Product pro = new Product(id,productName, productShortDescription, productLongDescription, productImageUrl, price);
		assertEquals(id, pro.getId());
		assertEquals(productName, pro.getProductName());
		assertEquals(productShortDescription, pro.getShortDescription());
		assertEquals(productLongDescription, pro.getLongDescription());
		assertEquals(productImageUrl, pro.getImageUrl());
		assertEquals(price, pro.getPrice());
	}
	@Test
	void productBuilder(){
		Long id = 1L;
		String productName = "Ruby Slippers";
		String productShortDescription = "An impressive pair of slippersfeaturingthousands of real rubies";
		String productLongDescription = "An impressive pair of slippersfeaturingthousands of real rubies impressive pair of slippersfeaturingthousands of real rubies";
		String productImageUrl = "https://raw.githubusercontent.com/jeff-lent/Alisnobba/main/Capstone/ActualRubyRubySlippers.jpg";
		Double price = 68475000D;
		Product pro = Product.builder()
								.id(id)
								.productName(productName)
								.shortDescription(productShortDescription)
								.longDescription(productLongDescription)
								.imageUrl(productImageUrl)
								.price(price)
								.build();
		assertEquals(id, pro.getId());
		assertEquals(productName, pro.getProductName());
		assertEquals(productShortDescription, pro.getShortDescription());
		assertEquals(productLongDescription, pro.getLongDescription());
		assertEquals(productImageUrl, pro.getImageUrl());
		assertEquals(price, pro.getPrice());
	}
	@Test
	void canSaveProduct(){
		String productName = "Ruby Slippers";
		String productShortDescription = "An impressive pair of slippersfeaturingthousands of real rubies";
		String productLongDescription = "An impressive pair of slippersfeaturingthousands of real rubies impressive pair of slippersfeaturingthousands of real rubies";
		String productImageUrl = "https://raw.githubusercontent.com/jeff-lent/Alisnobba/main/Capstone/ActualRubyRubySlippers.jpg";
		Double price = 68475000D;
		Product pro = Product.builder()
								.productName(productName)
								.shortDescription(productShortDescription)
								.longDescription(productLongDescription)
								.imageUrl(productImageUrl)
								.price(price)
								.build();
		given(productRepository.findByProductName(productName)).willReturn(Optional.empty());
		given(productRepository.save(pro)).willReturn(pro);
		Product savedProduct = productServiceImp.saveProdcut(pro);
		assertNotNull(savedProduct);
	}
	@Test
	void canGetAProduct(){
		Long productId = 1L;
		String productName = "Ruby Slippers";
		String productShortDescription = "An impressive pair of slippersfeaturingthousands of real rubies";
		String productLongDescription = "An impressive pair of slippersfeaturingthousands of real rubies impressive pair of slippersfeaturingthousands of real rubies";
		String productImageUrl = "https://raw.githubusercontent.com/jeff-lent/Alisnobba/main/Capstone/ActualRubyRubySlippers.jpg";
		Double price = 68475000D;
		Product pro = Product.builder()
								.id(productId)
								.productName(productName)
								.shortDescription(productShortDescription)
								.longDescription(productLongDescription)
								.imageUrl(productImageUrl)
								.price(price)
								.build();
		given(productRepository.getReferenceById(productId)).willReturn(pro);
		Product gottenProduct = productServiceImp.getAProdcut(pro.getId());
		assertNotNull(gottenProduct);
		assertEquals(gottenProduct.getId(), pro.getId());
		assertEquals(gottenProduct.getProductName(), pro.getProductName());
		assertEquals(gottenProduct.getShortDescription(), pro.getShortDescription());
		assertEquals(gottenProduct.getLongDescription(), pro.getLongDescription());
		assertEquals(gottenProduct.getImageUrl(), pro.getImageUrl());
		assertEquals(gottenProduct.getPrice(), pro.getPrice());
}
@Test
	void canUpdateAProduct(){
		Long productId = 1L;
		String productName = "Ruby Slippers";
		String productShortDescription = "An impressive pair of slippersfeaturingthousands of real rubies";
		String productLongDescription = "An impressive pair of slippersfeaturingthousands of real rubies impressive pair of slippersfeaturingthousands of real rubies";
		String productImageUrl = "https://raw.githubusercontent.com/jeff-lent/Alisnobba/main/Capstone/ActualRubyRubySlippers.jpg";
		Double price = 68475000D;
		Product pro = Product.builder()
								.id(productId)
								.productName(productName)
								.shortDescription(productShortDescription)
								.longDescription(productLongDescription)
								.imageUrl(productImageUrl)
								.price(price)
								.build();
		given(productRepository.findByProductName(productName)).willReturn(Optional.of(pro));
		given(productRepository.save(pro)).willReturn(pro);
		Product updateProduct = productServiceImp.updateProduct(pro);
		assertNotNull(updateProduct);
		assertEquals(updateProduct.getId(), pro.getId());
		assertEquals(updateProduct.getProductName(), pro.getProductName());
		assertEquals(updateProduct.getShortDescription(), pro.getShortDescription());
		assertEquals(updateProduct.getLongDescription(), pro.getLongDescription());
		assertEquals(updateProduct.getImageUrl(), pro.getImageUrl());
		assertEquals(updateProduct.getPrice(), pro.getPrice());
}
}
