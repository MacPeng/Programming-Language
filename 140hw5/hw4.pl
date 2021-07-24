% question 1
shuffle([], [], []).
shuffle([X|Xs], [Y|Ys], [X,Y|Z]) :- shuffle(Xs,Ys,Z).








