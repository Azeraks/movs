import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import one.ports.output.Output_port;

@Repository 
public class DatabaseController implements Output_port{

    private List<String> data = new ArrayList();

    @Override
    public void saveMessage(String message) {
        data.add(message);
    }

}