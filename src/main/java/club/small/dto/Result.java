package club.small.dto;

/**
 * 封装json对象，所有返回结果都使用它
 */
public class Result<T> {

	private boolean success;// 是否成功标志

	private T data;// 成功时返回的数据

	private String error;// 错误信息

	public Result() {

	}

	// 成功时调用的构造器
	public Result(T data) {
		this.success = true;
		this.data = data;
	}

	// 失败时调用的构造器
	public Result(String error) {
		this.success = false;
		this.error = error;

	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
}
