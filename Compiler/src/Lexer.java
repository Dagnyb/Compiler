import java.io.*;
//import java.util.List;
//import java.util.ArrayList;
//import java.lang.Object;
//import org.apache.commons.lang3.StringUtils;

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
    private BufferedReader reader;
    private String currentLex = "";
   // private Token token;
  //  private Token.Character character;

          
      public Lexer(){
    	  System.out.println("Smidur");
        Reader isReader = new InputStreamReader(System.in);     // Til að lesa inn Streng frá input
        reader = new BufferedReader(isReader);                  // Bufferar char fyrir char
        getChar();  
      }
      
    
    public Token nextToken(){
        System.out.println("Hello nextToken() ");
        Token next = new Token();
        
        if(Character.isLetter(nextChar)){
        	while(Character.isLetter(nextChar)){
    			addChar(nextChar);
    			getChar();
        	}
        }
        else if(Character.isDigit(nextChar)){		// Sé ekki hvernig við getum skilað Token, þarf að skoða
    		while(Character.isDigit(nextChar)){
    			addChar(nextChar);
    			getChar();
    			System.out.println("eg er her");
    		}
        }
        else{
        	addChar(nextChar);
        	getChar();
        }
        System.out.println("og her");
        
        if(currentLex != ""){
        	next.tCode = lookup(currentLex);
        	next.lexeme = currentLex;
        }
        
        if(currentLex == ""){
        	return null;
        }
        
        return next;
    }
    
    private void addChar(char c){
    	System.out.println("addChar ");
        currentLex = currentLex + c;
        //lookup(currentLex);
    }
    
    private void getChar(){
    	System.out.println("getChar");
        int c;
        try {
            if((c = reader.read()) != -1){
                //nextChar = (char) reader.read();
            	nextChar = (char) c;
            	if(nextChar == ' '){
            		getChar();
            	}
                //addChar(nextChar);
            }
           /* else{
            	character = Token.Character.EOF;
            	return;
            }*/
        } catch (IOException e) {
        	System.out.println("xxxxxxx");
            e.printStackTrace();
        }
    }
        private Token.TokenCode lookup(String lexeme){    //Skoða betur 
        
            if(Character.isWhitespace(lexeme.charAt(0)))    //eat up whitespace
            {
                currentLex = "";
                getChar();
            }
            else if(lexeme.equals("="))
            {
                return Token.TokenCode.ASSIGN;
               // currentLex = "";
            }
            else if(lexeme.equals(";"))
            {
            	return Token.TokenCode.SEMICOL;
                //currentLex = "";
            }
            else if(lexeme.equals("+"))
            {
            	return Token.TokenCode.ADD;
                //currentLex = "";
            }
            else if(lexeme.equals("-"))
            {
            	return Token.TokenCode.SUB;
               // currentLex = "";
            }
            else if(lexeme.equals("*"))
            {
            	return Token.TokenCode.MULT;
                //currentLex = "";
            }
            else if(lexeme.equals("("))
            {
            	return Token.TokenCode.LPAREN;
               // currentLex = "";
            }
            else if(lexeme.equals(")"))
            {
            	return Token.TokenCode.RPAREN;
               // currentLex = "";
            }
            else if(lexeme.equals("print"))                 // Ath t.d. printTwice = ID
            {
            	return Token.TokenCode.PRINT;
                //currentLex = "";
            }
            else if(lexeme.equals("end"))                   //Ath t.d. endFor = ID
            {
            	return Token.TokenCode.END;
               /* currentLex = "";
                try {
                    reader.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }*/
            }
            else if(Character.isDigit(lexeme.charAt(0))){
            	return Token.TokenCode.INT;
            }
            else if(Character.isLetter(lexeme.charAt(0))){
            	return Token.TokenCode.ID;
            }
            else{
            	return Token.TokenCode.ERROR;
            }
            return Token.TokenCode.ERROR;
            }
        
   /*
        if (Character.isDigit(nextChar)) {
        	character = Token.Character.DIGIT;
        }
        else if (Character.isLetter(nextChar)) {
        	character = Token.Character.LETTER;
        }
        else {
        	character = Token.Character.WHITESPACE;
        }
     */ 
     
    
 /*   
    public static String getidentifier(String s, int i) {
        String ident = "";
        int j = i;
        boolean key = false;
        for( ; j < s.length(); ) {
            if(Character.isLetter(s.charAt(j))) {
                j++;
            } else {
                ident = s.substring(i, j);
                //key = isKeyword(ident);
            }
        }
        if(!key)return s.substring(i, j);
        else if(ident == "print"){
            System.out.println("Nú myndi koma print skipun");
        }
        
        return "";  // Vantar fix
        return ident;
    }
    
private static boolean isKeyword(String id){
        
        switch(id){
        case "end":
        case "print":
            return true; // TODO setja inn virkni keyworda...
        default:
            return false;
        }
    
    
   public static List<Token> lookup(String input) {
       List<Token> result = new ArrayList<Token>();
       for(int i = 0; i < input.length(); ) {
            switch(input.charAt(i)) {
            case '=':
                result.add(new Token("=", Token.TokenCode.ASSIGN));
                i++;
                break;
            case '+':
                result.add(new Token( "+", Token.TokenCode.ADD));
                i++;
                break;
            case '-':
                result.add(new Token("-", Token.TokenCode.SUB));
                i++;
                break;
            case '*':
                result.add(new Token("*", Token.TokenCode.MULT));
                i++;
                break;
            case '(':
                result.add(new Token("(", Token.TokenCode.LPAREN));
                i++;
                break;
            case ')':
                result.add(new Token(")", Token.TokenCode.RPAREN));
                i++;
                break;
            default:
                if(Character.isWhitespace(input.charAt(i)) || input.charAt(i) == '\n' || input.charAt(i) == '\t') {
                    i++;
                } else {
                    String identifier = getidentifier(input, i);
                    //identifier += identifier.length();
                    result.add(new Token(identifier, Token.TokenCode.ID));
                }
                break;
            }
        }
       
        System.out.println("result.get(0).tCode: " + result.get(result.size() - 1).tCode);
        System.out.println("result.get(0).lexeme: " + result.get(result.size() - 1).lexeme);
        System.out.println("result.size(): " + result.size());
        
        return result;
    }
    */
 
     public static void main(String[] args) {
    	 Lexer lex = new Lexer();
         Token suchToken = lex.nextToken();
         System.out.println("Lex: " + suchToken.lexeme + ", TokenCode: " + suchToken.tCode.toString());

         for (int i = 0; i < 17; i++) {
             suchToken = lex.nextToken();
             System.out.println("Lex: " + suchToken.lexeme + ", TokenCode: " + suchToken.tCode.toString());
         }
     }
}
