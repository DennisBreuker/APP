grammar Expressions;

start : expression; // to remove "no viable alternative at input '<EOF>'"

expression : INT
    | expression KEER expression
    | expression PLUS expression;

INT : [0-9]+;
KEER : '*';
PLUS: '+';
WS : [ \t\r\n]+ -> skip;