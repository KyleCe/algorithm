/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 *Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]
* 
 * @author kyle
 */
public class S4BinaryTreePath {
    
    S4BinaryTreePath(){
        SelfTest();
    }
    
    private void SelfTest(){
        
    }
    
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> BTP = new ArrayList<String>();
        if(root == null) return BTP;
        String singlePath = String.valueOf(root.val);
        binaryTreePaths(root, BTP, singlePath);
        return BTP;

    }

    private void binaryTreePaths(TreeNode root, List<String> BTP, String singlePath){

        if(root.left == null && root.right == null)
            BTP.add(singlePath);
        else {
            if(root.left != null)
                binaryTreePaths(root.left, BTP, singlePath.concat("->").concat(String.valueOf(root.left.val)));
            if(root.right != null)
                binaryTreePaths(root.right, BTP, singlePath.concat("->").concat(String.valueOf(root.right.val)));
        }
    }
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
  
}
