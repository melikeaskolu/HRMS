package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.ActivationCode;

public interface ActivationCodeService {

	Result add(ActivationCode code);

}
