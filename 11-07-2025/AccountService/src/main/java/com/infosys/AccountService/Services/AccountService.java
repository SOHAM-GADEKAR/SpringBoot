package com.infosys.AccountService.Services;

import com.infosys.AccountService.DAO.AccountRepo;
import com.infosys.AccountService.Entity.Account;
import com.infosys.AccountService.Entity.AccountCustomerDetails;
import com.infosys.AccountService.Entity.Customer;
import com.infosys.AccountService.myclients.CustomerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AccountService {

    @Autowired
    private  AccountRepo repository;
    @Autowired
    private CustomerClient customerClient;


    public List<Account> getAllAccounts() {
        return repository.findAll();
    }

    public Optional<Account> getAccountById(Long id) {
        return repository.findById(id);
    }

    public Account createAccount(Account account) {
        return repository.save(account);
    }

    public Account updateAccount(Long id, Account updatedAccount) {
        return repository.findById(id)
                .map(account -> {
                    account.setAccountType(updatedAccount.getAccountType());
                    account.setBalance(updatedAccount.getBalance());
                    return repository.save(account);
                })
                .orElse(null);
    }

    public void deleteAccount(Long id) {
        repository.deleteById(id);
    }

    public AccountCustomerDetails getAccountCustomerDetails(Long id) {
        Account account = repository.findById(id).get();

        //from feing client requesting to findcustomerbyid and passing the id of the customer for given account
        Customer customer = customerClient.getCustomerByIdUsingClient(Integer.parseInt(account.getCustomerId()));

        return new AccountCustomerDetails(account, customer);
    }
}
