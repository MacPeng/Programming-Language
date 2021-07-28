

no_duplicates([Y|[]],[Y|[]]).
no_duplicates([A|B],C) :- members(A,B), no_duplicates(B,C).
no_duplicates([D|E],[D|[F|G]]) :-  \+ members(D,E), no_duplicates(E,[F|G]).



% question 4
deletes(X,[X|Xs],Xs).
deletes(X,[Y|Ys],[Y|Z]) :- deletes(X,Ys,Z).

same_elements([],[]).
same_elements([X|Xs],Ys) :- same_elements(Xs,Zs), deletes(X,Ys,Zs).

