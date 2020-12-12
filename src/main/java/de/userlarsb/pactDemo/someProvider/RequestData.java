package de.userlarsb.pactDemo.someProvider;

public class RequestData {
    private final String phrase;
    private final String name;

    public String getPhrase() {
        return phrase;
    }

    public String getName() {
        return name;
    }

    public RequestData(String phrase, String name) {
        this.phrase = phrase;
        this.name = name;
    }
}
