package kodlamaio.hrms.business.concretes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {
 
	private EmployerDao employerDao;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public Result add(Employer employer) {
		this.employerDao.save(employer);
		return new SuccessResult("Employer has been added.");  //iş veren eklendi
		
	}
	//
//	@Override
//	public void update(Employer employer) {
//		this.employerDao.save(employer);
//      return new SuccessResult("Employer has been updated."); //iş veren güncellendi
//	}
//
//	@Override
//	public Result delete(int id) {
//		this.employerDao.deleteById(id);
//	    return new SuccessResult("Employer has been deleted."); //iş veren silindi
//	}
//
//	@Override
//	public DataResult<Employer> getById(int id) {
//		return new SuccessDataResult<Employer>(this.employerDao.getById(id));
//	}


	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll());
	}

}
