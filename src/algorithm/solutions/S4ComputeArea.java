/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.solutions;

import algorithm.Utils.Util;
import java.util.HashMap;

/**
 *
 * @author kyle
 */
public class S4ComputeArea {
    S4ComputeArea(){
        SelfTest();
    }
    private static void SelfTest(){
//        int [] arr = {-2, -2, 2, 2, 3, 3, 4, 4};
//        int [] arr = {-2, -2, 2, 2, -4, 3, -3, 4};
        int [] arr = {-2, -2, 2, 2, -1, 4, 1, 6};
        Util.sop(computeArea(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5],arr[6],arr[7]));
//        arr.length;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        if(!map.containsKey(arr[0]))
           ;
        String s="ddsd";
        int i = s.length();
    }
    
    
    static public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int s_share = getEdgeOfArea(A,E,C,G) * getEdgeOfArea(B,F,D,H);
        if(noShare(A,B,C,D,E,F,G,H) || s_share < 0) s_share = 0;
        int s_sum = getSOfArea(A,B,C,D) + getSOfArea(E,F,G,H);
        return s_sum - s_share;
    }
    
    static public boolean noShare(int A, int B, int C, int D, int E, int F, int G, int H){
        return (A>G && B > H) || (E > C && F > D) 
                ||(F > D && A > G) || (E > C && B > H);
    }
    
    static public int getSOfArea(int A, int B , int C, int D){
        return (C -A)* (D -B);
    }
    
    static public int getEdgeOfArea(int A, int E,int C, int G){
        int Lmax = A >= E ? A : E;
        int Rmin = C <= G ? C : G;
        return Rmin - Lmax;
    }
}
