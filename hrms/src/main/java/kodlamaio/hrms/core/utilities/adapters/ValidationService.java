package kodlamaio.hrms.core.utilities.adapters;


public interface ValidationService {
	Boolean validationByMernis (String identityNumber, String first_name, String last_name, String birth_date);

	
}
