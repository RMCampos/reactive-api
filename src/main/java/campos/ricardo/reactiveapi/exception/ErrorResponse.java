package campos.ricardo.reactiveapi.exception;

import campos.ricardo.reactiveapi.vo.BaseResponse;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse implements BaseResponse {
  private Integer errorCode;
  private String errorMessage;

  public static ErrorResponse fromErrorEnum(ErrorCode code) {
    return ErrorResponse.builder()
        .errorCode(code.getCode())
        .errorMessage(code.getMessage())
        .build();
  }
}
