import java.util.Scanner;
interface Displayable {
    void displayIDCard();
}
abstract class IDCard implements Displayable {
    protected String name;
    protected String idNumber;
    protected String department;
    protected String email;
    protected String contactNumber;
    public IDCard(String name, String idNumber, String department, String email, String contactNumber) {
        this.name = name;
        this.idNumber = idNumber;
        this.department = department;
        this.email = email;
        this.contactNumber = contactNumber;
    }
    public abstract void displayIDCard();
}
class StudentIDCard extends IDCard {
    private String course;
    private int year;
    public StudentIDCard(String name, String idNumber, String department, String email, String contactNumber, String course, int year) {
        super(name, idNumber, department, email, contactNumber);
        this.course = course;
        this.year = year;
    }
    @Override
    public void displayIDCard() {
        System.out.println("\n--- Student ID Card ---");
        System.out.println("Name : " + name);
        System.out.println("ID Number : " + idNumber);
        System.out.println("Department : " + department);
        System.out.println("Course : " + course);
        System.out.println("Year : " + year);
        System.out.println("Email : " + email);
        System.out.println("Contact Number : " + contactNumber);
        System.out.println("------------------------");
    }
}
class TeacherIDCard extends IDCard {
    private String subject;
    public TeacherIDCard(String name, String idNumber, String department, String email, String contactNumber, String subject) {
        super(name, idNumber, department, email, contactNumber);
        this.subject = subject;
    }
    @Override
    public void displayIDCard() {
        System.out.println("\n--- Teacher ID Card ---");
        System.out.println("Name : " + name);
        System.out.println("ID Number : " + idNumber);
        System.out.println("Department : " + department);
        System.out.println("Subject : " + subject);
        System.out.println("Email : " + email);
        System.out.println("Contact Number : " + contactNumber);
        System.out.println("------------------------");
    }
}
public class IDCardGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select ID Type: 1. Student 2. Teacher");
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter ID Number: ");
        String idNumber = scanner.nextLine();
        System.out.print("Enter Department: ");
        String department = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Contact Number: ");
        String contactNumber = scanner.nextLine();
        IDCard idCard;
        if (choice == 1) {
            System.out.print("Enter Course: ");
            String course = scanner.nextLine();
            System.out.print("Enter Year: ");
            int year = scanner.nextInt();
            idCard = new StudentIDCard(name, idNumber, department, email, contactNumber, course, year);
        } else {
            System.out.print("Enter Subject: ");
            String subject = scanner.nextLine();
            idCard = new TeacherIDCard(name, idNumber, department, email, contactNumber, subject);
        }
        idCard.displayIDCard();
        scanner.close();
    }
}
