// Author:
// Nan Chen & Xinyu Li

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Copyright (C) 2001 Gerwin Klein <lsf@jflex.de>                          *
 * All rights reserved.                                                    *
 *                                                                         *
 * This is a modified version of the example from                          *
 *   http://www.lincom-asg.com/~rjamison/byacc/                            *
 *                                                                         *
 * Thanks to Larry Bell and Bob Jamison for suggestions and comments.      *
 *                                                                         *
 * License: BSD                                                            *
 *                                                                         *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

%{
import java.io.*;
%}

%right  ASSIGN
%left   OR
%left   AND
%right  NOT
%left   EQ      NE
%left   LE      LT      GE      GT
%left   ADD     SUB
%left   MUL     DIV     MOD

%token <obj>    EQ   NE   LE   LT   GE   GT
%token <obj>    ADD  SUB  MUL  DIV  MOD
%token <obj>    OR   AND  NOT

%token <obj>    IDENT     INT_LIT   BOOL_LIT

%token <obj> BOOL  INT
%token <obj> FUNC  IF  THEN  ELSE  WHILE  PRINT  RETURN
%token <obj> BEGIN  END  LPAREN  RPAREN
%token <obj> ASSIGN  TYPEOF  VAR  SEMI  COMMA  FUNCRET

%type <obj> program   decl_list  decl
%type <obj> fun_defn  local_decls  local_decl  type_spec  prim_type
%type <obj> params  param_list  param  args  arg_list
%type <obj> stmt_list  stmt  assign_stmt  print_stmt  return_stmt  if_stmt  while_stmt  compound_stmt     
%type <obj> expr

%%


program         : decl_list                                     { }
                ;

decl_list       : decl_list decl                                { }
                |                                               { }
                ;

decl            : fun_defn                                      { }
                ;

fun_defn        : FUNC IDENT TYPEOF LPAREN params RPAREN FUNCRET prim_type BEGIN local_decls stmt_list END { }
                ;

params          : param_list                                    { }
		|						{ }
                ;

param_list	: param_list COMMA param			{ }
		| param						{ }
		;

param		: IDENT TYPEOF type_spec			{ }
		;

type_spec	: prim_type					{ }
		;

prim_type       : INT                                           { }
		| BOOL						{ }
                ;

local_decls     : local_decls local_decl			{ }
		|						{ }
                ;

local_decl	: VAR IDENT TYPEOF type_spec SEMI		{ }
		;

stmt_list       : stmt_list stmt                                { }
                |                                               { }
                ;

stmt            : assign_stmt                                   { }
		| print_stmt					{ }
                | return_stmt                                   { }
                | if_stmt					{ }
                | while_stmt					{ }
                | compound_stmt					{ }
                ;

assign_stmt     : IDENT ASSIGN expr SEMI                        { }
                ;

print_stmt	: PRINT expr SEMI				{ }
		;

return_stmt     : RETURN expr SEMI                              { }
                ;

if_stmt		: IF expr THEN stmt_list ELSE stmt_list END	{ }
		;

while_stmt	: WHILE expr compound_stmt			{ }
		;

compound_stmt	: BEGIN local_decls stmt_list END		{ }
		;

args            : arg_list					{ }
		|						{ }
                ;

arg_list	: arg_list COMMA expr				{ }
		| expr						{ }
		;

expr            : expr AND expr                                 { }
		| expr OR expr					{ }
		| NOT expr					{ }
                | expr EQ expr                                 	{ }
                | expr NE expr					{ }
                | expr LE expr 					{ }
                | expr LT expr					{ }
                | expr GE expr					{ }
                | expr GT expr					{ }
                | expr ADD expr					{ }
                | expr SUB expr					{ }
                | expr MUL expr					{ }
                | expr DIV expr					{ }
                | expr MOD expr					{ }
                | LPAREN expr RPAREN                            { }
                | IDENT                                         { }
                | BOOL_LIT					{ }
                | INT_LIT					{ }
                | IDENT LPAREN args RPAREN                      { }
                ;

%%
    private Lexer lexer;

    private int yylex () {
        int yyl_return = -1;
        try {
            yylval = new ParserVal(0);
            yyl_return = lexer.yylex();
        }
        catch (IOException e) {
            System.out.println("IO error :"+e);
        }
        return yyl_return;
    }


    public void yyerror (String error) {
        //System.out.println ("Error message for " + lexer.lineno+":"+lexer.column +" by Parser.yyerror(): " + error);
        System.out.println ("Error message by Parser.yyerror(): " + error);
    }


    public Parser(Reader r, boolean yydebug) {
        this.lexer   = new Lexer(r, this);
        this.yydebug = yydebug;
    }
