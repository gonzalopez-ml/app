package appgonza.application.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;

@Setter
@Getter
@NoArgsConstructor
public class UserDto {

    private BigInteger Id;

    @NotNull(message = "Name is required ")
    @NotBlank(message = "Name is required")
    private String name;

    @NotNull(message = "Last name is required ")
    @NotBlank(message = "Last name is required ")
    private String lastName;

    @NotNull(message = "Dni is required ")
    @NotBlank(message = "Dni is required ")
    private String dni;

    @NotNull(message = "PhoneNumber is required ")
    @NotBlank(message = "PhoneNumber is required ")
    private String phoneNumber;

    @NotNull(message = "Email is required ")
    @NotBlank(message = "Email is required ")
    private String email;

    @NotNull(message = "User is required ")
    @NotBlank(message = "User is required ")
    private String user;

    @NotNull(message = "Pass is required ")
    @NotBlank(message = "Pass is required ")
    private String pass;

    public UserDto(String name, String lastName, String dni, String phoneNumber, String email, String user, String pass) {
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.user = user;
        this.pass = pass;
    }
}
