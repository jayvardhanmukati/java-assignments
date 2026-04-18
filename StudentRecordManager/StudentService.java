import java.io.*;
import java.util.*;

public class StudentService {

    String fileName = "Students.csv";

    // ➤ CREATE (Add Student)
    public void addStudent(Student s) {
        try {
            List<String> data = CSVUtils.readFile(fileName);

            // ✅ Check duplicate ID
            for (String line : data) {
                if (line.startsWith(s.studentId + ",")) {
                    System.out.println("Student ID already exists: " + s.studentId);
                    return;
                }
            }

            CSVUtils.appendLine(fileName, s.toCSV());
            System.out.println("Student added: " + s.name);

        } catch (IOException e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }

    // ➤ READ
    public void displayStudents() {
        try {
            List<String> data = CSVUtils.readFile(fileName);
            System.out.println("\n--- Student Records ---");
            for (String line : data) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // ➤ UPDATE Marks + Percentage
    public void updateMarksAndPercentage() {
        try {
            List<String> data = CSVUtils.readFile(fileName);
            List<String> updated = new ArrayList<>();

            updated.add(data.get(0)); // header

            for (int i = 1; i < data.size(); i++) {
                String[] parts = data.get(i).split(",");

                int m1 = Integer.parseInt(parts[3]);
                int m2 = Integer.parseInt(parts[4]);
                int m3 = Integer.parseInt(parts[5]);

                // Update marks4 and marks5
                int m4 = 85;
                int m5 = 90;

                double percentage = (m1 + m2 + m3 + m4 + m5) / 5.0;

                Student s = new Student(
                        Integer.parseInt(parts[0]),
                        parts[1],
                        parts[2],
                        m1, m2, m3, m4, m5, percentage);

                updated.add(s.toCSV());
            }

            CSVUtils.writeFile(fileName, updated);
            System.out.println("Updated all students with marks & percentage");

        } catch (IOException e) {
            System.out.println("Error updating: " + e.getMessage());
        }
    }

    // ➤ DELETE
    public void deleteStudent(int id) {
        try {
            List<String> data = CSVUtils.readFile(fileName);
            List<String> updated = new ArrayList<>();

            updated.add(data.get(0)); // header

            for (int i = 1; i < data.size(); i++) {
                if (!data.get(i).startsWith(id + ",")) {
                    updated.add(data.get(i));
                }
            }

            CSVUtils.writeFile(fileName, updated);
            System.out.println("Deleted student with ID: " + id);

        } catch (IOException e) {
            System.out.println("Error deleting: " + e.getMessage());
        }
    }
}