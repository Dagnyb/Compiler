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
    private ArrayList <String> intermediate;
    private Stack <Token> intermed; 
    
    
    
   /*public Parser(Lexer lexer){
    	
    	
    }*/
    
    public void parser(){
    	token = nextToken();
    	Statements();
    	
    }
    
    private Token nextToken() {
    	Token tempToken = new Token();
    	tempToken = lexer.nextToken();
    	
    	if(tempToken.tCode == Token.TokenCode.ERROR){
    		Error();
    	}
    	return tempToken;
	}

	
	private void Statements(){
		Statement();
		if(token.tCode == Token.TokenCode.SEMICOL){
			Token temp;
			/*while(!intermediate.isEmpty()){
				temp = intermediate.;
				intermed.add(GetCode(temp.tCode()))
			}*/
			token = nextToken();
		}
		else if(token.tCode == Token.TokenCode.END){
			
		}
		
	
		
		
	}
	
	private void Statement(){
		if(token.tCode == Token.TokenCode.ID){
			
			if(token.tCode == Token.TokenCode.ASSIGN){
				
				Expr();
			}
			
			else if(token.tCode == Token.TokenCode.PRINT){
				
				if(token.tCode == Token.TokenCode.ID){
					
				}
			}
		}
		/*else if(token.tCode == Token.TokenCode.INT){
			
		}
		else{
			Error();
		}*/
	}
	
	private void Expr(){
		Term();
		/*if(token.tCode == Token.TokenCode.ADD){
			while(??.peek().tCode == Token.TokenCode.MULT){
				intermediate.add(??.pop().tCode.toString());
			}
			
			??.push(token);
			Espr();
			token = nextToken();
		}
					
		else if(token.tCode == Token.TokenCode.SUB){
	            while (??.peek().tCode == Token.TokenCode.MULT){
	                intermediate.add(ops.pop().tCode.toString());
	            }
	            ??.push(token); 
	            token = nextToken();
	            Expr();
		}
				//Ekki viss hvort eitthvað ætti að vera hérna
		*/
		
	}
	
	private void Term(){
		Factor();
		/* if(token.tCode == Token.TokenCode.MULT){
		 * push
		 * token = nextToken();
		 * Term();
		 * }
		 */
		
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
	
	private String GetCode(Token.TokenCode tCode){
		if(tCode == Token.TokenCode.ADD){
			return "ADD";
		}
		else if(tCode == Token.TokenCode.SUB){
			return "SUB";
		}
		else{
			return tCode.toString();
		}
	}
}
