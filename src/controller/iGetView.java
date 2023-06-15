package controller;

import model.Student;

import java.util.List;

public interface iGetView {
    /**
     * напечатать список студентов
     * @param students
     */
    void printAllStudents(List<Student> students);

    /**
     * запросить у пользователя команду
     * @param message
     * @return
     */

    String prompt(String message);

    /**
     * перевести
     */
    String translateMessage(String message);
}
