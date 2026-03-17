import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Student> students = new HashMap<>();

        // ====================== TASK 1 ======================
        // TODO: Добавь минимум 5 студентов (ключ = ID)
        // Сделай минимум два студента с одинаковым GPA (для Task 3)
        students.put("S001", new Student("Alice",   3.9, 20));
        students.put("S002", new Student("Amir",     3.5, 22));
        students.put("S003", new Student("Aygerim", 3.7, 21));
        students.put("S004", new Student("Bayaman",   3.5, 23)); // same GPA as Bob
        students.put("S005", new Student("Elenora",     3.2, 19));
        students.put("S006", new Student("Aisha",   3.8, 24));

        // TODO: Напечатай всех студентов (ID + объект)
        printAll(students);

        // TODO: Найди студента по ID и выведи его
        findById(students, "S003");

        // TODO: Удали одного студента по ID
        removeById(students, "S005");

        // TODO: Обнови GPA у одного студента
        updateGpa(students, "S001", 4.0);

        // ====================== SORTING (IMPORTANT) ======================
        // TODO: Создай ArrayList из всех студентов (students.values())
        List<Student> studentList = new ArrayList<>(students.values());

        // TODO 6a: Отсортируй по GPA (natural ordering) и выведи
        sortByGpa(studentList);

        // TODO 6b: Отсортируй по имени (Comparator) и выведи
        sortByName(studentList);

        // ====================== TASK 2 ======================
        // TODO: Создай новый список, отсортируй по GPA по убыванию, выведи первые 3
        printTop3(students);

        // ====================== TASK 3 ======================
        // TODO: Сгруппируй студентов по GPA и выведи только те, где больше 1 студента
        printSameGpa(students);

        // ====================== TASK 4 ======================
        HashMap<Course, List<Student>> courseMap = new HashMap<>();
        // TODO: Создай 2–3 курса, добавь студентов, выведи всё
        setupAndPrintCourses(courseMap, students);

        // ====================== TASK 5 ======================
        // TODO: Создай Comparator (GPA убывание → если равно, то имя возрастание) и отсортируй
        sortGpaDescThenName(students);
    }

    // ====================== HELPER METHODS ======================

    static void printAll(HashMap<String, Student> students) {
        for (Map.Entry<String, Student> entry : students.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    static void findById(HashMap<String, Student> students, String id) {
        Student s = students.get(id);
        System.out.println(s != null ? s : "Not found: " + id);
    }

    static void removeById(HashMap<String, Student> students, String id) {
        students.remove(id);
        System.out.println("\nRemoved " + id);
    }

    static void updateGpa(HashMap<String, Student> students, String id, double newGpa) {
        Student s = students.get(id);
        if (s != null) {
            s.setGpa(newGpa);
            System.out.println("Updated " + id + " GPA to " + newGpa + ": " + s);
        }
    }

    static void sortByGpa(List<Student> list) {
        Collections.sort(list);
        for (Student s : list) System.out.println(s);
    }

    static void sortByName(List<Student> list) {
        list.sort(Comparator.comparing(Student::getName));
        for (Student s : list) System.out.println(s);
    }

    static void printTop3(HashMap<String, Student> students) {
        List<Student> top3 = new ArrayList<>(students.values());
        top3.sort(Comparator.comparingDouble(Student::getGpa).reversed());
        top3.stream().limit(3).forEach(System.out::println);
    }

    static void printSameGpa(HashMap<String, Student> students) {
        Map<Double, List<Student>> byGpa = new HashMap<>();
        for (Student s : students.values()) {
            byGpa.computeIfAbsent(s.getGpa(), k -> new ArrayList<>()).add(s);
        }
        for (Map.Entry<Double, List<Student>> entry : byGpa.entrySet()) {
            if (entry.getValue().size() > 1) {
                System.out.println("GPA " + entry.getKey() + ": " + entry.getValue());
            }
        }
    }

    static void setupAndPrintCourses(HashMap<Course, List<Student>> courseMap, HashMap<String, Student> students) {
        Course math = new Course("Linear algebra");
        Course cs   = new Course("Computer Architecture");
        Course bio  = new Course("Calculus");

        courseMap.put(math, Arrays.asList(students.get("S001"), students.get("S002")));
        courseMap.put(cs,   Arrays.asList(students.get("S003"), students.get("S004"), students.get("S006")));
        courseMap.put(bio,  Arrays.asList(students.get("S002"), students.get("S006")));

        for (Map.Entry<Course, List<Student>> entry : courseMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    static void sortGpaDescThenName(HashMap<String, Student> students) {
        List<Student> list = new ArrayList<>(students.values());
        list.sort(
                Comparator.comparingDouble(Student::getGpa).reversed()
                        .thenComparing(Student::getName)
        );
        list.forEach(System.out::println);
    }
}


