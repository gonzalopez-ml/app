package appgonza.application.exceptions;

import appgonza.application.dtos.ErrorDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
public class BaseException extends Exception{
    private ErrorDto statusCode;
    private HttpStatus status;

    public BaseException(String message, HttpStatus status) {
        super(message);
        this.statusCode = new ErrorDto(status.toString(), message);
        this.status = status;

    }
}
