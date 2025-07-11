package com.infosys.AccountService.Entity;

public class AccountCustomerDetails {

    private Account account;
    private Customer customer;

    public AccountCustomerDetails(){}

    public AccountCustomerDetails(Account account, Customer customer) {
        this.account = account;
        this.customer = customer;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
