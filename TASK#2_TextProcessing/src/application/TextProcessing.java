/*
 * Task2
 * Создать программу обработки текста учебника по программированию с использованием классов: Символ, Слово, Предложение, Знак препинания и др. 
 * Во всех задачах с формированием текста заменять табуляции и последовательности пробелов одним пробелом.
 * 
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
 *
 */
package application;

import java.util.*;
import text.Text;
import tokens.*;
import java.io.*;
import tokens.Sentence;
/**
 *
 * @author volodya
 */
public class TextProcessing {
    
    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        String[] subtasks;
        subtasks = new Scanner(new File("db\\task.txt")).useDelimiter("\\Z").next().split("\n");
        for(String chapterName:subtasks){
            System.out.println(chapterName);
        }
        
        Text text = new Text("test.txt");
        insertChapter("THE TEXT");
        text.splitText();
        List<Sentence> sentences;
        sentences = text.getSentences();
        sentences.stream().filter((s) -> !(s==null)).forEach((s) -> {
            System.out.println(s);
        });
        List<Sentence> sentencesWithoutMarks = Utilits.getLongestMatches(text);
        insertChapter(subtasks[0]);
        System.out.println(Utilits.countSentencesWithWordsRepeats);
        

        insertChapter(subtasks[1]);
        List<Sentence> sentencesSorted = new ArrayList<>(sentences);
        sentencesSorted.sort(new SortBySentenceLength());
        sentencesSorted.stream().filter((s) -> !(s==null)).forEach((s) -> {
            System.out.println(s);
        });
        
        insertChapter(subtasks[2]);
        System.out.println("A head sentence : " + sentences.get(0).toString());
        List<Sentence> restSentences = new ArrayList<>(sentences);
        Sentence firstSentence = restSentences.remove(0);
        List<Word> searchWords = firstSentence.getLexems();
        List<Word> restWords = new ArrayList<>();
        List<Word> resultWords = new ArrayList<>(searchWords);
        restSentences.stream().forEach((snt) -> {
            restWords.addAll(snt.getLexems());
        });
        label: for(Word word : searchWords) {
            for (Word w : restWords) {
                if(word.equals(w)) {
                    System.out.println(word + " - is found in the rest of the text");
                    resultWords.remove(word);
                    continue label;
                }
            }
        }
        System.out.println("\nUnique words from first sentcence: ");
        resultWords.stream().forEach((w) -> {
            System.out.println(w);
        });
        
        insertChapter(subtasks[3]);
        final int length = 5;
        Set<Word> uniqueWordsSet = new HashSet<>();
        List<Sentence> questionSentences = new ArrayList<>();
        sentences.stream().filter((s) -> !(s==null)).forEach((s) -> {
            if(s.getType()==TypeOfSentence.QUESTION) {
                questionSentences.add(s);
                System.out.println(s);
            }
        });
        questionSentences.stream().filter((qs) -> !(qs==null)).forEach((qs) -> {
            final List<Word> wordsQ = qs.getLexems();
            wordsQ.stream().filter((wq) -> (wq.size()==length)).forEach((wq) -> {
                uniqueWordsSet.add(wq);
            });
        });
        System.out.println("length = " + length + ", unique words : " 
                + uniqueWordsSet);
        
    }

    private static void insertChapter(String chapterName) {
        System.out.println("\n################################################"
                + "##########################################################");
        System.out.println(chapterName);
        System.out.println("#################################################"
                + "#########################################################");
    }
    
}
