package pde;

public class Criterion {
	private String name;
	private double weight;
	private int value;
	
	// Constructor
	public Criterion (String name,double weight,int value){
		this.name = name;
		this.weight = weight;
		this.value = value;
		
		if (weight < 0){
			this.weight = 0;
		}
		if (weight > 1){
			this.weight = 1;
		}
		if (value < -2){
			this.value = -2;
		}
		if (value > 2){
			this.value = 2;
		}
	}
	
	// Edit Info
	public void editName(String name){
		this.name = name;
	}
	public void editWeight(double weight){
		this.weight = weight;
		
		if (weight < 0){
			this.weight = 0;
		}
		if (weight > 1){
			this.weight = 1;
		}
	}
	public void editValue(int value){
		this.value = value;
		
		if (value < -2){
			this.value = -2;
		}
		if (value > 2){
			this.value = 2;
		}
	}
	
	// Get Info
	public String toString(){
		return this.name;
	}
	public double getWeight(){
		return this.weight;
	}
	public int getValue(){
		return this.value;
	}
	public double getScore(){
		return this.weight * this.value;
	}

}
