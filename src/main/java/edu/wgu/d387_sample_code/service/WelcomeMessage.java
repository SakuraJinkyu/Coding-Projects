package edu.wgu.d387_sample_code.service;


import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class WelcomeMessage implements Runnable {

    private final String language;
    private final List<String> messages;

    public WelcomeMessage(String language, List<String> messages) {
        this.language = language;
        this.messages = messages;
    }

    @Override
    public void run() {

        Locale locale = new Locale(language);
        ResourceBundle rb = ResourceBundle.getBundle("welcome", locale);
        String message = rb.getString("welcome");
        messages.add(message);
    }

}
