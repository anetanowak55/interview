package com.nowak.interview.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class WordCounterServiceTest {
    WordCounterService wordCounterService = new WordCounterService();
    String text = "He decided to count all the sand on the beach as a hobby. Chocolate covered crickets were his favorite snack.";

    @Test
    void countWordsIncudeCapital() {
        int wordsCount = wordCounterService.countWords(this.text, true);
        Assertions.assertEquals(20, wordsCount);
    }

    @Test
    void countWordsExcludeCapital() {
        int wordsCount = wordCounterService.countWords(this.text, false);
        Assertions.assertEquals(18, wordsCount);
    }
}