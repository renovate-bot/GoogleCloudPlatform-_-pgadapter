/* Copy.java */
/* Generated By:JJTree&JavaCC: Do not edit this line. Copy.java */
package com.google.cloud.spanner.pgadapter.parsers.copy;

public class Copy /*@bgen(jjtree)*/ implements CopyTreeConstants, CopyConstants {
  /*@bgen(jjtree)*/
  protected JJTCopyState jjtree = new JJTCopyState();

  public static void parse(String stmt, CopyTreeParser.CopyOptions options) throws Exception {
    java.io.InputStream stmtStream = new java.io.ByteArrayInputStream(stmt.getBytes());
    Copy tree = new Copy(stmtStream);
    try {
      ASTStart node = tree.Start();
      CopyVisitor v = new CopyTreeParser(options);
      node.jjtAccept(v, null);
    } catch (Exception e) {
      System.err.println(e.getMessage());
      e.printStackTrace();
      throw e;
    }
  }

  /** Main production. */
  public final ASTStart Start() throws ParseException {
    /*@bgen(jjtree) Start */
    ASTStart jjtn000 = new ASTStart(JJTSTART);
    boolean jjtc000 = true;
    jjtree.openNodeScope(jjtn000);
    try {
      Expression();
      jj_consume_token(40);
      jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
      {
        if ("" != null) return jjtn000;
      }
    } catch (Throwable jjte000) {
      if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {
          if (true) throw (RuntimeException) jjte000;
        }
      }
      if (jjte000 instanceof ParseException) {
        {
          if (true) throw (ParseException) jjte000;
        }
      }
      {
        if (true) throw (Error) jjte000;
      }
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
    throw new Error("Missing return statement in function");
  }

  /** An Expression. */
  public final void Expression() throws ParseException {
    CopyStmt();
  }

  /** Copy Statement. */
  public final void CopyStmt() throws ParseException {
    /*@bgen(jjtree) CopyStatement */
    ASTCopyStatement jjtn000 = new ASTCopyStatement(JJTCOPYSTATEMENT);
    boolean jjtc000 = true;
    jjtree.openNodeScope(jjtn000);
    try {
      jj_consume_token(K_COPY);
      qualifiedName();
      optColumnList();
      copyFrom();
      copyFileName();
      optWith();
      copyOptions();
    } catch (Throwable jjte000) {
      if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {
          if (true) throw (RuntimeException) jjte000;
        }
      }
      if (jjte000 instanceof ParseException) {
        {
          if (true) throw (ParseException) jjte000;
        }
      }
      {
        if (true) throw (Error) jjte000;
      }
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
  }

  /** Qualified Name. */
  public final void qualifiedName() throws ParseException {
    /*@bgen(jjtree) QualifiedName */
    ASTQualifiedName jjtn000 = new ASTQualifiedName(JJTQUALIFIEDNAME);
    boolean jjtc000 = true;
    jjtree.openNodeScope(jjtn000);
    try {
      identifier();
    } catch (Throwable jjte000) {
      if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {
          if (true) throw (RuntimeException) jjte000;
        }
      }
      if (jjte000 instanceof ParseException) {
        {
          if (true) throw (ParseException) jjte000;
        }
      }
      {
        if (true) throw (Error) jjte000;
      }
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
  }

  /** Optional Column List */
  public final void optColumnList() throws ParseException {
    if (jj_2_1(2)) {
      jj_consume_token(41);
      columnList();
      jj_consume_token(42);
    } else {

    }
  }

  /** Column List. */
  public final void columnList() throws ParseException {
    /*@bgen(jjtree) ColumnList */
    ASTColumnList jjtn000 = new ASTColumnList(JJTCOLUMNLIST);
    boolean jjtc000 = true;
    jjtree.openNodeScope(jjtn000);
    try {
      if (jj_2_2(2)) {
        columnElem();
        jj_consume_token(K_COMMA);
        columnList();
      } else {
        switch ((jj_ntk == -1) ? jj_ntk_f() : jj_ntk) {
          case IDENTIFIER:
            {
              columnElem();
              break;
            }
          default:
            jj_la1[0] = jj_gen;
            jj_consume_token(-1);
            throw new ParseException();
        }
      }
    } catch (Throwable jjte000) {
      if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {
          if (true) throw (RuntimeException) jjte000;
        }
      }
      if (jjte000 instanceof ParseException) {
        {
          if (true) throw (ParseException) jjte000;
        }
      }
      {
        if (true) throw (Error) jjte000;
      }
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
  }

