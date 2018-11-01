package hello;


import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRepositoryTests {

    @Autowired
    CustomerRepository repository;

    Customer dave, oliver, carter;

    @Before
    public void setUp() {

        repository.deleteAll();

        dave = repository.save(new Customer("Dave", "Matthews", 78));
        oliver = repository.save(new Customer("Oliver August", "Matthews", 45));
        carter = repository.save(new Customer("Carter", "Beauford", 25));
    }

    @Test
    public void setsIdOnSave() {

        Customer dave = repository.save(new Customer("Dave", "Matthews", 23));

        assertThat(dave.getId()).isNotNull();
    }

    @Test
    public void findsByLastName() {

        List<Customer> result = repository.query("Beauford", "Carter");

        assertThat(result).hasSize(1).extracting("firstName").contains("Carter");
    }

    @Test
    public void findsByExample() {

        Customer probe = new Customer(null, "Matthews", null);

        List<Customer> result = repository.findAll(Example.of(probe));

        assertThat(result).hasSize(2).extracting("firstName").contains("Dave", "Oliver August");
    }
}