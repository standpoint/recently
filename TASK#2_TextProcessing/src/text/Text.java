/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text;

import java.io.*;
import java.util.*;
import tokens.Sentence;

/**
 *
 * @author volodya
 */
public class Text {
    
    private final List<Sentence> sentences = new ArrayList<>();
    private static final String path = System.getProperty("user.dir") + "\\db\\";
    private final String fileName;
    private String text;
    
    public Text(String fileName){
        this.fileName = path + fileName;
        this.text = setText();
    }
    
    private String setText(){
        if (fileName == null) return text;
        try {
            File f = new File(fileName);
            int size = (int)f.length();
            FileInputStream in = new FileInputStream(f);
            int c = 0;
            char[] ch = new char[size];
            for(int i = 0; (c = in.read()) != -1; i++){
                ch[i] = (char)c;
            }
            text = String.valueOf(ch);
        } catch (FileNotFoundException ex) {
            System.err.println("File Not Found: " + fileName);
        } catch (IOException ex) {
            
        }
            return text;
    }
    
    public String getText(){
        return text;
    }
    
    public List<Sentence> getSentences(){
        return sentences;
    }
    
//    public void splitText(){
//        String t = getText();
//        StringTokenizer st = new StringTokenizer(t,".?!", true);
//        for(int i = 0; st.hasMoreTokens(); i++){
//            String s = st.nextToken();
//            if(st.hasMoreTokens()) s += st.nextToken();
//            Sentence sentence = new Sentence(s.trim());
//            sentences.add(sentence);
//        }
//    }
    
    public void splitText(){
        String t = getText();

        String[] s = t.split("((?<=[\\.?!)¢\\s}])\\s+\n*(?=([A-Za-z0-9(#\"\'-])))"
                + "|((?<=\\s)\\s+\\n)");

        for(int i = 0; i < s.length; i++){
            Sentence sen = new Sentence(s[i].trim());
            sentences.add(sen);
        }
    }
    
    public int size(){
        if (text == null) return 0;
        return text.length();
    }
}
