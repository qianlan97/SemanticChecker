// Author:
// Nan Chen & Xinyu Li

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Copyright (C) 2000 Gerwin Klein <lsf@jflex.de>                          *
 * All rights reserved.                                                    *
 *                                                                         *
 * Thanks to Larry Bell and Bob Jamison for suggestions and comments.      *
 *                                                                         *
 * License: BSD                                                            *
 *                                                                         *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

%%

%class Lexer
%byaccj

%{

  public Parser   parser;
  public int      lineno;
  public int      column;

  public Lexer(java.io.Reader r, Parser parser) {
    this(r);
    this.parser = parser;
    this.lineno = 1;
    this.column = 1;
  }

%}

int         = [0-9]+
identifier  = [a-zA-Z_][a-zA-Z0-9_]*
newline     = \n
whitespace  = [ \t\r]+
comment     = "//".*
blkcomment1 = "<!--"[^]*"-->"
blkcomment2 = "["[^]*"]"

%%

"func"                              { parser.yylval = new ParserVal(new Token(yytext())); return Parser.FUNC          ; }
"return"                            { parser.yylval = new ParserVal(new Token(yytext())); return Parser.RETURN        ; }
"var"                               { parser.yylval = new ParserVal(new Token(yytext())); return Parser.VAR           ; }
"if"                                { parser.yylval = new ParserVal(new Token(yytext())); return Parser.IF            ; }
"then"                              { parser.yylval = new ParserVal(new Token(yytext())); return Parser.THEN          ; }
"else"                              { parser.yylval = new ParserVal(new Token(yytext())); return Parser.ELSE          ; }
"begin"                             { parser.yylval = new ParserVal(new Token(yytext())); return Parser.BEGIN         ; }
"end"                               { parser.yylval = new ParserVal(new Token(yytext())); return Parser.END           ; }
"while"                             { parser.yylval = new ParserVal(new Token(yytext())); return Parser.WHILE         ; }
"("                                 { parser.yylval = new ParserVal(new Token(yytext())); return Parser.LPAREN        ; }
")"                                 { parser.yylval = new ParserVal(new Token(yytext())); return Parser.RPAREN        ; }
"int"                               { parser.yylval = new ParserVal(new Token(yytext())); return Parser.INT           ; }
"bool"                              { parser.yylval = new ParserVal(new Token(yytext())); return Parser.BOOL          ; }
"print"                             { parser.yylval = new ParserVal(new Token(yytext())); return Parser.PRINT         ; }
"<-"                                { parser.yylval = new ParserVal(new Token(yytext())); return Parser.ASSIGN        ; }
"->"                                { parser.yylval = new ParserVal(new Token(yytext())); return Parser.FUNCRET       ; }
"::"                                { parser.yylval = new ParserVal(new Token(yytext())); return Parser.TYPEOF        ; }
"+"                                 { parser.yylval = new ParserVal(new Token(yytext())); return Parser.ADD           ; }
"-"                                 { parser.yylval = new ParserVal(new Token(yytext())); return Parser.SUB           ; }
"*"                                 { parser.yylval = new ParserVal(new Token(yytext())); return Parser.MUL           ; }
"/"                                 { parser.yylval = new ParserVal(new Token(yytext())); return Parser.DIV           ; }
"%"                                 { parser.yylval = new ParserVal(new Token(yytext())); return Parser.MOD           ; }
"and"                               { parser.yylval = new ParserVal(new Token(yytext())); return Parser.AND           ; }
"or"                                { parser.yylval = new ParserVal(new Token(yytext())); return Parser.OR            ; }
"not"                               { parser.yylval = new ParserVal(new Token(yytext())); return Parser.NOT           ; }
"<"                                 { parser.yylval = new ParserVal(new Token(yytext())); return Parser.LT            ; }
">"                                 { parser.yylval = new ParserVal(new Token(yytext())); return Parser.GT            ; }
"<="                                { parser.yylval = new ParserVal(new Token(yytext())); return Parser.LE            ; }
">="                                { parser.yylval = new ParserVal(new Token(yytext())); return Parser.GE            ; }
"="                                 { parser.yylval = new ParserVal(new Token(yytext())); return Parser.EQ            ; }
"!="                                { parser.yylval = new ParserVal(new Token(yytext())); return Parser.NE            ; }
";"                                 { parser.yylval = new ParserVal(new Token(yytext())); return Parser.SEMI          ; }
","                                 { parser.yylval = new ParserVal(new Token(yytext())); return Parser.COMMA         ; }
"true"|"false"                      { parser.yylval = new ParserVal(new Token(yytext())); return Parser.BOOL_LIT      ; }
{int}                               { parser.yylval = new ParserVal(new Token(yytext())); return Parser.INT_LIT       ; }
{identifier}                        { parser.yylval = new ParserVal(new Token(yytext())); return Parser.IDENT         ; }
{comment}                           { /* skip */ }
{newline}                           { /* skip */ }
{whitespace}                        { /* skip */ }
{blkcomment1}                       { /* skip */ }
{blkcomment2}                       { /* skip */ }


\b     { System.err.println("Sorry, backspace doesn't work"); }

/* error fallback */
[^]    { System.err.println("Error: unexpected character '"+yytext()+"'"); return -1; }
