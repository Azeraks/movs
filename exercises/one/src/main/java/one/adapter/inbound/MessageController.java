package one.adapter.inbound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import one.ports.input.Input_port;


@RestController 
public class MessageController {
    

    private final Input_port service;

    @Autowired 
    MessageController(Input_port i) {
        this.service = i;
    }

    @GetMapping("test")
    public String getEcho(@RequestParam String message) {
        return service.message(message);
    }
}
