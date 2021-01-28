// Kathy Zeng
// 1/25/21
// ReadWritePoem.java
// Reads a poem in Poem.txt, then writes the first word to a file, output.txt.
/// Our first FileIO program.
/// Reading and writing to files compared to the terminal.

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class ReadWritePoem
{
	private PrintWriter output; // Object is used to print to the file
	private Scanner input; // object is used to read in from a file
	private String inFileName; // name of the input file
	private String outFileName; // name of the output file
	
	public ReadWritePoem()
	{
		inFileName = new String("Poem1.txt");
		outFileName = new String("output.txt");
		output = null;
		input = null;
	}
	
	public static void main(String[] args)
	{
		ReadWritePoem rwp = new ReadWritePoem();
		rwp.openIt();
		rwp.createIt();
		rwp.getWords();
	}

	// openIt uses a try-catch block to open a file
	public void openIt()
	{
		File inFile = new File(inFileName);
		try
		{
			input = new Scanner(inFile);
		}
		catch(FileNotFoundException e)
		{
			System.err.printf("\n\n\nERROR: Cannot file/open file %s\n\n\n", inFileName);
			System.exit(1); 
		}
	}
	
	// createIt uses a try-catch block to create a file to write.
	public void createIt()
	{
		File outFile = new File(outFileName);
		try
		{
			output = new PrintWriter(outFile);
		}
		catch(IOException e)
		{
			System.out.println("\n\n\nERROR: Cannot create " + outFileName + "file.\n\n\n");
			System.exit(2);
		}
	}

	// Reads the input file, saves the first word in each line, then prints that
	// word to the output file
	public void getWords()
	{
		System.out.println("\n\n\n");
		String word = new String("");
		while(input.hasNext() )
		{
			word = input.next(); 
			input.nextLine();
			output.println(word);
		}
		output.close();
	}
}
