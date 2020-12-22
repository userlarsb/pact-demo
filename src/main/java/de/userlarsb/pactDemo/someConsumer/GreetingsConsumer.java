package de.userlarsb.pactDemo.someConsumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GreetingsConsumer {

    private final RestTemplate restTemplate;

    private final String greetingsURL;

    public GreetingsConsumer(RestTemplate restTemplate,
                             @Value("${greetingsUrl}") String greetingsURL) {
        this.restTemplate = restTemplate;
        this.greetingsURL = greetingsURL;
    }

    public String consumeGreeting(String phrase, String name) {
        ConsumerResponseData response = restTemplate.postForObject(greetingsURL + "greeting",
                ConsumerRequestData.class,
                ConsumerResponseData.class);
        return response.getResponse();
    }
}
