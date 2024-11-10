package practice.springboot_microservices_notes_and_code.DAO;

import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl implements UserDAO {

    public UserDaoImpl() {
        System.out.println("UserDaoImpl :: Constructor");
    }

    @Override
    public String findNameById(Integer id) {
        if (id == 100) {
            return "You Choose 100";
        } else if (id == 200) {
            return "You Choose 200";
        }
        return null;
    }
}
