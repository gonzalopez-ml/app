package appgonza.application.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDto {
    private String name;
    private String lastName;
    private String dni;
    private String telefono;
    private String email;

    public UserDto() {

    }

    public UserDto(String name, String lastName, String dni, String telefono, String email, String user, String pass) {
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
    }
}
