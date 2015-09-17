/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.solutions;

/**
 *
 * @author kyle
 */

/*
Given a non-negative integer num, 
repeatedly add all its digits until the result has only one digit.

For example:

Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. 
Since 2 has only one digit, return it.

Follow up:
Could you do it without any loop/recursion in O(1) runtime?
*/
public class S4AddDigits {
    S4AddDigits(){
        
        
    }
    
    public int addDigits(int num) {
        return num==0?0:
                num%9==0?9:
                (num+1)%9==0?8:
                (num+2)%9==0?7:
                (num+3)%9==0?6:
                (num+4)%9==0?5:
                (num+5)%9==0?4:
                (num+6)%9==0?3:
                (num+7)%9==0?2:
                (num+8)%9==0?1:
                0;
        
    }
}
