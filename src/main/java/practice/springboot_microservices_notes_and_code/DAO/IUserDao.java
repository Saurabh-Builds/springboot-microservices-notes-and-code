package practice.springboot_microservices_notes_and_code.DAO;

public interface IUserDao {
    public boolean saveUser(String name, String email, String pwd);
}
