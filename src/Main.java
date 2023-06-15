import controller.Controller;
import controller.iGetModel;
import model.*;
import view.View;
import view.ViewEng;

import java.util.*;

public class Main {
    public static void main(String[] args) {


        Student u2 = new Student("Антон","Петров",22, "СПБ", 1);
        Student u3 = new Student("Стас","Иванов",22, "Москва", 2);
        Student u4 = new Student("Женя","Сидорова",19, "Калуга", 3);
        Student u5 = new Student("Маша","Соколова",40, "Мытищи", 4);
        Student u6 = new Student("Петя","Петя",22, "Москва", 5);
        List<Student> stud = new ArrayList<>(Arrays.asList(new Student[]{u2, u3, u4}));

        Model fModel = new Model(stud);


        Map <Long, Student>  studentMap= new HashMap<>();
        studentMap.put(1l,u5);
        HashModel hashModel = new HashModel(studentMap);

        hashModel.addStudent(u6);

        List<iGetModel> models= new ArrayList<>();
        models.add(fModel);
        models.add(hashModel);

        Controller controller =  new Controller(models);

        controller.run();

    }
}