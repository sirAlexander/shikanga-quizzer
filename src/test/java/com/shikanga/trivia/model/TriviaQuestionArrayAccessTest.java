package com.shikanga.trivia.model;

import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class TriviaQuestionArrayAccessTest {

    @Test
    public void getQuestionByIndex() {
        System.out.println("getQuestionByIndex");
        long index = 0;
        TriviaQuestionArrayAccess instance = new TriviaQuestionArrayAccess();
        TriviaQuestion expResult = (new TriviaQuestionBuilder())
                .id(1)
                .question("What was the first toy advertised on television?")
                .answerA("The Rubix Cube")
                .answerB("Mr. Potato Head")
                .answerC("Barbie")
                .answerD("A hula hoop")
                .correctAnswer("B")
                .hint("Use your head on this one")
                .lastUpdated(new Date())
                .build();
        TriviaQuestion result = instance.getQuestionByIndex(index);
        assertEquals("Trivia questions 1 do not match in ::getQuestion().", expResult.getId(), result.getId());
    }

    @Test
    public void getQuestionById() {
        System.out.println("getQuestionById");
        long Id = 3;
        TriviaQuestionArrayAccess instance = new TriviaQuestionArrayAccess();
        TriviaQuestion expResult = (new TriviaQuestionBuilder())
                .id(3)
                .question("The martial art of kung fu originated in which country?")
                .answerA("Viet Nam")
                .answerB("United States")
                .answerC("Japan")
                .answerD("China")
                .correctAnswer("D")
                .hint("Name most likely derives from the name of the Qin dynasty")
                .lastUpdated(new Date())
                .build();
        TriviaQuestion result = instance.getQuestionById(Id);
        assertEquals("Trivia questions 1 do not match in ::getQuestion().", expResult.getId(), result.getId());
    }

    @Test
    public void getRandomQuestion() {
        System.out.println("getRandomQuestion");
        TriviaQuestionArrayAccess instance = new TriviaQuestionArrayAccess();
        TriviaQuestion result = instance.getRandomQuestion();
        assertNotNull("A random question was not returned in ::getRandomQuestion().", result);
    }

    @Test
    public void getQuestionList() {
        System.out.println("getQuestionList");
        long offset = 0L;
        TriviaQuestionArrayAccess instance = new TriviaQuestionArrayAccess();
        List<TriviaQuestion> result = instance.getQuestionList(offset);

        assertNotNull("Trivia question list not returned in ::getQuestionList.", result);
        assertEquals(10, result.size());
    }

    @Test
    public void getSpecifiedQuestionList() {
        TriviaQuestionArrayAccess instance = new TriviaQuestionArrayAccess();

        List<TriviaQuestion> questionList = instance.getSpecifiedQuestionList(1L, 5L, 8L);

        List<Long> actual = questionList.stream()
                .map(TriviaQuestion::getId)
                .collect(Collectors.toList());

        List<Long> expected = Arrays.asList(1L, 5L, 8L);
        assertTrue(actual.containsAll(expected));
    }

    @Test
    public void getQuestionListSize() {
        System.out.println("getQuestionListSize");
        TriviaQuestionArrayAccess instance = new TriviaQuestionArrayAccess();
        long expResult = 11;
        long result = instance.getQuestionListSize();
        assertEquals("There should only be 11 trivia questions in ::getQuestionListSize.", expResult, result);
    }
}