package kodlamaio.hrms.core.utilities.result;


public class SuccessResult extends Result{
	public SuccessResult() {
		super(true);
	}

	public SuccessResult (boolean b, String message) {
		super(true,message);
		
	}
}
