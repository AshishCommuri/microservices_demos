package com.microservices.demo.currency_exchange_service;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {
	
	ExchangeValue findByFromAndTo(String from, String to);
	
	ExchangeValue findByFrom(String from);

}
