package com.vk.dwzkf.repository;

import com.vk.dwzkf.model.Answer;

import java.util.List;

public interface AnswerRepository {
    void save(Answer answer);
    Answer get(int id);
    void update(Answer a);
    void remove(int id);
    List<Answer> getAll(int parentId);
}
