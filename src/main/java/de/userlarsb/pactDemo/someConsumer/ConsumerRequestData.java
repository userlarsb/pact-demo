package de.userlarsb.pactDemo.someConsumer;

public class ConsumerRequestData {
    private final String phrase;
    private final String name;

    public String getPhrase() {
        return phrase;
    }

    public String getName() {
        return name;
    }

    public ConsumerRequestData(String phrase, String name) {
        this.phrase = phrase;
        this.name = name;
    }
}
