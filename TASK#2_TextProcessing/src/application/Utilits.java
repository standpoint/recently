/*
 * 1.	Найти наибольшее количество предложений текста, в которых есть одинаковые слова.
 * 2.	Вывести все предложения заданного текста в порядке возрастания 
 * количества слов в каждом из них.
 * 3.	Найти такое слово в первом предложении, которого нет ни в одном из остальных предложений.
 * 4.	Во всех вопросительных предложениях текста найти и напеча¬тать без повторений слова заданной длины.
 * 5.	В каждом предложении текста поменять местами первое слово с последним, не изменяя длины предложения.
 * 6.	Напечатать слова текста в алфавитном порядке по первой 
 * букве. Слова, начинающиеся с новой буквы, печатать с красной строки.
 * 7.	Рассортировать слова текста по возрастанию доли гласных букв (отношение количества гласных к общему количеству букв в слове).
 * 8.	Слова текста, начинающиеся с гласных букв, рассортировать в алфавитном порядке по первой согласной букве слова.
 * 9.	Все слова текста рассортировать по возрастанию количества заданной буквы в слове. Слова с одинаковым коли¬чеством расположить в алфавитном порядке.
 * 10.	Существует текст и список слов. Для каждого слова из заданного списка найти, сколько раз оно встречается в каждом предложении, и рассортировать слова по убыванию общего количества вхождений.
 * 11.	В каждом предложении текста исключить подстроку максимальной длины, начинающуюся и заканчивающуюся заданными символами.
 * 12.	Из текста удалить все слова заданной длины, начинающиеся на согласную букву.
 * 13.	Отсортировать слова в тексте по убыванию количества вхождений заданного символа, а в случае равенства – по алфавиту.
 * 14.	В заданном тексте найти подстроку максимальной длины, являющуюся палиндромом, т.е. читающуюся слева направо и справа налево одинаково.
 * 15.	Преобразовать каждое слово в тексте, удалив из него все последующие (предыдущие) вхождения первой (последней) буквы этого слова.
 * 16.	В некотором предложении текста слова заданной длины заменить указанной подстрокой, длина которой может не совпадать с длиной слова.
 */
package application;

import java.util.*;
import text.*;
import tokens.*;

class SortBySentenceLength implements Comparator<Sentence> {

    @Override
    public int compare(Sentence s1, Sentence s2) {
        
        int length1 = s1.getLexems().size();
        int length2 = s2.getLexems().size();
        return (length1 > length2 ? 1 : -1);
    }
    
}
/**
 *
 * @author volodya
 */
public final class Utilits{
    
    static int countSentencesWithWordsRepeats;
    
    public static List<Sentence> getLongestMatches(Text text){
        List<Sentence> sentences = text.getSentences();
        List<Sentence> lexemesList = new ArrayList<>();
        Iterator<Sentence> it = sentences.iterator();
        int wordsRepeats = 0;
        while(it.hasNext()){
            Sentence sentence = it.next();
            List<Word> lexemes = sentence.getLexems();
            wordsRepeats = sentence.getRepeats();
            if (wordsRepeats > 0) countSentencesWithWordsRepeats++;
            lexemesList.add(new Sentence(lexemes));
        }
        return lexemesList;
    }


}
