package practice.springboot_microservices_notes_and_code.beanlifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class Motor {

    @PostConstruct  // to execute method after bean object creation
    public void init() {
        System.out.println("Motor - init() Method...!");
    }
    @PreDestroy // to execute method before bean object creation
    public void destory() {
        System.out.println("Motor - destory() Method... !");
    }
}
