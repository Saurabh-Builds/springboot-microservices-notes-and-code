package practice.springboot_microservices_notes_and_code.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import practice.springboot_microservices_notes_and_code.DAO.IUserDao;

@Component
public class IUserService {

    @Autowired
    private PwdService pwdService;

    @Autowired
    private IUserDao userDao;

    @Autowired
    private EmailService emailService;


    public void registerUser (String name, String email, String pwd){

        // encrypt passsword
        String encryptPwd = pwdService.encryptPwd(pwd);

        // save user in db
        boolean isSaved = userDao.saveUser(name, email,encryptPwd);

        // send email
        if(isSaved) {
            boolean isSent = emailService.sendEmail(email, "Test Subject", "Test Body");

            if(isSent) {
                System.out.println("User Registration Complated.....");
            }
        }

    }
}
