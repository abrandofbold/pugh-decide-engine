package pde;

public class ChoiceArray {
	private String name;
	private Criterion[] criteria;
	private float score;
	private int rank;
	
	// Constructor
	public ChoiceArray(String name,Criterion[] criteria){
		this.name = name;
		this.criteria = criteria;
		this.score = 0;
		this.rank = 0;
	}
	
	// Edit Info
	public void editName(String name){
		this.name = name;
	}
	public void editCritria(Criterion[] criteria){
		this.criteria = criteria;
	}
	public void editRank(int rank){
		this.rank = rank;
	}
	
	// Actions
	public void score(){
		int size = this.criteria.length;
		float score = 0;
		
		for (int i = 0; i < size; i++){
			score += criteria[i].getWeight() * criteria[i].getScore();
		}
		
		this.score = score;
	}
	
	// Get Info
	public String toString(){
		return this.name;
	}
	public Criterion[] getCriteria(){
		return this.criteria;
	}
	public float getScore(){
		return this.score;
	}
	public int getRank(){
		return this.rank;
	}
}
