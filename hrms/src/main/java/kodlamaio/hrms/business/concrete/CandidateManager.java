package kodlamaio.hrms.business.concrete;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.concrete.validator.CandidateValidator;
import kodlamaio.hrms.core.utilities.adapters.ValidationService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService{
	
	private CandidateDao candidateDao;
	private ValidationService validationservice;

	@Autowired
	public CandidateManager(CandidateDao candidateDao, ValidationService validationservice) {
		super();
		this.candidateDao = candidateDao;
		this.validationservice = validationservice;
	}

	@Override
	public Result add(Candidate candidate) {
		var checkEmail=this.fİndByEmail(candidate.getEmail()).getData().size() !=0;
		var checkNationalityIdentity=this.findByNationalityIdentity(candidate.getNationalityIdentity()).getData().size() !=0;
		var checkValidateByPersonal=!this.ValidateByPersonalInfo(candidate.getNationalityIdentity(), candidate.getFirst_name(), 
				candidate.getLast_name(), candidate.getBirth_date()).getData();
		 var checkFields=!CandidateValidator.allFieldsAreRequired(candidate);
		 
		 if(checkEmail||checkNationalityIdentity||checkValidateByPersonal||checkFields) {
			 
			 String errorMessage="";
		 
		 if(checkEmail||checkNationalityIdentity) {
			 errorMessage+="Email and Tc No already exist";  //Email ve Tc No zaten mevcut
		 }
	     if(checkValidateByPersonal) {
	    	 errorMessage+="not a valid user";  //geçerli bir kullanıcı değil
	     }
	     if(checkFields) {
	    	 errorMessage+="All Fields are Required";  //bütün alanlar zorunludur
	     }
		return new ErrorResult(errorMessage);
		 }
		this.candidateDao.save(candidate);
		return new SuccessResult(true, "candidate has been added.");  //aday eklendi.
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll());
	}

	
	@Override
	public DataResult<List<Candidate>> findByNationalityIdentity(String nationalityİdentity) {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findByNationalityIdentity(nationalityİdentity));
	}

	
	@Override
	public DataResult<List<Candidate>> fİndByEmail(String email) {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findByEmail(email));
	}

	@Override
	public DataResult<Boolean> ValidateByPersonalInfo(String nationalityIdentity, String first_name, String last_name, String birth_date) {
		return new DataResult<>(this.validationservice.validationByMernis(nationalityIdentity, first_name, last_name, birth_date),true);
	}


	
}
