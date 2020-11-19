package io.github.cfrank95;

import java.io.IOException;
import java.util.ArrayList;


public class BinTree {
    Node mammal = new Node("Is it a mammal?", true);
    Node reptile = new Node("Is it a reptile?", true);
    Node bird = new Node("Is it a bird?", true);
    Node aquatic = new Node("Is it an aquatic animal?", true);
    Node bug = new Node("Is it a bug?", true);

    ArrayList<Node> nodes;

    public BinTree(){
        nodes = new ArrayList<>();
        initializeTree();
    }


    public int countNodes() {
        return nodes.size();
    }

    public Node getNode(int nodePos) {
        return nodes.get(nodePos);
    }


    private void initializeTree(){
        nodes.add(mammal);

        nodes.add(reptile);
        mammal.setRight(reptile);

        nodes.add(bird);
        reptile.setRight(bird);

        nodes.add(aquatic);
        bird.setRight(aquatic);

        nodes.add(bug);
        aquatic.setRight(bug);
    }

    public void test() {
        for (Node node : nodes) {
            System.out.println("Node: " + node.getNodeData());

            if (node.getLeft() != null)
                System.out.println("\tLeft: " + node.getLeft().getNodeData());
            else
                System.out.println("\tLeft: Null");

            if (node.getRight() != null)
                System.out.println("\tRight: " + node.getRight().getNodeData());
            else
                System.out.println("\tRight: Null");

        }
    }
}

