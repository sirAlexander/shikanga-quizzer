package com.shikanga.trivia.model;

import java.util.Date;
import java.util.Objects;

/**
 * Represents a trivia question. This class is immutable
 * and should be created cy the builder {@link TriviaQuestionBuilder}
 */
final public class TriviaQuestion {
    final private long id;
    final private String question;
    final private String answerA;
    final private String answerB;
    final private String answerC;
    final private String answerD;
    final private String correctAnswer;
    final private String hint;
    final private Date lastUpdated;

    /**
     * Constructor. Intentionally package scope. This class should be created by
     * the builder {@link TriviaQuestionBuilder}.
     *
     * @param id
     * @param question
     * @param answerA
     * @param answerB
     * @param answerC
     * @param answerD
     * @param correctAnswer
     * @param hint
     * @param lastUpdated
     */
    TriviaQuestion(long id,
                   String question,
                   String answerA,
                   String answerB,
                   String answerC,
                   String answerD,
                   String correctAnswer,
                   String hint,
                   Date lastUpdated) {
        this.id = id;
        this.question = question;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
        this.correctAnswer = correctAnswer;
        this.hint = hint;
        this.lastUpdated = lastUpdated;
    }

    public long getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswerA() {
        return answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public String getAnswerD() {
        return answerD;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getHint() {
        return hint;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TriviaQuestion that = (TriviaQuestion) o;
        return id == that.id &&
                Objects.equals(question, that.question) &&
                Objects.equals(answerA, that.answerA) &&
                Objects.equals(answerB, that.answerB) &&
                Objects.equals(answerC, that.answerC) &&
                Objects.equals(answerD, that.answerD) &&
                Objects.equals(correctAnswer, that.correctAnswer) &&
                Objects.equals(hint, that.hint) &&
                Objects.equals(lastUpdated, that.lastUpdated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, question, answerA, answerB, answerC, answerD, correctAnswer, hint, lastUpdated);
    }
}
