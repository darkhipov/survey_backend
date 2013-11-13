package models;

import org.apache.log4j.Logger;
import play.db.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitry on 11/13/13.
 */
public class SurveyManagement {

    private static final Logger _logger = Logger.getLogger(SurveyManagement.class);

    public static void submitResponses(int surveyNumber, int questionNumber, int responseNumber) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DB.getConnection();
            stmt = conn.prepareStatement("insert into survey_responses values (?,?,?) " +
                    "on duplicate key update response_number = ?");
            stmt.setInt(1, surveyNumber);
            stmt.setInt(2, questionNumber);
            stmt.setInt(3, responseNumber);
            stmt.setInt(4, responseNumber);
            stmt.executeUpdate();

            conn.close();
        } catch (SQLException e) {
            _logger.error("DB error: " + e);
        }
    }

    public static List<Question> getSurveyResponses(int surveyNumber) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Question> responses = new ArrayList<Question>();
        try {
            conn = DB.getConnection();
            stmt = conn.prepareStatement("select * from survey_responses where survey_id = ?");
            stmt.setInt(1, surveyNumber);
            rs = stmt.executeQuery();
            while (rs.next()) {
                responses.add(new Question(rs.getInt("question_id"), rs.getInt("response_number")));
            }

            conn.close();
        } catch (SQLException e) {
            _logger.error("DB error: " + e);
        }
        return responses;
    }
}
