package Projetouniandrade.Services;

import org.springframework.mail.SimpleMailMessage;

import Projetouniandrade.domain.Pedido;

public interface EmailService {
 	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
}
