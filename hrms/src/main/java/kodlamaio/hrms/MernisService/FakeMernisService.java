package kodlamaio.hrms.MernisService;

public class FakeMernisService {
	public boolean ValidateByPersonalInfo(String nationalityIdentity, String first_name, String last_name, String birth_date)
	{
		System.out.println(first_name + " " + last_name + "is valid person.");
		return true;
	}

}
