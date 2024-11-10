package practice.springboot_microservices_notes_and_code.DAO;

import org.springframework.stereotype.Component;

@Component
public class IUserDaoImpl implements  IUserDao{
    @Override
    public boolean saveUser(String name, String email, String pwd) {
        System.out.println("Record inserted in database.....!");
        return true;
    }
}
