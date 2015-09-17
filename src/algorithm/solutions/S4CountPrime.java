/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.solutions;

import algorithm.Utils.Util;

/**
 *
 * @author kyle
 */
public class S4CountPrime {
    
    S4CountPrime(){
        SelfTest();
    }
    
    static public void SelfTest(){
        Util.sop(isPrimeNumber(13),13);
        Util.sop(countPrimes(11),11);
        Util.sop(isPrimeNumber(14),14);
        Util.sop(countPrimes(15),15);
        Util.sop(countPrimes(17),17);
        Util.sop(isPrimeNumber(19),19);
    }
    
    static public int countPrimes(int n) {
        int count = 0;
        for(int i = n; i>0; i--)
            if(isPrimeNumber(i)) count++;
        return count;
    }
    private static boolean isPrimeNumber(int n){
        for(int i = (int)Math.sqrt(n); i > 1; i--){
            if(n % i == 0) return false;
        }
        return true;
    }
}
