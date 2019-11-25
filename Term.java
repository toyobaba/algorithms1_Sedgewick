package algorithms1;
import java.util.*;;

public class Term implements Comparable<Term>{
	//Members of class Term
	private String term;
	private long key;
	
	// Initializes a term with the given query string and weight.
    public Term(String query, long weight) {
    	setTerm(query);
    	setKey(weight);
    }
    
    public static class reverseCompare implements Comparator<Term>
    {
    	public int compare (Term term1, Term term2) {
    		return -(term1.getTerm().compareTo(term2.getTerm()));
    	}
    }
    
    public static class prefixCompare implements Comparator<Term>
    {
    	private int r;
    	public prefixCompare(int rthat) {
    		r = rthat;
    	}
    	
    	public int compare (Term term1, Term term2) {
    		String subString1 = term1.getTerm().substring(0,r);
    		String subString2 = term2.getTerm().substring(0,r);

    		return subString1.compareTo(subString2);
    	}
    }
//    // Compares the two terms in descending order by weight.
//    public static final Comparator<Term> byReverseWeightOrder = new reverseCompare();
//    
//    
//    // Compares the two terms in lexicographic order but using only the first r characters of each query.
//    public static final Comparator<Term> byPrefixOrder (int r) = new prefixCompare(r);
//	

    // Compares the two terms in lexicographic order by query.
    public int compareTo(Term that) {
    	return this.getTerm().compareTo(that.getTerm());
    }

    // Returns a string representation of this term in the following format:
    // the weight, followed by a tab, followed by the query.
    public String toString() {
    	return null;
    }
    
    // unit testing (required)
    public static void main(String[] args) {
    	Term ter1 = new Term ("ter1 is", 1234);
    	Term ter2 = new Term ("ter2 is", 12355);

    	System.out.println("Jump".compareTo("Jumo"));
    	Comparator<Term> c1 = new reverseCompare();
    	int a = c1.compare(ter2, ter1);
    	System.out.println(a);
    	
    	int hare = 5;
    	int tortoise = 11;
    	int j = 0;

    	for(j=0; j<20; j++)
    	{
    	    if(hare < tortoise)
    	        hare *= 2;
    	    else if(hare == tortoise)
    	        break;
    	    else
    	        tortoise += 1;
    	}
    	System.out.println(hare + tortoise);
    	
    	
    }

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public long getKey() {
		return key;
	}

	public void setKey(long key) {
		this.key = key;
	}

}
