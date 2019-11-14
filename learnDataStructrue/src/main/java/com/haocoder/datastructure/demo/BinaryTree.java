package com.haocoder.datastructure.demo;


/**
 *
 * @author LiuHao
 * @date 2019/11/13 17:27
 * @description 二叉树类型
*/
public class BinaryTree {

    private TreeNode root = null;

    private BinaryTree(TreeNode node){
        root = node;
    }
    public BinaryTree(){

    }
    /**
     *
     * @author LiuHao
     * @date 2019/11/14 13:28
     * @description 二叉树节点类型
     */
    private class TreeNode {
        private Integer data;
        private TreeNode leftNode;
        private TreeNode rightNode;

        public TreeNode(){}
        @Override
        public String toString(){
            return data.toString();
        }
    }
    /**
     * 利用数组递归构建二叉树（不太规范的二叉树）
     * @param data 数组
     * @param index 下标
     * @param n 数组长度
     * @return
     */
    private TreeNode construct(Integer[] data,int index,int n){
        TreeNode pNode = null;
        if(index < n ){
            pNode = new TreeNode();
            if(pNode == null){
                return null;
            }
            pNode.data = data[index];
            pNode.leftNode = construct(data,2*index+1,n);
            pNode.rightNode = construct(data,2*index+2,n);
        }
        return pNode;
    }

    /**
     * 利用数组递归构建二叉树
     * @param data
     */
    public void construct(Integer[] data){
        root = construct(data,0,data.length);
    }

    /**
     * 先序遍历打印二叉树
     * @param node
     */
    private void printTree(TreeNode node){
        if(node==null) {
            return;
        }
        System.out.print(node.data+"->");
        printTree(node.leftNode);
        printTree(node.rightNode);
    }

    /**
     * 先序遍历打印二叉树
     */
    public void printTree(){
        printTree(root);
    }

    /**
     * 合并二叉树，规则
     * 情况：1）二叉树对应位置两个节点都存在，将值相加
     * 2）二叉树对应位置两个节点任意一个节点存在，合并该节点
     * 3）二叉树对应位置两个节点都不存在，不进行处理
     *
     * @param aTree
     * @param bTree
     * @return
     */
    public static TreeNode mergeTree(TreeNode aTree,TreeNode bTree){
        if(aTree != null && bTree !=null){
            Integer sum = aTree.data + bTree.data;
            aTree.data = sum;
            mergeTree(aTree.leftNode,bTree.leftNode);
            mergeTree(aTree.rightNode,bTree.rightNode);
        }
        return  aTree == null ? bTree : aTree;
    }

    /**
     * 合并二叉树
     * @param aTree
     * @param bTree
     * @return
     */
    public static BinaryTree mergeTree(BinaryTree aTree,BinaryTree bTree){
        return new BinaryTree(mergeTree(aTree.getRoot(),bTree.getRoot()));
    }

    /**
     * 获取根节点
     * @return
     */
    private TreeNode getRoot(){
        return this.root;
    }

    public static void main(String args[]){
        BinaryTree binaryTree = new BinaryTree();
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