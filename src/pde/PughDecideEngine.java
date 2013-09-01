package pde;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PughDecideEngine {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		/**
		Criterion crit1 =  new Criterion("Speed",.491,2);
		Criterion crit2 =  new Criterion("Agility",.403,1);
		Criterion crit3 =  new Criterion("Cost",.106,-2);
		
		ChoiceArray bmw = new ChoiceArray("BMW",new Criterion[] {crit1,crit2,crit3});
		bmw.score();
		
		System.out.println(bmw.toString());
		**/
		
		System.out.println("[[ Pugh Decide ]]");
		System.out.println();
		
		System.out.println("What are you trying to decide?");
		String decision = reader.readLine();
		System.out.println();
		
		System.out.println("How many option do you have?");
		int optionCount = Integer.parseInt(reader.readLine());
		System.out.println();
		
		System.out.println("How many crtieria does your decision depend on?");
		int criteriaCount = Integer.parseInt(reader.readLine());
		System.out.println();
		
		ChoiceArray[] options = new ChoiceArray[optionCount];
		System.out.println("opt len: "+options.length);
		
		for (int o = 0; o < optionCount; o++){
			Criterion[] criteria = new Criterion[criteriaCount];
			
			System.out.print("Option Name: ");
			String optionName = reader.readLine();
			System.out.println();
			
			for (int c = 0; c < criteriaCount; c++){
				Criterion[] criteriaSet = new Criterion[criteriaCount];
				if (c == 0){
					for (int cn = 0; cn < criteriaCount; cn++){
						System.out.print("Criterion Name: ");
						String critName = reader.readLine();

						System.out.print("Weight: ");
						float critWeight = Float.parseFloat(reader.readLine());
						System.out.println();
						
						criteriaSet[cn] = new Criterion(critName,critWeight,0);
					}
				}
				String name = criteriaSet[c].toString();
				double weight = criteriaSet[c].getWeight();
				
				System.out.print(optionName+", "+name+" (" +weight+") "+"Value: ");
				int value = Integer.parseInt(reader.readLine());
				System.out.println("c: "+c);
				
				criteria[c] = new Criterion(name,weight,value);
			}
			
			options[o] = new ChoiceArray(optionName,criteria);
			options[o].score();
			
			System.out.println(options[o].toString());
		}
		
		DecisionMatrix dec = new DecisionMatrix(decision,options);
		dec.score();
		
		System.out.println(dec.getWinner());
	}

}
