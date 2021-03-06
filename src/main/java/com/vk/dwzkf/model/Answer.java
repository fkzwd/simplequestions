package com.vk.dwzkf.model;

public class Answer {
    private Integer parentId;
    private Integer id;
    private String text;

    public Answer() {

    }

    public Answer(int id, int parentId, String text) {
        this.parentId = parentId;
        this.id = id;
        this.text = text;
    }

    public Answer(int parentId, String text) {
        this.parentId = parentId;
        this.text = text;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
