/*
 *  Implement the class Lexer, a lexical analyzer. 
 *  It should contain a public method, nextToken(), which scans the standard input (stdin), 
 *  looking for patterns that match one of the tokens from 1). 
 *  Note that the lexemes corresponding to 
 *  the tokens ADD, SUB, MULT, LPAREN, RPAREN, ASSIGN, SEMICOL contain only a single letter. 
 *  The patterns for the lexemes for the other tokens are:
 *  
	INT = [0-9]+ 
	ID = [A-Za-z]+ 
	END = end 
	PRINT = print
	
	The lexical analyzer returns a token with TokenCode = ERROR if some illegal lexeme is found.
 */


public class Lexer {
	private char nextChar;
	//private String currentLex;
	  StringBuilder sb = new StringBuilder(100);
	  int charIndex = 0;
	  
	
	public void nextToken(){
		
	}
	
	private void addChar(){
		//currentLex = currentLex + nextChar;
		sb.append(nextChar).toString();
	}
	
	private void getChar(){
		nextChar = sb.charAt(charIndex);
		charIndex++;
	}
	
	private Token lookup(String lexeme){
		
		Token returnValue = null;
		
		return returnValue;
	}
	
	 public static void main(String[] args) {
		 
	 }
}
