package io.github.cfrank95;

import java.io.*;
import java.util.Scanner;

public class TreeDriver {
    public static void main(String[] args) throws IOException {
        System.out.println("Creating Tree\n");
        BinTree tree = new BinTree();
        int nodeID = 0;
        int nextNodeID = 1;
        int numYesses = 0;

        System.out.println("Current number of nodes: " + tree.countNodes() + "\n");

        for(int i = 0; tree.nodes.size() > i; i++){
            if(tree.getNode(i) != null){
                System.out.println(tree.getNode(i).getNodeData());
            }
        }

        Scanner sc = new Scanner(System.in);
        String response;
        boolean isDone = false;

        // Main loop
        while (!isDone){

            // Main User Interaction
            for(int i = 0; tree.nodes.size() > i; i++){
                System.out.println("Is the animal a(n) " + tree.getNode(i).getNodeData() + "?(Y/N)\n");

                response = sc.next();

                if(response.equals("N")) {
                    nextNodeID = tree.nodes.indexOf(tree.nodes.get(nodeID).getRight());

                    if (nextNodeID == -1){
                        System.out.println("I don't know.  Tell me what you were thinking of.");
                        response = sc.next();
                        tree.nodes.add(new Node(response));

                        System.out.println("What question could I use to identify that animal?");
                        response = sc.next();

                        tree.nodes.get(nodeID).setQuestion(response);
                    }
                }else if(response.equals("Y")){
                    if(tree.nodes.get(nodeID).getLeft() == null && numYesses > 0) {
                        System.out.println("I guessed right!  The animal was a(n) " + tree.nodes.get(nodeID).getNodeData() + "!\n\n");
                        break;
                    }else if(tree.nodes.get(nodeID).getLeft() == null && numYesses == 0){
                        System.out.println("I'm not sure where to go from here.\n" +
                                "Could you tell me what you were thinking?\n");
                        response = sc.next();
                        tree.nodes.add(new Node(response));

                        System.out.println("What question could I use to guess this animal?\n");
                        response = sc.next();
                        nextNodeID = tree.nodes.indexOf(tree.nodes.get(nodeID).getLeft());
                        tree.nodes.get(nextNodeID).setQuestion(response);

                    }
                    numYesses++;
                    nextNodeID = tree.nodes.indexOf(tree.nodes.get(nodeID).getLeft());
                }

                i = nextNodeID - 1;
                nodeID = nextNodeID;

            }

            System.out.println("Would you like to continue? (Y/N)");
            response = sc.next();

            if (response.equals("N")){
                isDone = true;
            }
        }

    }
}