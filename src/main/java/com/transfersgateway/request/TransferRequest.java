package com.transfersgateway.request;

import com.commons.Transfer;
import com.transfersgateway.services.TransferProducer;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
public class TransferRequest {
    private Long senderAccount;
    private String recipientAccount;
    private String title;
    private Double amount;
}
