package practice.springboot_microservices_notes_and_code.service;

import org.springframework.stereotype.Component;

@Component
public class PwdService {
    public String encryptPwd(String pwd) {
        // encrypted logic (MD, SHA, AES, BCrypto)
        System.out.println("Password Encryption complated ..... !");

        return pwd;
    }
}
