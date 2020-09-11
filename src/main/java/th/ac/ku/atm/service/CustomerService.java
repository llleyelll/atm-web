package th.ac.ku.atm.service;

import org.springframework.stereotype.Service;
import th.ac.ku.atm.model.Customer;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    // responsible for processing and managing
    private List<Customer> customers = new ArrayList<>();

    @PostConstruct
    public void postConstruct() {
        this.customers = new ArrayList<>();
    }

    public void createCustomer(Customer customer) {
//        int hashedPin = hash(customer.getPin());
//        customer.setPin(hashedPin);
        customers.add(customer);
    }

    private int hash(int value) {
        return 0;
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}
