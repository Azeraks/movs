import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import one.ports.output.OutputPort;

@Repository 
public class DatabaseController implements OutputPort{

    private List<String> data = new ArrayList();

    @Override
    public void saveMessage(String message) {
        data.add(message);
    }

}