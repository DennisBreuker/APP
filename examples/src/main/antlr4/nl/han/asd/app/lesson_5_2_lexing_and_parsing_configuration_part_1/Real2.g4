grammar Real2;

POSITIEF_GETAL: [1-9][0-9]*;
NEGATIEF_GETAL: '-' POSITIEF_GETAL;
NUL: '0';
WS: [ \t\r\n]+ -> skip;

real: getal;
getal: POSITIEF_GETAL
        | NEGATIEF_GETAL
        | NUL
        | positief_kommagetal
        | negatief_kommagetal;
positief_kommagetal: POSITIEF_GETAL ',' '0'* POSITIEF_GETAL;
negatief_kommagetal: NEGATIEF_GETAL ',' '0'* POSITIEF_GETAL;

// hier is geen wetenschappelijke notatie mogelijk