package com.example.beansexpt2;

import com.example.beansexpt2.formatter.DefaultMessageFormatter;
import com.example.beansexpt2.holder.MessageHolder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BeansExPt2ApplicationTests {

    @Autowired
    DefaultMessageFormatter msgForm;

    @Test
    void contextLoads() {
    }

    @Test
    void testSpanishMessageHolder(@Autowired @Qualifier("es") MessageHolder msgHolder) {
        String formattedMessage = msgForm.format(msgHolder.message());

        System.out.println(formattedMessage);

        Assertions.assertTrue(formattedMessage.contains("Hola Mundo!"));
    }

    @Test
    void testEnglishMessageHolder(@Autowired MessageHolder msgHolder) {
        String formattedMessage = msgForm.format(msgHolder.message());

        System.out.println(formattedMessage);

        Assertions.assertTrue(formattedMessage.contains("Hello World!"));
    }

    @Test
    void testFinnishMessageHolder(@Autowired @Qualifier("fi") MessageHolder msgHolder) {
        String formattedMessage = msgForm.format(msgHolder.message());

        System.out.println(formattedMessage);

        Assertions.assertTrue(formattedMessage.contains("Hei Maailma!"));
    }

    @Test
    void testItalianMessageHolder(@Autowired @Qualifier("it") MessageHolder msgHolder) {
        String formattedMessage = msgForm.format(msgHolder.message());

        System.out.println(formattedMessage);

        Assertions.assertTrue(formattedMessage.contains("Ciao Mondo!"));
    }

    @Test
    void testGermanMessageHolder(@Autowired @Qualifier("de") MessageHolder msgHolder) {
        String formattedMessage = msgForm.format(msgHolder.message());

        System.out.println(formattedMessage);

        Assertions.assertTrue(formattedMessage.contains("Hallo Welt!"));
    }
}
