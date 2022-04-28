# Semantic Checker

## Developer: Nan Chen & Xinyu Li


## How to build
### This project is built in Intellij
### How to build
1. There is generated `Lexer.java`, `Parser.java` and `ParserVal.java` in this submission.
2. But if you want to generate those files on your own, enter "src" directory and run in terminal as follows:
   `java -jar jflex-1.6.1.jar Lexer.flex`
   `.\yacc.exe -Jthrows="Exception" -Jextends=ParserImpl -Jclass=Parser -Jnorun -J Parser.y`
3. Click on "build" in Intellij to get two excutable file.

## How to run
1. Right click on the Tokenizer folder and open in Intellij
2. For `Env`, replace your `TestEnv` file and click `build and run` button to get the output.
3. Add the test case files into **/out/production/SemanticChecker**
4. In terminal, head into **/out/product/SemanticChecker**
5. Run `java SemanticChecker syntaxerr_x.minc > solu.txt`
6. The output will be in the **solu.txt** file in the same directory
