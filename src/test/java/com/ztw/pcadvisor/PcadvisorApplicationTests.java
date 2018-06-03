package com.ztw.pcadvisor;

import com.ztw.pcadvisor.config.SecurityConfig;
import com.ztw.pcadvisor.model.User;
import com.ztw.pcadvisor.model.UserRole;
import com.ztw.pcadvisor.model.UserType;
import com.ztw.pcadvisor.repository.RoleRepository;
import com.ztw.pcadvisor.repository.UserRepository;
import com.ztw.pcadvisor.service.AdminService;
import com.ztw.pcadvisor.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PcadvisorApplicationTests {

	@MockBean
    UserRepository userRepository;

	@MockBean
    RoleRepository roleRepository;

    private ArrayList<User> users;

    @Autowired
    UserService userService;

    @Autowired
    AdminService adminService;

    private User user1;

    private ArrayList<User> adminUsers;

    private ArrayList<User> standardUsers;

	@Before
    public void setUp(){
        user1 = new User();
        user1.setUserName("kane16");
        user1.setUserType(UserType.Standardowy);
        user1.setPassword("guimis1");
        UserRole userRole1 = new UserRole();
        userRole1.setName("ROLE_ADMIN");
        user1.setUserRole(userRole1);
        User user2 = new User();
        user2.setUserName("Magda12");
        user2.setUserType(UserType.Gracz);
        user2.setPassword("nowa");
        UserRole userRole2 = new UserRole();
        userRole2.setName("ROLE_USER");
        user2.setUserRole(userRole2);
        users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        adminUsers = new ArrayList<>();
        adminUsers.add(user1);
        standardUsers = new ArrayList<>();
        standardUsers.add(user2);
    }


	@Test
	public void checkAllUsers(){
        Mockito.when(userRepository.findAll()).thenReturn(users);
        Assert.assertEquals(2,userService.getAllUsers().size());
    }

    @Test
    public void checkByUsername(){
	    Mockito.when(userRepository.findByUserName("kane16")).thenReturn
                (users.stream().filter(user -> user.getUserName().equals("kane16")).collect(Collectors.toList()).get(0));
	    Assert.assertEquals(user1, userService.findByUserName("kane16"));
	}

	@Test
    public void findAllAdminUsers(){
	    Mockito.when(userRepository.findByUserRole(roleRepository.findByName("ROLE_ADMIN"))).thenReturn(
                users.stream().filter(user -> user.getUserRole().getName().equals("ROLE_ADMIN")).collect(Collectors.toList())
        );
	    Assert.assertEquals(adminUsers, adminService.findAllAdmins());
    }

    @Test
    public void findAllStandardUsers(){
	    Mockito.when(userRepository.findByUserRole(roleRepository.findByName("ROLE_USER"))).thenReturn(
	            users.stream().filter(user -> user.getUserRole().getName().equals("ROLE_USER")).collect(Collectors.toList())
        );
	    Assert.assertEquals(standardUsers, userService.findAllStandardUsers());
    }

    @Test
    public void deleteUser(){
	    String username = "Magda12";
        Mockito.when(userRepository.findByUserName(username)).thenReturn
                (users.stream().filter(user -> user.getUserName().equals(username)).collect(Collectors.toList()).get(0));

        User user = userRepository.findByUserName(username);

        Mockito.doAnswer((invocation) -> {
            User userArgument = (User)invocation.getArgument(0);
            users.remove(userArgument);
            return null;
        }).when(userRepository).delete(user);

        userService.deleteUser(username);
        Assert.assertEquals(1, users.size());
    }


}
