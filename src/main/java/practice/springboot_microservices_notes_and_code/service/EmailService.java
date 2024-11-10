package practice.springboot_microservices_notes_and_code.service;

import org.springframework.stereotype.Component;

@Component
public class EmailService {
    public boolean sendEmail(String to, String subject, String body) {

        // logic to send email
        System.out.println("Email sent to user ... !");

        return true;
    }
}
