package kodlamaio.hrms.business.concrete;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.dataAccess.abstracts.JobTitleDao;
import kodlamaio.hrms.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService {
	private JobTitleDao jobTitleDao;

	@Override
	public Result add(JobTitle jobTitle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<JobTitle>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<JobTitle> getJobByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

}
