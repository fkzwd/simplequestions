package com.vk.dwzkf.repository;

import com.vk.dwzkf.model.Question;

import java.util.List;

public interface QuestionRepository {
    List<Question> getAll();
    Question get(int id);
    void save(Question question);
    void update(Question question);
    void remove(int id);
}
