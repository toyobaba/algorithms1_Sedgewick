package algorithms1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Autocomplete {
	// Initializes the data structure from the given array of terms.
    public Autocomplete(Term[] terms) {    	
    	
    }

    // Returns all terms that start with the given prefix, in descending order of weight.
    //public Term[] allMatches(String prefix) {}

    // Returns the number of terms that start with the given prefix.
    //public int numberOfMatches(String prefix) {	}

    // unit testing (required)
    public static void main(String[] args)  {
    	
    	FileReader fileReader = null;
		try {
			fileReader = new FileReader("C:\\Users\\omtai\\eclipse-workspace\\Algorithms\\src\\algorithms1\\wiktionary.txt");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	BufferedReader textReader = new BufferedReader(fileReader);
    	String line = new String();
    	int i = 0;
    	Term[] termArray = new Term[10000];
    	try {
			while((line = textReader.readLine()) != null) {
				String[] splitLine = line.split("\\s+");
				Term tempTerm = new Term(splitLine[2], Long.parseLong(splitLine[1]));				
				termArray[i]= tempTerm;
				System.out.println(termArray[i].getTerm());
				System.out.println(termArray[i].getKey());
				i++;				
				}
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	Autocomplete autoCompleter = new Autocomplete(termArray);
    }
    	
    }


