package model;

public class Employee extends Person {
    private String special;
    public Employee(String firstName, String secondName, int age, String address, String special) {
        super(firstName, secondName, age, address);
        this.special=special;
    }
    public Employee(String firstName, String secondName, int age ) {
        super(firstName, secondName, age);
        this.special=null;
    }



    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstname='" + super.getFirstName() + '\'' +
                "second name='"+super.getSecondName()+
                ", age=" + super.getAge() +
                ", address='" + super.getAddress() + '\'' +
                "special='" + special + '\'' +
                '}';
    }
}
