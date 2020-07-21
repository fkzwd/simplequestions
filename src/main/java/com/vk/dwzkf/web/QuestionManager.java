package com.vk.dwzkf.web;

import com.vk.dwzkf.model.Question;
import com.vk.dwzkf.repository.InMemQuestionRepository;
import com.vk.dwzkf.repository.PostgresQuestionRepository;
import com.vk.dwzkf.repository.QuestionRepository;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.List;
import java.util.Map;

@ManagedBean
@SessionScoped
public class QuestionManager {
    private QuestionRepository questionRepo = new PostgresQuestionRepository();

    public QuestionManager(){

    }

    public List<Question> getAll(){
        return questionRepo.getAll();
    }

    public String checkoutQuestion(int id) {
        Question q = questionRepo.get(id);
        if (q == null) return "index.xhtml?faces-redirect=true";

        Map<String, Object> reqMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        reqMap.put("question", q);
        return "answers.xhtml?faces-redirect=true";
    }

    public String newQuestion(){
        Question q = new Question();
        Map<String, Object> reqMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        reqMap.put("question", q);
        return "newquestion.xhtml";
    }

    public String createQuestion() {
        Map<String, Object> reqMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        Question q = (Question) reqMap.get("question");
        if (!q.getTitle().isEmpty() && !q.getText().isEmpty()) {
            questionRepo.save(q);
        }
        return "questions.xhtml?faces-redirect=true";
    }
}
