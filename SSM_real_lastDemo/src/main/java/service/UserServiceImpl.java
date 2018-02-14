package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UserDao;
import pojo.User;


//@Service("UserService") ע�����ڱ�ʾ����Ϊҵ������,��ʹ��ʱ�ᱻע�������Զ���
    //spring����ע��,�������Ǵ���ʵ��
@Service("UserService")
public class UserServiceImpl implements UserService {
    //�Զ�ע��userdao ���ڷ������ݿ�
    @Autowired
    UserDao Mapper;

    //��¼������ʵ��,��jspҳ���ȡusername��password
    public boolean login(String username, String password) {
//        System.out.println("������˺�:" + username + "���������:" + password);
        //�������˺Ž��в�ѯ,ȡ�����ݿ��б������Ϣ
        User user = Mapper.selectByName(username);
        if (user != null) {
//            System.out.println("��ѯ�������˺�:" + user.getUsername() + "����:" + user.getPassword());
//            System.out.println("---------");
            if (user.getUsername().equals(username) && user.getPassword().equals(password))
                return true;

        }
        return false;

    }
}
