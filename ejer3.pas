program netflix;
const
  df=8;
type
  sub= 1..8;
  peliGuardar = record
    codP:integer;
    puntajeC: real;
  end;
  peliculas = record 
    dato: peliGuardar;
    codG: sub;
  end;
  lista = ^nodo;
  nodo = record
	ele:peliGuardar;
	sig:lista;
  end;
  
   punteros = record
	l,ult:lista;
  end;
  vectorPunt = array[1..df] of punteros;
  maximos = record
	codM:integer;
	puntM: real;
  end;
  vector2=array[1..df]of maximos;
  
procedure agregarAtras(var l,ult:lista;p:peliGuardar);
var
  nuevo:lista;
begin 
  new(nuevo); nuevo^.ele:=p; nuevo^.sig:=nil;
  if(l=nil)then begin 
    l:=nuevo; ult:=nuevo;
  end
  else begin 
    ult^.sig:=nuevo; ult:=nuevo;
  end;
end;
procedure cargarReg(var p:peliculas);
begin
  readln(p.dato.codP); 
  if(p.dato.codP <> -1) then begin 
    writeln('genero '); readln(p.codG); writeln('puntaje promedio '); readln(p.dato.puntajeC);
  end;
end;
procedure inicializacion(var v:vectorPunt);
var 
  i:integer;
begin
  for i:=1 to df do v[i].l:=nil;
end;
procedure cargar(var v:vectorPunt);
var
  p:peliculas;
begin
  inicializacion(v);
  cargarReg(p);
  while(p.dato.codP <> -1)do begin
    agregarAtras(v[p.codG].l,v[p.codG].ult, p.dato);
    cargarReg(p);
  end;
end;
procedure inicializacionVector(var v2:vector2);
var i:integer;
begin
  for i:=1 to df do v2[i].puntM:=-1;
end;
procedure nuevoVector(v:vectorPunt; var v2:vector2);
var
  i:integer;
  l:lista;
begin
  inicializacionVector(v2);
  for i:=1 to df do begin
    l:=v[i].l;
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
  v:vectorPunt;
  v2:vector2;
begin
  cargar(v);
  nuevoVector(v,v2);
  ordenar(v2);
  mayorYmenor(v2); 
end.
