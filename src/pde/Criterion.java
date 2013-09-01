package pde;

public class Criterion {
	private String name;
	private float weight;
	private int score;
	
	// Constructor
	public Criterion (String name,float weight,int score){
		this.name = name;
		this.weight = weight;
		this.score = score;
		
		if (weight < 0){
			this.weight = 0;
		}
		if (weight > 1){
			this.weight = 1;
		}
		if (score < -2){
			this.score = -2;
		}
		if (score > 2){
			this.score = 2;
		}
	}
	
	// Edit Info
	public void editName(String name){
		this.name = name;
	}
	public void editWeight(float weight){
		this.weight = weight;
		
		if (weight < 0){
			this.weight = 0;
		}
		if (weight > 1){
			this.weight = 1;
		}
	}
	public void editScore(int score){
		this.score = score;
		
		if (score < -2){
			this.score = -2;
		}
		if (score > 2){
			this.score = 2;
		}
	}
	
	// Get Info
	public String toString(){
		return this.name;
	}
	public float getWeight(){
		return this.weight;
	}
	public int getScore(){
		return this.score;
	}

}
