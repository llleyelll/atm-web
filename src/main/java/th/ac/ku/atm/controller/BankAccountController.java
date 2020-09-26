package th.ac.ku.atm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import th.ac.ku.atm.model.BankAccount;
import th.ac.ku.atm.model.Transaction;
import th.ac.ku.atm.model.TransactionType;
import th.ac.ku.atm.service.BankAccountService;

@Controller
@RequestMapping("/bankaccount")
public class BankAccountController {
    private BankAccountService bankAccountService;

    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping
    public String getBankAccountPage(Model model) {
        model.addAttribute("allBankAccounts", bankAccountService.getBankAccounts());
        return "bankaccount";
    }

    @PostMapping
    public String openAccount(@ModelAttribute BankAccount bankAccount, Model model) {
        bankAccountService.openBankAccount(bankAccount);
        model.addAttribute("allBankAccounts", bankAccountService.getBankAccounts());
        return "redirect:bankaccount";
    }

    @GetMapping("/transaction/{transactionType}/{id}")
    public String getTransactionBankAccountPage(@PathVariable int id,
                                            @PathVariable String transactionType,
                                            Model model) {
        BankAccount account = bankAccountService.getBankAccount(id);
        model.addAttribute("bankAccount", account);
        if (transactionType.equals("deposit")) {
            model.addAttribute("pageTitle", "Deposit");
        } else {
            model.addAttribute("pageTitle", "Withdraw");
        }
        return "bankaccount-transaction";
    }

    @PostMapping("/transaction/{transactionType}/{id}")
    public String makeTransaction(@PathVariable int id,
                                  @PathVariable String transactionType,
                                  @RequestBody MultiValueMap<String, String> transactionForm,
                                  Model model) {
        TransactionType type = TransactionType.DEPOSIT;
        if (transactionType.equals("Withdraw")) {
            type = TransactionType.WITHDRAW;
        }
        double amount = Double.parseDouble(transactionForm.get("amount").get(0));
        Transaction transaction = new Transaction(id, type, amount);
        bankAccountService.makeTransaction(transaction);
        model.addAttribute("allBankAccounts", bankAccountService.getBankAccounts());
        return "redirect:/bankaccount";
    }

    @PostMapping("delete/{id}")
    public String deleteAccount(@PathVariable int id,
                                @ModelAttribute BankAccount bankAccount,
                                Model model) {
        bankAccountService.deleteBankAccount(bankAccount);
        model.addAttribute("allBankAccounts",bankAccountService.getBankAccounts());
        return "redirect:/bankaccount";
    }

}
