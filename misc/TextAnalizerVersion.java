import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class TextAnalizerVersion {
	
	private static String sourceText;
	private static char entry;
	private String[] wordArray = getWordsArray();
	private int[] entriesCountArray = getEntriesCountArray();
	private List<Fragments> arrayList = new ArrayList<>(); 
	
	private String[] getWordsArray() {
		return sourceText.split("[ ,.;:?!]");
	}
	
	private int[] getEntriesCountArray() {
		int[] entriesCountArray = new int[wordArray.length];
		int pos;
		int count;
		for (int i = 0; i < wordArray.length; i++) {
			pos = -1;
			count = 0;
			while (pos < wordArray[i].length() && (pos = (wordArray[i].toLowerCase()).indexOf(entry,pos+1)) >=0) {
				count++;
			}
			entriesCountArray[i] = count;
		}
		return entriesCountArray;
	}

	static String getSourceText() {
		return sourceText;
	}

	static void setSourceText(String sourceText) {
		TextAnalizerVersion.sourceText = sourceText;
	}

	static char getEntry() {
		return entry;
	}

	static void setEntry(char entry) {
		TextAnalizerVersion.entry = entry;
	}
	
	private void fillArrayList(){
		for (int i = 0; i < wordArray.length; i++) {
			arrayList.add(new Fragments(wordArray[i],entriesCountArray[i]));
		}			
	}
	
	private List<Fragments> getArrayList(){
		fillArrayList();
		Collections.sort(arrayList, new SortedByEntiers());
		return arrayList;
	}
	
	public void print(){
		for (Fragments e : this.getArrayList()) {
			System.out.print(e.getWord() + " ");
		}
	}
}
