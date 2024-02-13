package com.letcode.SecureBankSystem;

import com.letcode.SecureBankSystem.entities.UserEntity;
import com.letcode.SecureBankSystem.repositories.UserRepository;
import com.letcode.SecureBankSystem.services.user.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SecureBankSystemApplicationTests {

	/*@Test
	void contextLoads() {
	}*/

	@MockBean
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@Test
	public void passLargerThanEight(){
		UserEntity user1 = new UserEntity();
		user1.setName("yousef");
		user1.setPassword("123456789");

		UserEntity user2 = new UserEntity();
		user2.setName("fawaz");
		user2.setPassword("123456789");

		UserEntity user3 = new UserEntity();
		user3.setName("sara");
		user3.setPassword("123456");

		List<UserEntity> mockUsers = Arrays.asList(user1, user2, user3);

		Mockito.when(userRepository.findAll()).thenReturn(mockUsers);

		assertEquals(Arrays.asList("yousef", "fawaz"), userService.getAllUsersWithStrongPassword());
	}
}
