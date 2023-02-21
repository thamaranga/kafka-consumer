package com.hasithat.kafkaconsumer;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.hasithat.kafka.dto.PaymentRequest;
import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
@Slf4j
public class KafkaConsumerApplication {


	public static void main(String[] args) {
		SpringApplication.run(KafkaConsumerApplication.class, args);
	}

	/*Here I have created two consumers as paymentConsumer1 and paymentConsumer2.
	* By increasing consumers count we can achieve high level of concurrency.
	*payment-topic has three partitions. Which partition's message is assign to
	* which consumer is decided by kafka. So we cannot control it. */
	@KafkaListener(topics = "payment-topic", groupId = "payment_consumer_group")
	public void paymentConsumer1(PaymentRequest paymentRequest) throws JsonProcessingException {
		//business logic
		log.info("paymentConsumer1 consumed message {} ", paymentRequest.toString());
	}

	@KafkaListener(topics = "payment-topic", groupId = "payment_consumer_group")
	public void paymentConsumer2(PaymentRequest paymentRequest) throws JsonProcessingException {
		//business logic
		log.info("paymentConsumer2 consumed message {} ", paymentRequest.toString());
	}

}
