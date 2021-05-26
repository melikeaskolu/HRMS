package kodlamaio.hrms.business.abstracts;
import java.util.List;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.entities.concretes.Employee;

public interface EmployeeService {
	DataResult<List<Employee>> getAll();
}