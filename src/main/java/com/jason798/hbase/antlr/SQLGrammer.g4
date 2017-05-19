grammar SQLGrammer;

prog : selectSql  # selectSqlStmt
     | deleteSql  # deleteSqlStmt
     | updateSql  # updateSqlStmt
     ;

// select stmt
selectSql : SELECT columnList FROM table_name ( wherec )? rowkeyrange ( maxversionexp)? (tsrange)? (limitexp)?
	       ;
// deleteOne stmt
deleteSql : DELETE columnList FROM table_name ( wherec )? rowkeyrange ( TS IS tsexp )?
	       ;	       

//update stmt
updateSql : UPDATE table_name SET assignList specrowkey
           ;
// update set
assignList : column_name EQ values ( ',' column_name EQ values )* ;

// generate condition
wherec : WHERE conditionc ;

conditionc : LB conditionc RB              # conditionwrapper
	|conditionc AND conditionc            # andcondition
	|conditionc OR conditionc             # orcondition
	|column_name EQUAL constant                   # equalconstant
	|column_name EQUAL var                        # equalvar
	|column_name LESS constant                    # lessconstant
	|column_name LESS var                         # lessvar
	|column_name GREATER constant                 # greaterconstant
	|column_name GREATER var                      # greatervar
	|column_name LESSEQUAL constant               # lessequalconstant
	|column_name LESSEQUAL var                    # lessequalvar
	|column_name GREATEREQUAL constant            # greaterequalconstant
	|column_name GREATEREQUAL var                 # greaterequalvar
	|column_name NOTEQUAL constant                # notequalconstant
	|column_name NOTEQUAL var                     # notequalvar
	|column_name NOTMATCH constant                # notmatchconstant
	|column_name NOTMATCH var                     # notmatchvar
	|column_name MATCH constant                   # matchconstant
	|column_name MATCH var                        # matchvar
	|column_name IN constantList                  # inconstantlist
	|column_name IN var                           # invarlist
	|column_name NOTIN constantList               # notinconstantlist
	|column_name NOTIN var                        # notinvarlist
	|column_name BETWEEN constant AND constant    # betweenconstant
	|column_name BETWEEN var AND var              # betweenvar
	|column_name NOTBETWEEN constant AND constant # notbetweenconstant
	|column_name NOTBETWEEN var AND var           # notbetweenvar
	|column_name ISNULL                           # isnullc
	|column_name ISNOTNULL                        # isnotnullc
	|column_name ISMISSING                        # ismissingc
	|column_name ISNOTMISSING                     # isnotmissingc
	;

// rowkey specified
specrowkey : ROWKEY IS rowkeyexp
           ;

// rowkey condition
rowkeyrange : STARTKEY IS rowkeyexp ',' ENDKEY IS rowkeyexp # rowkeyrangeSE
			| STARTKEY IS rowkeyexp                         # rowkeyrangeStart
            | ENDKEY IS rowkeyexp		                    # rowkeyrangeEnd
            | specrowkey			                        # rowkeyrangeOne
            | ROWKEY IN LB rowkeyexp ( ',' rowkeyexp )* RB  # rowkeyrangeSpec
			;

	
rowkeyexp : Data_Value ;//                        # rowkey_constant
//	| HBASESTARTKEY                             # rowkey_hbasestart
//	| HBASEENDKEY                               # rowkey_hbaseend
//    ;

//	| funcname LB constant RB                             # rowkey_FuncConstant
//  LB rowkeyexp RB                               # rowkey_Wrapper

tsrange : STARTTS IS tsexp ',' ENDTS IS  tsexp                   # tsrange_startAndEnd
		| STARTTS IS tsexp                                       # tsrange_start
		| ENDTS IS tsexp                                         # tsrange_end
	    ;
		
tsexp: constant ;

columnList : column_name (',' column_name) *    #columnListExt// cidList   # cidList_CidList
			  | STAR                            #columnListAll
			  | column_name                     #columnListOne
	     	  ;
	
//cidList : LB  RB ;
//cid : column_name ;

funcname: column_name ;
	
constantList  : LB constant ( ',' constant) * RB ;
constant2List : LB constant2 ( ',' constant2) * RB ;

constant2: constant               # constant2_NotNull
         | NULL                   # constant2_Null
		 ;
		 
maxversionexp : MAXVERSION maxversion ;

// limit 100 ;  limit 10,1000
limitexp : LIMIT POSITIVE //column_name ( ',' column_name)?
		 ;


maxversion : column_name ;

constant: '"' column_name '"';
//constant: '"' TEXT '"' ;
//    #constan_double_quote
//        | '\'' TEXTINPUT '\'' #constant_single_quote;
var : '#' column_name '#' ;


//keywords
SELECT : 'select' | 'SELECT' ;
UPDATE : 'update' | 'UPDATE' ;
//INSERT : 'insert' | 'INSERT' ;
DELETE : 'delete' | 'DELETE' ;

