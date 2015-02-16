/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokens;

/**
 *
 * @author volodya
 */
public enum PunctuationMark {
    FULL_STOP("."),
    EXCLAMATION_MARK("!"),
    QUESTION_MARK("?"),
    ELLIPSIS("..."),
    COMMA(","),
    DASH("-"),
    COLON(":"),
    SEMICOLON(";"),
    OPEN_BRACKET("("),
    CLOSE_BRACKET(")");
    
    private final String mark;

    private PunctuationMark(String s) {
        this.mark = s;
    }
    
    public String getMark(){
        return mark;
    }
}
