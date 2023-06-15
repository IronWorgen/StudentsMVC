package view;

import controller.iGetView;
import model.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ViewEng implements iGetView {
    /**
     * словарь основных сообщений
     */
    Map<String,String> language;

    public ViewEng() {
        this.language = new HashMap<>();
        language.put("Введите команду:", "input command:");
        language.put("Выход из программы!", "Exit the program!");
        language.put("Введите id:", "Input id:");
    }

    /**
     * напечатать студентов
     * @param students
     */
    @Override
    public void printAllStudents(List<Student> students) {
        System.out.println("beginning of the list");
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println("end");
    }

    /**
     * запросить команду
     * @param message
     * @return
     */
    @Override
    public String prompt(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n"+translateMessage(message));

        return scanner.nextLine().trim();
    }

    /**
     * перевести сообщение
     * @param message
     * @return
     */

    public String translateMessage(String message){
        for (String s : language.keySet()) {
            if(s.trim().equals(message)){
                return language.get(s);
            }
        }
        return message;
    }
}
