package io.github.cfrank95;

public class Node {

    private String question;
    private String data;
    private Node left;
    private Node right;
    final private boolean isCategory;

    Node(String data, boolean isCategory){
        this.data = data;
        this.question = null;
        this.isCategory = isCategory;
        left = null;
        right = null;
    }

    // Setters
    void setLeft(Node node){
        if (left == null)
            left = node;
    }

    void setRight(Node node){
        if (right == null)
            right = node;
    }

    void setNodeData(String data){
        this.data = data;
    }

    void setQuestion(String question){
        this.question = question;
    }


    // Getters
    public Node getLeft(){
        return left;
    }

    public Node getRight(){
        return right;
    }

    public String getNodeData(){
        return data;
    }

    public String getQuestion(){
        return question;
    }

    public boolean getIsCategory() {
        return isCategory;
    }

    public boolean isTail(){
        if (getLeft() == null && getRight() == null){
            return true;
        }
        else
            return false;
    }

}