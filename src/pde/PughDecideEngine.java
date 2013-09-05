package pde;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import static util.Printing.*;

public class PughDecideEngine {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		p("[[ Pugh Decide ]]"+pNL(1));
		
		p("What are you trying to decide?");
		String decision = reader.readLine();
		
		pnb(pNL(1)+"How many criteria does your decision depend on? ");
		int criteriaCount = Integer.parseInt(reader.readLine());

		Criterion[] criteriaSet = new Criterion[criteriaCount];

		for (int cn = 0; cn < criteriaCount; cn++){
			pnb(pNL(1)+"What is your "+pNumber(cn+1)+" Criteria? ");
			String critName = reader.readLine();

			pnb("  "+critName+"'s Weight (1-9): ");
			float critWeight = Float.parseFloat(reader.readLine());
			
			criteriaSet[cn] = new Criterion(critName,critWeight,0);
		}
		
		pnb(pNL(1)+"How many options do you have? ");
		int optionCount = Integer.parseInt(reader.readLine());
		
		ChoiceArray[] options = new ChoiceArray[optionCount];

		for (int o = 0; o < optionCount; o++){
			Criterion[] criteria = new Criterion[criteriaCount];
			
			pnb(pNL(1)+"What is your "+pNumber(o+1)+" Option? ");
			String optionName = reader.readLine();
			
			for (int c = 0; c < criteriaCount; c++){
				String name = criteriaSet[c].toString();
				double weight = criteriaSet[c].getWeight();
				
				pnb("  "+optionName+"'s "+name+" Value: ");
				int value = Integer.parseInt(reader.readLine());
				
				criteria[c] = new Criterion(name,weight,value);
			}
			
			options[o] = new ChoiceArray(optionName,criteria);
			options[o].score();
		}
		
		DecisionMatrix dm = new DecisionMatrix(decision,options);
		dm.score();
		
		p(pNL(1)+"For the question '"+dm+"', your best choice is "+dm.getWinner());
	}
}
