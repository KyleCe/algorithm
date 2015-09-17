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

/*
Write a program to check whether a given number is an ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.

Note that 1 is typically treated as an ugly number.
*/
public class S4UglyNumber {
    S4UglyNumber(){
        super();
        int[] array = {11,13,14,15,16,17,18,19,20};
        for(int i :array){
            Util.sop(i,(isUgly(i)?"is":"is not")+" ugly num");
        }
    }
    
    public boolean isUgly(int num) {
        if(num == 0) return false;
        while(num % 5 == 0)
            num /= 5;
        while(num % 3 == 0)
            num /= 3;
        while(num %  2 == 0)
            num /= 2;
        return num== 1;
    }
}
