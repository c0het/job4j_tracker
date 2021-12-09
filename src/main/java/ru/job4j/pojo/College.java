package ru.job4j.pojo;

import java.time.LocalDate;

public class College {

    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Иванов Иван Иванович");
        student.setGroup("ЭО-11");
        student.setReceiptDate(LocalDate.parse("2001-12-03"));
        System.out.println("ФИО студента - " + student.getFullName() + System.lineSeparator()
                + "Группа - " +  student.getGroup() + System.lineSeparator()
                + "Дата поступления - " + student.getReceiptDate());
    }
}
