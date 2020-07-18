package com.vk.dwzkf.web;

import com.vk.dwzkf.model.Answer;
import com.vk.dwzkf.repository.AnswerRepository;
import com.vk.dwzkf.repository.InMemoryAnswerRepository;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean
@SessionScoped
public class AnswerManager {
    private AnswerRepository answerRepo = new InMemoryAnswerRepository();

    public List<Answer> getAll(int parentId) {
        return answerRepo.getAll(parentId);
    }
}
