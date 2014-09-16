import java.util.Arrays;

/**
 * Sorts words in the text ascending number of entries letter 'e'. And sorts lexicographically in the case of equality of the words. 
 * 
 * @author volodya
 *
 */
class TextAnalizer {
	
	public static String getResultText(String sourceText, char entry) {
		StringBuffer resultText = new StringBuffer(sourceText.length());	//string for result
		String[] sortedWords = getSortedWords(sourceText,entry);			//getting sorted array of the concatenations of entry numbers and words (e.g. {0by,0format,0format,0in,0string,1Arguments,1the,1the,2specifiers,4referenced})
		for (int i = 0; i < sortedWords.length; i++) {						//making result string, e.g.:
			resultText.append(sortedWords[i], 1, sortedWords[i].length());	//{0by,..., 2specifiers, 4referenced} to "by ...specifiers referenced "
			resultText.append(" ");
		}
		return resultText.toString();
	}
	
	private static String[] getSortedWords(String sourceText, char entry){
		String[] wordsArray = getWordsArray(sourceText);
		int[] entries = getEntriesCountArray(wordsArray,entry);
		String[] res = new String[entries.length];
		for (int i = 0; i < wordsArray.length; i++) {
			res[i] = String.valueOf(entries[i]).concat(wordsArray[i]);
		}
		Arrays.sort(res);
		return res;
	}
	
	private static String[] getWordsArray(String sourceText) {
		return sourceText.split("[ ,.;:?!]");
	}
	
	private static int[] getEntriesCountArray(String[] wordArray, char entry) {
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
}
