package dao;
import pojo.User;

public interface UserDao {
	//�����Խӿ���ʽ���������ݿ��������,����ֻ��
    // ��Mybatisӳ���ļ��ж������ӳ��Ϳ���ֱ��ʹ��
    public User selectById(int id);
    public User selectByName(String username);

}
