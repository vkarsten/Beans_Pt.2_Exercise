package com.example.beansexpt2.holder;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("de")
public class GermanMessageHolder implements MessageHolder {

    @Override
    public String message() {
        return "Hallo Welt!";
    }
}
