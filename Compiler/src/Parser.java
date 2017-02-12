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
    private Stack <String> intermediate;
    private Stack <Token> intermed; 
    
    
    
   public Parser(Lexer lexer){
    	intermed = new Stack<Token>();
    	lexer = lexer;
    	
    }
    
    public void parser(){
    	token = nextToken();
    	Statements();
    	
    }
    
    private Token nextToken() {
    	Token nextT = new Token();
    	nextT = lexer.nextToken();
    	
    	if(nextT.tCode == Token.TokenCode.ERROR){
    		Error();
    	}
    	return nextT;
	}

	
	private void Statements(){
		Statement();
		if(token.tCode == Token.TokenCode.SEMICOL){
			Token temp;
			while(!intermed.isEmpty()){
				temp = intermed.pop();
				intermediate.add(temp.tCode.toString());
			}
			token = nextToken();
		}
		else if(token.tCode == Token.TokenCode.END){
			
		}		
		
	}
	
	private void Statement(){
		if(token.tCode == Token.TokenCode.ID){
			intermediate.add("PUSH " + token.lexeme);
			token = nextToken();
			if(token.tCode == Token.TokenCode.ASSIGN){
				intermed.push(token);
				token = nextToken();
				Expr();
			}
			
			else if(token.tCode == Token.TokenCode.PRINT){
				intermed.push(token);
				token = nextToken();
				if(token.tCode == Token.TokenCode.ID){
					intermediate.add("PUSH " + token.lexeme);
					token = nextToken();
				}
			}
		}		
	}
	
	private void Expr(){
		Term();
		if(token.tCode == Token.TokenCode.ADD){
			while(intermed.peek().tCode == Token.TokenCode.MULT){
				intermediate.add(intermed.pop().tCode.toString());
			}
			
			intermed.push(token);
			token = nextToken();
			Expr();
			
		}
					
		else if(token.tCode == Token.TokenCode.SUB){
	            while (intermed.peek().tCode == Token.TokenCode.MULT){
	                intermediate.add(intermed.pop().tCode.toString());
	            }
	            intermed.push(token); 
	            token = nextToken();
	            Expr();
		}
	}
	
	private void Term(){
		Factor();	
	}
	
	private void Factor(){
		if(token.tCode == Token.TokenCode.INT){
			
		}
		else if(token.tCode == Token.TokenCode.ID){
			
		}
		else if(token.tCode == Token.TokenCode.LPAREN){
			
			if(token.tCode == Token.TokenCode.RPAREN){
				
			}
		}
		
	}
	
	private void Error(){
    	
    	System.out.println("Syntax error!");    // Error massage
        System.exit(0);							// And then immediately quit
    }
	
}
