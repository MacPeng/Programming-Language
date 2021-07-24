% question 1
shuffle([], [], []).
shuffle([X|Xs], [Y|Ys], [X,Y|Z]) :- shuffle(Xs,Ys,Z).



% question 2
double([],[]).
double([X|T],[X,X|HT]) :- double(T,HT).




%question 3
members(X, [X|_]).
members(X, [_|T]):- members(X,T).

no_duplicates([Y|[]],[Y|[]]).
no_duplicates([A|B],C) :- members(A,B), no_duplicates(B,C).
no_duplicates([D|E],[D|[F|G]]) :-  \+ members(D,E), no_duplicates(E,[F|G]).



% question 4
deletes(X,[X|Xs],Xs).
deletes(X,[Y|Ys],[Y|Z]) :- deletes(X,Ys,Z).

same_elements([],[]).
same_elements([X|Xs],Ys) :- same_elements(Xs,Zs), deletes(X,Ys,Zs).

