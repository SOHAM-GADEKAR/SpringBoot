package com.infosys.AccountService.myclients;

import com.infosys.AccountService.Entity.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "CUSTOMERSERVICE",url = "http://localhost:8081")
public interface CustomerClient {

//    public Customer getCustomerByIdUsingClient(@RequestParam("customerid") int customerId);

    @GetMapping("/findcustomerbyid")
    public Customer getCustomerByIdUsingClient(@RequestParam int customerId);

}
