package kodlamaio.hrms.core.activation;

public interface ActivationService {
	void sendLink(String email);
	void sendCode(int activationCode);

}
