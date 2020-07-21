package com.vk.dwzkf.repository;

import com.vk.dwzkf.model.Answer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PostgresAnswerRepository implements AnswerRepository {
    private Connection connection = DBConnection.getInstance();

    public PostgresAnswerRepository(){

    }

    @Override
    public void save(Answer answer) {
        if (connection==null) return;
        if (answer.getId()!=null) return;
        if (answer.getParentId()==null) return;
        String preparedSQL = "INSERT into answers (description, parentid) VALUES(?,?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(preparedSQL);
            preparedStatement.setString(1,answer.getText());
            preparedStatement.setInt(2,answer.getParentId());
            preparedStatement.execute();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Answer get(int id) {
        return null;
    }

    @Override
    public void update(Answer a) {

    }

    @Override
    public void remove(int id) {
        String preparedSQL = "DELETE FROM answers WHERE id=?;";
        try {
            PreparedStatement statement = connection.prepareStatement(preparedSQL);
            statement.setInt(1, id);
            statement.execute();
        }
        catch (Exception e) {

        }
    }

    @Override
    public List<Answer> getAll(int parentId) {
        String preparedSQL = "SELECT * FROM answers WHERE parentid=? ORDER BY id ASC;";
        List<Answer> answers = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(preparedSQL);
            statement.setInt(1, parentId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Answer a = new Answer();
                a.setId(rs.getInt("id"));
                a.setParentId(rs.getInt("parentid"));
                a.setText(rs.getString("description"));
                answers.add(a);
            }
        }
        catch (Exception e) {

        }
        return answers;
    }
}
