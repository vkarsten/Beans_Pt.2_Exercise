package com.example.beansexpt2.holder;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("it")
public class ItalianMessageHolder implements MessageHolder {
    @Override
    public String message() {
        return "Ciao Mondo!";
    }
}
