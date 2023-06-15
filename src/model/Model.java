package model;

import controller.iGetModel;

import java.util.List;

public class Model implements iGetModel {
    private List<Student> students ;

    public Model(List<Student> students) {
        this.students = students;
    }

    public  List<Student> getAllStudents(){
        return  this.students;
    }

    @Override
    public void removeStudent(long id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentId() ==id){
                students.remove(i);
            }
        }
    }
}
