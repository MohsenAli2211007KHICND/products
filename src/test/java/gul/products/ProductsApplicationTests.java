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

}
