package de.userlarsb.pactDemo.someProvider;

import org.springframework.web.bind.annotation.*;

@RestController
public class ProviderController {

    @GetMapping("/greeting")
    public ProviderResponseData createProperGreeting(
            @RequestParam(value = "phrase") String phrase,
            @RequestParam(value = "name") String name) {
        return new ProviderResponseData(phrase + name);
    }

    @PostMapping("/greeting")
    public ProviderResponseData postProperGreeting(@RequestBody ProviderRequestData requestData) {
        return new ProviderResponseData(requestData.getPhrase() + requestData.getName());
    }
}
