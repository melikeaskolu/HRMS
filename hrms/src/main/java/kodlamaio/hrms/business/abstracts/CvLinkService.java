package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.CvLink;

public interface CvLinkService {
	Result add(CvLink cvLink);
	Result update(CvLink cvLink);
	Result delete(int id);
	DataResult<CvLink> getById(int id);	
	DataResult<List<CvLink>> getAll();
	DataResult<List<CvLink>> getAllByCandidateId(int id);

}
