import org.springframework.web.bind.annotation.RestController;

@RestController
public class Service implements InPort{

    @Override
    public void registration(String firstname, String lastname, String password) {
        User user = new User(firstname, lastname, password);
    }
}
