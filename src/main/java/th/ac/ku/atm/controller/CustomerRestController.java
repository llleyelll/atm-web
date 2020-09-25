package th.ac.ku.atm.controller;

import org.springframework.web.bind.annotation.*;
import th.ac.ku.atm.model.Customer;
import th.ac.ku.atm.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("api/customer")
public class CustomerRestController {

    private CustomerService customerService;

    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping()
    public List<Customer> getAll() {
        return customerService.getCustomers();
    }

    @GetMapping("/{id}")
    public Customer getOne(@PathVariable int id) {
        return customerService.findCustomer(id);
    }
}
