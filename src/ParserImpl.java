import java.util.*;
import java.util.HashMap;

@SuppressWarnings("unchecked")
public class ParserImpl
{
    public static Boolean _debug = true;
    void Debug(String message)
    {
        if(_debug)
            System.out.println(message);
    }

    Env env = new Env(null);

    void create_local_env() throws Exception {
        if (env == null)
            env = new Env(null);
        else env = new Env(env);
    }

    void delete_local_env() throws Exception {
        if (env != null) {
            Env p = env.prev;
            env = p;
        }
    }

    // this stores the root of parse tree, which will be used to print parse tree and run the parse tree
    ParseTree.Program parsetree_program = null;

    Object program____decllist(Object s1) throws Exception
    {
        ArrayList<ParseTree.FuncDefn> decllist = (ArrayList<ParseTree.FuncDefn>)s1;
        parsetree_program = new ParseTree.Program(decllist);
        return parsetree_program;
    }

    Object decllist____decllist_decl(Object s1, Object s2) throws Exception
    {
        ArrayList<ParseTree.FuncDefn> decllist = (ArrayList<ParseTree.FuncDefn>)s1;
        ParseTree.FuncDefn                decl = (ParseTree.FuncDefn           )s2;
        decllist.add(decl);
        return decllist;
    }
    Object decllist____eps() throws Exception
    {
        return new ArrayList<ParseTree.FuncDefn>();
    }
    Object decl____fundefn(Object s1) throws Exception
    {
        return s1;
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    Object fundefn____FUNC_IDENT_TYPEOF_LPAREN_params_RPAREN_FUNCRET_primtype_BEGIN_localdecls_11x_stmtlist_END(Object s2, Object s5, Object s8, Object s10) throws Exception
    {
        return null;
    }
    Object fundefn____FUNC_IDENT_TYPEOF_LPAREN_params_RPAREN_FUNCRET_primtype_BEGIN_localdecls_x11_stmtlist_END(Object s2, Object s5, Object s8, Object s10, Object s12, Object s13) throws Exception
    {
        Token                            id         = (Token                           )s2;
        ArrayList<ParseTree.Param>       params     = (ArrayList<ParseTree.Param>      )s5;
        ParseTree.TypeSpec               rettype    = (ParseTree.TypeSpec              )s8;
        ArrayList<ParseTree.LocalDecl>   localdecls = (ArrayList<ParseTree.LocalDecl>  )s10;
        ArrayList<ParseTree.Stmt>        stmtlist   = (ArrayList<ParseTree.Stmt>       )s12;
        Token                            end        = (Token                           )s13;
        ParseTree.FuncDefn funcdefn = new ParseTree.FuncDefn(id.lexeme, rettype, params, localdecls, stmtlist);
        return funcdefn;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    Object params____paramlist(Object s1) throws Exception
    {
        return s1;
    }

    Object params____eps() throws Exception 
    {
        return new ArrayList<ParseTree.Param>();
    }

    Object paramlist____paramlist_COMMA_param(Object s1, Object s3) throws Exception
    {
        ((HashMap<String, Object>) s1).putAll((HashMap<String, Object>) s3);
        return s1;
    }

    Object paramlist____param(Object s1) throws Exception
    {
        ArrayList<Object> paramlist = new ArrayList<Object>(); //new ArrayList<>();
        paramlist.add(s1);
        return paramlist;
        // return s1;
        // not sure which one to use
    }

    Object param____IDENT_TYPEOF_type_spec() throws Exception
    {

    }

    Object typespec____primtype() throws Exception
    {

    }

    Object primtype____INT() throws Exception
    {
        ParseTree.TypeSpec typespec = new ParseTree.TypeSpec("int");
        return typespec;
    }

    Object primtype____BOOL() throws Exception
    {

    }

    Object localdecls____localdecls_localdecl() throws Exception
    {

    }

    Object localdecls____eps() throws Exception
    {
        return new ArrayList<ParseTree.LocalDecl>();
    }

    Object local_decl____VAR_IDENT_TYPEOF_typespec_SEMI() throws Exception
    {

    }

    Object stmtlist____stmtlist_stmt(Object s1, Object s2) throws Exception
    {
        ArrayList<ParseTree.Stmt> stmtlist = (ArrayList<ParseTree.Stmt>)s1;
        ParseTree.Stmt            stmt     = (ParseTree.Stmt           )s2;
        stmtlist.add(stmt);
        return stmtlist;
    }
    Object stmtlist____eps() throws Exception
    {
        return new ArrayList<ParseTree.Stmt>();
    }

    Object stmt____assignstmt(Object s1) throws Exception
    {
        assert(s1 instanceof ParseTree.AssignStmt);
        return s1;
    }

    Object stmt____printstmt() throws Exception
    {

    }

    Object stmt____returnstmt  (Object s1) throws Exception
    {
        assert(s1 instanceof ParseTree.ReturnStmt);
        return s1;
    }

    Object stmt____ifstmt() throws Exception
    {

    }

    Object stmt____whilestmt() throws Exception
    {

    }

    Object stmt____compoundstmt() throws Exception
    {

    }

    Object assignstmt____IDENT_ASSIGN_expr_SEMI(Object s1, Object s2, Object s3) throws Exception
    {
        Token          id     = (Token         )s1;
        Token          assign = (Token         )s2;
        ParseTree.Expr expr   = (ParseTree.Expr)s3;
        return new ParseTree.AssignStmt(id.lexeme, expr);
    }

    Object printstmt____PRINT_expr_SEMI() throws Exception
    {

    }

    Object returnstmt____RETURN_expr_SEMI(Object s2) throws Exception
    {
        ParseTree.Expr expr = (ParseTree.Expr)s2;
        return new ParseTree.ReturnStmt(expr);
    }

    Object ifstmt____IF_expr_THEN_stmtlist_ELSE_stmtlist_END() throws Exception
    {

    }

    Object whilestmt____WHILE_expr_compoundstmt() throws Exception
    {

    }

    Object compoundstmt____BEGIN_localdecls_stmtlist_END() throws Exception
    {

    }

    Object args____arglist() throws Exception
    {

    }

    Object args____eps() throws Exception
    {
        return new ArrayList<ParseTree.Expr>();
    }

    Object arglist____arglist_COMMA_expr() throws Exception
    {

    }

    Object arglist____expr() throws Exception
    {

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    Object expr____expr_AND_expr() throws Exception{

    }

    Object expr____expr_OR_expr() throws Exception{

    }

    Object expr____NOT_expr() throws Exception{

    }

    Object expr____expr_EQ_expr(Object s1, Object s2, Object s3) throws Exception
    {
        ParseTree.Expr expr1 = (ParseTree.Expr)s1;
        Token          oper  = (Token         )s2;
        ParseTree.Expr expr2 = (ParseTree.Expr)s3;
        return new ParseTree.ExprOper("=",expr1,expr2);
    }

    Object expr____expr_NE_expr(Object s1, Object s2, Object s3) throws Exception
    {
        ParseTree.Expr expr1 = (ParseTree.Expr)s1;
        Token          oper  = (Token         )s2;
        ParseTree.Expr expr2 = (ParseTree.Expr)s3;
        return new ParseTree.ExprOper("!=",expr1,expr2);
    }

    Object expr____expr_LE_expr(Object s1, Object s2, Object s3) throws Exception
    {
        ParseTree.Expr expr1 = (ParseTree.Expr)s1;
        Token          oper  = (Token         )s2;
        ParseTree.Expr expr2 = (ParseTree.Expr)s3;
        return new ParseTree.ExprOper("<=",expr1,expr2);
    }

    Object expr____expr_LT_expr(Object s1, Object s2, Object s3) throws Exception
    {
        ParseTree.Expr expr1 = (ParseTree.Expr)s1;
        Token          oper  = (Token         )s2;
        ParseTree.Expr expr2 = (ParseTree.Expr)s3;
        return new ParseTree.ExprOper("<",expr1,expr2);
    }

    Object expr____expr_GE_expr(Object s1, Object s2, Object s3) throws Exception
    {
        ParseTree.Expr expr1 = (ParseTree.Expr)s1;
        Token          oper  = (Token         )s2;
        ParseTree.Expr expr2 = (ParseTree.Expr)s3;
        return new ParseTree.ExprOper(">=",expr1,expr2);
    }

    Object expr____expr_GT_expr(Object s1, Object s2, Object s3) throws Exception
    {
        ParseTree.Expr expr1 = (ParseTree.Expr)s1;
        Token          oper  = (Token         )s2;
        ParseTree.Expr expr2 = (ParseTree.Expr)s3;
        return new ParseTree.ExprOper(">",expr1,expr2);
    }

    Object expr____expr_ADD_expr(Object s1, Object s2, Object s3) throws Exception
    {
        ParseTree.Expr expr1 = (ParseTree.Expr)s1;
        Token          oper  = (Token         )s2;
        ParseTree.Expr expr2 = (ParseTree.Expr)s3;
        return new ParseTree.ExprOper("+",expr1,expr2);
    }

    Object expr____expr_SUB_expr(Object s1, Object s2, Object s3) throws Exception
    {
        ParseTree.Expr expr1 = (ParseTree.Expr)s1;
        Token          oper  = (Token         )s2;
        ParseTree.Expr expr2 = (ParseTree.Expr)s3;
        return new ParseTree.ExprOper("-",expr1,expr2);
    }

    Object expr____expr_MUL_expr(Object s1, Object s2, Object s3) throws Exception
    {
        ParseTree.Expr expr1 = (ParseTree.Expr)s1;
        Token          oper  = (Token         )s2;
        ParseTree.Expr expr2 = (ParseTree.Expr)s3;
        return new ParseTree.ExprOper("*",expr1,expr2);
    }

    Object expr____expr_DIV_expr(Object s1, Object s2, Object s3) throws Exception
    {
        ParseTree.Expr expr1 = (ParseTree.Expr)s1;
        Token          oper  = (Token         )s2;
        ParseTree.Expr expr2 = (ParseTree.Expr)s3;
        return new ParseTree.ExprOper("/",expr1,expr2);
    }

    Object expr____expr_MOD_expr(Object s1, Object s2, Object s3) throws Exception
    {
        ParseTree.Expr expr1 = (ParseTree.Expr)s1;
        Token          oper  = (Token         )s2;
        ParseTree.Expr expr2 = (ParseTree.Expr)s3;
        return new ParseTree.ExprOper("%",expr1,expr2);
    }

    Object expr____LPAREN_expr_RPAREN(Object s1, Object s2, Object s3) throws Exception
    {
        Token          lparen = (Token         )s1;
        ParseTree.Expr expr   = (ParseTree.Expr)s2;
        Token          rparen = (Token         )s3;
        return new ParseTree.ExprOper("()", expr, null);    // This use only op1
    }
    Object expr____IDENT(Object s1) throws Exception
    {
        Token id = (Token)s1;
        return new ParseTree.ExprIdent(id.lexeme);
    }
    Object expr____BOOLLIT(Object s1) throws Exception
    {
        Token token = (Token)s1;
        boolean value = Boolean.parseBoolean(token.lexeme);
        return new ParseTree.ExprBoolLit(value);
    }
    Object expr____INTLIT(Object s1) throws Exception
    {
        Token token = (Token)s1;
        int value = Integer.parseInt(token.lexeme);
        return new ParseTree.ExprIntLit(value);
    }
    Object expr____IDENT_LPAREN_args_RPAREN(Object s1, Object s3) throws Exception
    {
        Token                    id   = (Token                   )s1;
        ArrayList<ParseTree.Arg> args = (ArrayList<ParseTree.Arg>)s3;
        return new ParseTree.ExprCall(id.lexeme, args);
    }


}
