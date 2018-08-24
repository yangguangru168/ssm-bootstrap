import com.hand.entity.Address;
import com.hand.mapper.AddressMapper;
import com.hand.mapper.CustomerMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:applicationContext.xml","classpath:spring-mvc.xml"})
public class TestMsql {

    @Autowired
    WebApplicationContext context;

    MockMvc mockMvc;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private AddressMapper addressMapper;


    @Before
    public void  inFilmMvc(){
       mockMvc= MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void getCustomer(){
        List<Address> customers = addressMapper.AddressSelectAlls();
        for (Address cus: customers) {
            System.out.println(cus);
        }

    }
}
