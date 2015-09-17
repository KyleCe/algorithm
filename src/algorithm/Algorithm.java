/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

 算法面试题  
 整数数组，求数组子序列中的和最大子序列，输出这个最大和
 例：
 {1,-2,3,-2,4,-10}
 最大和子序列{3,-2,4}，最大和：5
 */
package algorithm;
//import stdlib.*;

import algorithm.Utils.Util;
import algorithm.solutions.S4CountPrime;
import algorithm.solutions.S4ValidAnagram;


//import org.apache.commons.lang3.time;

/**
 *
 * @author kyle
 */
public class Algorithm {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        sort();
//        test();
//        lc_test();
//        new Solution4Palindrome();
//        new Solution4UglyNumber();
//        new S4AddDigits();
//        new S4DeleteNodeInLinkedList();
//        new S4SummaryRanges();
//        new MyStack();
//        new S4PowerOfTwo();
        S4CountPrime.SelfTest();
        Util.sop(1);
        
    }

    public static void lc_test(){
        S4ValidAnagram so = new S4ValidAnagram();
        if(so.isAnagram("judgement", "mentjudge")) sop("true");
        else sop("false");
    }
    
    
    public static void test()
    {
        //把一个字符串转换为整数
        Character[] a = {'m','e','r','g','e','s','o','r','t','e','x','a','m','p','l','e'};
        int len = a.length;
        Integer [] a2int = new Integer[len];
        for(int i =0; i< len; i++){
            a2int[i] = (int)a[i];
        }
        show(a2int);
    }
    

    public static void sort() {

//        sop(exR1(6));
//        sop(gcd(1111111, 1234567));
        Character[] a = {'S','H','E','L','L','S','O','R','T','E','X','A','M','P','L','E'};
        sort_shell(a);
//        show(a);
        
//        merge_sort_example();
        quick_sort_example();
        
    }
    
    public static void quick_sort_example(){
        Character[] a = {'Q','U','I','C','K','S','O','R','T','E','X','A','M','P','L','E'};
        quick_sort(a,0,a.length - 1);
        show(a);
    }
    
    public static void quick_sort(Comparable[] a,int lo, int hi){
        if(hi <= lo) return;
        int j = partition(a,lo,hi);
        quick_sort(a, lo, j-1);
        quick_sort(a, j+ 1, hi);
    }
    
    public static int partition(Comparable[] a, int lo, int hi){
        int i = lo,j = hi+1;
        Comparable v = a[lo];
        while(true){
            while(less(a[++i], v)) if(i == hi) break;
            while(less(v, a[--j])) if(j == lo) break;
            if(i >= j) break;
            exch(a,i,j);
        }
        exch(a,lo,j);
        return j;
    }
    
    public static void merge_sort_example(){
    Character[] b = {'m','e','r','g','e','s','o','r','t','e','x','a','m','p','l','e','b'};
        aux = new Comparable[b.length];
//        sort_merge(b,0,b.length-1);
        sort_merge_BU(b);
        show(b);
    }
    
    private static Comparable [] aux;
    
    public static void sort_merge(Comparable []a, int lo, int hi){
        if(hi <= lo) return;
        int mid = lo + (hi - lo)/2;
        sort_merge(a, lo,mid);
        sort_merge(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }
    
    public static void sort_merge_BU(Comparable [] a){
        int N = a.length;
        for(int sz = 1; sz < N; sz = sz + sz)
            for(int lo = 0; lo < N - sz; lo += sz + sz)
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz -1, N -1));
    }
    
    public static void merge(Comparable []a, int lo, int mid, int hi){
        int i = lo;
        int j = mid + 1;
        for(int k = lo; k<=hi; k++)
            aux[k] = a[k];
        for(int k = lo; k<= hi; k++)
            if(i > mid) a[k] = aux[j++];
            else if(j> hi) a[k] = aux[i++];
            else if(less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k]  = aux[i++];
    }

    public static void sort_shell(Comparable[] a){
        int L = a.length;
        int STEP = 4;
        int s = 1;
        while( s < L/STEP) s = STEP * s + 1;
        while( s >= 1){
            for(int i = s; i < L; i++){
                for(int j = i; j>= s && less(a[j],a[j-s]);j-=s)
                    exch(a,j,j-s);
            }
            s/=STEP;
        }
    }

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            //TODO
            //Mothod 1 每次比较后，遇大就交换
//            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
//                exch(a, j, j - 1);
//            }

            //Method 2 比较后，不马上交换，而是看之前的是不是也比a[i]大的，
            //                          是       则继续以上步骤
            //                          不是     则结束比较，顺序移位
            for (int j = i; j > 0 && less(a[i], a[j - 1]); j--) {
                //如果j-1=0 结束比较，移位
                //如果j-1>0 但a[j-2]<a[i],结束比较，移位
                //           a[j-2]>a[i],继续比较
                if (j == 1 || (j > 1 && !less(a[i], a[j - 2]))) {
                    move(a, j - 1, i);
                    break;
                }
            }
        }
    }

    /* 把a 从m位到n-1位向后顺移一位，m位用n位的填充
     */
    public static void move(Comparable[] a, int m, int n) {
        assert m < n && n >= 1;
        Comparable t = a[n];
        //TODO
        for (int i = n; i > m; i--) {
            a[i] = a[i - 1];
        }
        a[m] = t;
    }
    
    public static void exch(Comparable[] a, int m, int n) {
        Comparable t = a[m];
        a[m] = a[n];
        a[n] = t;
    }


    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void show(Object[] a) {
        for (int i = 0; i < a.length; i++) {
            sop(a[i]);
        }
    }

    public static int gcd(int a, int b) {

        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static int mystery(int a, int b) {
        if (b == 0) {
            return 1;
        }
        if (b % 2 == 0) {
            return mystery(a * a, b / 2);
        }
        return mystery(a * a, b / 2) * a;
    }

    public static String exR1(int n) {
        if (n <= 0) {
            return "";
        }
        return exR1(n - 3) + n + exR1(n - 2);
    }

    public static boolean isPrime(int N) {
        if (N < 2) {
            return false;
        }
        for (int i = 2; i * i <= N; i++) {
            if (N % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static double sqrt(double c) {
        if (c < 0) {
            return Double.NaN;
        }
        double err = 1e-15;
        double t = c;
        while (Math.abs(t - c / t) > err * t) {
            t = (c / t + t) / 2.0;
        }
        return t;
    }

    public static int rank(int key, int[] a, int lo, int hi) {
        if (lo > hi) {
            return -1;
        }
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]) {
            return rank(key, a, lo, mid - 1);
        } else if (key > a[mid]) {
            return rank(key, a, mid + 1, hi);
        } else {
            return mid;
        }
    }

    static public void sop(Object o) {

        System.out.println(o.toString());
    }
}
