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
public class S4ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s == null && t == null) return true;
        if(only1Null(s,t)) return false;
        if(s.length() != t.length()) return false;
        if(s.equals(t)) return true;
        return sure(s,t);
    }
    
    public static boolean sure(String s, String t){
        Character[] ch_s = toCharacterArray(s);
        Character[] ch_t = toCharacterArray(t);
        shell_sort(ch_s);
        shell_sort(ch_t);
        for(int i = 0; i< ch_s.length; i++)
            if(ch_s[i] != ch_t[i]) return false;
        return true;
    }
    
    public static boolean only1Null(String s, String t){
        return !(s != null && t != null);
    }
    
    public static Character[] toCharacterArray(String s){
        char[] a = s.toCharArray();
        int l = a.length;
        Character[] Chs = new Character[l];
        for(int i = 0; i< l; i++)
            Chs[i] = a[i];
        return Chs;
    }
    
    public static void shell_sort(Comparable[] src){
        int N = src.length;
        int h = 1;
        while(h <= N / 3) h = h * 3 + 1;
        while(h >= 1){
            for(int i = h; i < N; i++)
                for(int j = i; j >= h && less(src[j],src[j-h]); j -= h) 
                    exch(src,j,j-h);
            h /= 3;
        }
    }
    
    public static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }
    
    public static void exch(Comparable[] a, int i, int j){
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
