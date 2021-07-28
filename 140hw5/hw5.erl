-module(hw5).
-export([myelem/2]).
-export([myremoveduplicates/1]).
-export([myintersection/2]).
-export([myintersection_helper/3]).
-export([mylast/1]).
-export([myreverse/1]).
-export([myreverse_helper/2]).
-export([myreplaceall/3]).
-export([myreplaceall_helper/4]).




%Q1
myelem(_, []) -> false;
myelem(H, [H|_]) -> true;
myelem(H, [_|T]) -> myelem(H, T).


myremoveduplicates([]) -> [];
myremoveduplicates([H|[]]) -> [H];
myremoveduplicates([H|T]) -> 
    case myelem(H,T) of
    true -> myremoveduplicates(T);
    false -> [H]++myremoveduplicates(T) 
end.





%Q2
myintersection([], _) -> [];
myintersection(_, []) -> [];
myintersection(X, Y) -> myintersection_helper(X, Y, []).


myintersection_helper([], _, Z) -> Z;
myintersection_helper(X, Y, Z) -> [H | T] = X, 
    case (myelem(H, Y)) of
    true -> myintersection_helper(T, Y, Z ++ [H]);
    false -> myintersection_helper(T, Y, Z) 
end.





%Q3
mylast([]) -> [] ;
mylast([H|[]]) -> [H] ;
mylast([_|T]) -> mylast(T).





%Q4
myreverse(X) -> myreverse_helper(X, []).

myreverse_helper([], X) -> X;
myreverse_helper([H|T], X) -> myreverse_helper(T, [H|X]).




%Q5
myreplaceall(X, Y, Z) -> myreplaceall_helper(X, Y, Z, []).


myreplaceall_helper(_,_,[],Z) -> myreverse(Z);
myreplaceall_helper(X, Y, [Y|T], Z) -> myreplaceall_helper(X, Y, T, [X|Z]);
myreplaceall_helper(X, Y, [H|T], Z)  -> myreplaceall_helper(X, Y, T, [H|Z]).
