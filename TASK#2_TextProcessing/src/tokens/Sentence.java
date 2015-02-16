/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokens;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sentence {
    List<Word> words = new ArrayList<>();
    private TypeOfSentence type;
    private int wordsRepeats;
    
    public Sentence(String sequence){
        StringTokenizer st = new StringTokenizer(sequence,".!?,;:-() ", true);
        for(int i = 0; st.hasMoreTokens(); i++){
            words.add(new Word(st.nextToken()));
        }
        setTypeOfSentence(sequence);
    }
    
    public Sentence(List<Word> words){
        this.words = words;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder(words.size()*30);
        words.stream().forEach((w) -> {
            sb.append(w.toString());
        });
        return sb.toString();
    }
    
    private void setTypeOfSentence(String sentence){
        Pattern p = Pattern.compile("([\\.?!])|([\\.?!]\\))|(\\.\\.\\.)|$");
        Matcher m = p.matcher(sentence);
        String mark = (m.find()) ? m.group() : "";
        switch(mark){
            case "."    :   type = TypeOfSentence.AFFIRMATIVE;
                break;
            case ".)"   :   type = TypeOfSentence.AFFIRMATIVE;
                break;
            case "..."  :   type = TypeOfSentence.AFFIRMATIVE;
                break;
            case "?"    :   type = TypeOfSentence.QUESTION;
                break;
            case "?)"   :   type = TypeOfSentence.QUESTION;
                break;
            case "!"    :   type = TypeOfSentence.EXCLAMATION;
                break;
            case "!)"   :   type = TypeOfSentence.EXCLAMATION;
                break;
            default :   type = TypeOfSentence.OTHER;
        }
    }
    
    public TypeOfSentence getType(){
        return type;
    }
    
    public List<Word> getLexems(){
        Iterator<Word> it = words.iterator();
        List<Word> lexemes = new ArrayList<>();
        Word lexeme;
        Pattern p = Pattern.compile("[A-Za-z0-9]+");
        while(it.hasNext()){
            lexeme = new Word(it.next().word);
            lexeme.word = lexeme.word.trim();
            Matcher m = p.matcher(lexeme.word);
            if(m.find()) {
                lexeme.word = m.group();
                if (lexemes.contains(lexeme)) wordsRepeats++;
                lexemes.add(lexeme);
            }
        }
        return lexemes;
    }

    /**
     * @return the wordsRepeats
     */
    public int getRepeats() {
        return wordsRepeats;
    }
    
    public int size() {
        return words.size();
    }
}
