package kodlamaio.hrms.business.concrete.validator;
import kodlamaio.hrms.entities.concretes.Employer;

public class EmployerValidator {
	public static boolean allFieldsAreRequired(Employer employer) { //tüm alanlar zorunludur
		if (employer.getEmail().strip().isEmpty()
				|| employer.getPassword().strip().isEmpty()
				|| employer.getCompanyName().strip().isEmpty()
				|| employer.getWeb().strip().isEmpty()
				|| employer.getPhoneNumber().strip().isEmpty()){
				return false;
		}
			return true;
		}	
}

