grammar APascalet;

NUM: [0-9]+;
PLUS: '+';

expression:
NUM PLUS NUM        # Add
;