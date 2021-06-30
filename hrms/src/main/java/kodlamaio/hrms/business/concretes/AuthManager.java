package kodlamaio.hrms.business.concretes;
import java.util.Date;

import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.VerificationCodeService;
import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.adapters.ValidationService;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.core.verification.VerificationService;
import kodlamaio.hrms.entities.concretes.VerificationCode;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class AuthManager implements AuthService {


	private UserService userService;
	private EmployerService employerService;
	private CandidateService candidateService;
	private VerificationService verificationService;
	private ValidationService validationService;
	private VerificationCodeService verificationCodeService;
	
	
	public AuthManager(UserService userService, EmployerService employerService, CandidateService candidateService,
			VerificationService verificationService, ValidationService validationService,
			VerificationCodeService verificationCodeService) {
		super();
		this.userService = userService;
		this.employerService = employerService;
		this.candidateService = candidateService;
		this.verificationService = verificationService;
		this.validationService = validationService;
		this.verificationCodeService = verificationCodeService;
	}

	

	@Override
	public Result registerEmployer(Employer employer, String confirmPassword) {

		if (!checkIfNullInfoForEmployer(employer)) {

			return new ErrorResult("You have entered missing information. Please fill in all fields.");
		}

		if (!checkIfEqualEmailAndDomain(employer.getEmail(), employer.getWeb())) {

			return new ErrorResult("Invalid email address.");
		}

		if (!checkIfEmailExists(employer.getEmail())) {

			return new ErrorResult(employer.getEmail() + " already exists.");
		}

		if (!checkIfEqualPasswordAndConfirmPassword(employer.getPassword(), confirmPassword)) {

			return new ErrorResult("Passwords do not match.");
		}

		employerService.add(employer);
		String code = verificationService.sendCode();
		verificationCodeRecord(code, employer.getId(), employer.getEmail());
		return new SuccessResult("Registration has been successfully completed");

	}

	@Override
	public Result registerCandidate(Candidate candidate, String confirmPassword) {

		if (checkIfRealPerson(Long.parseLong(candidate.getIdentityNumber()), candidate.getFirstName(),
				candidate.getLastName(), candidate.getBirthDate()) == false) {
			return new ErrorResult("TCKN could not be verified.");
		}

		if (!checkIfNullInfoForCandidate(candidate, confirmPassword)) {

			return new ErrorResult("You have entered missing information. Please fill in all fields.");
		}

		if (!checkIfExistsTcNo(candidate.getIdentityNumber())) {

			return new ErrorResult(candidate.getIdentityNumber() + " already exists.");
		}

		if (!checkIfEmailExists(candidate.getEmail())) {

			return new ErrorResult(candidate.getEmail() + " already exists.");
		}

		
		candidateService.add(candidate);
		String code = verificationService.sendCode();
		verificationCodeRecord(code, candidate.getId(), candidate.getEmail());
		return new SuccessResult("Registration has been successfully completed");
	}

	// Validation for employer register ---START---

	private boolean checkIfNullInfoForEmployer(Employer employer) {

		if (employer.getCompanyName() != null && employer.getWeb() != null && employer.getEmail() != null
				&& employer.getPhoneNumber() != null && employer.getPassword() != null) {

			return true;

		}

		return false;
	}

	private boolean checkIfEqualEmailAndDomain(String email, String web) {
		String[] emailArr = email.split("@", 2);
		String domain = web.substring(4, web.length());

		if (emailArr[1].equals(domain)) {

			return true;
		}

		return false;
	}

	// Validation for employer register ---END---

	// Validation for candidate register ---START---
	
	private boolean checkIfNullInfoForCandidate(Candidate candidate, String confirmPassword) {

		if (candidate.getFirstName() != null && candidate.getLastName() != null && candidate.getIdentityNumber() != null
				&& candidate.getBirthDate() != null && candidate.getPassword() != null && candidate.getEmail() != null
				&& confirmPassword != null) {

			return true;

		}

		return false;
	}

	private boolean checkIfExistsTcNo(String identityNumber) {

		if (this.candidateService.getCandidateByIdentityNumber(identityNumber).getData() == null) {
			return true;
		}
		return false;
	}

	private boolean checkIfRealPerson(long identityNumber, String firstName, String lastName, Date date) {

		if (validationService.validateByMernis(identityNumber, firstName, lastName, date)) {
			return true;
		}
		return false;
	}

	// Validation for candidate register ---END---

	// Common Validation

	private boolean checkIfEmailExists(String email) {

		if (this.userService.getUserByEmail(email).getData() == null) {

			return true;
		}

		return false;
	}

	private boolean checkIfEqualPasswordAndConfirmPassword(String password, String confirmPassword) {

		if (!password.equals(confirmPassword)) {
			return false;
		}

		return true;
	}
	
	private void verificationCodeRecord(String code, int id, String email) {
		
		VerificationCode verificationCode = new VerificationCode(id, code, false);
		this.verificationCodeService.add(verificationCode);
		System.out.println("Verification code has been sent to " + email );
	
	}
}
