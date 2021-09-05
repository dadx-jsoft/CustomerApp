package net.codejava.spring;
 
import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
@Service("customerService")
public class CustomerService {
    @Autowired
    private CustomerRepository repository;
     
    public void test() {
        // Save a new customer
        Customer newCustomer = new Customer();
        newCustomer.setFirstName("John");
        newCustomer.setLastName("Smith");
         
        repository.save(newCustomer);
         
        // Find a customer by ID
        Optional<Customer> result = repository.findById(1L);
        result.ifPresent(customer -> System.out.println(customer));
         
        // Find customers by last name
        List<Customer> customers = repository.findByLastName("Smith");
        customers.forEach(System.out::println);
         
        // List all customers
        Iterable<Customer> iterator = repository.findAll();
        iterator.forEach(System.out::println);
         
        // Count number of customer
        long count = repository.count();
        System.out.println("Number of customers: " + count);
    }
}