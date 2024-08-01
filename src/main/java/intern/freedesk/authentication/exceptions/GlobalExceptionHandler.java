package intern.freedesk.authentication.exceptions;


import intern.freedesk.authentication.api.response.BaseResponse;
import intern.freedesk.authentication.lib.constants.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j

public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<BaseResponse> handleException(RuntimeException e){
        log.error("Error: " + e);
        return ResponseEntity.internalServerError().body(createFailResponse(e.getMessage().split("HataMesaji")[1].substring(3,e.getMessage().split("HataMesaji")[1].length()-3)));
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<BaseResponse> handleException (NotFoundException e){
        log.error("Error: " + e);
        //no_content
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(createFailResponse(e.getMessage()));
    }

    private BaseResponse createFailResponse(String message) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setResultCode(Constants.FAILED);
        baseResponse.setMessage(message);
        return baseResponse;
    }

}
