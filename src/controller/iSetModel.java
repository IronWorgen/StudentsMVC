package controller;

import model.Student;

public interface iSetModel {
    /**
     * добавить студента
     * @param student
     */
    void addStudent(Student student);

    /**
     * удалить студента
     * @param studentID
     */
    boolean deleteStudent(int studentID);
}
