package one.service;

import org.springframework.stereotype.Service;

import one.ports.input.InputPort;

@Service
public class MessageService implements InputPort {
    
    @Override
    public String message(String m) {
        String res = "Service" + m;
        System.out.println(res);
        return res;
    }
}
