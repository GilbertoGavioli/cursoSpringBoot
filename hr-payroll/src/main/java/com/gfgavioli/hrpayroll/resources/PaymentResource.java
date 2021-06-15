package com.gfgavioli.hrpayroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gfgavioli.hrpayroll.entities.Payment;
import com.gfgavioli.hrpayroll.services.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

	@Autowired
	private PaymentService service;
	
	//CASO DE ALGUM ERRO CHAMA ESTE METODO ALTERNATIVO
	@HystrixCommand(fallbackMethod = "getPaymentfallbackMethod")
	@GetMapping(value = "/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days) {
		Payment payment = service.getPayment(workerId, days);
		return ResponseEntity.ok(payment);
	}	
	
	
	public ResponseEntity<Payment>  getPaymentfallbackMethod(Long workerId, Integer days) {
		Payment payment = new Payment("Gilbreto", 400.0, days);//service.getPayment(workerId, days);
		return ResponseEntity.ok(payment);
	}	
}







