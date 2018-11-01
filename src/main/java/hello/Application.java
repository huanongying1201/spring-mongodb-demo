package hello;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private CustomerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		repository.deleteAll();

		// save a couple of customers
		repository.save(new Customer("Alice", "Smith", 23));
		repository.save(new Customer("Bob", "Smith", 30));
		
		System.out.println("---------------start-----------------");
		
		// fetch all customers
		System.out.println("1.Customers found with findAll():");
		for (Customer customer : repository.findAll()) {
			System.out.println(customer);
		}
		System.out.println("--------------------------------");
		System.out.println();

		// fetch an individual customer
		System.out.println("2.Customer found with findByFirstName('Alice'):");
		System.out.println(repository.findByFirstName("Alice"));
		System.out.println("--------------------------------");
		System.out.println();

		System.out.println("3.Customers found with findByLastName('Smith'):");
		for (Customer customer : repository.query("Smith","Bob")) {
			System.out.println(customer);
		}

		System.out.println("---------------end-----------------");
	}

}
