package _02_Rainbow_Zombie_Conga_Line;

import _00_Intro_to_Linked_Lists.LinkedList;
import _00_Intro_to_Linked_Lists.Node;

public class RainbowZombieCongaLine {
    
    /*
     * You are hosting a rainbow zombie conga dance party! Zombies are not very
     * smart(maybe that's why they crave brains) and need your help to direct
     * them through the choreography.
     * 
     * Each method is a dance move you will need to implement.
     * 
     * When you think you've gotten your zombies trained well enough you can
     * start the party by running the main method in RainbowZombieDanceParty and
     * typing how many rounds you want in the console to see if they followed
     * your choreography correctly.
     * 
     * Note: The party will always start with a rainbow brains and every 5
     * rounds the head and tail of the dance line will be removed.
     */

    private LinkedList<Zombie> congaLine;
    private ZombieHatColor[] zombieHats;

    public RainbowZombieCongaLine() {

        congaLine = new LinkedList<Zombie>();
        zombieHats = ZombieHatColor.values();
        

    }

    // Make the passed in zombie the first Zombie in the conga line!
    public void engine(Zombie dancer) {
    	Node<Zombie> node = new Node<Zombie>(dancer);
    	congaLine.setHead(node);
    }

    // Make the passed in zombie the last Zombie in the conga line!
    public void caboose(Zombie dancer) {
    	Node<Zombie> node = new Node<Zombie>(dancer);
    	congaLine.setTail(node);
    }

    // Place the zombie at the designated position in the conga line!
    public void jumpInTheLine(Zombie dancer, int position) {
    	Node<Zombie> node = new Node<Zombie>(dancer);
    	//still need to do this
    }

    /*
     * Remove all zombies with the same hat color as the passed in zombie from
     * the conga line!
     */
    public void everyoneOut(Zombie dancer) {
    	Node<Zombie> next = congaLine.getHead().getNext();
    	Node<Zombie> prev = congaLine.getHead();
    	while (next != null) {
    		Zombie z = next.getValue();
    		if (z.getZombieHatColor() == dancer.getZombieHatColor())  { //may need to be .equals not sure
    			next = next.getNext();
    			prev.setNext(next);
    			next.setPrev(prev);
    		}
    		prev = prev.getNext();
    		next = next.getNext();
    		
    	}
    }

    /*
     * Remove the first zombie with the same hat color as the passed in zombie
     * from the conga line!
     */
    public void youAreDone(Zombie dancer) {
    	Node<Zombie> next = congaLine.getHead();
    	Node<Zombie> prev = congaLine.getHead();
    	while (next != null) {
    		Zombie z = next.getValue();
    		if (z.getZombieHatColor() == dancer.getZombieHatColor())  { //may need to be .equals not sure
    			next = next.getNext();
    			prev.setNext(next);
    			next.setPrev(prev);
    			break;
    		}
    		next = next.getNext();
    		prev = prev.getNext();
    	}
    }

    /*
     * Make two more zombies with the same hat color as the passed in zombie and
     * add one to the front, one to the end and one in the middle.
     */
    public void brains(Zombie dancer) {
    	Node<Zombie> next = congaLine.getHead();
    	Node<Zombie> prev = congaLine.getHead();
    	
    	Zombie a = new Zombie(dancer.getZombieHatColor());
    	Zombie b = new Zombie(dancer.getZombieHatColor());
    	Node<Zombie> node = new Node<Zombie>(b);
    	Node<Zombie> front = new Node<Zombie>(a);
    	
    	double middle = congaLine.size() / 2;
    	int compare = congaLine.size() / 2;
    	double convert = compare;
    	if (middle != convert) {
    		middle = convert--;
    	}
    	for (int i = 0; i < middle - 1; i++) {
    		prev = prev.getNext();
    		next = next.getNext();
    		if(i == middle - 2) {
    			next = next.getNext();
    			node.setNext(next);
    			node.setPrev(prev);
    			prev.setNext(node);
    			next.setPrev(node);
    		}
    	}
    	next = congaLine.getHead();
    	prev = congaLine.getHead();
    	next = next.getNext();
    	next.setPrev(prev);
    	prev.setNext(next);
    	congaLine.setHead(front);
    	front.setNext(prev);
    	
    	congaLine.add(dancer);
    }

    /*
     * Add the passed in zombie to the front and then add one zombie of each hat
     * color to the end of the line.
     */
    public void rainbowBrains(Zombie dancer) {
  
    	Node<Zombie> front = new Node<Zombie>(dancer);

    
    	congaLine.setHead(front);
    	congaLine.print();
    	ZombieHatColor[] hatColors = ZombieHatColor.values();
    	
    
    	for (int i = 0; i < hatColors.length; i++) {
    		congaLine.add(new Zombie(hatColors[i]));
    	}
    }

    public LinkedList<Zombie> getCongaLine() {
        return congaLine;
    }
}
