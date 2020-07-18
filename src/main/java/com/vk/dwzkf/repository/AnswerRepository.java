package com.vk.dwzkf.repository;

import com.vk.dwzkf.model.Answer;

import java.util.List;

public interface AnswerRepository {
    void save(Answer answer);
    void get(int id);
    void update(Answer a);
    void remove(Answer a);
    List<Answer> getAll();
}
