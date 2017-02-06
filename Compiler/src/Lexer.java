
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
	private String currentLex;
	
	public void nextToken(){
		
	}
	
	private void addChar(){
		
	}
	
	private void getChar(){
		
	}
	
	private Token.TokenCode lookup(String lexeme){    //Soða betur 
		
		Token.TokenCode returnValue = null;
		
		if(lexeme.equals("="))
		{
			returnValue = Token.TokenCode.ASSIGN;
		}
		else if(lexeme.equals(";"))
		{
			returnValue = Token.TokenCode.SEMICOL;
		}
		else if(lexeme.equals("+"))
		{
			returnValue = Token.TokenCode.ADD;
		}
		else if(lexeme.equals("-"))
		{
			returnValue = Token.TokenCode.SUB;
		}
		else if(lexeme.equals("*"))
		{
			returnValue = Token.TokenCode.MULT;
		}
		else if(lexeme.equals("("))
		{
			returnValue = Token.TokenCode.LPAREN;
		}
		else if(lexeme.equals(")"))
		{
			returnValue = Token.TokenCode.RPAREN;
		}
		else if(lexeme.equals("print"))
		{
			returnValue = Token.TokenCode.PRINT;
		}
		else if(lexeme.equals("end"))
		{
			returnValue = Token.TokenCode.END;
		}
		else if(Character.isDigit(lexeme.charAt(0)))     //Líklega þarf að laga
		{
			returnValue = Token.TokenCode.ID;
		}
		else if(Character.isLetter(lexeme.charAt(0)))   //Líklega þarf að laga
		{
			returnValue = Token.TokenCode.INT;
		}
		else
		{
			returnValue = Token.TokenCode.ERROR;
		}
		
		return returnValue;
	}
	
	 public static void main(String[] args) {
		 
	 }
}
