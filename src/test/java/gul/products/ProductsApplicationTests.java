package gul.products;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.*;

import java.util.List;
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
	void getAndsetName(){
		String name = "Ruby Slippers";
		Product pro = new Product();
		pro.setName(name);
		assertEquals(name, pro.getName());
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
	void getAndSetProductimageLink(){
		String productimageLink = "https://raw.githubusercontent.com/jeff-lent/Alisnobba/main/Capstone/ActualRubyRubySlippers.jpg";
		Product pro = new Product();
		pro.setImageLink(productimageLink);
		assertEquals(productimageLink	, pro.getImageLink());
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
		String name = "Ruby Slippers";
		String productShortDescription = "An impressive pair of slippersfeaturingthousands of real rubies";
		String productLongDescription = "An impressive pair of slippersfeaturingthousands of real rubies impressive pair of slippersfeaturingthousands of real rubies";
		String productimageLink = "https://raw.githubusercontent.com/jeff-lent/Alisnobba/main/Capstone/ActualRubyRubySlippers.jpg";
		Double price = 68475000D;
		Product pro = new Product(id,name, productShortDescription, productLongDescription, productimageLink, price);
		assertEquals(id, pro.getId());
		assertEquals(name, pro.getName());
		assertEquals(productShortDescription, pro.getShortDescription());
		assertEquals(productLongDescription, pro.getLongDescription());
		assertEquals(productimageLink, pro.getImageLink());
		assertEquals(price, pro.getPrice());
	}
	@Test
	void productBuilder(){
		Long id = 1L;
		String name = "Ruby Slippers";
		String productShortDescription = "An impressive pair of slippersfeaturingthousands of real rubies";
		String productLongDescription = "An impressive pair of slippersfeaturingthousands of real rubies impressive pair of slippersfeaturingthousands of real rubies";
		String productimageLink = "https://raw.githubusercontent.com/jeff-lent/Alisnobba/main/Capstone/ActualRubyRubySlippers.jpg";
		Double price = 68475000D;
		Product pro = Product.builder()
								.id(id)
								.name(name)
								.shortDescription(productShortDescription)
								.longDescription(productLongDescription)
								.imageLink(productimageLink)
								.price(price)
								.build();
		assertEquals(id, pro.getId());
		assertEquals(name, pro.getName());
		assertEquals(productShortDescription, pro.getShortDescription());
		assertEquals(productLongDescription, pro.getLongDescription());
		assertEquals(productimageLink, pro.getImageLink());
		assertEquals(price, pro.getPrice());
	}
	@Test
	void canSaveProduct(){
		String name = "Ruby Slippers";
		String productShortDescription = "An impressive pair of slippersfeaturingthousands of real rubies";
		String productLongDescription = "An impressive pair of slippersfeaturingthousands of real rubies impressive pair of slippersfeaturingthousands of real rubies";
		String productimageLink = "https://raw.githubusercontent.com/jeff-lent/Alisnobba/main/Capstone/ActualRubyRubySlippers.jpg";
		Double price = 68475000D;
		Product pro = Product.builder()
								.name(name)
								.shortDescription(productShortDescription)
								.longDescription(productLongDescription)
								.imageLink(productimageLink)
								.price(price)
								.build();
		given(productRepository.findByname(name)).willReturn(Optional.empty());
		given(productRepository.save(pro)).willReturn(pro);
		Product savedProduct = productServiceImp.saveProdcut(pro);
		assertNotNull(savedProduct);
	}
@Test
	void canGetAProduct(){
		Long productId = 1L;
		String name = "Ruby Slippers";
		String productShortDescription = "An impressive pair of slippersfeaturingthousands of real rubies";
		String productLongDescription = "An impressive pair of slippersfeaturingthousands of real rubies impressive pair of slippersfeaturingthousands of real rubies";
		String productimageLink = "https://raw.githubusercontent.com/jeff-lent/Alisnobba/main/Capstone/ActualRubyRubySlippers.jpg";
		Double price = 68475000D;
		Product pro = Product.builder()
								.id(productId)
								.name(name)
								.shortDescription(productShortDescription)
								.longDescription(productLongDescription)
								.imageLink(productimageLink)
								.price(price)
								.build();
		given(productRepository.getReferenceById(productId)).willReturn(pro);
		Product gottenProduct = productServiceImp.getAProdcut(pro.getId());
		assertNotNull(gottenProduct);
		assertEquals(gottenProduct.getId(), pro.getId());
		assertEquals(gottenProduct.getName(), pro.getName());
		assertEquals(gottenProduct.getShortDescription(), pro.getShortDescription());
		assertEquals(gottenProduct.getLongDescription(), pro.getLongDescription());
		assertEquals(gottenProduct.getImageLink(), pro.getImageLink());
		assertEquals(gottenProduct.getPrice(), pro.getPrice());
}
	@Test
	void canGetAllProduct(){
		Product pro1 = Product.builder()
								.id(1L)
								.name("product 1")
								.shortDescription("product 1 short description")
								.longDescription("product 1 long description")
								.imageLink("product 1 image")
								.price(245677D)
								.build();
		Product pro2 = Product.builder()
								.id(1L)
								.name("product 2")
								.shortDescription("product 2 short description")
								.longDescription("product 2 long description")
								.imageLink("product 2 image")
								.price(2455477D)
								.build();
		
		Product pro3 = Product.builder()
								.id(1L)
								.name("product 3")
								.shortDescription("product 3 short description")
								.longDescription("product 3 long description")
								.imageLink("product 3 image")
								.price(245652477D)
								.build();
		List<Product> products = List.of(pro1, pro2, pro3);
		given(productRepository.findAll()).willReturn(List.of(pro1, pro2, pro3));
		List<Product> product = productServiceImp.getAllProducts();
		assertNotNull(product);
		assertEquals(product.size(), 3);
	
		
	}
}
