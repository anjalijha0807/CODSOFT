package javainternship;
import java.util.Scanner;


public class gradecalculation {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of subjects:");
		int totalSubjects = input.nextInt();
		
		int totalMarks = 0;
		
		for(int i=1;i<=totalSubjects;i++) {
			System.out.print("Enter the marks for subject "+ i+" out of 100:");
			int marks = input.nextInt();
			totalMarks += marks;
		}
		double avgpercentage =(double) totalMarks/totalSubjects;
		System.out.println("Overall marks scored by the student is :" + totalMarks);
		System.out.println("Average percentage scored by the student is :" + avgpercentage + "%");
		
		 int percentage = (int)avgpercentage;
		 switch(percentage/10) {
		 case 10:
			 System.out.println("The student has been awarded grade A+");
			 break;
		 case 9:
			 System.out.println("The student has been awarded grade A");
			 break;
		 case 8:
			 System.out.println("The student has been awarded grade B");
			 break;
		 case 7:
			 System.out.println("The student has been awarded grade C");
			 break;
		 case 6:
			 System.out.println("The student has been awarded grade D");
			 break;
		 case 5:
			 System.out.println("The student has been awarded grade E");
			 break;
			 default:
				 System.out.println("The student has been awarded grade F and has failed");
		 }
		 
		 
		
		}

	}


