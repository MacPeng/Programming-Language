same_elements([],[]).
same_elements([X|Xs],Ys) :- same_elements(Xs,Zs), deletes(X,Ys,Zs).

