program netflix;
const
  df=8; 
type
  sub= 1..8;
  peliGuardar = record //REGISTRO QUE DEBE TENER LA LISTA
    codP:integer;
    puntajeC: real;
  end;
  peliculas = record 
    dato: peliGuardar;
    codG: sub;		//PARA ACCEDER A LA LISTA CORRESPONDIENTE EN EL VECTOR
  end;
  lista = ^nodo;
  nodo = record
	ele:peliGuardar;
	sig:lista;
  end;
  
   punteros = record    //REGISTRO QUE TIENE EL PUNTERO INICIAL Y ULTIMO DE UNA LISTA
	l,ult:lista;
  end;
  vectorPunt = array[1..df] of punteros; //VECTOR QUE TIENE LOS PUNTEROS INICIAL Y FINAL DE TODAS LAS LISTAS
  maximos = record	
	codM:integer;
	puntM: real;
  end;
  vector2=array[1..df]of maximos;  //VECTOR QUE TIENE EL PUNTAJE MAXIMO Y SU CODIGO DE PELICULA ASOCIADO AL PUNTAJE DE CADA LISTA 
   
procedure agregarAtras(var l,ult:lista;p:peliGuardar);  // PARA IR AGREGANDO A LA LISTA EN EL ORDEN QUE INGRESAN LOS DATOS
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
procedure inicializacion(var v:vectorPunt);  //CREAR LAS LISTAS VACIAS DE LOS 8 GENEROS DE MUSICA
var 
  i:integer;
begin
  for i:=1 to df do v[i].l:=nil;
end;
procedure cargar(var v:vectorPunt);  //ESTRUCTURA PRINCIPAL DE CARGA DEL VECTOR DE LISTAS
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
procedure inicializacionVector(var v2:vector2); //PARA CALCULAR EL PUNTAJE MAXIMO DE CADA LISTA 
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
procedure ordenar(var v:vector2); //ORDENA EL VECTOR DE MENOR A MAYOR CON RESPECTO AL PUNTAJE 
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

//INICIO PROGRAMA PRINCIPAL
var
  v:vectorPunt;
  v2:vector2;
begin
  cargar(v);
  nuevoVector(v,v2);
  ordenar(v2);
  mayorYmenor(v2); 
end.
