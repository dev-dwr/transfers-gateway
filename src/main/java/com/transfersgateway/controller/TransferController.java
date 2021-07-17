package com.transfersgateway.controller;

import com.commons.Transfer;
import com.transfersgateway.connector.Dto.AccountDto;
import com.transfersgateway.provider.AccountsProvider;
import com.transfersgateway.request.TransferRequest;
import com.transfersgateway.services.TransferProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1/transfers")
@RequiredArgsConstructor
public class TransferController {
    private final AccountsProvider accountsProvider;
    private final TransferProducer transferProducer;

    @PostMapping
    public void saveTransfer(@RequestBody TransferRequest request) throws Exception {
        AccountDto senderAccount = accountsProvider.getAccount(request.getSenderAccount()).get(0);
        if(senderAccount.getAvailableFunds() - request.getAmount() < 0){
            throw new IllegalArgumentException("\"You do not have enough money\"");
        }
        log.info("Received transfer request: " + request);
        Transfer transfer = new Transfer();
        transfer.setAmount(request.getAmount());
        transfer.setTitle(request.getTitle());
        transfer.setRecipientAccount(request.getRecipientAccount());
        transfer.setSenderAccount(request.getSenderAccount());

        transferProducer.sendTransfer(transfer);
    }
}
