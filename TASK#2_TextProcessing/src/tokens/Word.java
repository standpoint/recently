/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokens;

import java.util.Objects;

/**
 *
 * @author volodya
 */
public class Word{
    String word;
    
    public Word(String word){
        this.word = word;
    }
    
    
    
    @Override
    public String toString(){
        return word;
    }
    
    /**
     *
     * @param lexeme
     * @return
     */
    @Override
    public boolean equals(Object lexeme){
        Word w = (Word)lexeme;
        return word.equalsIgnoreCase(w.word);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.word.toLowerCase());
        return hash;
    }
    
    public int size(){
        return word.length();
    }
}
