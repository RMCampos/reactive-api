package campos.ricardo.reactiveapi.exception;

public enum ErrorCode {
  ENTITY_NOT_FOUND(100, "%s not found"),
  UNKNOWN_ERROR(999, "Unknown error");

  private final int code;
  private final String message;

  ErrorCode(int code, String message) {
    this.code = code;
    this.message = message;
  }

  public int getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }
}
