package pde;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import static util.Printing.*;

public class PughDecideEngine {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("[[ Pugh Decide ]]");
		System.out.println();
		
		System.out.println("What are you trying to decide?");
		String decision = reader.readLine();
		System.out.println();
		
		System.out.print("How many criteria does your decision depend on? ");
		int criteriaCount = Integer.parseInt(reader.readLine());
		System.out.println();
		Criterion[] criteriaSet = new Criterion[criteriaCount];
		for (int cn = 0; cn < criteriaCount; cn++){
			System.out.print("What is your "+pNumber(cn+1)+" Criteria? ");
			String critName = reader.readLine();

			System.out.print("Weight (1-9): ");
			float critWeight = Float.parseFloat(reader.readLine());
			System.out.println();
			
			criteriaSet[cn] = new Criterion(critName,critWeight,0);
		}
		
		System.out.print("How many options do you have? ");
		int optionCount = Integer.parseInt(reader.readLine());
		System.out.println();
		ChoiceArray[] options = new ChoiceArray[optionCount];
		
		for (int o = 0; o < optionCount; o++){
			Criterion[] criteria = new Criterion[criteriaCount];
			
			System.out.print("Option Name: ");
			String optionName = reader.readLine();
			System.out.println();
			
			for (int c = 0; c < criteriaCount; c++){
				String name = criteriaSet[c].toString();
				double weight = criteriaSet[c].getWeight();
				
				System.out.print("What is "+optionName+"'s "+name+" Value? ");
				int value = Integer.parseInt(reader.readLine());
				
				criteria[c] = new Criterion(name,weight,value);
			}
			
			options[o] = new ChoiceArray(optionName,criteria);
			options[o].score();
			System.out.println();
		}
		
		DecisionMatrix dm = new DecisionMatrix(decision,options);
		dm.score();
		
		System.out.println("For the question '"+dm+"', your best choice is "+dm.getWinner());
	}
}
