grammar Configuration;

properties: property+;
property: ID '=' value;
value: INT | STRING;

ID: [a-zA-Z]+ ;
STRING: '"' .*? '"';
INT: [0-9]+ ;
WS: [ \t\r\n]+ -> skip ;
