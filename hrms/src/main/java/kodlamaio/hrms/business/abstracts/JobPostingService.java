package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobPosting;

public interface JobPostingService {
	DataResult<List<JobPosting>>getAll();
	Result add(JobPosting jobposting);
	DataResult<List<JobPosting>> findByActiveTrue();
	DataResult<List<JobPosting>> findByEmployer_IdAndActiveTrue(String companyName);
	DataResult<List<JobPosting>> findByActiveTrueOrderByReleaseDate();
	DataResult<JobPosting> findByIdAndActiveTrue(int id);
	DataResult<JobPosting> updateActive(int id, boolean active);
	
	
	

}
