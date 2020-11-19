package io.github.cfrank95;

import java.io.*;
import java.util.Scanner;

public class TreeDriver {

    // begin main()
    public static void main(String[] args){
        System.out.println("Creating Tree\n");
        BinTree tree = new BinTree();

        System.out.println("Current number of nodes: " + tree.countNodes() + "\n");

        Scanner sc = new Scanner(System.in);

        boolean isDone = false;

        // Main loop
        while (!isDone) {
            // Keep Track of Nodes
            int nodeId = 0;
            int nextNodeID;

            // Differentiate between responses
            String response;            // Y / N responses
            String questionResponse;    // Responses to create question nodes (isQuestion == true)
            String animalResponse;      // Responses to create animal nodes (isQuestion == false)

            // Main User Interaction
            while (tree.nodes.size() > nodeId) {
                if (tree.getNode(nodeId).getIsQuestion())
                    System.out.println(tree.getNode(nodeId).getNodeData() + " (Y/N)");
                else {
                    System.out.println("Is the animal a(n) " + tree.getNode(nodeId).getNodeData() + "? (Y/N)");
                }

                response = sc.nextLine();

                // "No" Branch (Right)
                if (response.equalsIgnoreCase("N")) {

                    // Is branch null?
                    nextNodeID = tree.nodes.indexOf(tree.nodes.get(nodeId).getRight());
                    if (nextNodeID == -1) {
                        System.out.println("I don't know.  Tell me what you were thinking of.");
                        animalResponse = sc.nextLine();

                        System.out.println("What question could I use to identify that animal?");
                        questionResponse = sc.nextLine();

                        Node question = new Node(questionResponse, true);
                        tree.nodes.add(question);
                        tree.nodes.get(nodeId).setRight(question);

                        nextNodeID = tree.nodes.indexOf(question);
                        Node animal = new Node(animalResponse, false);
                        tree.nodes.add(animal);
                        tree.nodes.get(nextNodeID).setLeft(animal);

                        nodeId = 0;

                        // Continue
                    } else {
                        nodeId = tree.nodes.indexOf(tree.nodes.get(nodeId).getRight());
                    }

                    // "Yes" Branch (Left)
                } else if (response.equalsIgnoreCase("Y")) {

                    nextNodeID = tree.nodes.indexOf(tree.nodes.get(nodeId).getLeft());
                    // Is the next branch a tail extending from a question?
                    if (nextNodeID == -1 && !tree.nodes.get(nodeId).getIsQuestion()) {
                        System.out.println("\nI guessed right!  The animal was a(n) "
                                + tree.nodes.get(nodeId).getNodeData() + "!\n");
                        break;
                        // Is the next branch a tail and extending from a question?
                    } else if (nextNodeID == -1) {

                        System.out.println("I'm not sure where to go from here.\n" +
                                "Could you tell me what you were thinking?");
                        animalResponse = sc.nextLine();

                        System.out.println("What question could I use to guess this animal?");
                        questionResponse = sc.nextLine();

                        Node question = new Node(questionResponse, true);
                        tree.nodes.add(question);
                        tree.nodes.get(nodeId).setLeft(question);

                        nextNodeID = tree.nodes.indexOf(question);
                        Node animal = new Node(animalResponse, false);
                        tree.nodes.add(animal);
                        tree.nodes.get(nextNodeID).setLeft(animal);
                        nodeId = 0;

                        // Continue
                    } else {
                        nodeId = tree.nodes.indexOf(tree.nodes.get(nodeId).getLeft());
                    }
                }
            }

            // Prompt user to continue
            System.out.println("Would you like to continue? (Y/N)");
            response = sc.nextLine();
            if (response.equals("N")) {
                isDone = true;
            }

            // Un-comment to see nodes and their Right/ Left values
            // tree.test();
        }   // end main while() loop
    }   // end main()


}