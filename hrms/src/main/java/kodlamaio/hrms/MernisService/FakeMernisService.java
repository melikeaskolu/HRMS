package kodlamaio.hrms.MernisService;

import java.util.Date;

public class FakeMernisService {
	public boolean ValidateByPersonalInfo(long identityNumber, String firstName, String lastName, Date birthDate) {
		System.out.println(firstName + " " + lastName + " is valid person.");
		return true;
	}

}
