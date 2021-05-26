package kodlamaio.hrms.core.utilities.result;


public class SuccessDataResult<T> extends DataResult<T> {

	public SuccessDataResult(T Data, String message ) {
		super(Data, true, message);
	}
	
	public SuccessDataResult( T data){
		super(data,true);
	}
	
	public SuccessDataResult( String message ) {
		super(null, true, message);
	}
	
	public SuccessDataResult( ) {
		super(null, true);
	}


}
