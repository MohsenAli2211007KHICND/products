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
	void getAndSetId(){
		Long id = 1L;
		Product pro = new Product();
		pro.setId(id);
		assertEquals(id, pro.getId());
	}

}
