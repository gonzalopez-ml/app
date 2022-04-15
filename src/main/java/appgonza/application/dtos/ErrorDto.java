package appgonza.application.dtos;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class ErrorDto {
    private String code;
    private String message;

    public ErrorDto(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
