package com.nowak.interview.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class WordCounterService {

    public int countWords(String text, Boolean countCapital) {
        List<String> wordsList = Arrays.stream(text.split("\\W+")).toList(); //split by anything that's not a word
        int counter = 0;

        if (countCapital == null || countCapital) {
            counter = wordsList.size();
        } else {
            Pattern capitalLetterWordPattern = Pattern.compile("\\b[a-z].*?\\b");
            List<String> filteredWordsList = wordsList.stream().filter(capitalLetterWordPattern.asPredicate()).toList();
            counter = filteredWordsList.size();
        }

        return counter;
    }
}
