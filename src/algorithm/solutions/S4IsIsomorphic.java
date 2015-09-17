/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author kyle
 */
public class S4IsIsomorphic {
    
    S4IsIsomorphic(){
        SelfTest();
    }
    private static void SelfTest(){
        
    }
    
    public boolean isIsomorphic(String s, String t) {
        char [] p = s.toCharArray();
        char [] q = t.toCharArray();
        int len = s.length();
        HashMap<Character, List<Integer>> mapP = new HashMap<>();
        HashMap<Character, List<Integer>> mapQ = new HashMap<>();
        List <Integer> list = new ArrayList<>();
        for(int i = 0; i< len; i++){
            if(!mapP.containsKey(p[i])){
                mapP.put(p[i], list);
                mapP.get(p[i]).add(i);
            }
        }
        return false;
    }
    
}
