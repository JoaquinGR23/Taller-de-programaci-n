{  -----------------------------------------VECTOR RECURSIÓN------------------------------------------- }

{  -----------------------------------------LISTA RECURSIÓN------------------------------------------- }

{  -----------------------------------------ÁRBOL------------------------------------------- }
----------CONTADOR DE NODOS EN RANGO QUE SUPERAN A UN VALOR X------------



{  -----------------------------------------VECTOR ELIMINAR ELEMENTOS EN RANGO------------------------------------------- }
program ejemplo;

type
procedure EliminarRango(var v:vector;var dl:integer;cod1,cod2:integer);
var i,indiceIzq,indiceDer,salto:integer;
begin 
  i:=1;
  while((i<dl)and(v[i].cod<codIzq)) do i:=i+1
  indiceIzq:=i;
  while((i<dl)and(v[i].cod<=codDer)) do i:=i+1
  indiceDer:=i;
  
  salto:=indiceDer-indiceIzq;
  while((indiceIzq+salto)<=dl) do begin 
    v[indiceIzq]:=v[indiceIzq+salto];
    indiceIzq:=indiceIzq+1;
  end;
  dl:=dl-salto;
end;

var v:vector; cod1,cod2:integer;
begin 
  readln(cod1); readln(cod2);
  EliminarRango(v,dl,cod1,cod2); 
end.
