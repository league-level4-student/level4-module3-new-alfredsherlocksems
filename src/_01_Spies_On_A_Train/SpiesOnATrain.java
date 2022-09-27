package _01_Spies_On_A_Train;

import java.util.ArrayList;
import java.util.HashMap;

import _00_Intro_to_Linked_Lists.LinkedList;
import _00_Intro_to_Linked_Lists.Node;

public class SpiesOnATrain {

    /*
     * A spy has made off with important intel from your intelligence agency!
     * You know the spy is somewhere on this train(LinkedList). Your job is to
     * find the suspect that matches the description given to you by the list of
     * clues(the array).
     * 
     * Walk through the train, questioning each of the passengers about what
     * they have seen and return the name of the most likely suspect.
     * 
     * The results are randomly generated each time so you should have a general
     * case solution that carefully compares the clues to each passenger's
     * testimony. Remember to use String methods to break up the passengers'
     * statements.
     */
    String findIntel(LinkedList<TrainCar> train, String[] clues) {

        train.print();
    	for (int i = 0; i < clues.length; i++) {
    		  System.out.println(clues[i]); 
    	}
    	Node<TrainCar> next = train.getHead();
    	TrainCar car;
    	ArrayList<Suspects> sus = new ArrayList<Suspects>();
    	while (next != null) {
    	      car = next.getValue();
    	      String name = car.toString();
    	      sus.add(new Suspects(name));
    	      next = next.getNext();
    	      System.out.println(name);
    	}
    	next = train.getHead();
        while (next != null) {

            car = next.getValue();
            String quote = car.questionPassenger();
            
           
            int temp = 0;
            temp = quote.indexOf("I saw ");
            temp += 6;
           
            String evidence = quote.substring(temp);
            String[] nameSeperation = evidence.split(" ");
            String suspect = nameSeperation[0]; // find code to make it equal to suspect
            StringBuilder b = new StringBuilder(evidence);
            b.replace(b.length() - 1, b.length(), "");
            b.replace(0, suspect.length() + 1, "");
            evidence = b.toString();
            System.out.println(evidence);
            System.out.println(suspect);
       
            
            for (int i = 0; i < clues.length; i++)
            if (evidence.equals(clues[i])) {
            	for (int j = 0; j < sus.size(); j++) {
            		if (sus.get(j).getName().equals(suspect)) {
            			sus.get(j).addMention();
            		}
            	}
            	
            }
            next = next.getNext();
            
        }
        int highestMentionIndex = 0;
        for (int i = 0; i < sus.size(); i++) {
        	System.out.println(sus.get(i).getMentions());
        	if (sus.get(i).getMentions() > sus.get(highestMentionIndex).getMentions()) {
        		highestMentionIndex = i;
        	}
        }

        System.out.println();
        System.out.println("The suspect is " + sus.get(highestMentionIndex).getName());
    	return sus.get(highestMentionIndex).getName();

    }

}
