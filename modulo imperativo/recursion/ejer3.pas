program ejer3;
const
  df=20;
type
  vector = array[1..df] of integer;
procedure cargarV(var v:vector;var dl:integer);
var num: integer;
begin 
  num:=random(1251)+300;
  if(dl<df)then begin 
    dl:=dl+1;
    v[dl]:=num;
	cargarV(v,dl);
  end;
end;
procedure insercion(var v:vector;dl:integer);
var i,j,actual:integer;
begin 
  for i:=2 to dl do begin
    actual:=v[i]; j:=i-1;
	while((j>0)and(v[j]>actual)) do begin 
	  v[j+1]:=v[j]; j:=j-1;
	end;
	v[j+1]:=actual;
  end;
end;
procedure imprimirV(v:vector;dl:integer);
var i:integer;
begin
  for i:=1 to dl do writeln(v[i]); 
end;
var
  v:vector;
  dl:integer;
begin 
  randomize();
  dl:=0;
  cargarV(v,dl);
  writeln('VECTOR SIN ORDENAR ');
  imprimirV(v,dl);
  insercion(v,dl);
  writeln('VECTOR ORDENADO ');
  imprimirV(v,dl);
end.
