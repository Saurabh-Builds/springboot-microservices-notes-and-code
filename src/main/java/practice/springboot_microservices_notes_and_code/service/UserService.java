package practice.springboot_microservices_notes_and_code.service;

import lombok.Getter;
import lombok.Setter;
import practice.springboot_microservices_notes_and_code.DAO.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    private UserDAO dao;

//    @Autowired // field injection (reflection)
//    private UserDAO dao;

    @Autowired // if comment this line it will through an error NullPointerException
//  "@Autowired is used when there are two constructors with the same name."
    public UserService(UserDAO dao) {
        this.dao = dao;
        System.out.println("UserService :: Arg - parameter - Constructor");
    }
    public UserService() {
        System.out.println("UserService :: 0 - parameter - Constructor");
    }

    @Autowired
    public void setDao(UserDAO dao) {
        System.out.println("UserService :: setDao() called...");
        this.dao = dao;
    }

    public void getUsername(Integer id) {
        String name = dao.findNameById(id);
        System.out.println(name);
    }


}
