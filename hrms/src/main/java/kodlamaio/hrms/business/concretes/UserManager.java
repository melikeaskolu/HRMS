package kodlamaio.hrms.business.concretes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.User;
@Service
public class UserManager implements UserService {
	
	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao=userDao;
		
	}
	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult(true, "User has been added.");  //Kullanıcı eklendi.
	}
//	@Override
//	public Result update(User user) {
//		this.userDao.save(user);
//      return new SuccessResult("User has been updated."); //kullanıcı güncellendi
//	}
//
//	@Override
//	public Result delete(int id) {
//		this.userDao.deleteById(id);
//      return new SuccessResult("User has been deleted."); //kullanıcı silindi
//	}
//
//	@Override
//	public DataResult<User> getById(int id) {
//		return new SuccessDataResult<User>(this.userDao.getById(id));
//	}

	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(this.userDao.findAll());
	
	}
	@Override
	public DataResult<User> getUserByEmail(String email) {
		return new SuccessDataResult<User>(this.userDao.findUserByEmail(email));
	}

	

}
