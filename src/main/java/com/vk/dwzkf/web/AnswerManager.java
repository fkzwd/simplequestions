package com.vk.dwzkf.web;

import com.vk.dwzkf.model.Answer;
import com.vk.dwzkf.model.Question;
import com.vk.dwzkf.repository.AnswerRepository;
import com.vk.dwzkf.repository.InMemoryAnswerRepository;
import com.vk.dwzkf.repository.PostgresAnswerRepository;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.List;
import java.util.Map;

@ManagedBean
@SessionScoped
public class AnswerManager {
    private AnswerRepository answerRepo = new PostgresAnswerRepository();

    public List<Answer> getAll(int parentId) {
        return answerRepo.getAll(parentId);
    }

    public String newAnswer(int parentId) {
        Answer a = new Answer();
        a.setParentId(parentId);
        Map<String, Object> map = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        map.put("answer", a);
        return "newanswer.xhtml";
    }

    public String createAnswer(int parentId) {
        Map<String, Object> map = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        Question q = (Question) map.get("question");
        if (q.getId().compareTo(parentId)==0) {
            Answer a = (Answer) map.get("answer");
            if (!a.getText().isEmpty()) {
                answerRepo.save(a);
            }
            return "answers.xhtml?faces-redirect=true";
        }
        return "answers.xhtml?faces-redirect=true";
    }

    public String toAnswers(){
        Map<String, Object> map = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        map.remove("answer");
        return "answers.xhtml?faces-redirect=true";
    }

    public String remove(int id) {
        answerRepo.remove(id);
        return "answers.xhtml?faces-redirect=true";
    }
}
