/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.solutions;

import algorithm.Utils.Util;
import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].

 * @author kyle
 */
public class S4SummaryRanges {
    S4SummaryRanges(){
        SelfTest();
    }
    
    private void SelfTest(){
        Util.sop(summaryRanges(new int[]{1,2,8}));//  0,1,2,4,5,7,9,10,11,12,13,16 //0,1,2,4,5,7
    }
    
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        if(nums.length == 1) {
            result.add(getRangesString(nums,0));
            return result;
        }
        for(int k = 0;k <= nums.length-1 ;k++)
            result.add(getRangesString(nums,k,k = getRightKey(nums,k)));
        return result;
    }
    
    private int getRightKey(int[] nums, int k){
        int result = 0;
        if(k >= nums.length ) return -1;
        if(k == nums.length -1) return k;
        for(result = k; k < nums.length-1 ; k ++) 
            if(nums[k+1] == nums[k] + 1) result = k+1; 
            else break;
        return result;
    }
    
    private String getRangesString(int[]nums,int... a){
        if( nums == null) return "";
        if(a.length > 2) return "";
        if(a.length == 1 || nums[a[0]] == nums[a[1]]) return String.valueOf(nums[a[0]]);
        else return String.valueOf(nums[a[0]]) + "->" + String.valueOf(nums[a[1]]);
    }
}
