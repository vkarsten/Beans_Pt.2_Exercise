package com.example.beansexpt2.holder;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class EnglishMessageHolder implements MessageHolder {

    @Override
    public String message() {
        return "Hello World!";
    }
}
