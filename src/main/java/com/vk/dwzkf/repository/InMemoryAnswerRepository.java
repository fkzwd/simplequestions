package com.vk.dwzkf.repository;

import com.vk.dwzkf.model.Answer;
import com.vk.dwzkf.model.Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryAnswerRepository implements AnswerRepository{
    private List<Answer> answers;
    private AtomicInteger idValue = new AtomicInteger();

    public InMemoryAnswerRepository() {
        answers = new ArrayList<>();
        answers.addAll(Arrays.asList(
                new Answer(idValue.incrementAndGet(),1,"Answer 1\r\nblabla\r\nblah blah then blah\r\nand blah"),
                new Answer(idValue.incrementAndGet(),1, "Answer 2\r\n\r\nasdasd\r\na"),
                new Answer(idValue.incrementAndGet(),1,"Answer 3\naaaaf\n"),
                new Answer(idValue.incrementAndGet(),1,"Answer 3\naaaaf\n"),
                new Answer(idValue.incrementAndGet(),1,"Answer 3\naaaaf\n"),
                new Answer(idValue.incrementAndGet(),1,"Answer 3\naaaaf\n"),
                new Answer(idValue.incrementAndGet(),1,"Answer 3\naaaaf\n"),
                new Answer(idValue.incrementAndGet(),1,"Answer 3\naaaaf\n"),
                new Answer(idValue.incrementAndGet(),1,"Answer 3\naaaaf\n"),
                new Answer(idValue.incrementAndGet(),1,"Answer 3\naaaaf\n"),
                new Answer(idValue.incrementAndGet(),1,"Answer 3\naaaaf\n"),
                new Answer(idValue.incrementAndGet(),1,"Answer 3\naaaaf\n"),
                new Answer(idValue.incrementAndGet(),2, "Answer 1"),
                new Answer(idValue.incrementAndGet(),2, "Answer 2"),
                new Answer(idValue.incrementAndGet(),2, "Answer 3")
        ));
    }

    @Override
    public void save(Answer answer) {
        if (answer.getId()!=null) return;
        if (answer.getParentId()==null) return;
        answer.setId(idValue.incrementAndGet());
        answers.add(answer);
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

    }

    @Override
    public List<Answer> getAll(int parentId) {
        List<Answer> answerList = new ArrayList<>();
        for (Answer a : answers) {
            if (a.getParentId().compareTo(parentId) == 0) {
                answerList.add(a);
            }
        }
        return answerList;
    }
}
