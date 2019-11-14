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
        Integer[] arrays1  = {1,2,3,4,5,6,7,9,10};
        binaryTree.construct(arrays1);
        binaryTree.printTree();

        System.out.println();

        BinaryTree binaryTree1 = new BinaryTree();
        Integer[] array2 = {1,2,3,4};
        binaryTree1.construct(array2);
        binaryTree1.printTree();

        System.out.println();

        BinaryTree.mergeTree(binaryTree,binaryTree1).printTree();
    }
}
