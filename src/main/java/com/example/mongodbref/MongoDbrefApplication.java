package com.example.mongodbref;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongodbref.entity.AccountEntity;
import com.example.mongodbref.entity.CustomerEntity;
import com.example.mongodbref.repository.AccountEntityRepository;
import com.example.mongodbref.repository.CustomerEntityRepository;


@SpringBootApplication
@RestController
public class MongoDbrefApplication {
	
	CustomerEntityRepository reactiveCustomerRepository;
	AccountEntityRepository reactiveAccountRepository;
	
	
	
	
    @Autowired
	public void setReactiveCustomerRepository(CustomerEntityRepository reactiveCustomerRepository) {
		this.reactiveCustomerRepository = reactiveCustomerRepository;
	}


    @Autowired
	public void setReactiveAccountRepository(AccountEntityRepository reactiveAccountRepository) {
		this.reactiveAccountRepository = reactiveAccountRepository;
	}


	public static void main(String[] args) {
		SpringApplication.run(MongoDbrefApplication.class, args);
	}

	
	@GetMapping("/hello")
    public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
		this.reactiveAccountRepository.deleteAll();
		this.reactiveCustomerRepository.deleteAll();
		AccountEntity account = new AccountEntity();
		account.setName("acc_1");
		this.reactiveAccountRepository.save(account);
		
		AccountEntity savedAccount= this.reactiveAccountRepository.findByName("acc_1");
		System.out.println("savedAccount is:\n"+savedAccount);
		CustomerEntity customer = new CustomerEntity();
		customer.setFirstName("rach");
		customer.setLastName("D");
		customer.setAccount(savedAccount);
		this.reactiveCustomerRepository.save(customer);
		System.out.println("customer saved:\n");
		
        return String.format("Hello %s!", name);
        
        
    }
}
