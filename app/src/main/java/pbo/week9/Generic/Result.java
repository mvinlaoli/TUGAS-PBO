package pbo.week9.Generic;

public class Result<T> {
    private final boolean isSuccess;
    private final String errorMessage;
    private final T data;

    private Result(boolean isSuccess, String errorMessage, T data) {
        this.isSuccess = isSuccess;
        this.errorMessage = errorMessage;
        this.data = data;
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(true, null, data);
    }

    public static <T> Result<T> failure(String errorMessage) {
        return new Result<>(false, errorMessage, null);
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public T getData() {
        return data;
    }
}
