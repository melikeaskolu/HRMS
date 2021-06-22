package kodlamaio.hrms.business.concrete.validator;

import kodlamaio.hrms.entities.concretes.Candidate;

public class CandidateValidator {
	public static boolean allFieldsAreRequired(Candidate candidate) { //tüm alanlar zorunludur
		if (candidate.getEmail().strip().isEmpty()
				|| candidate.getPassword().strip().isEmpty()
				|| candidate.getFirst_name().strip().isEmpty()
				|| candidate.getLast_name().strip().isEmpty()
				|| candidate.getIdentityNumber().strip().isEmpty()
				|| candidate.getBirth_date().toString().strip().isEmpty()) {
			return false;
		}
		return true;
	}

}
