% question 1
shuffle([], [], []).
shuffle([X|Xs], [Y|Ys], [X,Y|Zs]) :- shuffle(Xs,Ys,Zs).



% question 2
double([],[]).
double([I|T],[I,I|HT]) :- double(T,HT).


%question 3
no_duplicates([A0|[]],[A0|[]]).
no_duplicates([E1|F1],G1) :- member(E1,F1), no_duplicates(F1,G1).
no_duplicates([A1|B1],[A1|[D1|H1]]) :- \+ member(A1,B1), no_duplicates(B1,[D1|H1]).


% question 4
full_members([],[],_).
full_members([S1|T1],[T2|T3],T5) :-member(S1,T5), full_members(T1,T3,T5), append(_,[T2|T3],T5).
same_elements(A4,Z4) :- full_members(Z4,A4,A4), full_members(A4,Z4,Z4).

