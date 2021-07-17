package com.transfersgateway.services;

import com.commons.Transfer;
import com.commons.TransferMessage;
import com.transfersgateway.provider.AccountsProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class TransferProducer {
    private static final String TRANSFERS_TOPIC = "transfers";
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final AccountsProvider accountsProvider;

    public void sendTransfer(final Transfer transfer){
        TransferMessage transferMessage = new TransferMessage(transfer); //from com.commons.TransferMessage;

        log.info("Sending message to Kafka, transferMessage: {}", transferMessage);
        kafkaTemplate.send(TRANSFERS_TOPIC, transferMessage);
        log.info("Message was sent");
    }
}
