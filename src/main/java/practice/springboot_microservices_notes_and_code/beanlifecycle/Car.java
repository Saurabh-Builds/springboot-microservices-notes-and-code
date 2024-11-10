package practice.springboot_microservices_notes_and_code.beanlifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class Car implements InitializingBean, DisposableBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Car Started ... ! ");
    }

    public void drive() {
        System.out.println("I am a Driving a Car ... !");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Car Stopped ... !");
    }
}
