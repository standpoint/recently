/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitsnumber;

/**
 *
 * @author volodya
 */
public class BitsNumber {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        byte byteNum = -127;
        short shortNum = Short.MAX_VALUE>>2;
        int intNum = Integer.MAX_VALUE>>3;
        long longNum = Long.MAX_VALUE>>4;
        System.out.println(String.format("%8s", Integer.toBinaryString(byteNum)).replace(' ', '0'));
        System.out.println(getBitsNumber(byteNum));
        System.out.println(String.format("%16s", Integer.toBinaryString(shortNum)).replace(' ', '0'));
        System.out.println(getBitsNumber(shortNum));
        System.out.println(String.format("%32s", Integer.toBinaryString(intNum)).replace(' ', '0'));
        System.out.println(getBitsNumber(intNum));
        System.out.println(String.format("%64s", Long.toBinaryString(longNum)).replace(' ', '0'));
        System.out.println(getBitsNumber(longNum));
    }

    public static int getBitsNumber(byte byteNum){
        int n=0;
        while((byteNum >>> n)>1){
            n++;
        }
        return ++n;
    }
    public static int getBitsNumber(short shortNum){
        int n=0;
        while((shortNum >> n)>1){
            n++;
        }
        return ++n;
    }
    public static int getBitsNumber(int intNum){
        int n=0;
        while((intNum >> n)>1){
            n++;
        }
        return ++n;
    }
    public static int getBitsNumber(long longNum){
        int n=0;
        while((longNum >> n)>1){
            n++;
        }
        return ++n;
    }
}
