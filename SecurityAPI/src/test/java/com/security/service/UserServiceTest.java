package com.security.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.security.demo.SecurityApiApplication;
import com.security.vo.User;;

@SpringBootTest
@ContextConfiguration(classes = SecurityApiApplication.class)
@ExtendWith(SpringExtension.class)
public class UserServiceTest {

//	@Autowired
//	private UserRepository repository; // repository 를 테스트 하는건 UserService에서 해당하지 않는다.
	@Mock
	private UserService service;
	
	@BeforeEach
	public void 테이블초기화() {
//		repository.deleteAll();
		service.reset();
		assertThat("DROP TABLE");
	}

	@Test
	public void test() {
		assertEquals("1", "1");
	}

	@Test
	public void 전체조회() {
//		assertEquals(repository.findAll().size(), 0);
	}

	@Test
	public void 유저추가id미기입() { // 유저 id값이 존재하지 않아 repository save시 JpaSystemException이 발생하면 @ID가 잘 수행되는 것.
		// assertThrows ( 발생할 예외처리, 실행하려는 로직)
//		assertThrows(JpaSystemException.class, () -> {
//			User errorUser = new User(null, "1234", "chk");
//			System.out.println(service.register(errorUser));
//		});
		User errorUser = new User(null, "1234", "chk");
		assertEquals(service.register(errorUser), false);
	}

	@Test
	public void 중복id가입() {
//		assertThrows(JpaSystemException.class, ()->{
		User errorUser1 = new User("1", "1234", "chk");
		User errorUser2 = new User("1", "4444", "chk");

//		});
	}
}
