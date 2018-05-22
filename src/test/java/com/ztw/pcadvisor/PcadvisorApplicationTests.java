package com.ztw.pcadvisor;

import com.ztw.pcadvisor.config.SecurityConfig;
import com.ztw.pcadvisor.model.User;
import com.ztw.pcadvisor.model.UserType;
import com.ztw.pcadvisor.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Collections;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PcadvisorApplicationTests {

	@MockBean
    UserRepository userRepository;

	@Test
	public void contextLoads() {
		User user = new User();
		user.setUserName("kane16");
		user.setUserType(UserType.Standardowy);
		user.setPassword("guimis1");
		ArrayList<User> users = new ArrayList<>();
		users.add(user);
        Mockito.when(userRepository.findAll()).thenReturn(users);
	}

	@Test
	public void checkAllUsers(){
        Assert.assertEquals(1,userRepository.findAll().size());
    }

}
