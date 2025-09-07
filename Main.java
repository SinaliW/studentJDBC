import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Grade: ");
                    String grade = sc.nextLine();
                    dao.addStudent(new Student(name, age, grade));
                    break;

                case 2:
                    dao.getAllStudents().forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("Enter ID to update: ");
                    int idU = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New Name: ");
                    String nName = sc.nextLine();
                    System.out.print("New Age: ");
                    int nAge = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New Grade: ");
                    String nGrade = sc.nextLine();
                    dao.updateStudent(idU, nName, nAge, nGrade);
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    int idD = sc.nextInt();
                    dao.deleteStudent(idD);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);

        sc.close();
    }
}
