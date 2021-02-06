package sk.upjs.kramrest;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kram.storage.DaoFactory;
import kram.storage.EntityNotFoundException;
import kram.storage.user.User;
import kram.storage.user.UserDao;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {
	
	private UserDao userDao = DaoFactory.INSTATNCE.getUserDao();
	
//	List<User> getAllAcceptedInCourse(Long idCourse) throws EntityNotFoundException;
//	List<User> getAllWaitingInCourse(Long idCourse) throws EntityNotFoundException;
//	boolean checkUsername(String username) throws EntityNotFoundException;
	
	@GetMapping()
	private List<User> getAllusers() {
		return userDao.getAll();
	}
	
	@GetMapping("{idUser}")
	public User getById(@PathVariable("idUser") long idUser) throws EntityNotFoundException {
		return userDao.getById(idUser);
		
	}
	
	@GetMapping("login/{userName}/{passwd}")
	public User login(@PathVariable("userName") String userName, @PathVariable("passwd") String passwd) {
		return userDao.login(userName,passwd);
	}
	
	@GetMapping("/userName/{userName}")
	public User getByUsername(@PathVariable("userName") String userName) throws EntityNotFoundException {
		return userDao.getByUsername(userName);
		
	}
	
	@PostMapping()
	public User saveUser(@RequestBody User user) throws EntityNotFoundException {
		return userDao.saveUser(user);
	}
	
	@DeleteMapping("{id}")
	public void deleteUser(@PathVariable("id") Long idUser) throws EntityNotFoundException {
		userDao.deleteUser(idUser);
	}
}
