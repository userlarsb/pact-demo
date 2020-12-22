package de.userlarsb.pactDemo.someConsumer;

import au.com.dius.pact.consumer.MockServer;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.web.client.RestTemplateBuilder;


@ExtendWith(PactConsumerTestExt.class)
class GreetingsConsumerPactTest {

    final String someName = "some name";

    @Pact(provider = "GreetingsProvider", consumer = "someConsumer")
    public RequestResponsePact createPact(PactDslWithProvider builder) {
        PactDslJsonBody requestBody = new PactDslJsonBody()
                .stringType("phrase", "anotherPhrase")
                .stringValue("name", someName).asBody();
        PactDslJsonBody responseBody = new PactDslJsonBody()
                .stringType("greeting");

        return builder
                .given("we want to greet someone")
                .uponReceiving("a phrase and a name")
                .path("/greeting")
                .method("POST")
                .body(requestBody)
                .headers("Content-Type", "application/json")
                .willRespondWith()
                .body(responseBody)
                .toPact();
    }

    @Test
    public void testConsumer(MockServer mockServer) {
        GreetingsConsumer greetingsConsumer = new GreetingsConsumer(
                new RestTemplateBuilder().build(),
                mockServer.getUrl());
        greetingsConsumer.consumeGreeting("phrase", someName);
    }

}