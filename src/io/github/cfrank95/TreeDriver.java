package io.github.cfrank95;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TreeDriver {

    // begin main()
    public static void main(String[] args) throws IOException {
        System.out.println("Creating Tree\n");
        BinTree tree = new BinTree();
        int nodeID = 0;
        int nextNodeID = 1;

        System.out.println("Current number of nodes: " + tree.countNodes() + "\n");

        Scanner sc = new Scanner(System.in);
        String response;
        boolean isDone = false;

        // Main loop
        while (!isDone){

            // Main User Interaction
            int numYeses = 0;
            for(int i = 0; tree.nodes.size() > i; i++){
                System.out.println("Is the animal a(n) " + tree.getNode(i).getNodeData() + "? (Y/N)");

                response = sc.nextLine();

                if(response.equalsIgnoreCase("N")) {

                    nextNodeID = tree.nodes.indexOf(tree.nodes.get(nodeID).getRight());
                    if (nextNodeID == -1){
                        System.out.println("I don't know.  Tell me what you were thinking of.");
                        response = sc.nextLine();
                        tree.nodes.add(new Node(response, false));

                        System.out.println("What question could I use to identify that animal?");
                        response = sc.nextLine();
                        sc.next();


                        tree.nodes.get(nextNodeID).setQuestion(response);
                    }
                }else if(response.equalsIgnoreCase("Y")){

                    if(tree.nodes.get(nodeID).getLeft() == null && tree.nodes.get(nodeID).isTail()) {
                        System.out.println("I guessed right!  The animal was a(n) "
                                + tree.nodes.get(nodeID).getNodeData() + "!\n\n");
                        break;

                    }else if(tree.nodes.get(nodeID).getLeft() == null && !tree.nodes.get(nodeID).isTail()){

                        System.out.println("I'm not sure where to go from here.\n" +
                                "Could you tell me what you were thinking?");
                        response = sc.nextLine();
                        tree.nodes.add(new Node(response, false));
                        nextNodeID = tree.countNodes() - 1;
                        tree.nodes.get(nodeID).setLeft(tree.nodes.get(nextNodeID));

                        System.out.println("What question could I use to guess this animal?");
                        response = sc.nextLine();
                        tree.nodes.get(nextNodeID).setQuestion(response);
                    }

                    numYeses++;
                    nextNodeID = tree.nodes.indexOf(tree.nodes.get(nodeID).getLeft());
                }

                i = nextNodeID - 1;
                nodeID = nextNodeID;
            }

            System.out.println("Would you like to continue? (Y/N)");
            response = sc.nextLine();
            if (response.equals("N")){
                isDone = true;
            }

            tree.test();
        }   // end main while() loop

    }   // end main()


}