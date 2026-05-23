package com.auth.backend.util;

import com.auth.backend.config.RabbitMQConfig;
import com.auth.backend.dto.auth.EmailPayload;
import com.auth.backend.exception.CustomInternalServerErrorException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MailUtil {
    private final JavaMailSender mailSender;

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void sendMail(EmailPayload payload){
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);
            helper.setTo(payload.to());
            helper.setSubject(payload.subject());
            helper.setText(payload.text(),true);

            mailSender.send(message);

        } catch (MessagingException exception){
            throw new CustomInternalServerErrorException(exception.getMessage());
        }
    }
}
