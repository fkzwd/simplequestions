package com.vk.dwzkf.repository;

import com.vk.dwzkf.model.Question;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PostgresQuestionRepository implements QuestionRepository{
    private Connection connection = DBConnection.getInstance();

    @Override
    public List<Question> getAll() {
        String sql = "SELECT * FROM questions ORDER BY id ASC;";
        List<Question> questions = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            statement.execute(sql);
            ResultSet rs = statement.getResultSet();
            while (rs.next()) {
                Question q = new Question();
                q.setId(rs.getInt("id"));
                q.setTitle(rs.getString("title"));
                q.setText(rs.getString("description"));
                questions.add(q);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return questions;
    }

    @Override
    public Question get(int id) {
        String sql = "SELECT * FROM questions WHERE id=?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            ResultSet rs = preparedStatement.getResultSet();
            Question q = new Question();
            rs.next();
            q.setId(rs.getInt("id"));
            q.setText(rs.getString("description"));
            q.setTitle(rs.getString("title"));
            return q;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(Question question) {
        if (question.getId()!=null) return;
        String sql = "INSERT INTO questions (description, title) VALUES(?,?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, question.getText());
            preparedStatement.setString(2, question.getTitle());
            preparedStatement.execute();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Question question) {

    }

    @Override
    public void remove(int id) {
        String preparedSQL = "DELETE FROM questions where id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(preparedSQL);
            preparedStatement.setInt(1,id);
            preparedStatement.execute();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
