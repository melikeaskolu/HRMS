package kodlamaio.hrms.business.concrete;

import java.util.List;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.User;

public class UserManager implements UserService {

	@Override
	public Result add(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<User>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<User> getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
