
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.unla.nahuel.entities.User;
import com.unla.nahuel.entities.UserRole;

public class TestBCryptPasswordEncoder {

	public static void main(String[] args) {
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		System.out.println(pe.encode("user"));
		
		/*User user1 = new User("nahuel","$2a$10$8s9vHOfteSgbzSId31b2XOOTC1ijAte7CLpFoieKxwPhKNOIt3c/m",true);
		UserRole role1 = new UserRole(user1.getId(),user1,"ROLE_USER");*/

	}
}