package com.yit.catalog.dao;

import static org.assertj.core.api.Assertions.assertThat;

import javax.annotation.Resource;
import javax.ws.rs.core.Application;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.yit.catalog.bean.Product;
import com.yit.catalog.repository.ProductDAO;
import com.yit.catalog.repository.ProductDAOForTest;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
public class ProductDaoTest {
	
	@Autowired
    private ProductDAOForTest productDao;
    
	private Product p1;
	
	@Before
    public void setUp(){
        p1 = new Product();
        p1.setDescription("CPU 50Core, Ram100GB");
        p1.setName("Samsung S20");
        p1.setPrice(500);
        p1.setWarranty(2);
    }
	
	
	@Test
    public void createProduct() {

		Product mm= productDao.save(p1);
		System.out.println("Generate id = " + mm.getId());
        assertThat(mm.getId()).isNotNull();
        
    }
	
	
}
