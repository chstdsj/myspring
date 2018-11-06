package test;

import com.jar.wh.mapper.UserDAO;
import com.jar.wh.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMybatis {

    @Test
    public void testMapper() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        UserDAO dao = ac.getBean(UserDAO.class);
        User u1 = dao.find("hllo");
        User u2 = dao.login("hllo5", 102);
        System.out.println(u1.getName().equals(u2.getName()));
    }

}
