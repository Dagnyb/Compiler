/*
 Implement the class Token, which contains both a lexeme and a token code:
 String lexeme; 
 TokenCode tCode;
 where TokenCode is:
 enum TokenCode { ID, ASSIGN, SEMICOL, INT, ADD, SUB, MULT, LPAREN, RPAREN, PRINT, END, ERROR }
 Note: See explanation for ERROR in 2
*/


public class Token {
	// ID = 0 / ASSIGN = 1 / SEMICOL = 2 / INT = 3 / ADD = 4 / SUB = 5 / MULT =6 / LPAREN = 7 / RPAREN = 8
	// PRINT = 9 / END = 10 / ERROR = 11 
	enum TokenCode { ID, ASSIGN, SEMICOL, INT, ADD, SUB,
		MULT, LPAREN, RPAREN, PRINT, END, ERROR }
	
	enum Caracter { LETTER, DIGIT}   //Veit ekkert hvað ég er að gera ;) 
	
	public String lexeme;
	public TokenCode tCode;

}
