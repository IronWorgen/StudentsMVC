package controller;

import model.Student;

import java.util.List;

public interface iGetModel {

    /**
     *
     * @return список студентов
     */
    public List<Student>  getAllStudents();

    /**
     * удалить студента
     */
    void removeStudent(long id);

}
