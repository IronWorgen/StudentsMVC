package model;

public class Student extends Person implements Comparable<Student> {
    private long studentId;

    public Student(String firstName, String secondName, int age, String address, long studentId) {
        super(firstName, secondName, age, address);
        this.studentId = studentId;
    }

    public Student(String firstName, String secondName, int age, long studentId) {
        super(firstName, secondName, age);
        this.studentId = studentId;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "Student{" + "firstname='" + super.getFirstName() + '\'' +
                "second name='" + super.getSecondName() +
                ", age=" + super.getAge() +
                ", address='" + super.getAddress() + '\'' +
                ", studentId=" + studentId +
                '}';
    }

    /**
     * метод указывает параметры для сортировки при вызове Collections.sort()
     * сортировка сначала по возрасту, потом по ID
     *
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Student o) {
        System.out.println(super.getFirstName() + o.getFirstName());
        if (this.getAge() == o.getAge()) {
            if (this.getStudentId() == o.getStudentId()) {

                return 0;
            }
            if (this.getStudentId() < o.getStudentId()) {
                return -1;
            }
            return 1;

        }
        if (this.getAge() < o.getAge()) {
            return -1;
        }
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        Student student = (Student) obj;
        if (super.getFirstName().equals(student.getFirstName()) &&
                super.getSecondName().equals(student.getSecondName()) &&
                super.getAge() == student.getAge()) {
            return true;
        }
        return false;
    }
}
