package appgonza.application.exceptions;

import lombok.Data;

@Data
public class UsersNotFoundInDbException extends RuntimeException{
    private String code;

    public UsersNotFoundInDbException(String code, String message) {
        super(message);
        this.code = code;
    }
}
