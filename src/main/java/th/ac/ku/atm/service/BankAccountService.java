package th.ac.ku.atm.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import th.ac.ku.atm.model.BankAccount;
import th.ac.ku.atm.model.Transaction;

import java.util.Arrays;
import java.util.List;

@Service
public class BankAccountService {

    private RestTemplate restTemplate;
    private String baseUrl = "http://bankaccount-api:8091/api/bankaccount/";

    public BankAccountService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<BankAccount> getCustomerBankAccount(int customerId) {
        String url = baseUrl + "customer/" + customerId;
        ResponseEntity<BankAccount[]> response =
                restTemplate.getForEntity(url, BankAccount[].class);

        BankAccount[] accounts = response.getBody();

        return Arrays.asList(accounts);
    }

    public List<BankAccount> getBankAccounts() {
        String url = baseUrl;

        ResponseEntity<BankAccount[]> response =
                restTemplate.getForEntity(url, BankAccount[].class);

        BankAccount[] accounts = response.getBody();
        return Arrays.asList(accounts);
    }

    public void openBankAccount(BankAccount bankAccount) {
        String url = baseUrl;

        restTemplate.postForObject(url, bankAccount, BankAccount.class);
    }

    public BankAccount getBankAccount(int id) {
        String url = baseUrl + id;

        ResponseEntity<BankAccount> response =
                restTemplate.getForEntity(url, BankAccount.class);

        return response.getBody();
    }

    public void makeTransaction(Transaction transaction) {
        String url = baseUrl + "transaction/" + transaction.getBankAccountId();
        restTemplate.put(url, transaction);
    }

    public void deleteBankAccount(BankAccount bankAccount) {
        String url = baseUrl + bankAccount.getId();

        restTemplate.delete(url, bankAccount);
    }
}
