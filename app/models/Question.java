package models;

/**
 * Created by Dmitry on 11/13/13.
 */
public class Question {

    private int questionId;
    private int responseId;

    public Question(int questionId, int responseId) {
        this.questionId = questionId;
        this.responseId = responseId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getResponseId() {
        return responseId;
    }

    public void setResponseId(int responseId) {
        this.responseId = responseId;
    }
}
