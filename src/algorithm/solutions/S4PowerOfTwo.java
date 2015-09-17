/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.solutions;

import algorithm.Utils.Util;

/**
 *Given an integer, write a function to determine if it is a power of two.
 * @author kyle
 */
public class S4PowerOfTwo {
    
    S4PowerOfTwo(){
        SelfTest();
    }
    
    private void SelfTest(){
        Util.sop(13 , isPowerOfTwo(13));
        Util.sop(14 , isPowerOfTwo(14));
        Util.sop(15 , isPowerOfTwo(15));
        Util.sop(16 , isPowerOfTwo(16));
        Util.sop(17 , isPowerOfTwo(17));
        Util.sop(18 , isPowerOfTwo(18));
        Math.abs(-1);
    }
    
    public boolean isPowerOfTwo(int n) {
        if(n <= 1) return n == 1;
        if(n%2 != 0) return false;
        while(n /2 != 0){
            if(n % 2 == 0) n = n/2;
            else return false;
        }
        return true;
        
    }
    
//    inline
}
