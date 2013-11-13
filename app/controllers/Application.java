package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
        render();
    }

    public static void submitResponse(int surveyNumber, int questionNumber, int responseNumber) {
        SurveyManagement.submitResponses(surveyNumber, questionNumber, responseNumber);
    }

    public static void getResponses(int surveyNumber) {
        List<Question> responses = SurveyManagement.getSurveyResponses(surveyNumber);
        renderJSON(responses);
    }

}