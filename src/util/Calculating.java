package util;
import java.util.*;
// import java.lang.Math;

public class Calculating {
	public static int randInt(int min, int max) {
		
		Random random = new Random();
		
		int output = random.nextInt(max - min + 1) + min; 
		
		return output;		
	}
	
	public static int r(int max) {
		
		Random random = new Random();
		
		int output = random.nextInt(max) + 1; 
		
		return output;		
	}
	
	public static int[] randArray(int size, int min, int max) {
		int[] output = new int[size];
		
		for (int i=0; i<size; i++){
			output[i] = randInt(min,max);
		}
		
		return output;
	}
	
	public static int maxArrayList(ArrayList<Integer> input) {
		int output = (input.size() != 0 ? Integer.MIN_VALUE : 0);
		Iterator<Integer> iter = input.iterator();
		
		while (iter.hasNext()){
			Integer thisInt = (Integer) iter.next();
			int thisNumb = thisInt.intValue();
			output = (thisNumb > output ? thisNumb : output);
		}
		
		return output;
	}
	
	public static int minArrayList(ArrayList<Integer> input) {
		int output = (input.size() != 0 ? Integer.MAX_VALUE : 0);
		Iterator<Integer> iter = input.iterator();
		
		while (iter.hasNext()){
			Integer thisInt = (Integer) iter.next();
			int thisNumb = thisInt.intValue();
			output = (thisNumb < output ? thisNumb : output);
		}
		
		return output;
	}
	
	public static int sumArrayList(ArrayList<Integer> input) {
		int output = 0;
		Iterator<Integer> iter = input.iterator();
		
		while (iter.hasNext()){
			Integer thisInt = (Integer) iter.next();
			int thisNumb = thisInt.intValue();
			output += thisNumb;
		}
		
		return output;
	}
	
	public static float avgArrayList(ArrayList<Integer> input) {
		float output = 0;
		Iterator<Integer> iter = input.iterator();
		
		while (iter.hasNext()){
			Integer thisInt = (Integer) iter.next();
			float thisNumb = thisInt.intValue();
			output += thisNumb;
		}
		
		output = output / input.size();
		
		return output;
	}
}
