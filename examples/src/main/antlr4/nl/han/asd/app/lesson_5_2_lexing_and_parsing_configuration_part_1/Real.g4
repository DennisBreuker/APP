grammar Real;

GETAL_ZONDER_VOORLOOPNUL: [1-9][0-9]*;
WS: [ \t\r\n]+ -> skip;

real: getal;
getal: geheel_getal | kommagetal;
geheel_getal: '-'? (GETAL_ZONDER_VOORLOOPNUL | '0');
kommagetal: geheel_getal ',' '0'* GETAL_ZONDER_VOORLOOPNUL;
