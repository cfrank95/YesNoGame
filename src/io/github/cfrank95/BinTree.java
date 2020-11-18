package io.github.cfrank95;

import java.io.IOException;
import java.util.ArrayList;


public class BinTree {
    Node mammal = new Node("Mammal", true);
    Node reptile = new Node("Reptile", true);
    Node bird = new Node("Bird", true);
    Node aquatic = new Node("Aquatic Animal", true);
    Node bug = new Node("Bug", true);

    private Node node;

    ArrayList<Node> nodes;

    public BinTree() throws IOException {
        nodes = new ArrayList<>();
        initializeTree();
    }

    public boolean isEmpty(){
        return mammal == null;
    }

    public int countNodes(){
        return nodes.size();
    }

    public Node getNode(int nodePos){
        return nodes.get(nodePos);
    }

    public void setNode(Node node){
        this.node = node;
    }

    private void initializeTree() throws IOException {
//        FileReader reader = new FileReader("src/res/nodelist.txt");
//        BufferedReader bufferedReader = new BufferedReader(reader);
//
//
//        StringBuilder sb = new StringBuilder();
//
//        String nodes;
//        while((nodes = bufferedReader.readLine() != null){
//
//            sb.append(nodes);
//            sb.append(System.lineSeparator());
//
//            tree.add(new Node(sb));
//        }
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

    public void test(){
        for(int i = 0; i < nodes.size(); i++){
            System.out.println("Node: " + nodes.get(i).getNodeData());

            if(nodes.get(i).getLeft() != null)
                System.out.println("\tLeft: " + nodes.get(i).getLeft().getNodeData());
            else
                System.out.println("\tLeft: Null");

            if(nodes.get(i).getRight() != null)
                System.out.println("\tRight: " + nodes.get(i).getRight().getNodeData());
            else
                System.out.println("\tRight: Null");

        }
    }
}

