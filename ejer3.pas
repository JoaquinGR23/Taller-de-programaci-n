program netflix;
const
  df=8;
type
  sub= 1..8;
  peliculas =record 
    codP:integer;
    codG: sub;
    puntajeC: real;
  end;
  lista = ^nodo;
  nodo = record
	ele:peliculas;
	sig:lista;
  end;
  maximos = record
	codM:integer;
	puntM: real;
  end;
  vector= array[1..df] of lista;
  vector2=array[1..df]of maximos;
procedure agregarAtras(var l:lista;p:peliculas);
var
  nuevo,aux:lista;
begin 
  new(nuevo); nuevo^.ele:= p; nuevo^.sig:=nil;
  if(l=nil) then l:=nuevo
  else begin
    aux:=l;
    while(aux^.sig<>l) do l:=l^.sig;
    aux^.sig:=nuevo; 
  end;
end;
procedure cargarReg(var p:peliculas);
begin
  readln(p.codP); 
  if(p.codP <> -1) then begin 
    writeln('genero '); readln(p.codG); writeln('puntaje promedio '); readln(p.puntajeC);
  end;
end;
procedure inicializacion(var v:vector);
var 
  i:integer;
begin
  for i:=1 to df do v[i]:=nil;
end;
procedure cargar(var v:vector);
var
  p:peliculas;
begin
  inicializacion(v);
  cargarReg(p);
  while(p.codP <> -1)do begin
    agregarAtras(v[p.codG], p);
    cargarReg(p);
  end;
end;
procedure inicializacionVector(var v2:vector2);
var i:integer;
begin
  for i:=1 to df do v2[i].codM:=-1;
end;
procedure nuevoVector(v:vector; var v2:vector2);
var
  i:integer;
  l:lista;
begin
  inicializacionVector(v2);
  for i:=1 to df do begin
    l:=v[i];
    while(l<>nil) do begin 
	  if(v2[i].puntM<l^.ele.puntajeC) then begin 
	    v2[i].puntM:= l^.ele.puntajeC; 
	    v2[i].codM:=l^.ele.codP;
	  end;
	  l:=l^.sig;
	end;
  end;
end;
procedure ordenar(var v:vector2);
var
  i,j:integer;
  max:maximos;
begin
  for i:=2 to df do begin
	j:=i-1; max:=v[i];
	while((j>0)and(max.puntM<v[j].puntM)) do begin
	  v[j+1]:=v[j]; j:=j-1; 
	end;
	v[j+1]:=max;
  end;
end;
procedure mayorYmenor(v:vector2);
begin
  writeln('minimo ',v[1].codM); writeln('maximo ', v[df].codM);
end;
var
  v:vector;
  v2:vector2;
begin
  cargar(v);
  nuevoVector(v,v2);
  ordenar(v2);
  mayorYmenor(v2); 
end.
