package com.backend.heArt.utilities.email;

import com.backend.heArt.request.SignUpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Properties;


@Component
public class EmailSender {
    private static final Logger log = LoggerFactory.getLogger(EmailSender.class);
    @Value("${mail.smtp.username}")
    private String mailSmtpUser;

    @Value("${mail.smtp.password}")
    private String mailSmtpPassword;

    @Value("${confirmationSubject}")
    private String confirmationSubject;

    @Value("${mail.smtp.auth}")
    private String mailSmtpAuth;

    @Value("${mail.smtp.starttls.enable}")
    private String mailSmtpStartTls;

    @Value("${mail.smtp.host}")
    private String mailSmtpHost;

    @Value("${mail.smtp.port}")
    private String mailSmtpPort;


    @Async
    public void sendEmail(SignUpRequest signUpRequest, String token) throws UnsupportedEncodingException, MessagingException {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        System.out.println("Username: " + mailSmtpUser);
        System.out.println("Password: " + mailSmtpPassword);
        mailSender.setUsername(mailSmtpUser);
        mailSender.setPassword(mailSmtpPassword);
        mailSender.setHost(mailSmtpHost);
        mailSender.setPort(Integer.parseInt(mailSmtpPort));
        Properties props = setUpMailProperties();
        mailSender.setJavaMailProperties(props);
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message);
            helper.setFrom(mailSmtpUser);
            helper.setTo(signUpRequest.getEmail());
            helper.setText("Hello " + signUpRequest.getName() + " "
                    + "Thank you for registering on heArt. Please confirm that it's you by clicking on this link: "
                    + "http://localhost:8080/auth/confirm-registration?token=" + token
            );
            helper.setSubject(confirmationSubject);
            mailSender.send(message);
        } catch (MessagingException exception) {
            log.error("Couldn't send the email, try again later");
            throw new MessagingException("Couldn't send the email");
        }

        mailSender.send(message);
    }

    private Properties setUpMailProperties() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", mailSmtpAuth);
        props.put("mail.smtp.starttls.enable", mailSmtpStartTls);
        return props;
    }
}
