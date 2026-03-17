public class Student implements Comparable<Student> {
    private String name;
    private double gpa;
    private int age;

    // TODO: Task 1 — Создай конструктор, который принимает имя, GPA и возраст
    public Student(String name, double gpa, int age) {
        this.name = name;
        this.gpa = gpa;
        this.age = age;// заглушка
    }

    public String getName() { return name; }
    public double getGpa() { return gpa; }
    public int getAge() { return age; }

    // TODO: Task 1 — Добавь возможность изменить GPA
    public void setGpa(double newGpa) {
        this.gpa = newGpa;
    }

    // TODO: Task 1 (Sorting) — Реализуй Comparable по GPA (по возрастанию)
    @Override
    public int compareTo(Student other) {
        return Double.compare(this.gpa, other.gpa);

    }

    @Override
    public String toString() {
        // TODO: Сделай красивый вывод
        return "Name: " + getName()+ "\nGPA: " +getGpa()+ "\nAge: " + getAge();
    }
}