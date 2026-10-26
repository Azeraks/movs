package one.adapter.inbound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import one.ports.input.InputPort;


@RestController 
public class MessageController {

    private final InputPort service;

    @Autowired 
    MessageController(InputPort i) {
        this.service = i;
    }

    @GetMapping("test")
    public String getEcho(@RequestParam String message) {
        return service.message(message);
    }
}
