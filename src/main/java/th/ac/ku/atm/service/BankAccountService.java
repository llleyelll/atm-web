package th.ac.ku.atm.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import th.ac.ku.atm.model.BankAccount;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class BankAccountService {

    private ArrayList<BankAccount> bankAccountList;

    @PostConstruct
    public void postContruct() {
        bankAccountList = new ArrayList<>();
    }

    public void createCustomer(BankAccount bankAccount) {
        bankAccountList.add(bankAccount);
    }

    public List<BankAccount> getBankAcoounts() {
        return new ArrayList<>(this.bankAccountList);
    }

    public BankAccount findBankAccount(int id) {
        for (BankAccount bankAccount : bankAccountList) {
            if (bankAccount.getId() == id)
                return bankAccount;
        }
        return null;
    }

}
