package gul.products;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductsApplicationTests {

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
	

}
