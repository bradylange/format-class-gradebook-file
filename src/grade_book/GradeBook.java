package grade_book;

// Import libraries
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

// Import class's
import applications.Driver;

/*
 * Course: CSIS 162 - Programming II
 * Institution: University of Wisconsin-River Falls
 * Development Language: Java
 */

/**
 * <p>
 * 		Uses an input text file ({@link #inFile}) to instantiate student information,
 * 		then calculates their average grade and letter grade,
 * 		finally writes the formatted data to a new text file.
 * </p>
 * 
 * @author  Brady Lange - <a href = "https://www.linkedin.com/in/brady-lange/" target = "_blank">LinkedIn</a>
 * @version  1.0.1 (01/13/2019)
 * @since  1.0 (04/07/2017)
 */
public class GradeBook 
{ 
	// Instance variables
	/**
	 * A personal name given to the student at birth or baptism and used before a family name.
	 */
	private String firstName;
	/**
	 * Student's surname.
	 */
	private String lastName;		
	/**
	 * Collection of student's scores (in percentage).
	 */
	private double[] scores = new double[5];					
	/**
	 * Input file to be scraped.
	 */
	static private Scanner inFile; 								
	/**
	 * Flag to prevent file being re-opened each iteration.
	 * (Static tag will make sure value is not reset)
	 */
	static private int flag; 	
	/**
	 * Student's average grade score (total percentage / total number of scores).
	 */
	private double averageScore; 								
	/**
	 * Student's letter grade (A, B, C, D, or F) of average score.
	 */
	private char grade; 										
	/**
	 * Total amount of percentage of scores.
	 */
	private double sum; 										
	/**
	 * Average score of the class as a whole.
	 * (Static tag will keep track of each students average score)
	 */
	private static double average; 			
	
// ------------------- Default Constructor -------------------
	/**
	 * Constructs a {@link GradeBook} object by reading the text from an input text file,
	 *  then formats it and writes it to a new text file.
	 * 
	 * @throws FileNotFoundException  Invalid file path
	 */
	public GradeBook() throws FileNotFoundException		
	{
		// Instantiate default properties
		firstName = "";
		lastName = "";
		
		if (flag == 0) 													// Prevent the file from being opened each iteration
		{
			inFile = new Scanner(new FileReader("./data/inFile.txt"));			// Open the file to read from 
		}
		flag = 1;														// Set the flag so the file cannot be re-opened anymore
		
		firstName = inFile.next();										// Retrieve student's first name
		lastName = inFile.next();										// Retrieve student's last name
		
		for (int index = 0; index < scores.length; index++)				// Retrieve all student test scores 
		{
			scores[index] = inFile.nextDouble();						// Retrieve student's test scores from file 
			sum += scores[index];										// Sum test scores 
			averageScore = sum / scores.length;							// Calculate student's average test score 
		}
		average += averageScore;										// Add average test scores to the class's average test scores 									
		
		// Determine letter grade of the student
		if (averageScore >= 90)											// 90 percent or better 
		{
			grade = 'A';
		}
		else if (averageScore >= 80 && averageScore < 90)				// Between 80 percent and 89 percent 
		{
			grade = 'B';
		}
		else if (averageScore >= 70 && averageScore < 80)				// Between 70 percent and 79 percent 
		{
			grade = 'C';
		}
		else if (averageScore >= 60 && averageScore < 70)				// Between 60 percent and 69 percent 
		{
			grade = 'D';
		}
		else if (averageScore < 60)										// Less than 60 percent 
		{
			grade = 'F';
		}
		else 															// Not a valid score 
		{
			grade = '?';
		}
	} 
// ------------------- End Default Constructor -------------------
	
// ------------------- Alternate Constructor -------------------
	/**
	 * Constructs a {@link GradeBook} object with {@link #firstName}, 
	 * {@link #lastName}, and {@link #scores}.
	 * 
	 * @param firstName  {@link #firstName} of the student
	 * @param lastName  {@link #lastName} of the student
	 * @param scores  Collection of {@link #scores} of the student
	 */
	public GradeBook(String firstName, String lastName, double[] scores) 
	{
		// Instantiate properties with parameter values
		this.firstName = firstName;										
		this.lastName = lastName;										
		for (int index = 0; index < scores.length; index++)				// Iterate through each student's test score 
		{
			this.scores[index] = scores[index];							// Update student's scores				
		}
	}
// ------------------- End Alternate Constructor -------------------
	
// ------------------- Copy Constructor -------------------
	/**
	 * Constructs a shallow copy of the {@link GradeBook} object.
	 * 
	 * @param obj  {@link GradeBook} object to be shallow copied
	 */
	public GradeBook(GradeBook obj)
	{		
		// Instantiate properties with parameter value
		this.firstName = obj.firstName;									// Shallow copy student's first name
		this.lastName = obj.lastName;									// Shallow copy student's last name
		for (int index = 0; index < obj.scores.length; index++)			// Create a copy for test scores array with for loop
		{
			this.scores[index] = obj.scores[index];						// Shallow copy student's test scores 
		}
	}
// ------------------- End Copy Constructor Method -------------------
	
// ------------------- Make Copy Method -------------------
	/**
	 * Shallow copies the {@link GradeBook} object.
	 * 
	 * @param obj  {@link GradeBook} object to be shallow copied
	 */
	public void makeCopy(GradeBook obj)
	{
		this.firstName = obj.firstName;									// Shallow copy student's first name
		this.lastName = obj.lastName;									// Shallow copy student's last name 
		for (int index = 0; index < obj.scores.length; index++)			// Create a copy for the scores array with for loop
		{
			this.scores[index] = obj.scores[index];						// Shallow copy student's test scores 
		}
	}
// ------------------- End Make Copy Method -------------------
	
// ------------------- Get Copy Method -------------------
	/**
	 * Retrieves a deep copy of the {@link GradeBook} object.
	 * 
	 * @return  Deep copy of the {@link GradeBook} object
	 * 
	 * @throws FileNotFoundException  Invalid file path
	 */
	public GradeBook getCopy() throws FileNotFoundException				
	{
		GradeBook tempObj = new GradeBook();							// Create temporary object to hold copied properties 
		tempObj.firstName = firstName;									// Deep copy student's first name
		tempObj.lastName = lastName;									// Deep copy student's last name 
		for (int index = 0; index < tempObj.scores.length; index++)		// For each test score
		{
			tempObj.scores[index] = scores[index]; 						// Deep copy student's test scores 
		}
		return tempObj;													// Return deep copied object 
	}
// ------------------- End Get Copy Method -------------------
	
// ------------------- Class Average Method -------------------
	/**
	 * Calculates the class's {@link #averageScore}.
	 * 
	 * @return  Class's {@link #averageScore}
	 */
	public double classAverage()
	{
		inFile.close();													// Close the input file
		return average / Driver.numberOfStudents;						// Calculate and return the class's average test scores 
	}
// ------------------- End Class Average Method -------------------
	
// ****************
// *** Setters: ***
// ****************
// ------------------- Set First Name Method -------------------
	/**
	 * Updates the student's {@link #firstName}.
	 * 
	 * @param fName  {@link #firstName} of the student
	 */
	public void setFirstName(String fName)
	{
		firstName = fName;												// Update student's first name
	}
// ------------------- End Set First Name Method -------------------
	
// ------------------- Set Last Name Method -------------------
	/**
	 * Updates the student's {@link #lastName}.
	 * 
	 * @param lName  {@link #lastName} of the student
	 */
	public void setLastName(String lName)
	{
		lastName = lName;												// Update student's last name
	}
// ------------------- End Set Last Name Method -------------------
	
// ------------------- Set Scores Method -------------------
	/**
	 * Updates the student's {@link #scores}.
	 * 
	 * @param scores  Collection of {@link #scores} of the student
	 */
	public void setScores(double[] scores)
	{
		for (int index = 0; index < scores.length; index++)				// For each test score 
		{
			this.scores[index] = scores[index];							// Update student's test score 
		}
	}
// ------------------- End Set Scores Method -------------------

// ****************
// *** Getters: ***
// ****************
// ------------------- Get First Name Method -------------------
	/**
	 * Retrieves the student's {@link #firstName}.
	 * 
	 * @return  Student's {@link #firstName}
	 */
	public String getFirstName()
	{
		return firstName;												// Return student's first name
	}
// ------------------- End Get First Name Method -------------------
	
// ------------------- Get Last Name Method -------------------
	/**
	 * Retrieves the student's {@link #lastName}.
	 * 
	 * @return  Student's {@link #lastName}
	 */
	public String getLastName()
	{
		return lastName;												// Return student's last name
	}
// ------------------- End Get Last Name Method -------------------
	
// ------------------- Get Scores Method -------------------
	/**
	 * Retrieves the student's test {@link #scores}.
	 * 
	 * @return  Student's {@link #scores}
	 */
	public double[] getScores()
	{
		double[] tempArray = new double[scores.length];
		for (int index = 0; index < tempArray.length; index++)			// For each test score 
		{
			tempArray[index] = this.scores[index];						// Set student's test score to temporary array
		}
		return tempArray;												// Return student's test scores with temporary array
	}
// ------------------- End Get Scores Method -------------------
	
// ------------------- Is Equal Method -------------------
	/**
	 * Determines if two {@link GradeBook} objects are the same.
	 * 
	 * @param obj  {@link GradeBook} object to be compared
	 * 
	 * @return  'true' if equal and 'false' if not equal
	 */
	public boolean isEqual(GradeBook obj)
	{
		boolean equalScores = false;									// Flag that determines if the objects scores are equal
		for (int index = 0; index < scores.length; index++)				// Check if each score is equal between the objects 
		{
			if (scores[index] != obj.scores[index])						// Scores are not equal 
			{
				equalScores = false;
				break;													// At least one score isn't equal, exit loop 
			}
			else														// Scores are equal 
			{
				equalScores = true;
			}
		}
		return firstName.equals(obj.firstName) 							// Return if the objects are equal
			   && lastName.equals(obj.lastName) && equalScores;
	}
// ------------------- End Is Equal Method -------------------
	
// ------------------- Copy Array Method -------------------
	/**
	 * Copies the student's {@link #scores} into a collection.
	 * 
	 * @param array  Collection of test {@link #scores}
	 * 
	 * @return  Collection of test {@link #scores}
	 */
	public int[] copyArray(int[] array)
	{
		int[] tempArray = new int[array.length];
		for (int index = 0; index < array.length; index++)				// Iterate through each score and copy the score into a temporary array
		{
			tempArray[index] = array[index];							// Deep copy student's test scores 
		}
		return tempArray;												// Return test scores with a temporary array
	}
// ------------------- End Copy Array Method -------------------	
	
// ------------------- Find the Same Method -------------------
	/**
	 * Determines if two collections of test {@link #scores} are
	 * the same.
	 * 
	 * @param one  First collection of test {@link #scores}
	 * @param two  Second collection of test {@link #scores}
	 * 
	 * @return  'true' if the same and 'false' if not the same.
	 */
	public boolean findTheSame(int[] one, int[] two)
	{
		if (one.length != two.length)									// The objects scores lengths are not the same 
		{	
			return false;												// Not the same object scores 
		}
		else															// The objects scores are the same length
		{
			for (int index = 0; index < one.length; index++)			// Iterate through each score 
			{
				if (one[index] != two[index])							// If at least one of the objects scores do not equal 
				{
					return false;										// Not the same object scores
				}
			}
		}
		return true;													// Same objects scores 
	}
// ------------------- End Find the Same Method -------------------
	
// ------------------- To String Method -------------------
	/**
	 * Converts the {@link GradeBook} object's data to a String.
	 */
	public String toString()
	{
		String tempArray = "";											// Store student's test scores array as a String 
		for (int index = 0; index < scores.length; index++)				// For each score 
		{
			tempArray += scores[index] + "\t\t";						// Format scores with two tabs 
		}
		String fName = String.format("%-8.8s", firstName); 				// Format first name with 8 spaces after & 8 characters in length 
		String lName = String.format("%1s", lastName);					// Format last name with 1 space before
		String avgForm = String.format("%.2f", averageScore); 			// Format average score to two decimal places 
		String data = fName + "\t\t" + lName + "\t\t" 					// Format grade book's data with two tabs 
						+ tempArray + avgForm + "\t\t" + grade; 
		return data;													// Return grade book's data
	}
// ------------------- End To String Method -------------------
} // End of class GradeBook