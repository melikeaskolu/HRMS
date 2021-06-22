package kodlamaio.hrms.business.abstracts;
import java.util.List;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobPosition;
public interface JobPositionService {
	Result add(JobPosition jobTitle);
	DataResult<List<JobPosition>> getAll();
	DataResult<List<JobPosition>> getByJobTitle(String title);
}
