
import dao.UserDao;


import pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created by Alvin on 15/9/6.
 */
public class Test1 {
   private static ApplicationContext ac;
    static {
        ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    public static void main(String[] args) {
        UserDao mapper = (UserDao) ac.getBean("UserDao");
        System.out.println("ªÒ»°alvin");
        User user = mapper.selectByName("xdl");

        System.out.println(user.getId()+":"+"username:"+user.getUsername());
        System.out.println("password:"+user.getPassword());

    }
}