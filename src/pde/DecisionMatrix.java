package pde;

public class DecisionMatrix {
	private String name;
	private ChoiceArray[] options;
	private ChoiceArray winner;

	// Constructor
	public DecisionMatrix(String name, ChoiceArray[] options){
		this.name = name;
		this.options = options;
		this.winner = null;
	}
	
	// Edit Info
	public void editName(String name){
		this.name = name;
	}
	public void editOptions(ChoiceArray[] options){
		this.options = options;
	}
	
	// Actions
	public void score(){
		int size = this.options.length;
		float maxScore = 0;
		ChoiceArray winner = null;
		
		for (int i=0; i < size; i++){
			this.options[i].score();
			float currentScore = this.options[i].getScore();
			
			if (currentScore > maxScore){
				maxScore = currentScore;
				winner = this.options[i];
			}
		}
		
		this.winner = winner;
	}
	
	// Get Info
	public String toString(){
		return this.name;
	}
	public ChoiceArray getWinner(){
		return this.winner;
	}
}
