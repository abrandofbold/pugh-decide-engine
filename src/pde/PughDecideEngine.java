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
		
		for (int o = 0; o < optionCount; o++){
			for (int c = 0; c < criteriaCount; c++){
				
			}
		}
		
		
	}

}
