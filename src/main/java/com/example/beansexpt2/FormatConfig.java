package com.example.beansexpt2;

import com.example.beansexpt2.formatter.DefaultMessageFormatter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FormatConfig {
    @Bean
    DefaultMessageFormatter getMessageFormatter() { return new DefaultMessageFormatter(); }
}
