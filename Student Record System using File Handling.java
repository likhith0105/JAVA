import java.io.*;
import java.util.Scanner;

public class StudentFileProject {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addStudent(sc);
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // Method to add student
    static void addStudent(Scanner sc) {
        try {
            FileWriter fw = new FileWriter("students.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Marks: ");
            int marks = sc.nextInt();
            sc.nextLine();

            bw.write(name + " - " + marks);
            bw.newLine();

            bw.close();
            System.out.println("Student saved successfully!");

        } catch (IOException e) {
            System.out.println("Error writing file!");
        }
    }

    // Method to view students
    static void viewStudents() {
        try {
            FileReader fr = new FileReader("students.txt");
            BufferedReader br = new BufferedReader(fr);

            String line;
            System.out.println("\n--- Student Records ---");

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();

        } catch (IOException e) {
            System.out.println("Error reading file!");
        }
    }
}