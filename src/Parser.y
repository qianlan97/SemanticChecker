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


program         : decl_list                                     { Debug("program -> decl_list"                  ); $$ = program____decllist		($1); }
                ;

decl_list       : decl_list decl                                { Debug("decl_list -> decl_list decl"           ); $$ = decllist____decllist_decl	($1,$2); }
                |                                               { Debug("decl_list -> eps"                  	); $$ = decllist____eps			(); }
                ;

decl            : fun_defn                                      { Debug("decl -> fun_defn"                  	); $$ = decl____fundefn			($1); }
                ;

fun_defn        : FUNC IDENT TYPEOF LPAREN params RPAREN FUNCRET prim_type BEGIN local_decls{ Debug("fun_defn -> FUNC ID::( params )->type BEGIN local_decls"); $<obj>$ =    fundefn____FUNC_IDENT_TYPEOF_LPAREN_params_RPAREN_FUNCRET_primtype_BEGIN_localdecls_11x_stmtlist_END($2, $5, $8, $10          ); }
                                                                               stmt_list END{ Debug("                                         stmt_list END "); $$ =         fundefn____FUNC_IDENT_TYPEOF_LPAREN_params_RPAREN_FUNCRET_primtype_BEGIN_localdecls_x11_stmtlist_END($2, $5, $8, $10, $12, $13); }
                ;

params          : param_list                                    { Debug("params -> param_list "                 ); $$ = params____paramlist		($1); }
		|						{ Debug("params -> eps"                  	); $$ = params____eps			(); }
                ;

param_list	: param_list COMMA param			{ Debug("param_list -> param_list , param"      ); $$ = paramlist____paramlist_COMMA_param($1,$3); }
		| param						{ Debug("param_list -> param"                  	); $$ = paramlist____param		($1); }
		;

param		: IDENT TYPEOF type_spec			{ Debug("param -> IDENT TYPEOF type_spec"       ); $$ = param____IDENT_TYPEOF_type_spec	(); }
		;

type_spec	: prim_type					{ Debug("type_spec -> prim_type"                ); $$ = typespec____primtype		($1); }
		;

prim_type       : INT                                           { Debug("prim_type -> INT"                  	); $$ = primtype____INT			(); }
		| BOOL						{ Debug("prim_type -> BOOL"                  	); $$ = primtype____BOOL		(); }
                ;

local_decls     : local_decls local_decl			{ Debug("local_decls -> local_decls local_decl" ); $$ = localdecls____localdecls_localdecl($1,$2); }
		|						{ Debug("local_decls -> eps"                  	); $$ = localdecls____eps		(); }
                ;

local_decl	: VAR IDENT TYPEOF type_spec SEMI		{ Debug("local_decl -> VAR IDENT TYPEOF type_spec ;"); $$ = local_decl____VAR_IDENT_TYPEOF_typespec_SEMI(); }
		;

stmt_list       : stmt_list stmt                                { Debug("stmt_list -> stmt_list stmt"           ); $$ = stmtlist____stmtlist_stmt	($1, $2); }
                |                                               { Debug("stmt_list -> eps"                  	); $$ = stmtlist____eps			(); }
                ;

stmt            : assign_stmt                                   { Debug("stmt -> assign_stmt"                  	); $$ = stmt____assignstmt		($1); }
		| print_stmt					{ Debug("stmt -> print_stmt"                  	); $$ = stmt____printstmt		($1); }
                | return_stmt                                   { Debug("stmt -> return_stmt"                  	); $$ = stmt____returnstmt		($1); }
                | if_stmt					{ Debug("stmt -> if_stmt"                  	); $$ = stmt____ifstmt			($1); }
                | while_stmt					{ Debug("stmt -> while_stmt"                  	); $$ = stmt____whilestmt		($1); }
                | compound_stmt					{ Debug("stmt -> compound_stmt"                 ); $$ = stmt____compoundstmt		($1); }
                ;

assign_stmt     : IDENT ASSIGN expr SEMI                        { Debug("assign_stmt -> IDENT <- expr ;"    ); $$ = assignstmt____IDENT_ASSIGN_expr_SEMI($1,$2,$3); }
                ;

