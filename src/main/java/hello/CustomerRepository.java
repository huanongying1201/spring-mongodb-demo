package hello;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    public Customer findByFirstName(String firstName);
    
    //@Query(value="{'lastName':?0}",fields="{'firstName':1}")
    @Query(value="{ 'lastName':?0, 'firstName':?1}",fields="{ 'firstName' : 1}") 
    public List<Customer> query(String lastName,String firstName);

}
