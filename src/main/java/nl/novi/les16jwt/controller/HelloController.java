package nl.novi.les16jwt.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String sayHello(@AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails != null) {
            return "Hello " + userDetails.getUsername();
        }
        else {
            return "Hello stranger!";
        }
    }

    @GetMapping("/secret")
    public String tellSecret() {
        return " this is secret...";
    }
}