  /** Column Element. */
  public final void columnElem() throws ParseException {
    /*@bgen(jjtree) ColumnElement */
    ASTColumnElement jjtn000 = new ASTColumnElement(JJTCOLUMNELEMENT);
    boolean jjtc000 = true;
    jjtree.openNodeScope(jjtn000);
    Token t;
    try {
      t = jj_consume_token(IDENTIFIER);
      jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
      jjtn000.setName(t.image);
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
  }

  /** Copy From */
  public final void copyFrom() throws ParseException {
    /*@bgen(jjtree) CopyDirection */
    ASTCopyDirection jjtn000 = new ASTCopyDirection(JJTCOPYDIRECTION);
    boolean jjtc000 = true;
    jjtree.openNodeScope(jjtn000);
    try {
      switch ((jj_ntk == -1) ? jj_ntk_f() : jj_ntk) {
        case K_FROM:
          {
            jj_consume_token(K_FROM);
            jjtree.closeNodeScope(jjtn000, true);
            jjtc000 = false;
            jjtn000.setDirection("FROM");
            break;
          }
        case K_TO:
          {
            jj_consume_token(K_TO);
            jjtree.closeNodeScope(jjtn000, true);
            jjtc000 = false;
            jjtn000.setDirection("TO");
            {
              if (true) throw new ParseException("COPY TO is not supported.");
            }
            break;
          }
        default:
          jj_la1[1] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
      }
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
  }

  public final void copyFileName() throws ParseException {
    /*@bgen(jjtree) Filename */
    ASTFilename jjtn000 = new ASTFilename(JJTFILENAME);
    boolean jjtc000 = true;
    jjtree.openNodeScope(jjtn000);
    Object o;
    try {
      switch ((jj_ntk == -1) ? jj_ntk_f() : jj_ntk) {
        case K_STDIN:
          {
            jj_consume_token(K_STDIN);
            jjtree.closeNodeScope(jjtn000, true);
            jjtc000 = false;
            jjtn000.setName("STDIN");
            break;
          }
        case K_STDOUT:
          {
            jj_consume_token(K_STDOUT);
            jjtree.closeNodeScope(jjtn000, true);
            jjtc000 = false;
            jjtn000.setName("STDOUT");
            break;
          }
        case IDENTIFIER:
          {
            identifier();
            break;
          }
        default:
          jj_la1[2] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
      }
    } catch (Throwable jjte000) {
      if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {
          if (true) throw (RuntimeException) jjte000;
        }
      }
      if (jjte000 instanceof ParseException) {
        {
          if (true) throw (ParseException) jjte000;
        }
      }
      {
        if (true) throw (Error) jjte000;
      }
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
  }

  /** Optional With */
  public final void optWith() throws ParseException {
    switch ((jj_ntk == -1) ? jj_ntk_f() : jj_ntk) {
      case K_WITH:
        {
          jj_consume_token(K_WITH);
          break;
        }
      default:
        jj_la1[3] = jj_gen;
    }
  }

  /** Optional list of copy options */
  public final void copyOptions() throws ParseException {
    /*@bgen(jjtree) CopyOptions */
    ASTCopyOptions jjtn000 = new ASTCopyOptions(JJTCOPYOPTIONS);
    boolean jjtc000 = true;
    jjtree.openNodeScope(jjtn000);
    try {
      if (jj_2_3(2)) {
        jj_consume_token(41);
        copyOptionList();
        jj_consume_token(42);
      } else {
        copyOptionList();
      }
    } catch (Throwable jjte000) {
      if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {
          if (true) throw (RuntimeException) jjte000;
        }
      }
      if (jjte000 instanceof ParseException) {
        {
          if (true) throw (ParseException) jjte000;
        }
      }
      {
        if (true) throw (Error) jjte000;
      }
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
  }

  public final void copyOptionList() throws ParseException {
    /*@bgen(jjtree) CopyOptionList */
    ASTCopyOptionList jjtn000 = new ASTCopyOptionList(JJTCOPYOPTIONLIST);
    boolean jjtc000 = true;
    jjtree.openNodeScope(jjtn000);
    try {
      switch ((jj_ntk == -1) ? jj_ntk_f() : jj_ntk) {
        case O_BINARY:
        case O_CSV:
        case O_TEXT:
        case O_FORMAT:
        case O_FREEZE:
        case O_DELIMITER:
        case O_NULL:
        case O_HEADER:
        case O_QUOTE:
        case O_ESCAPE:
        case O_FORCE_QUOTE:
        case O_FORCE_NOT_NULL:
        case O_FORCE_NULL:
        case O_ENCODING:
          {
            copyOptionElement();
            copyOptionList();
            break;
          }
        default:
          jj_la1[4] = jj_gen;
          jjtree.closeNodeScope(jjtn000, true);
          jjtc000 = false;
      }
    } catch (Throwable jjte000) {
      if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {
          if (true) throw (RuntimeException) jjte000;
        }
      }
      if (jjte000 instanceof ParseException) {
        {
          if (true) throw (ParseException) jjte000;
        }
      }
      {
        if (true) throw (Error) jjte000;
      }
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
  }

  public final void copyOptionElement() throws ParseException {
    /*@bgen(jjtree) CopyOptionElement */
    ASTCopyOptionElement jjtn000 = new ASTCopyOptionElement(JJTCOPYOPTIONELEMENT);
    boolean jjtc000 = true;
    jjtree.openNodeScope(jjtn000);
    try {
      switch ((jj_ntk == -1) ? jj_ntk_f() : jj_ntk) {
        case O_FORMAT:
          {
            jj_consume_token(O_FORMAT);
            formatType();
            jjtree.closeNodeScope(jjtn000, true);
            jjtc000 = false;
            jjtn000.setName("FORMAT");
            break;
          }
        case O_BINARY:
        case O_CSV:
        case O_TEXT:
          {
            formatType();
            jjtree.closeNodeScope(jjtn000, true);
            jjtc000 = false;
            jjtn000.setName("FORMAT");
            break;
          }
        case O_FREEZE:
          {
            jj_consume_token(O_FREEZE);
            jjtree.closeNodeScope(jjtn000, true);
            jjtc000 = false;
            jjtn000.setName("FREEZE");
            {
              if (true) throw new ParseException("FREEZE is not supported.");
            }
            break;
          }
        case O_DELIMITER:
          {
            jj_consume_token(O_DELIMITER);
            singleChar();
            jjtree.closeNodeScope(jjtn000, true);
            jjtc000 = false;
            jjtn000.setName("DELIMITER");
            break;
          }
        case O_NULL:
          {
            jj_consume_token(O_NULL);
            quotedIdentifier();
            jjtree.closeNodeScope(jjtn000, true);
            jjtc000 = false;
            jjtn000.setName("NULL");
            break;
          }
        case O_HEADER:
          {
            jj_consume_token(O_HEADER);
            booleanOption();
            jjtree.closeNodeScope(jjtn000, true);
            jjtc000 = false;
            jjtn000.setName("HEADER");
            break;
          }
        case O_QUOTE:
          {
            jj_consume_token(O_QUOTE);
            singleChar();
            jjtree.closeNodeScope(jjtn000, true);
            jjtc000 = false;
            jjtn000.setName("QUOTE");
            break;
          }
        case O_ESCAPE:
          {
            jj_consume_token(O_ESCAPE);
            singleChar();
            jjtree.closeNodeScope(jjtn000, true);
            jjtc000 = false;
            jjtn000.setName("ESCAPE");
            break;
          }
        default:
          jj_la1[5] = jj_gen;
          if (jj_2_4(3)) {
            jj_consume_token(O_FORCE_QUOTE);
            jj_consume_token(41);
            columnList();
            jj_consume_token(42);
            jjtree.closeNodeScope(jjtn000, true);
            jjtc000 = false;
            jjtn000.setName("FORCE_QUOTE");
            {
              if (true) throw new ParseException("FORCE_QUOTE is not supported.");
            }
          } else if (jj_2_5(3)) {
            jj_consume_token(O_FORCE_NOT_NULL);
            jj_consume_token(41);
            columnList();
            jj_consume_token(42);
            jjtree.closeNodeScope(jjtn000, true);
            jjtc000 = false;
            jjtn000.setName("FORCE_NOT_NULL");
            {
              if (true) throw new ParseException("FORCE_NOT_NULL is not supported.");
            }
          } else if (jj_2_6(3)) {
            jj_consume_token(O_FORCE_NULL);
            jj_consume_token(41);
            columnList();
            jj_consume_token(42);
            jjtree.closeNodeScope(jjtn000, true);
            jjtc000 = false;
            jjtn000.setName("FORCE_NULL");
            {
              if (true) throw new ParseException("FORCE_NULL is not supported.");
            }
          } else {
            switch ((jj_ntk == -1) ? jj_ntk_f() : jj_ntk) {
              case O_ENCODING:
                {
                  jj_consume_token(O_ENCODING);
                  identifier();
                  jjtree.closeNodeScope(jjtn000, true);
                  jjtc000 = false;
                  jjtn000.setName("ENCODING");
                  {
                    if (true) throw new ParseException("ENCODING is not supported.");
                  }
                  break;
                }
              default:
                jj_la1[6] = jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
            }
          }
      }
    } catch (Throwable jjte000) {
      if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {
          if (true) throw (RuntimeException) jjte000;
        }
      }
      if (jjte000 instanceof ParseException) {
        {
          if (true) throw (ParseException) jjte000;
        }
      }
      {
        if (true) throw (Error) jjte000;
      }
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
  }

  public final void formatType() throws ParseException {
    /*@bgen(jjtree) FormatType */
    ASTFormatType jjtn000 = new ASTFormatType(JJTFORMATTYPE);
    boolean jjtc000 = true;
    jjtree.openNodeScope(jjtn000);
    try {
      switch ((jj_ntk == -1) ? jj_ntk_f() : jj_ntk) {
        case O_TEXT:
          {
            jj_consume_token(O_TEXT);
            jjtree.closeNodeScope(jjtn000, true);
            jjtc000 = false;
            jjtn000.setFormat("TEXT");
            break;
          }
        case O_BINARY:
          {
            jj_consume_token(O_BINARY);
            jjtree.closeNodeScope(jjtn000, true);
            jjtc000 = false;
            jjtn000.setFormat("BINARY");
            break;
          }
        case O_CSV:
          {
            jj_consume_token(O_CSV);
            jjtree.closeNodeScope(jjtn000, true);
            jjtc000 = false;
            jjtn000.setFormat("CSV");
            break;
          }
        default:
          jj_la1[7] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
      }
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
  }

  /** An Identifier. */
  public final void identifier() throws ParseException {
    /*@bgen(jjtree) ID */
    ASTID jjtn000 = new ASTID(JJTID);
    boolean jjtc000 = true;
    jjtree.openNodeScope(jjtn000);
    Token t;
    try {
      t = jj_consume_token(IDENTIFIER);
      jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
      jjtn000.setName(t.image);
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
  }

  public final void quotedIdentifier() throws ParseException {
    /*@bgen(jjtree) ID */
    ASTID jjtn000 = new ASTID(JJTID);
    boolean jjtc000 = true;
    jjtree.openNodeScope(jjtn000);
    Token t;
    try {
      t = jj_consume_token(QUOTED_IDENTIFIER);
      jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
      jjtn000.setName(t.image);
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
  }

  public final void singleChar() throws ParseException {
    /*@bgen(jjtree) SingleChar */
    ASTSingleChar jjtn000 = new ASTSingleChar(JJTSINGLECHAR);
    boolean jjtc000 = true;
    jjtree.openNodeScope(jjtn000);
    Token t;
    try {
      t = jj_consume_token(QUOTED_CHAR);
      jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
      jjtn000.setChar(t.image.charAt(1));
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
  }

  public final void booleanOption() throws ParseException {
    /*@bgen(jjtree) Boolean */
    ASTBoolean jjtn000 = new ASTBoolean(JJTBOOLEAN);
    boolean jjtc000 = true;
    jjtree.openNodeScope(jjtn000);
    try {
      switch ((jj_ntk == -1) ? jj_ntk_f() : jj_ntk) {
        case O_TRUE:
          {
            jj_consume_token(O_TRUE);
            jjtree.closeNodeScope(jjtn000, true);
            jjtc000 = false;
            jjtn000.setBool(true);
            break;
          }
        case O_FALSE:
          {
            jj_consume_token(O_FALSE);
            jjtree.closeNodeScope(jjtn000, true);
            jjtc000 = false;
            jjtn000.setBool(false);
            break;
          }
        default:
          jj_la1[8] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
      }
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
  }

  private boolean jj_2_1(int xla) {
    jj_la = xla;
    jj_lastpos = jj_scanpos = token;
    try {
      return (!jj_3_1());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(0, xla);
    }
  }

  private boolean jj_2_2(int xla) {
    jj_la = xla;
    jj_lastpos = jj_scanpos = token;
    try {
      return (!jj_3_2());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(1, xla);
    }
  }

  private boolean jj_2_3(int xla) {
    jj_la = xla;
    jj_lastpos = jj_scanpos = token;
    try {
      return (!jj_3_3());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(2, xla);
    }
  }

  private boolean jj_2_4(int xla) {
    jj_la = xla;
    jj_lastpos = jj_scanpos = token;
    try {
      return (!jj_3_4());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(3, xla);
    }
  }

  private boolean jj_2_5(int xla) {
    jj_la = xla;
    jj_lastpos = jj_scanpos = token;
    try {
      return (!jj_3_5());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(4, xla);
    }
  }

  private boolean jj_2_6(int xla) {
    jj_la = xla;
    jj_lastpos = jj_scanpos = token;
    try {
      return (!jj_3_6());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(5, xla);
    }
  }

  private boolean jj_3_6() {
    if (jj_scan_token(O_FORCE_NULL)) return true;
    if (jj_scan_token(41)) return true;
    if (jj_3R_columnList_134_3_1()) return true;
    return false;
  }

  private boolean jj_3_3() {
    if (jj_scan_token(41)) return true;
    if (jj_3R_copyOptionList_188_3_3()) return true;
    if (jj_scan_token(42)) return true;
    return false;
  }

  private boolean jj_3R_columnList_134_3_1() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_2()) {
      jj_scanpos = xsp;
      if (jj_3R_columnList_136_5_4()) return true;
    }
    return false;
  }

  private boolean jj_3_2() {
    if (jj_3R_columnElem_145_3_2()) return true;
    if (jj_scan_token(K_COMMA)) return true;
    return false;
  }

  private boolean jj_3_5() {
    if (jj_scan_token(O_FORCE_NOT_NULL)) return true;
    if (jj_scan_token(41)) return true;
    if (jj_3R_columnList_134_3_1()) return true;
    return false;
  }

  private boolean jj_3_4() {
    if (jj_scan_token(O_FORCE_QUOTE)) return true;
    if (jj_scan_token(41)) return true;
    if (jj_3R_columnList_134_3_1()) return true;
    return false;
  }

  private boolean jj_3_1() {
    if (jj_scan_token(41)) return true;
    if (jj_3R_columnList_134_3_1()) return true;
    return false;
  }

  private boolean jj_3R_copyOptionElement_216_5_15() {
    if (jj_scan_token(O_ESCAPE)) return true;
    return false;
  }

  private boolean jj_3R_copyOptionElement_213_5_14() {
    if (jj_scan_token(O_QUOTE)) return true;
    return false;
  }

  private boolean jj_3R_copyOptionElement_210_5_13() {
    if (jj_scan_token(O_HEADER)) return true;
    return false;
  }

  private boolean jj_3R_copyOptionElement_207_5_12() {
    if (jj_scan_token(O_NULL)) return true;
    return false;
  }

  private boolean jj_3R_copyOptionElement_204_5_11() {
    if (jj_scan_token(O_DELIMITER)) return true;
    return false;
  }

  private boolean jj_3R_formatType_248_5_20() {
    if (jj_scan_token(O_CSV)) return true;
    return false;
  }

  private boolean jj_3R_copyOptionElement_200_5_10() {
    if (jj_scan_token(O_FREEZE)) return true;
    return false;
  }

  private boolean jj_3R_formatType_245_5_19() {
    if (jj_scan_token(O_BINARY)) return true;
    return false;
  }

  private boolean jj_3R_copyOptionElement_197_5_9() {
    if (jj_3R_formatType_242_5_17()) return true;
    return false;
  }

  private boolean jj_3R_formatType_242_5_18() {
    if (jj_scan_token(O_TEXT)) return true;
    return false;
  }

  private boolean jj_3R_formatType_242_5_17() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_formatType_242_5_18()) {
      jj_scanpos = xsp;
      if (jj_3R_formatType_245_5_19()) {
        jj_scanpos = xsp;
        if (jj_3R_formatType_248_5_20()) return true;
      }
    }
    return false;
  }

  private boolean jj_3R_copyOptionElement_194_5_7() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_copyOptionElement_194_5_8()) {
      jj_scanpos = xsp;
      if (jj_3R_copyOptionElement_197_5_9()) {
        jj_scanpos = xsp;
        if (jj_3R_copyOptionElement_200_5_10()) {
          jj_scanpos = xsp;
          if (jj_3R_copyOptionElement_204_5_11()) {
            jj_scanpos = xsp;
            if (jj_3R_copyOptionElement_207_5_12()) {
              jj_scanpos = xsp;
              if (jj_3R_copyOptionElement_210_5_13()) {
                jj_scanpos = xsp;
                if (jj_3R_copyOptionElement_213_5_14()) {
                  jj_scanpos = xsp;
                  if (jj_3R_copyOptionElement_216_5_15()) {
                    jj_scanpos = xsp;
                    if (jj_3_4()) {
                      jj_scanpos = xsp;
                      if (jj_3_5()) {
                        jj_scanpos = xsp;
                        if (jj_3_6()) {
                          jj_scanpos = xsp;
                          if (jj_3R_copyOptionElement_234_5_16()) return true;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return false;
  }

  private boolean jj_3R_copyOptionElement_194_5_8() {
    if (jj_scan_token(O_FORMAT)) return true;
    return false;
  }

  private boolean jj_3R_columnElem_145_3_2() {
    if (jj_scan_token(IDENTIFIER)) return true;
    return false;
  }

  private boolean jj_3R_copyOptionList_190_5_6() {
    return false;
  }

  private boolean jj_3R_copyOptionElement_234_5_16() {
    if (jj_scan_token(O_ENCODING)) return true;
    return false;
  }

  private boolean jj_3R_copyOptionList_188_3_3() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_copyOptionList_188_3_5()) {
      jj_scanpos = xsp;
      if (jj_3R_copyOptionList_190_5_6()) return true;
    }
    return false;
  }

  private boolean jj_3R_copyOptionList_188_3_5() {
    if (jj_3R_copyOptionElement_194_5_7()) return true;
    return false;
  }

  private boolean jj_3R_columnList_136_5_4() {
    if (jj_3R_columnElem_145_3_2()) return true;
    return false;
  }

  /** Generated Token Manager. */
  public CopyTokenManager token_source;

  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;

  private int jj_ntk;
  private Token jj_scanpos, jj_lastpos;
  private int jj_la;
  private int jj_gen;
  private final int[] jj_la1 = new int[9];
  private static int[] jj_la1_0;
  private static int[] jj_la1_1;

  static {
    jj_la1_init_0();
    jj_la1_init_1();
  }

  private static void jj_la1_init_0() {
    jj_la1_0 =
        new int[] {
          0x0, 0x600, 0x180, 0x1000, 0x3fff0000, 0x3ff0000, 0x20000000, 0x70000, 0xc0000000,
        };
  }

  private static void jj_la1_init_1() {
    jj_la1_1 =
        new int[] {
          0x2, 0x0, 0x2, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0,
        };
  }

  private final JJCalls[] jj_2_rtns = new JJCalls[6];
  private boolean jj_rescan = false;
  private int jj_gc = 0;

  /** Constructor with InputStream. */
  public Copy(java.io.InputStream stream) {
    this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Copy(java.io.InputStream stream, String encoding) {
    try {
      jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1);
    } catch (java.io.UnsupportedEncodingException e) {
      throw new RuntimeException(e);
    }
    token_source = new CopyTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 9; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
    ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try {
      jj_input_stream.ReInit(stream, encoding, 1, 1);
    } catch (java.io.UnsupportedEncodingException e) {
      throw new RuntimeException(e);
    }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 9; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public Copy(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new CopyTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 9; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    if (jj_input_stream == null) {
      jj_input_stream = new SimpleCharStream(stream, 1, 1);
    } else {
      jj_input_stream.ReInit(stream, 1, 1);
    }
    if (token_source == null) {
      token_source = new CopyTokenManager(jj_input_stream);
    }

    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 9; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public Copy(CopyTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 9; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(CopyTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 9; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  @SuppressWarnings("serial")
  private static final class LookaheadSuccess extends java.lang.Error {
    @Override
    public Throwable fillInStackTrace() {
      return this;
    }
  }

  private static final LookaheadSuccess jj_ls = new LookaheadSuccess();

  private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0;
      Token tok = token;
      while (tok != null && tok != jj_scanpos) {
        i++;
        tok = tok.next;
      }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }

  /** Get the next Token. */
  public final Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

  /** Get the specific Token. */
  public final Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk_f() {
    if ((jj_nt = token.next) == null)
      return (jj_ntk = (token.next = token_source.getNextToken()).kind);
    else return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;
  private int[] jj_lasttokens = new int[100];
  private int jj_endpos;

  private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) {
      return;
    }

    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];

      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }

      for (int[] oldentry : jj_expentries) {
        if (oldentry.length == jj_expentry.length) {
          boolean isMatched = true;

          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              isMatched = false;
              break;
            }
          }
          if (isMatched) {
            jj_expentries.add(jj_expentry);
            break;
          }
        }
      }

      if (pos != 0) {
        jj_lasttokens[(jj_endpos = pos) - 1] = kind;
      }
    }
  }

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[43];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 9; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1 << j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1 << j)) != 0) {
            la1tokens[32 + j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 43; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  private boolean trace_enabled;

  /** Trace enabled. */
  public final boolean trace_enabled() {
    return trace_enabled;
  }

  /** Enable tracing. */
  public final void enable_tracing() {}

  /** Disable tracing. */
  public final void disable_tracing() {}

  private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 6; i++) {
      try {
        JJCalls p = jj_2_rtns[i];

        do {
          if (p.gen > jj_gen) {
            jj_la = p.arg;
            jj_lastpos = jj_scanpos = p.first;
            switch (i) {
              case 0:
                jj_3_1();
                break;
              case 1:
                jj_3_2();
                break;
              case 2:
                jj_3_3();
                break;
              case 3:
                jj_3_4();
                break;
              case 4:
                jj_3_5();
                break;
              case 5:
                jj_3_6();
                break;
            }
          }
          p = p.next;
        } while (p != null);

      } catch (LookaheadSuccess ls) {
      }
    }
    jj_rescan = false;
  }

  private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) {
        p = p.next = new JJCalls();
        break;
      }
      p = p.next;
    }

    p.gen = jj_gen + xla - jj_la;
    p.first = token;
    p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }
}