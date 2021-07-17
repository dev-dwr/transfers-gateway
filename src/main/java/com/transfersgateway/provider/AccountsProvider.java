package com.transfersgateway.provider;

import com.transfersgateway.connector.AccountsConnector;
import com.transfersgateway.connector.Dto.AccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountsProvider {
    private final AccountsConnector accountsConnector;

    public List<AccountDto> getAccount(Long customerId){
        return accountsConnector.getAccount(customerId);
    }
}
