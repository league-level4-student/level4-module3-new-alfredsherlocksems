package _01_Spies_On_A_Train;

public class Suspects {
	
	String name;
	int mentions = 0;
	
	public Suspects(String name) {
		this.name = name;
	}

	void addMention() {
		mentions++;
	}
	int getMentions() {
		return mentions;
	}
	String getName() {
		return name;
	}
}
