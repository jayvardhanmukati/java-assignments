import java.util.*;

public class Main {
    public static void main(String[] args) {

        StudentService service = new StudentService();

        // ✅ RESET FILE (remove old duplicate data)
        try {
            List<String> header = new ArrayList<>();
            header.add("studentId,name,branch,marks1,marks2,marks3,marks4,marks5,percentage");

            CSVUtils.writeFile("Students.csv", header);
            System.out.println("File reset done");

        } catch (Exception e) {
            System.out.println("Error resetting file: " + e.getMessage());
        }

        // ➤ ADD STUDENTS (fresh)
        service.addStudent(new Student(101, "Aman", "CS", 70, 75, 80, 0, 0, 0));
        service.addStudent(new Student(102, "Neha", "IT", 85, 80, 78, 0, 0, 0));
        service.addStudent(new Student(103, "Raj", "ENTC", 60, 65, 70, 0, 0, 0));

        service.displayStudents();

        // ➤ UPDATE
        service.updateMarksAndPercentage();
        service.displayStudents();

        // ➤ DELETE
        service.deleteStudent(102);
        service.displayStudents();

        // ➤ EXCEPTION DEMO
        try {
            CSVUtils.readFile("WrongFile.csv");
        } catch (Exception e) {
            System.out.println("\nException Occurred: " + e.getMessage());
        }
    }
}