package one.service;

import org.springframework.stereotype.Service;

import one.ports.input.Input_port;

@Service
public class MessageService implements Input_port {
    
    @Override
    public String message(String m) {
        System.out.println("Service: " + m);
        return "Service: " + m;
    }
}
