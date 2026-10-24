package edu.wgu.d387_sample_code.rest;

import edu.wgu.d387_sample_code.service.WelcomeMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(ResourceConstants.WELCOME_V1)
@CrossOrigin
public class WelcomeResource {

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ResponseEntity<List<String>> getWelcome() throws InterruptedException {
        List<String> messages = new ArrayList<>();

        // Start both threads before returning
        Thread t1 = new Thread(new WelcomeMessage("en", messages));
        Thread t2 = new Thread(new WelcomeMessage("fr", messages));
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        return new ResponseEntity<>(messages, HttpStatus.OK);
    }
}
