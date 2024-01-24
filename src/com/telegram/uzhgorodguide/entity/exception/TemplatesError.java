package com.telegram.uzhgorodguide.entity.exception;

public enum TemplatesError {
    REQUIRED("Поле %s є обов'язковим до заповнення."),
    MIN_LENGTH("Поле %s не може бути меншим за %d симв."),
    MAX_LENGTH("Поле %s не може бути більшим за %d симв."),
    ONLY_LATIN("Поле %s лише латинські символи та символ _."),
    PASSWORD("Поле %s латинські миволи, хочаб одна буква з великої, одна з малої та хочаб одна цифра.");

    private String template;

    private TemplatesError(String template) {
        this.template = template;
    }

    public String getTemplate() {
        return this.template;
    }
}
