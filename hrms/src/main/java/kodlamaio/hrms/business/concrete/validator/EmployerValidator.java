package kodlamaio.hrms.business.concrete.validator;
import kodlamaio.hrms.entities.concretes.Employer;

public class EmployerValidator {
	public static boolean allFieldsAreRequired(Employer employer) { //tüm alanlar zorunludur
		if (employer.getEmail().strip().isEmpty()
				|| employer.getPassword().strip().isEmpty()
				|| employer.getCompany_name().strip().isEmpty()
				|| employer.getWeb_address().strip().isEmpty()
				|| employer.getPhone_number().strip().isEmpty()){
				return false;
		}
			return true;
		}	
}

