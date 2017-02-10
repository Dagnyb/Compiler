import java.util.*;

/*
 *  Implement the class Parser, the syntax analyzer (parser). 
 *  This should be a top-down recursive descent parser for the grammar G above. 
 *  The output of the parser is the stack-based intermediate code S, corresponding to the given program, 
 *  written to standard output (stdout). 
 *  If the expression is not in the language (or if an ERROR token is returned by the Lexer) 
 *  then the parser should output the error message “Syntax error!” 
 *  (at the point when the error is recognized) and immediately quit.
 *	
 *	The parser should have at least two (private) member variables, one of type Lexer, 
 *	the other of type Token (for the current token). 
 *	It should only have a single public method, parse(), 
 *	for initiating the parse – other methods are private.
 */
public class Parser {
	private Lexer lexer;
    private Token token;
    private Stack<Token> lookahead;
    
    public Parser(Lexer lexer){
    	
    	
    }
    
    public void parser(){
    	token = nextToken();
    	
    }
    
    private Token nextToken() {
		// TODO Auto-generated method stub
		return null;
	}

	private void Error(){
    	
    	System.out.println("Syntax error!");    // Error massage
        System.exit(0);							// And then immediately quit
    }
	
	private void stat(){
		
		
	}
	
	private void  Term(){
		if(Character.isDigit((char)lookahead)){
			
		}
		else{
			Error();
		}
	}
	
	private void Expr(){
		Term();
		rest();
		
	}

	private void rest() {
		// TODO Auto-generated method stub
		if(token.tCode == Token.TokenCode.ADD){
			if(!lookahead.isEmpty()){
				if(lookahead.peek().tCode == Token.TokenCode.MULT){
					
				}
			}
		}
		
		else if(token.tCode == Token.TokenCode.SUB){
			
		}
		//Ekki viss hvort eitthvað ætti að vera hérna
	}
	
	
}
