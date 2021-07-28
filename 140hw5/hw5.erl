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




