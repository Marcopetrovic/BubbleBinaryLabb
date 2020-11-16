package com.company;

public class BinarySearchTree {

    public boolean delete(int key){
        Node focusNode = root;
        Node parent = root;

        boolean isItaLeftChild = true;

        while(focusNode.key != key){
            parent = focusNode;
            if (key < focusNode.key){
                isItaLeftChild = true;
                focusNode = focusNode.leftChild;
            }
            else{
                isItaLeftChild = false;
                focusNode = focusNode.rightChild;
            }
            if(focusNode == null)
                return false;
        }
        if(focusNode.leftChild == null && focusNode.rightChild == null){
            if(focusNode == root){
                root = null;
            }
            else if(isItaLeftChild){
                parent.leftChild = null;
            }
            else{
                parent.rightChild = null;
            }
        }
        else if(focusNode.rightChild == null){
            if(focusNode == root)
                root = focusNode.leftChild;

            else if(isItaLeftChild)
                parent.leftChild = focusNode.leftChild;

            else parent.rightChild = focusNode.leftChild;
        }
        else if(focusNode.leftChild == null){
            if(focusNode == root)
                root = focusNode.rightChild;

            else if(isItaLeftChild)
                parent.leftChild = focusNode.rightChild;

            else

                parent.rightChild = focusNode.leftChild;
        }
        else{
            Node replacement = getReplacementNode(focusNode);

            if(focusNode == root)
                root = replacement;

                else if(isItaLeftChild)
                    parent.leftChild = replacement;

                else
                    parent.rightChild = replacement;

                replacement.leftChild = focusNode.leftChild;
        }
        return true;
    }

    public Node getReplacementNode(Node replacedNode){
        Node replaceParent = replacedNode;
        Node replacement = replacedNode;

        Node focusNode = replacedNode.rightChild;

        while(focusNode != null){
            replaceParent = replacement;
            replacement = focusNode;
            focusNode = focusNode.leftChild;
        }
        if(replacement != replacedNode.rightChild){
            replaceParent.leftChild = replacement.rightChild;
            replacement.rightChild = replacedNode.rightChild;
        }
        return replacement;
    }


    public void inOrderTraverseTree(Node focusNode){
        if(focusNode != null){
            inOrderTraverseTree(focusNode.leftChild);
            System.out.println(focusNode);
            inOrderTraverseTree(focusNode.rightChild);
        }
    }

    public void preOrderTraverseTree(Node focusNode){
        if(focusNode != null){
            System.out.println(focusNode);
            preOrderTraverseTree(focusNode.leftChild);
            preOrderTraverseTree(focusNode.rightChild);
        }
    }

    public void postOrderTraverseTree(Node focusNode){
        if(focusNode != null){
            postOrderTraverseTree(focusNode.leftChild);
            postOrderTraverseTree(focusNode.rightChild);
            System.out.println(focusNode);
        }
    }

    public void reverseOrderTraverseTree(Node focusNode) {
        if (focusNode != null){
        reverseOrderTraverseTree(focusNode.rightChild);
        System.out.println(focusNode);
        reverseOrderTraverseTree(focusNode.leftChild);
    }
    }

    Node root;
    public void addNode(int key, String name){

        Node newNode = new Node(key, name);

        if(root == null){
            root = newNode;
        }
        else{
            Node focusNode = root;
            Node parent;

            while(true){
                parent = focusNode;

                if(key < focusNode.key){
                    focusNode = focusNode.leftChild;
                    if(focusNode == null){
                        parent.leftChild = newNode;
                        return;
                    }
                }
                else{
                    focusNode = focusNode.rightChild;

                    if(focusNode == null){
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }



class Node {
    int key;
    String name;

    Node leftChild;
    Node rightChild;

    Node(int key, String name){
        this.key = key;
        this.name = name;
    }

    public String toString(){
        return name + " has a key " + key;
    }
    }
}
