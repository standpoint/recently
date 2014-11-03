class Fragments {
	
	private String word;
	private int numberEntries;

	Fragments(){
		this(new String(""),0);
	}
	
	Fragments(String word, int numberEntries){
		this.word = word;
		this.numberEntries = numberEntries;
	}
	
	public int getNumberEntries(){
		return this.numberEntries;
	}
	
	public String getWord(){
		return this.word;
	}
}
