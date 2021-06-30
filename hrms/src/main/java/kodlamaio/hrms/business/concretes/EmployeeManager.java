package kodlamaio.hrms.business.concretes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hrms.entities.concretes.Employee;


@Service
public class EmployeeManager implements EmployeeService{
	
	private EmployeeDao employeeDao;

	@Autowired
	public EmployeeManager(EmployeeDao employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}
//	@Override
//	public Result add(Employee employee) {
//		this.employeeDao.save(employee);
//      return new SuccessResult("Employee has been added.");		 //Çalışan eklendi
//	}
//
//	@Override
//	public Result update(Employee employee) {
//		this.employeeDao.save(employee);
//      return new SuccessResult("Employee has been updated."); //Çalışan güncellendi
//	}
//
//	@Override
//	public Result delete(int id) {
//		this.employeeDao.deleteById(id);
//      return new SuccessResult("Employee has been deleted."); //Çalışan silindi
//	}
//
//	@Override
//	public DataResult<Employee> getById(int id) {
//		return new SuccessDataResult<Employee>(this.employeeDao.getById(id));
//	}
	@Override
	public DataResult<List<Employee>> getAll() {
		return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll());
	}

}
