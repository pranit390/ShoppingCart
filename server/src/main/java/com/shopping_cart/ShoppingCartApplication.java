package com.shopping_cart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import com.shopping_cart.model.Apparal;
import com.shopping_cart.model.Book;
import com.shopping_cart.model.User;
import com.shopping_cart.repository.ApparalRepository;
import com.shopping_cart.repository.BookRepository;
import com.shopping_cart.repository.UserRepository;

@SpringBootApplication
@Configuration
public class ShoppingCartApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext = SpringApplication
				.run(ShoppingCartApplication.class, args);

		BookRepository bookrepo = configurableApplicationContext.getBean(BookRepository.class);
		ApparalRepository appralrepo = configurableApplicationContext.getBean(ApparalRepository.class);

		UserRepository userRepo = configurableApplicationContext.getBean(UserRepository.class);

		Book book = new Book("Book", 500f, "ScienceFiction", "Danbrown", "PenguinPublications");
		Apparal apparal = new Apparal("Apparel", 1000f, "Jeans", "Levi", "Joggers");
		User user = new User("Pranit","Bhatt", "pranit@123", "pranit@gmail.com", 7247371480L);

		bookrepo.save(book);
		appralrepo.save(apparal);

		userRepo.save(user);
	}

	
	

}
