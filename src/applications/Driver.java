package applications;

// Import libraries
import java.io.FileNotFoundException;
import java.io.PrintWriter;

// Import classes
import grade_book.GradeBook;

/*
 * Course: CSIS 162 - Programming II
 * Institution: University of Wisconsin-River Falls
 * Development Language: Java
 */

/**
 * <p>
 * 		Inserts student data and grades into the {@link GradeBook} object and writes 
 * 		the data formatted to an output text file. Contains the {@link #main} method and 
 * 		"glues" other classes together.
 * </p>
 * <p>
 * 		Depends on:
 * </p>
 * <ul>
 * 		<li>{@link GradeBook}</li>
 * </ul>
 * 
 * @author  Brady Lange - <a href = "https://www.linkedin.com/in/brady-lange/" target = "_blank">LinkedIn</a>
 * @version  1.0.1 (01/13/2019)
 * @since  1.0 (04/07/2017)
 */
public class Driver
{ 
	// Instance variables 
	/**
	 * Total amount of students in the {@link GradeBook}.
	 * (Static tag will keep the variable in memory)
	 */
	public static int numberOfStudents = 10;								
	
// ------------------- Main Method -------------------
	/**
	 * Instantiates and sets up a {@link GradeBook}.
	 * 
	 * @param args  Array of command line arguments to be passed
	 * 
	 * @throws FileNotFoundException  Invalid file path
	 */
	public static void main(String[] args) throws FileNotFoundException	
	{ 
		PrintWriter outFile = new PrintWriter("./data/outFile.txt");			// Create the output file stream to write data to the file
		System.out.println("**************************************************************************");
		System.out.println("***                 Writing Grade Book Data to a File:                 ***");
		System.out.println("**************************************************************************");
		System.out.println("Writing object data to output file...");
		outFile.println("Course Grade Book | Developer: Brady Lange");
		outFile.println("**********************************************************************************************************");
		outFile.println("First:\t\t\tLast:\t\tTest 1:\t\tTest2:\t\tTest 3:\t\tTest 4:\t\tTest 5:\t\tAverage:\tGrade:");
		outFile.println("**********************************************************************************************************");
		
		GradeBook[] students = new GradeBook[numberOfStudents];			// Create an array of students
		for (int index = 0; index < students.length; index++)			// Insert students into the array
		{
			students[index] = new GradeBook(); 							// Each student will be in the grade book
		}
		
		for (int index = 0; index < students.length; index++)			// Print out the array to the output file 
		{
			outFile.println(students[index]);							// Print out student information
		}
		outFile.println("**********************************************************************************************************");
		outFile.println("Class Average of Scores: " 					// Print out the class's average of scores
					   + students[0].classAverage());		
		outFile.close();												// Close the output file
		System.out.println("Success!");
		System.out.println("**************************************************************************\n");
	}
// ------------------- End Main Method -------------------
} // End of class Driver