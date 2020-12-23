package de.userlarsb.pactDemo.someProvider;

public class ProviderResponseData {
    public final String greeting;

    public ProviderResponseData(String response) {
        this.greeting = response;
    }

    public String getGreeting() {
        return greeting;
    }
}
