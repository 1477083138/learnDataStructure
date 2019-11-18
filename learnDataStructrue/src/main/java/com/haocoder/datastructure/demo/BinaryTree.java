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
        if(root == null){
            System.out.println("该二叉树为空树!");
        }
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
    private static TreeNode mergeTree(TreeNode aTree,TreeNode bTree){
        if(aTree != null && bTree !=null && aTree.data!= null && bTree.data !=null){
            aTree.data = aTree.data + bTree.data;
            aTree.leftNode = mergeTree(aTree.leftNode,bTree.leftNode);
            aTree.rightNode = mergeTree(aTree.rightNode,bTree.rightNode);
            return aTree;
        }
        //如果两个二叉树任一节点存在，则合并（这一层包含了bTree=null的情况，即条件3））是递归的结束条件
       /* if(aTree == null || aTree.data == null){
            return bTree;
        }else{
            return aTree;
        }*/
        //化简
        return aTree == null || aTree.data == null ? bTree : aTree;
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
}
