package kodlamaio.hrms.core.utilities.adapters;

import org.springframework.stereotype.Service;

@Service
public class MernisServiceAdapter implements ValidationService {

	@Override
	public Boolean validationByMernis(String nationalityIdentity, String first_name, String last_name, String birth_date) {
		return true;
	}

}
