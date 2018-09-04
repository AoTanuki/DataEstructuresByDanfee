package stackExercise;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import danfeeLinearDataEstructures.DanfeeStack;
import danfeeLinearDataEstructures.List;

public class BalancedString {

	public static void main (String[] args) throws Exception
	{
		System.out.println(System.getProperty("java.classpath"));
		BufferedReader bf = new BufferedReader(new FileReader(new File("./src/stackExercise/testCases.txt")));
		
		int cases = Integer.parseInt( bf.readLine() );
		
		int actualCase = 1;
		
		
		
		long initialTime = System.currentTimeMillis();
		while(actualCase++ <= cases)
		{
			DanfeeStack<String> stack = new List<String>();
			String message = bf.readLine();
			String balanced = "T";
			
			for (int i = 0; i < message.length() && balanced.equals("T"); i++) {
				char val = message.charAt(i);
				
				//If val is an open bracket is added to stack
				if(val=='{' ||val =='['|| val =='(' || val=='<')
				{
					stack.push(val+"");
				}
				
				//if val is a close bracket is evaluated
				if(val=='}'||val==']'||val==')'||val=='>' )
				{
					
					if(stack.isEmpty())
					{
//						balanced = "F";
					}else
					{
						char bracketPoped = stack.pop().charAt(0);
						switch (val) {
						
						case '}':
							if(bracketPoped != '{') balanced="F";
							break;

						case ']':
							if(bracketPoped != '[') balanced="F";
							break;
							
						case ')':
							if(bracketPoped != '(') balanced="F";
							break;
							
						case '>':
				
							if(bracketPoped != '<') balanced="F";
							break;
						}
					}
				}
				
			}
			
			if(balanced.equals("T") && !stack.isEmpty())
			{
				balanced = "F";
			}	
			
			System.out.println(balanced);
		}
		
	}

}
