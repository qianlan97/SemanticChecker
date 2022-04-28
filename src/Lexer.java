/* The following code was generated by JFlex 1.6.1 */

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


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.6.1
 * from the specification file <tt>Lexer.flex</tt>
 */
class Lexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\10\0\1\52\1\4\1\3\1\7\1\7\1\6\22\0\1\4\1\11"+
    "\3\0\1\46\2\0\1\37\1\40\1\45\1\44\1\51\1\12\1\0"+
    "\1\5\12\1\1\43\1\50\1\10\1\47\1\13\2\0\32\2\1\14"+
    "\1\0\1\15\1\0\1\2\1\0\1\26\1\33\1\21\1\35\1\23"+
    "\1\16\1\34\1\30\1\27\2\2\1\31\1\2\1\20\1\41\1\42"+
    "\1\2\1\22\1\32\1\24\1\17\1\25\1\36\3\2\12\0\1\7"+
    "\u1fa2\0\1\7\1\7\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\udfe6\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\2\4\1\5\1\6\1\1"+
    "\1\7\1\10\1\1\12\3\1\11\1\12\2\3\1\1"+
    "\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\4"+
    "\1\0\1\22\1\23\1\24\1\25\1\26\1\0\1\4"+
    "\12\3\1\27\4\3\1\30\1\3\1\31\1\0\2\3"+
    "\1\32\1\3\1\33\3\3\1\34\1\35\1\36\4\3"+
    "\1\0\1\37\1\3\1\40\1\41\1\42\1\3\1\43"+
    "\2\3\1\0\1\3\1\44\1\45\1\46\1\0\1\47"+
    "\1\4";

  private static int [] zzUnpackAction() {
    int [] result = new int[95];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\53\0\126\0\201\0\53\0\254\0\327\0\u0102"+
    "\0\u012d\0\u0158\0\u0183\0\u01ae\0\u01d9\0\u0204\0\u022f\0\u025a"+
    "\0\u0285\0\u02b0\0\u02db\0\u0306\0\u0331\0\u035c\0\53\0\53"+
    "\0\u0387\0\u03b2\0\u03dd\0\53\0\53\0\53\0\53\0\53"+
    "\0\53\0\53\0\u0408\0\u0433\0\53\0\53\0\53\0\53"+
    "\0\53\0\u01ae\0\u01ae\0\u045e\0\u0489\0\u04b4\0\u04df\0\u050a"+
    "\0\u0535\0\u0560\0\u058b\0\u05b6\0\u05e1\0\201\0\u060c\0\u0637"+
    "\0\u0662\0\u068d\0\201\0\u06b8\0\53\0\u06e3\0\u070e\0\u0739"+
    "\0\201\0\u0764\0\201\0\u078f\0\u07ba\0\u07e5\0\201\0\201"+
    "\0\201\0\u0810\0\u083b\0\u0866\0\u0891\0\u08bc\0\201\0\u08e7"+
    "\0\201\0\201\0\201\0\u0912\0\201\0\u093d\0\u0968\0\u0993"+
    "\0\u09be\0\201\0\201\0\201\0\u09e9\0\201\0\u08bc";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[95];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\1\6\1\7\1\6\1\2"+
    "\1\10\1\11\1\12\1\13\1\14\1\2\1\15\1\4"+
    "\1\16\1\4\1\17\1\20\1\21\1\22\1\23\1\24"+
    "\3\4\1\25\2\4\1\26\1\27\1\30\1\31\1\32"+
    "\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\42"+
    "\54\0\1\3\52\0\2\4\13\0\21\4\2\0\2\4"+
    "\14\0\1\6\1\0\1\6\51\0\1\43\56\0\1\44"+
    "\1\45\34\0\1\46\52\0\1\47\16\0\1\50\106\0"+
    "\1\51\3\0\15\52\1\53\35\52\1\0\2\4\13\0"+
    "\1\4\1\54\6\4\1\55\10\4\2\0\2\4\11\0"+
    "\2\4\13\0\21\4\2\0\1\56\1\4\11\0\2\4"+
    "\13\0\5\4\1\57\13\4\2\0\2\4\11\0\2\4"+
    "\13\0\2\4\1\60\10\4\1\61\5\4\2\0\2\4"+
    "\11\0\2\4\13\0\4\4\1\62\5\4\1\63\6\4"+
    "\2\0\2\4\11\0\2\4\13\0\10\4\1\64\10\4"+
    "\2\0\2\4\11\0\2\4\13\0\2\4\1\65\16\4"+
    "\2\0\2\4\11\0\2\4\13\0\1\66\1\4\1\67"+
    "\16\4\2\0\2\4\11\0\2\4\13\0\5\4\1\70"+
    "\13\4\2\0\1\71\1\4\11\0\2\4\13\0\12\4"+
    "\1\72\6\4\2\0\2\4\11\0\2\4\13\0\4\4"+
    "\1\73\14\4\2\0\2\4\11\0\2\4\13\0\4\4"+
    "\1\74\14\4\2\0\2\4\53\0\1\75\7\0\3\43"+
    "\1\0\2\43\2\0\43\43\12\0\1\76\41\0\2\4"+
    "\13\0\2\4\1\77\16\4\2\0\2\4\11\0\2\4"+
    "\13\0\13\4\1\100\5\4\2\0\2\4\11\0\2\4"+
    "\13\0\6\4\1\101\12\4\2\0\2\4\11\0\2\4"+
    "\13\0\6\4\1\102\12\4\2\0\2\4\11\0\2\4"+
    "\13\0\17\4\1\103\1\4\2\0\2\4\11\0\2\4"+
    "\13\0\14\4\1\104\4\4\2\0\2\4\11\0\2\4"+
    "\13\0\1\4\1\105\17\4\2\0\2\4\11\0\2\4"+
    "\13\0\5\4\1\106\13\4\2\0\2\4\11\0\2\4"+
    "\13\0\4\4\1\107\14\4\2\0\2\4\11\0\2\4"+
    "\13\0\17\4\1\110\1\4\2\0\2\4\11\0\2\4"+
    "\13\0\6\4\1\111\12\4\2\0\2\4\11\0\2\4"+
    "\13\0\16\4\1\112\2\4\2\0\2\4\11\0\2\4"+
    "\13\0\21\4\2\0\1\113\1\4\11\0\2\4\13\0"+
    "\11\4\1\114\7\4\2\0\2\4\11\0\2\4\13\0"+
    "\11\4\1\115\7\4\2\0\2\4\22\0\1\116\41\0"+
    "\2\4\13\0\3\4\1\117\15\4\2\0\2\4\11\0"+
    "\2\4\13\0\14\4\1\105\4\4\2\0\2\4\11\0"+
    "\2\4\13\0\1\4\1\120\17\4\2\0\2\4\11\0"+
    "\2\4\13\0\5\4\1\121\13\4\2\0\2\4\11\0"+
    "\2\4\13\0\5\4\1\122\13\4\2\0\2\4\11\0"+
    "\2\4\13\0\2\4\1\123\16\4\2\0\2\4\11\0"+
    "\2\4\13\0\11\4\1\124\7\4\2\0\2\4\11\0"+
    "\2\4\13\0\13\4\1\125\5\4\2\0\2\4\11\0"+
    "\2\4\13\0\13\4\1\126\5\4\2\0\2\4\11\0"+
    "\2\4\13\0\2\4\1\127\16\4\2\0\2\4\10\0"+
    "\12\116\1\130\40\116\1\0\2\4\13\0\4\4\1\131"+
    "\14\4\2\0\2\4\11\0\2\4\13\0\2\4\1\132"+
    "\16\4\2\0\2\4\11\0\2\4\13\0\5\4\1\133"+
    "\13\4\2\0\2\4\11\0\2\4\13\0\6\4\1\134"+
    "\12\4\2\0\2\4\10\0\12\116\1\135\40\116\1\0"+
    "\2\4\13\0\2\4\1\136\16\4\2\0\2\4\10\0"+
    "\12\116\1\135\1\137\37\116";

  private static int [] zzUnpackTrans() {
    int [] result = new int[2580];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\2\1\1\11\21\1\2\11\3\1\7\11"+
    "\1\1\1\0\5\11\1\0\22\1\1\11\1\0\17\1"+
    "\1\0\11\1\1\0\4\1\1\0\2\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[95];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;
  
  /** 
   * The number of occupied positions in zzBuffer beyond zzEndRead.
   * When a lead/high surrogate has been read from the input stream
   * into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /* user code: */

  public Parser   parser;
  public int      lineno;
  public int      column;

  public Lexer(java.io.Reader r, Parser parser) {
    this(r);
    this.parser = parser;
    this.lineno = 1;
    this.column = 1;
  }



  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  Lexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x110000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 160) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException("Reader returned 0 characters. See JFlex examples for workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      /* If numRead == requested, we might have requested to few chars to
         encode a full Unicode character. We assume that a Reader would
         otherwise never return half characters. */
      if (numRead == requested) {
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public int yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
          { return 0; }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { System.err.println("Error: unexpected character '"+yytext()+"'"); return -1;
            }
          case 40: break;
          case 2: 
            { parser.yylval = new ParserVal(new Token(yytext())); return Parser.INT_LIT       ;
            }
          case 41: break;
          case 3: 
            { parser.yylval = new ParserVal(new Token(yytext())); return Parser.IDENT         ;
            }
          case 42: break;
          case 4: 
            { /* skip */
            }
          case 43: break;
          case 5: 
            { parser.yylval = new ParserVal(new Token(yytext())); return Parser.DIV           ;
            }
          case 44: break;
          case 6: 
            { parser.yylval = new ParserVal(new Token(yytext())); return Parser.LT            ;
            }
          case 45: break;
          case 7: 
            { parser.yylval = new ParserVal(new Token(yytext())); return Parser.SUB           ;
            }
          case 46: break;
          case 8: 
            { parser.yylval = new ParserVal(new Token(yytext())); return Parser.GT            ;
            }
          case 47: break;
          case 9: 
            { parser.yylval = new ParserVal(new Token(yytext())); return Parser.LPAREN        ;
            }
          case 48: break;
          case 10: 
            { parser.yylval = new ParserVal(new Token(yytext())); return Parser.RPAREN        ;
            }
          case 49: break;
          case 11: 
            { parser.yylval = new ParserVal(new Token(yytext())); return Parser.ADD           ;
            }
          case 50: break;
          case 12: 
            { parser.yylval = new ParserVal(new Token(yytext())); return Parser.MUL           ;
            }
          case 51: break;
          case 13: 
            { parser.yylval = new ParserVal(new Token(yytext())); return Parser.MOD           ;
            }
          case 52: break;
          case 14: 
            { parser.yylval = new ParserVal(new Token(yytext())); return Parser.EQ            ;
            }
          case 53: break;
          case 15: 
            { parser.yylval = new ParserVal(new Token(yytext())); return Parser.SEMI          ;
            }
          case 54: break;
          case 16: 
            { parser.yylval = new ParserVal(new Token(yytext())); return Parser.COMMA         ;
            }
          case 55: break;
          case 17: 
            { System.err.println("Sorry, backspace doesn't work");
            }
          case 56: break;
          case 18: 
            { parser.yylval = new ParserVal(new Token(yytext())); return Parser.ASSIGN        ;
            }
          case 57: break;
          case 19: 
            { parser.yylval = new ParserVal(new Token(yytext())); return Parser.LE            ;
            }
          case 58: break;
          case 20: 
            { parser.yylval = new ParserVal(new Token(yytext())); return Parser.NE            ;
            }
          case 59: break;
          case 21: 
            { parser.yylval = new ParserVal(new Token(yytext())); return Parser.FUNCRET       ;
            }
          case 60: break;
          case 22: 
            { parser.yylval = new ParserVal(new Token(yytext())); return Parser.GE            ;
            }
          case 61: break;
          case 23: 
            { parser.yylval = new ParserVal(new Token(yytext())); return Parser.IF            ;
            }
          case 62: break;
          case 24: 
            { parser.yylval = new ParserVal(new Token(yytext())); return Parser.OR            ;
            }
          case 63: break;
          case 25: 
            { parser.yylval = new ParserVal(new Token(yytext())); return Parser.TYPEOF        ;
            }
          case 64: break;
          case 26: 
            { parser.yylval = new ParserVal(new Token(yytext())); return Parser.NOT           ;
            }
          case 65: break;
          case 27: 
            { parser.yylval = new ParserVal(new Token(yytext())); return Parser.END           ;
            }
          case 66: break;
          case 28: 
            { parser.yylval = new ParserVal(new Token(yytext())); return Parser.VAR           ;
            }
          case 67: break;
          case 29: 
            { parser.yylval = new ParserVal(new Token(yytext())); return Parser.AND           ;
            }
          case 68: break;
          case 30: 
            { parser.yylval = new ParserVal(new Token(yytext())); return Parser.INT           ;
            }
          case 69: break;
          case 31: 
            { parser.yylval = new ParserVal(new Token(yytext())); return Parser.FUNC          ;
            }
          case 70: break;
          case 32: 
            { parser.yylval = new ParserVal(new Token(yytext())); return Parser.ELSE          ;
            }
          case 71: break;
          case 33: 
            { parser.yylval = new ParserVal(new Token(yytext())); return Parser.BOOL_LIT      ;
            }
          case 72: break;
          case 34: 
            { parser.yylval = new ParserVal(new Token(yytext())); return Parser.THEN          ;
            }
          case 73: break;
          case 35: 
            { parser.yylval = new ParserVal(new Token(yytext())); return Parser.BOOL          ;
            }
          case 74: break;
          case 36: 
            { parser.yylval = new ParserVal(new Token(yytext())); return Parser.BEGIN         ;
            }
          case 75: break;
          case 37: 
            { parser.yylval = new ParserVal(new Token(yytext())); return Parser.WHILE         ;
            }
          case 76: break;
          case 38: 
            { parser.yylval = new ParserVal(new Token(yytext())); return Parser.PRINT         ;
            }
          case 77: break;
          case 39: 
            { parser.yylval = new ParserVal(new Token(yytext())); return Parser.RETURN        ;
            }
          case 78: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
