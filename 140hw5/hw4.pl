same_elements([],[]).
same_elements([X|Xs],Ys) :- same_elements(Xs,Zs), deletes(X,Ys,Zs).




no_duplicates([Y|[]],[Y|[]]).
no_duplicates([A|B],C) :- members(A,B), no_duplicates(B,C).
no_duplicates([D|E],[D|[F|G]]) :-  \+ members(D,E), no_duplicates(E,[F|G]).

