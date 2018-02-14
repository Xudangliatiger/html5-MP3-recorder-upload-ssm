package service;
import org.springframework.ui.Model;

public interface UserService {
	public boolean login(String username, String password);
	
}
