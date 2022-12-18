package com.eren.medium.model.enums;

public enum BlogTag {
    PROGRAMMING("Programming"),
    TECHNOLOGY("Technology"),
    PYTHON("Python"),
    JAVA("Java"),
    ADVICE("Advice");

    private final String val;

    private BlogTag(String val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return val;
    }
}
