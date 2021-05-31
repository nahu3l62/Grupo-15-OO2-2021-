package com.unla.nahuel;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NahuelApplication implements CommandLineRunner {

	/*@Autowired
	private BCryptPasswordEncoder passEncoder;
*/
	public static void main(String[] args) {
		SpringApplication.run(NahuelApplication.class, args);
		//HOLA NAHU
	}

	@Override
	public void run(String... args) throws Exception {
		/*String pass1 = "user";
		String pass2 = "Admin";
		
		System.out.println(passEncoder.encode(pass1));
		System.out.println(passEncoder.encode(pass2));

		*/
	}

}
