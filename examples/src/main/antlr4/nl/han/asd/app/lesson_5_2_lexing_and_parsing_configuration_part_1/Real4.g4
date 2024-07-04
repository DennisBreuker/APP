grammar Real4;

POS_DIGIT: [1-9];
ZERO: '0';
EXPONENT: [eE];
WS: [ \t\r\n]+ -> skip;

real: (fraction | integerWithoutLeadingZero) exponent? EOF;
fraction: integerWithoutLeadingZero '.' posIntegerWithoutEndingZero;
integerWithoutLeadingZero:
    negIntegerWithoutLeadingZero
    | posIntegerWithoutLeadingZero
    | ZERO;
negIntegerWithoutLeadingZero: '-' posIntegerWithoutLeadingZero;
posIntegerWithoutLeadingZero: POS_DIGIT digit*;
digit: ZERO | POS_DIGIT;
posIntegerWithoutEndingZero: digit* POS_DIGIT | ZERO;
exponent: EXPONENT integerWithoutLeadingZero;

// hier kan nog wel: -0