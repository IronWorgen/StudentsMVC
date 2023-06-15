package view;

import controller.iGetView;
import model.Student;

import java.util.List;
import java.util.Scanner;

public class View implements iGetView{
    /**
     * напечатать список студентов
     * @param students
     */
    public void  printAllStudents(List<Student> students){
        System.out.println("----Список студентов-------");
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println("----Конец-------");

    }

    /**
     * запрос команды у пользователя
     * @param message
     * @return
     */
    @Override
    public String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print("\n"+message);
        return in.nextLine().trim();
    }

    @Override
    public String translateMessage(String message) {
        return message;
    }
}
