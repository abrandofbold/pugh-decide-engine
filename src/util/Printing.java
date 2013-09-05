package util;
import java.io.PrintStream;

public class Printing {
	public static String pNL(int count) {
		String newLine = "";
		for(int i = 0; i < count; i++){
		newLine += System.getProperty("line.separator");
		}
		return newLine;
	}
	
	public static void printArray(int[] array){
		String arrayOutput = "";
		
		for (int i = 0; i < array.length; i++) {
			arrayOutput = arrayOutput + "[" + array[i] + "] ";
		}
		
		System.out.println(arrayOutput);
		
		return;
	}
	
	public static String reverse(String input, String output) {
        return (input.isEmpty()) ? output :
            (input.charAt(0) == ' ')
            ? output + ' ' + reverse(input.substring(1), "")
            : reverse(input.substring(1), input.charAt(0) + output);
    }
	
	public static String pCash(float value){
		return "$" + value + "0";
	}
	
	public static String pBrackets(String input){
		return "[" + input + "]";
	}
	
	public static void p(Object obj) {
	    System.out.println(obj);
	}

	public static void p() {
		System.out.println();
	}

	public static void pnb(Object obj) {
		System.out.print(obj);
	}
	
	public static PrintStream
		printf(String format, Object... args) {
	    return System.out.printf(format, args);
	}
	
	public static String pNumber(int i){
		String s = ((i % 100 >=10 && i % 100 < 20) || i % 10 >= 4 || i % 10 == 0) ? "th" : (i % 10 == 3) ? "rd" : (i % 10 == 2) ? "nd" : "st";
		
		return i + s;
	}
}
