package controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
public class Application implements CommandLineRunner {

	@Autowired
	private CustomerRepository repository;

	@Autowired
	private SiniestroRepository repositorySini;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	public void run(String... args) throws Exception {

		repository.deleteAll();

		// save a couple of customers
		repository.save(new Customer("Alice", "Smith"));
		repository.save(new Customer("Bob", "Smith"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : repository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		
		System.out.println("Customer found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByFirstName("Alice"));

		System.out.println("Customers found with findByLastName('Smith'):");
		System.out.println("--------------------------------");
		for (Customer customer : repository.findByLastName("Smith")) {
			System.out.println(customer);
		}
		// Delete all siniestros
		repository.deleteAll();
	    // Save siniestro 
		repositorySini.save(new Siniestro("4720BNL", "0000001", "VF1DA050525512550", "RENAULT", "RENAULT MEGANE DYNAMIQUE 1900 DCI COUPE", "01/01/2014", "A42 KM 30", "Siniestro total"));	

		// fetch all siniestros
		System.out.println("Siniestros found with findAll():");
		System.out.println("-------------------------------");
		for (Siniestro sini : repositorySini.findAll()) {
			System.out.println(sini);
		}	
	}
}


