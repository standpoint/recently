import java.util.Comparator;

public class SortedByEntiers implements Comparator<Fragments> {
	
	public int compare(Fragments frag1, Fragments frag2){
		int numberEntries1 =  frag1.getNumberEntries();
		int numberEntries2 =  frag2.getNumberEntries();
		String word1 = frag1.getWord();
		String word2 = frag2.getWord();
		
		if (numberEntries1 > numberEntries2) {
			return 1;
		}
		else if (numberEntries1 < numberEntries2) {
			return -1;
		}
		else {
			return word1.compareTo(word2);
		}
	}
}
