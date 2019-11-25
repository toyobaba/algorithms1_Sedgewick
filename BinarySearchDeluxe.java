package algorithms1;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



public class BinarySearchDeluxe {

    // Returns the index of the first key in a[] that equals the search key, or -1 if no such key.
    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
    	int startIndex = 0;
    	int endIndex = a.length;
    	
    	while(startIndex < endIndex) {
    		int middleIndex = startIndex+endIndex/2;
    		if (comparator.compare(key, a[middleIndex]) > 1) {
    			startIndex = middleIndex+1;
    		}
    		else if (comparator.compare(key, a[middleIndex]) < 1) {
    			endIndex = middleIndex-1;
    		}
    		else return middleIndex;
    	}
    	return -1;
    }

    // Returns the index of the last key in a[] that equals the search key, or -1 if no such key.
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
    	int foundFirst = firstIndexOf(a, key, comparator);
    	while (a[foundFirst] == a [foundFirst+1]) { foundFirst++;}
    	return foundFirst;
    }

    // unit testing (required)
    public static void main(String[] args) {
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
				Term tempTerm = new Term(line, i);				
				termArray[i]= tempTerm;
				System.out.println(termArray[i].getTerm());
				i++;				
				}
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
