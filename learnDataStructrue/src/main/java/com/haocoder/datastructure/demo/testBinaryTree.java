package com.haocoder.datastructure.demo;

/**
 *
 * @author LiuHao
 * @date 2019/11/14 14:19
 * @description 测试二叉树类功能
*/
public class testBinaryTree {
    public static void main(String args[]){
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.printTree();
        Integer[] arrays1  = {1,3,2,5};
        binaryTree.construct(arrays1);
        binaryTree.printTree();

        System.out.println();

        BinaryTree binaryTree1 = new BinaryTree();
        Integer[] array2 = {2,1,3,null,4,null,7};
        binaryTree1.construct(array2);
        binaryTree1.printTree();

        System.out.println();

        BinaryTree.mergeTree(binaryTree,binaryTree1).printTree();
    }
}
