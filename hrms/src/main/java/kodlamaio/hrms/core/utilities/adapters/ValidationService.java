package kodlamaio.hrms.core.utilities.adapters;


public interface ValidationService {
	Boolean validationByMernis (String nationalityIdentity, String first_name, String last_name, String birth_date);

	
}
