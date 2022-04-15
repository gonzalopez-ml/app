package appgonza.application.models;

import com.mongodb.lang.NonNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data //getter y setter
@NoArgsConstructor
@ToString
@Document(collection = "users")
public class User {

    private String _id;

    private String name;
    private String lastName;
    private String dni;
    private String telefono;
    private String email;
    private String user;
    private String pass;

}
