package model;

import controller.iGetModel;
import controller.iSetModel;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HashModel implements iGetModel, iSetModel {
    private Map<Long, Student> students;
    private long countStudents;

    public HashModel(Map<Long, Student> students) {
        this.students = students;
        countStudents = students.size();
    }


    /**
     * @return список студентов
     */
    @Override
    public List<Student> getAllStudents() {

        for (Long aLong : students.keySet()) {
            System.out.println(aLong);
        }
        List <Student> studentList = new ArrayList<>();
        for (Long aLong : students.keySet()) {
            studentList.add(students.get(aLong));
        }

        return studentList;
    }

    /**
     * добавить студента
     * @param student
     */
    @Override
    public void addStudent(Student student) {
        countStudents++;
        students.put(countStudents, student);
    }

    /**
     * удалить студента
     * @param studentID
     */
    @Override
    public boolean deleteStudent(int studentID) {
        // флаг на случай если несколько одинаковых студентов в модели
        boolean flag = false;
        for (Map.Entry<Long, Student> entry : students.entrySet()) {
            if(entry.getValue().getStudentId()==studentID){
                students.remove(entry.getKey());
                flag = true;
            }
        }
        return flag;
    }

    /**
     * удалить студента
     * @param id
     * @return
     */
    @Override
    public void removeStudent(long id) {
        for (Map.Entry<Long, Student> entry : students.entrySet()) {
            if(entry.getValue().getStudentId()==id){
                students.remove(entry.getKey());
                return;
            }
        }
    }
}
