package kodlamaio.hrms.business.concrete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ActivationCodeService;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ActivationCodeDao;
import kodlamaio.hrms.entities.concretes.ActivationCode;
@Service
public class ActivationCodeManager implements ActivationCodeService {

private ActivationCodeDao verificationCodeDao;

	@Autowired
	public ActivationCodeManager(ActivationCodeDao verificationCodeDao) {
	super();
	this.verificationCodeDao = verificationCodeDao;
}
	@Override
	public Result add(ActivationCode code) {
		this.verificationCodeDao.save(code);
		return new SuccessResult(true, "Code has been saved.");  //kod kaydedildi
	}

}
