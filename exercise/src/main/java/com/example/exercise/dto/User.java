

import lombok.Getter;
import lombok.Setter;


@Setter @Getter
public class User {
    
    private final String firstname;
    private final String lastname;
    private final String password;


    public User(String f, String l, String p) {
        this.firstname = f;
        this.lastname = l;
        this.password = p;
    }
}
