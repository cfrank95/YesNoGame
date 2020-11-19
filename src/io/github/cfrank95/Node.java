package io.github.cfrank95;

public class Node {

    private final boolean isQuestion;
    private final String data;
    private Node left;
    private Node right;

    Node(String data, boolean isQuestion) {
        this.data = data;
        this.isQuestion = isQuestion;
        left = null;
        right = null;
    }

    // Setters
    void setLeft(Node node) {
        if (left == null)
            left = node;
    }

    void setRight(Node node) {
        if (right == null)
            right = node;
    }

    // Getters
    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public String getNodeData() {
        return data;
    }

    public boolean getIsQuestion() {
        return isQuestion;
    }

}