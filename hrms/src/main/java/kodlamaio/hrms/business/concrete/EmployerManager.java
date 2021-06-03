package kodlamaio.hrms.business.concrete;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.concrete.validator.EmployeeValidator;
import kodlamaio.hrms.business.concrete.validator.EmployerValidator;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {
 
	private EmployerDao employerDao;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public Result add(Employer employer) {
		var checkEmail=this.fİndByEmail(employer.getEmail()).getData().size()!=0; //email kontrol et ve datada olan bi mail girilmişse hata ver
		var checkFields=!EmployerValidator.allFieldsAreRequired(employer);  //employer sınıfındaki alanları kontrol et , alanlar boş olmayacak
		var checkConfirm=!EmployeeValidator.confirmEmployer(employer); //personel onay kontrolü
		if (checkEmail || checkFields || checkConfirm) {
			String errorMessage="";
			if(checkEmail) {
				errorMessage+="email available"; //e-mail mevcut
			}
			if (checkFields) {
				errorMessage+="All Fields are Required";  //bütün alanlar zorunludur
			}
			if (checkConfirm) {
				errorMessage+="Registration confirmation was rejected by our employee";   //kayıt onayı çalışanımız tarafından reddedildi
			}
			return new ErrorResult(errorMessage);
			
		}
		this.employerDao.save(employer);
		return new SuccessResult(true, "Employer has been added.");  //iş veren eklendi
		
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll());
	}

	@Override
	public DataResult<List<Employer>> fİndByEmail(String email) {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findByEmail(email));
	}

}
