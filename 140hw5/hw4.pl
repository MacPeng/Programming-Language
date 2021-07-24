% question 1
shuffle([], [], []).
shuffle([X|Xs], [Y|Ys], [X,Y|Z]) :- shuffle(Xs,Ys,Z).





%question 3
members(X, [X|_]).
members(X, [_|T]):- members(X,T).

no_duplicates([Y|[]],[Y|[]]).
no_duplicates([A|B],C) :- members(A,B), no_duplicates(B,C).
no_duplicates([D|E],[D|[F|G]]) :-  \+ members(D,E), no_duplicates(E,[F|G]).


