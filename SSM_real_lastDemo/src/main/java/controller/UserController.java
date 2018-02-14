package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pojo.User;
import service.UserService;


//@Controllerע�����ڱ�ʾ����Ϊweb��������
@Controller
//@RequestMapping("/user")���ڱ궨����ʱ��urlλ��
@RequestMapping("/user")
//��Ĭ�������springmvc��ʵ�����ǵ���ģʽ,����ʹ��scope����ע��Ϊÿ�ζ�����һ���µ�ʵ��
@Scope("prototype")
public class UserController {
    //�Զ�ע��ҵ����userService��
    @Autowired
        UserService userService;

    //loginҵ��ķ���λ��Ϊ/user/login
    @RequestMapping("/login")
       public String login(User user,HttpServletRequest request){
        //����login��������֤�Ƿ���ע���û�
        boolean loginType = userService.login(user.getUsername(),user.getPassword());
        if(loginType){
            //�����֤ͨ��,���û���Ϣ����ǰ̨
            request.setAttribute("user",user);
            //����ת��success.jspҳ��
            return "success";
        }else{
            //������,�򽫴�����Ϣ��ʾ������ҳ��
            request.setAttribute("message","�û����������");
            return "error";
        }
    }

}