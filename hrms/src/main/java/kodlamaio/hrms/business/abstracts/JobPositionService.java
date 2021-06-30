package kodlamaio.hrms.business.abstracts;
import java.util.List;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobPosition;
public interface JobPositionService {

	Result add(JobPosition jobPosition);
//	Result update(JobPosition jobPosition);
//	Result delete(int id);
//	DataResult<JobPosition> getById(int id);
	DataResult<List<JobPosition>> getAll();
	DataResult<List<JobPosition>> getJobByTitle(String title);
	
}
