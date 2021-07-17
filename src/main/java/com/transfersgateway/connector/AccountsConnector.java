package com.transfersgateway.connector;

import com.transfersgateway.connector.Dto.AccountDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.NoSuchElementException;

@FeignClient(name="accounts", fallback = AccountsConnectorFallback.class)
public interface AccountsConnector {
    @GetMapping("/v1/accounts")
    List<AccountDto> getAccount(@RequestParam("customerId") Long customerId);
}


@Component
class AccountsConnectorFallback implements AccountsConnector{
    @Override
    public List<AccountDto> getAccount(Long customerId) {
        throw new NoSuchElementException("Problem");
    }
}