/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bidirectionalcount;

/**
 *
 * @author volodya
 */
public class BiDirectionalCount {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        double sum1 = 0;
        double sum2 = 0;

        double[] members = {1,9,99,999,9999,99999,999999,9999999};
        for(int i = 0, j = members.length-1; i < members.length; i++, j--){
            sum1 += 1./members[i];
            sum2 += 1./members[j];
        }
        System.out.println(sum1 + "\n" +  sum2);
    }
}
