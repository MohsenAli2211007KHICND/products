package gul.products;

import org.junit.jupiter.api.Test;
import org.mockito.invocation.Invocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.LinkedMultiValueMap;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@WebMvcTest
public class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ProductService productService;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void canGetProduct() throws Exception {
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
        given(productService.getAllProducts()).willReturn(products);
        ResultActions response = mockMvc.perform(get("/api/product/all")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(products)));

        response.andExpect(status().isOk());
        response.andDo(print())
                .andExpect(jsonPath("$.size()", is(products.size())));
                
    }

    
}
