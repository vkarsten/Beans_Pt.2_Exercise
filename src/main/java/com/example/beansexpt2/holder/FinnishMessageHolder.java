package com.example.beansexpt2.holder;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("fi")
public class FinnishMessageHolder implements MessageHolder {
    @Override
    public String message() {
        return "Hei Maailma!";
    }
}