print_stmt	: PRINT expr SEMI				{ Debug("print_stmt -> PRINT expr ;"            ); $$ = printstmt____PRINT_expr_SEMI	($2); }
		;

return_stmt     : RETURN expr SEMI                              { Debug("return_stmt -> RETURN expr ;"          ); $$ = returnstmt____RETURN_expr_SEMI	($2); }
                ;

if_stmt		: IF expr THEN stmt_list ELSE stmt_list END	{ Debug("if_stmt -> IF expr THEN stmt_list ELSE stmt_list END"	); $$ = ifstmt____IF_expr_THEN_stmtlist_ELSE_stmtlist_END(); }
		;

while_stmt	: WHILE expr compound_stmt			{ Debug("while_stmt -> WHILE expr compound_stmt"); $$ = whilestmt____WHILE_expr_compoundstmt(); }
		;

compound_stmt	: BEGIN local_decls stmt_list END		{ Debug("compound_stmt -> BEGIN local_decls stmt_list END"); $$ = compoundstmt____BEGIN_localdecls_stmtlist_END(); }
		;

args            : arg_list					{ Debug("args -> arg_list"                  	); $$ = args____arglist			(); }
		|						{ Debug("args -> eps"                  		); $$ = args____eps			(); }
                ;

arg_list	: arg_list COMMA expr				{ Debug("arg_list -> arg_list , expr"           ); $$ = arglist____arglist_COMMA_expr	(); }
		| expr						{ Debug("arg_list -> expr"                  	); $$ = arglist____expr			(); }
		;

expr            : expr AND expr                                 { Debug("expr -> expr and expr"                 ); $$ = expr____expr_AND_expr		(); }
		| expr OR expr					{ Debug("expr -> expr or expr"                  ); $$ = expr____expr_OR_expr		(); }
		| NOT expr					{ Debug("expr -> not expr"                  	); $$ = expr____NOT_expr		(); }
                | expr EQ expr                                 	{ Debug("expr -> expr == expr"                  ); $$ = expr____expr_EQ_expr		($1,$2,$3); }
                | expr NE expr					{ Debug("expr -> expr != expr"                  ); $$ = expr____expr_NE_expr		($1,$2,$3); }
                | expr LE expr 					{ Debug("expr -> expr <= expr"                  ); $$ = expr____expr_LE_expr		($1,$2,$3); }
                | expr LT expr					{ Debug("expr -> expr < expr"                  	); $$ = expr____expr_LT_expr		($1,$2,$3); }
                | expr GE expr					{ Debug("expr -> expr >= expr"                  ); $$ = expr____expr_GE_expr		($1,$2,$3); }
                | expr GT expr					{ Debug("expr -> expr > expr"                  	); $$ = expr____expr_GT_expr		($1,$2,$3); }
                | expr ADD expr					{ Debug("expr -> expr + expr"                  	); $$ = expr____expr_ADD_expr		($1,$2,$3); }
                | expr SUB expr					{ Debug("expr -> expr - expr"                  	); $$ = expr____expr_SUB_expr		($1,$2,$3); }
                | expr MUL expr					{ Debug("expr -> expr * expr"                  	); $$ = expr____expr_MUL_expr		($1,$2,$3); }
                | expr DIV expr					{ Debug("expr -> expr / expr"                  	); $$ = expr____expr_DIV_expr		($1,$2,$3); }
                | expr MOD expr					{ Debug("expr -> expr % expr"                  	); $$ = expr____expr_MOD_expr		($1,$2,$3); }
                | LPAREN expr RPAREN                            { Debug("expr -> ( expr )"                  	); $$ = expr____LPAREN_expr_RPAREN	($1,$2,$3); }
                | IDENT                                         { Debug("expr -> IDENT"                  	); $$ = expr____IDENT			($1); }
                | BOOL_LIT					{ Debug("expr -> BOOL_LIT"                  	); $$ = expr____BOOLLIT			($1); }
                | INT_LIT					{ Debug("expr -> INT_LIT"                  	); $$ = expr____INTLIT			($1); }
                | IDENT LPAREN args RPAREN                      { Debug("expr -> IDENT ( args )"                ); $$ = expr____IDENT_LPAREN_args_RPAREN($1,$3); }
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