FROM   : 'from'  | 'FROM' ;
WHERE  : 'where' | 'WHERE' ;

STAR : '*' ;

LB : '(' ;
RB : ')' ;

SET : 'set' | 'SET' ;

ROWKEY   : 'rowkey' | 'ROWKEY' ;
STARTKEY : 'startkey' | 'STARTKEY' ;
ENDKEY   : 'endkey' | 'ENDKEY' ;

MAXVERSION    : 'maxversion' ;

LIMIT : 'limit' POSITIVE (',' POSITIVE )? ;

//COUNT  : 'count' | 'COUNT' ;
//COUNTSUM  : 'countsum' ;
//INTO   : 'into' ;
//VALUES : 'values' ;
//HBASESTARTKEY : 'hbasestartkey';
//HBASEENDKEY   : 'hbaseendkey';

TS :           'ts' | 'TS' ;
STARTTS : 'startTS' | 'STARTTS' ;
ENDTS :    'endTS'  | 'ENDTS' ;

IS      : 'is'  | 'IS' ;
NULL    : 'null'| 'NULL' ;
NOT     : 'not' | 'NOT' ;

AND : 'and' | 'AND' ;
OR : 'or' | 'OR' ;
EQ : '=' ;

LESSEQUAL : 'lessequal' ;
LESS : 'less' ;

GREATEREQUAL : 'greaterequal';
GREATER: 'greater' ;

NOTEQUAL : 'notequal' ;
EQUAL : 'equal' ;

NOTMATCH : 'notmatch' ;
MATCH : 'match' ;

IN : 'in' ;
NOTIN : 'notin' ;

BETWEEN : 'between' ;
NOTBETWEEN : 'notbetween' ;

ISNULL : 'isnull' ;
ISNOTNULL : 'isnotnull' ;

ISMISSING : 'ismissing' ;
ISNOTMISSING : 'isnotmissing' ;

Double_Quote                    : '"';
Quote                           : '\'';
Underscore                      : '_';
Period                          : '.';

//numbers
//1~Integer.MAX
POSITIVE : [1-9]+[0-9]* ;
//0~Integer.MAX
NATURAL : [0-9]+ ;


table_name                      : Regular_Identifier;//NonDoubleQuote_Character;//identifier;//basic_identifier_chain;
column_name                     : Regular_Identifier;//NonDoubleQuote_Character;//identifier;
values                          : Data_Value;

//basic_identifier_chain          : identifier_chain;
//identifier_chain                : identifier ((Period identifier))*;
//identifier                      : Regular_Identifier    #regular_identifer
//                                | Delimited_Identifier  #delimited_identifer
//                                ;
// 标示符， _或字母开头 + 字母/数字/下划线
Regular_Identifier              : Identifier_Body;

//Delimited_Identifier            : Double_Quote Delimited_Identifier_Body Double_Quote;
// 值， "任何内容，包括转义"
Data_Value                      : Double_Quote (ESC|.)*? Double_Quote ;

fragment
DoubleQuote_Symbol          : '""';
fragment
Identifier_Body             : Identifier_Start (Identifier_Part)*;
fragment
Identifier_Part             : Identifier_Start | Identifier_Extend;
fragment
Simple_Latin_Letter			: Simple_Latin_Upper_Case_Letter | Simple_Latin_Lower_Case_Letter;
fragment
Identifier_Start            : Underscore | Simple_Latin_Letter; // !! See the Syntax Rules
fragment
Identifier_Extend           : Simple_Latin_Letter | Digit | Underscore; // !! See the Syntax Rules
fragment
ESC                         : '\\"' | '\\\\';

fragment
Digit : [0-9];
fragment
Simple_Latin_Upper_Case_Letter : [A-Z];
fragment
Simple_Latin_Lower_Case_Letter : [a-z];


fragment
Delimited_Identifier_Body   : Delimited_Identifier_Part;
fragment
Delimited_Identifier_Part   : NonDoubleQuote_Character | DoubleQuote_Symbol;
fragment
NonDoubleQuote_Character : Unicode_Character_Without_Quotes;



fragment
Unicode_Character_Without_Quotes    : Basic_Latin_Without_Quotes
                                    | '\u00A0' .. '\uFFFF';
fragment
Basic_Latin_Without_Quotes          : ' ' .. '!' | '#' .. '&' | '(' .. '~';
fragment
Extended_Latin_Without_Quotes       : '\u0001' .. '!' | '#' .. '&' | '(' .. '\u00FF';


//TEXTNOSIGN : [a-zA-Z0-9_]+ ;
//TEXTINPUT : [a-zA-Z0-9_]+ ;
//TEXT : [a-zA-Z0-9_:\<\(\[\{\\\^\-\=\$\!\|\]\}\)\?\*\+\.\>]+ ;

WS : [ \t\r\n]+ -> skip ; // toss out whitespace


//INPUTSTRING : Double_Quote .*? Double_Quote;