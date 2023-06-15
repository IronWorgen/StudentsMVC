package controller;

import model.Model;
import model.Student;
import view.View;
import view.ViewEng;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
    private iGetView view;
    /**
     * Список моделей
     */
    private List<iGetModel> models;

    private List<Student> studentList;

    public Controller(iGetView view, iGetModel model) {
        this.view = view;
        this.models =new ArrayList<>();
        this.models.add(model);
        this.studentList = new ArrayList<>();
    }

    /**
     * конструктор который создает контроллер на основе выбранного пользователем языка
     *
     * @param model
     */
    public Controller(iGetModel model) {

        String language = selectLanguage();
        switch (language) {
            case "eng":
                this.view = new ViewEng();
                break;
            case "rus":
                this.view = new View();
                break;
        }

        models= new ArrayList<>();
        this.models.add(model);

    }
    /**
     * конструктор который создает контроллер на основе выбранного пользователем языка
     *
     * @param models - список моделей
     */
    public Controller(List<iGetModel> models) {
        String language = selectLanguage();
        switch (language) {
            case "eng":
                this.view = new ViewEng();
                break;
            case "rus":
                this.view = new View();
                break;
        }
        this.models=models;

    }


    /**
     * запросить у модели список всех студентов
     */
    public void getAllStudents() {
        List<Student> newList = new ArrayList<>();
        for (iGetModel model : models) {
            newList.addAll(model.getAllStudents());
        }
        studentList = newList;
    }

    public boolean testData() {
        if (studentList.size() > 0) {
            return true;
        }
        return false;
    }

    /**
     * запуск программы
     */

    public void run() {
        Commands com = Commands.NONE;
        boolean getNewIteration = true;
        while (getNewIteration) {
            String command = view.prompt("Введите команду:");
            com = Commands.valueOf(command.toUpperCase());
            switch (com) {
                case EXIT:
                    getNewIteration = false;
                    System.out.println(view.translateMessage("Выход из программы!"));
                    break;
                case LIST:
                    getAllStudents();
                    view.printAllStudents(studentList);
                    break;

                case DELETE:
                    long studentID = Long.parseLong(view.prompt("Введите id:"));
                    for (iGetModel model : models) {
                        for (Student student : model.getAllStudents()) {
                            if (studentID==student.getStudentId()){
                                model.removeStudent(studentID);
                                break;
                            }
                        }
                    }
                    break;


            }

        }
    }

    /**
     * выбор языка при запуске программы
     *
     * @return
     */
    private String selectLanguage() {
        Scanner scanner = new Scanner(System.in);
        String input = "eng";
        boolean flag = true;
        while (flag) {
            System.out.println("Eng/Рус?");
            input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("eng") || input.equals("рус") || input.equals("rus")) {
                if (input.equals("рус")) {
                    input = "rus";
                }
                flag = false;
            } else {
                System.out.println("Error");
            }
        }
        return input;
    }

    public void update() {
        //----------------MVP-----------------

        getAllStudents();
        if (testData()) {
            view.printAllStudents(studentList);
        } else {
            System.out.println("список пуст");
        }

        //  --------------MVC-----------------
        //view.printAllStudents(model.getAllStudents());
    }

}
