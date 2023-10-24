package studentdatamgt;

import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String student_name;
    private int student_rollNumber;
    private String student_grade;

    public Student(String name, int rollNumber, String grade) {
        this.student_name = name;
        this.student_rollNumber = rollNumber;
        this.student_grade = grade;
    }

    public String getStudentName() {
        return student_name;
    }

    public int getStudentRollNumber() {
        return student_rollNumber;
    }

    public String getStudentGrade() {
        return student_grade;
    }
    

    @Override
    public String toString() {
        return "Student{" +
                "name ='" + student_name + '\'' +
                ", rollNumber =" + student_rollNumber +
                ", grade ='" + student_grade + '\'' +
                '}';
    }
}

class StudentMgtSystem {
    private ArrayList<Student> dataList;

    public StudentMgtSystem() {
        this.dataList = new ArrayList<>();
    }

    public void addStudentData(Student student) {
    	dataList.add(student);
    }

    public void removeStudentData(int rollNumber) {
    	dataList.removeIf(student -> student.getStudentRollNumber() == rollNumber);
    }

    public Student searchStudentData(int rollNumber) {
        for (Student student: dataList) {
            if (student.getStudentRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudentsData() {
    	for (Student student : dataList) {
            System.out.println(student);
        }
    }
   

    public boolean isRollNumberUnique(int rollNumber) {
        for (Student student : dataList) {
            if (student.getStudentRollNumber() == rollNumber) {
                return false;
            }
        }
        return true;
    }
}

public class studentManagement {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StudentMgtSystem data = new StudentMgtSystem();

        while (true) {
            System.out.print("Options available:\n");
            System.out.println("1. Add student data");
            System.out.println("2. Remove student data");
            System.out.println("3. Search for student data available ");
            System.out.println("4. Display All students data");
            System.out.println("5. Exit code execution.");
            System.out.print("Enter your choice: ");

            int option =input.nextInt();
           input.nextLine(); 
            switch (option) {
                case 1:
                    addStudentData(input, data);
                    break;

                case 2:
                    removeStudentData(input, data);
                    break;

                case 3:
                    searchStudentData(input, data);
                    break;

                case 4:
                    data.displayAllStudentsData();
                    break;

                case 5:
                    System.out.println("Exiting code execution ..");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }

    private static void addStudentData(Scanner sc, StudentMgtSystem sms) {
        System.out.print("Enter student name: ");
        String student_name = sc.nextLine();
        int student_rollNumber;
        do {
            System.out.print("Enter student roll number: ");
           student_rollNumber = sc.nextInt();
        } while (!sms.isRollNumberUnique(student_rollNumber));
        sc.nextLine();
        System.out.print("Enter student grade: ");
        String student_grade = sc.nextLine();

        sms.addStudentData(new Student(student_name,student_rollNumber, student_grade));
        System.out.println("Student data has been added successfully.");
    }

    private static void removeStudentData(Scanner re, StudentMgtSystem sms) {
        System.out.print("Enter student's roll number to remove: ");
        int removeRollNumber = re.nextInt();
        sms.removeStudentData(removeRollNumber);
        System.out.println("Student data has been removed successfully.");
    }

    private static void searchStudentData(Scanner sr, StudentMgtSystem sms) {
        System.out.print("Enter student's roll number to search: ");
        int searchRollNo = sr.nextInt();
        Student searchedStudentData = sms.searchStudentData(searchRollNo);
        if (searchedStudentData != null) {
            System.out.println("Student data found successfully: " + searchedStudentData);
        } else {
            System.out.println("Sorry! No student data is available with this roll number.");
        }
    }
}