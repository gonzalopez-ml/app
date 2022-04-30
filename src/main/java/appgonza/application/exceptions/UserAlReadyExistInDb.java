package appgonza.application.exceptions;

import lombok.Data;

@Data
public class UserAlReadyExistInDb extends RuntimeException{
    private String code;

    public UserAlReadyExistInDb(String code, String message) {
        super(message);
        this.code = code;
    }
}
