package appgonza.application.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Data //getter y setter
@NoArgsConstructor
@ToString
@Document(collection = "users")
public class User {

    private BigInteger id;
    private String name;
    private String lastName;
    private String dni;
    private String phoneNumber;
    private String email;
    private String user;
    private String pass;
}