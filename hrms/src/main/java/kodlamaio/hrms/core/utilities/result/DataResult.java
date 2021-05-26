package kodlamaio.hrms.core.utilities.result;

public class DataResult<T> extends Result{

	private T data;
	public DataResult(T Data, boolean success, String message) {
		super(success, message);
		this.data = data;
	} 
	public DataResult(T Data, boolean success ) {
		super(success);
		this.data = data;
	} 
	public T getData() {
	return this.data;
	}
}
