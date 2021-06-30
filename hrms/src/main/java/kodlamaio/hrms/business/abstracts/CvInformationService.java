package kodlamaio.hrms.business.abstracts;

import java.util.List;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.CvInformation;

public interface CvInformationService {
	
	Result add(CvInformation cvInformation);
	Result update(CvInformation cvInformation);
	Result delete(int id);
	DataResult<CvInformation> getById(int id);	
	DataResult<List<CvInformation>> getAll();

}
