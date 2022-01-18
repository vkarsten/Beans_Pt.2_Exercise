package com.example.beansexpt2.holder;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("es")
public class SpanishMessageHolder implements MessageHolder {
    @Override
    public String message() {
        return "Hola Mundo!";
    }
}
