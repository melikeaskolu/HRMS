package kodlamaio.hrms.core.activation;

import org.springframework.stereotype.Service;

@Service
public class ActivationManager implements ActivationService{


	@Override
	public void sendLink(String email) {
		System.out.println("Verification link has been sent to" + email); //doğrulama bağlantısı şu adrese gönderildi
		System.out.println("Please click on the link to verify your account" );  //Hesabınızı doğrulamak için lütfen bağlantıya tıklayın
	
		
	}

	@Override
	public void sendCode(int activationCode) {
		System.out.println("Your activation code"+ activationCode);   //aktivasyon kodunuz
		
	}

}
