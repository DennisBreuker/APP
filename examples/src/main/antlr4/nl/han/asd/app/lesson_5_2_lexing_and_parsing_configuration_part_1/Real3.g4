grammar Real3;

DIGIT: [0-9];
WS: [ \t\r\n]+ -> skip;

real: (fraction | integer) exponent?;
fraction: integer '.' pos_integer;
integer: neg_integer | pos_integer;
neg_integer: '-' pos_integer;
pos_integer: DIGIT+;
exponent: ('e' | 'E') integer;

// hier zijn nog voorloop- en naloopnullen mogelijk: 01 en 1.200