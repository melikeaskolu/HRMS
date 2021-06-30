package kodlamaio.hrms.business.concretes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.VerificationCodeService;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.VerificationCodeDao;
import kodlamaio.hrms.entities.concretes.VerificationCode;

@Service
public class VerificationCodeManager implements VerificationCodeService {
	
	public VerificationCodeDao activationCodeDao;
	
	@Autowired
	public VerificationCodeManager(VerificationCodeDao activationCodeDao) {
		super();
		this.activationCodeDao = activationCodeDao;
	}

	@Override
	public Result add(VerificationCode code) {
		this.activationCodeDao.save(code);
		return new SuccessResult("Code has been saved."); //kod kaydedildi
	}
//	@Override
//	public Result delete(VerificationCode code) {
//		this.verificationCodeDao.delete(code);
//		return new SuccessResult("Code has been deleted.");  //kod silindi.
//	}
//
//	@Override
//	public Result update(VerificationCode code) {
//		this.verificationCodeDao.save(code);
//		return new SuccessResult("Code has been updated.");  //kod ggüncellendi.
//	}
//
//	@Override
//	public DataResult<VerificationCode> getById(int id) {
//		return new SuccessDataResult<VerificationCode>(this.verificationCodeDao.getById(id));
//	}
//
//	@Override
//	public DataResult<List<VerificationCode>> getAll() {
//		return new SuccessDataResult<List<VerificationCode>>(this.verificationCodeDao.findAll());
//	}

}
