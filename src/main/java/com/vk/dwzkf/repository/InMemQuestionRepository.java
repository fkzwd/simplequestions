package com.vk.dwzkf.repository;

import com.vk.dwzkf.model.Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemQuestionRepository implements QuestionRepository{
    private List<Question> questions = new ArrayList<>();
    private AtomicInteger idValue = new AtomicInteger(0);

    public InMemQuestionRepository(){
        questions.addAll(Arrays.asList(
                new Question(idValue.incrementAndGet(),
                        "Question "+idValue.get(),
                        "Some description "+idValue.get()),
                new Question(idValue.incrementAndGet(),
                        "Question "+idValue.get(),
                        "Some description "+idValue.get())
        ));
    }

    @Override
    public List<Question> getAll() {
        return questions;
    }

    @Override
    public Question get(int id) {
        for (Question q : questions) {
            if (q.getId().compareTo(id)==0) return q;
        }
        return null;
    }

    @Override
    public void save(Question question) {
        if (question.getId()!=null) return;
        question.setId(idValue.incrementAndGet());
        questions.add(question);
    }

    @Override
    public void update(Question question) {
        Question question1 = get(question.getId());
        if (question1 == null) return;
        question1.setTitle(question.getTitle());
        question1.setText(question.getText());
    }

    @Override
    public void remove(Question question) {
        Question question1 = get(question.getId());
        if (question1==null) return;
        questions.remove(question);
    }
}
