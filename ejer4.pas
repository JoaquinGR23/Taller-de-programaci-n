program libreria;
const
  df1=8;
  df2 =30;
type
  sub=1..8;
  productos = record
    codP:integer;
    codRubro: sub;
    precio:real;
  end;
  lista = ^nodo;
  nodo = record
	ele:productos;
	sig:lista;
  end;
  vector = array[1..df1] of lista;
  vector2 = array[1..df2] of productos;
procedure insertar(var l:lista;p:productos);
var
  ant,actual,nuevo:lista;
begin
  new(nuevo); nuevo^.ele:=p; nuevo^.sig:=nil;
  if(l=nil) then l:=nuevo
  else begin
    actual:=l; 
    while((actual<>nil)and(nuevo^.ele.codP>actual^.ele.codP)) do begin
      ant:=actual;
      actual:=actual^.sig; 
    end;
  end;
  if(actual=l) then begin 
    nuevo^.sig:=l; l:=nuevo;
  end
  else begin
	ant^.sig:=nuevo; nuevo^.sig:=actual;
  end;
end;

procedure inicializacion(var v:vector);
var 
  i:integer;
begin
  for i:=1 to df1 do v[i]:=nil;
end;
procedure cargarReg(var p:productos);
begin
  readln(p.precio);
  if(p.precio <> 0) then begin
    readln(p.codP); readln(p.codRubro);
  end;
end;
procedure cargar(var v:vector);
var
  p:productos;
begin
  cargarReg(p);
  inicializacion(v);
  while(p.precio<>0) do begin
	insertar(v[p.codRubro],p);
	cargarReg(p);
  end;
end;
procedure imprimirLista(l:lista);
begin
  while(l<>nil) do begin 
    writeln(l^.ele.codP); l:=l^.sig;
  end;
end;
procedure imprimirCod(v:vector);
var
  i:integer;
begin 
  for i:=1 to df1 do begin 
    writeln('rubro ', i); imprimirLista(v[i]);
  end;
end;
procedure vectorNuevo(l:lista;var v2:vector2;var dl2:integer);
begin
  dl2:=0;  
  while((dl2<df2)and(l<>nil)) do begin 
	dl2:=dl2+1; 
	v2[dl2]:=l^.ele;
	l:=l^.sig;
  end;
end;
procedure ordenarV(var v2:vector2;dl2:integer);
var
  i,j:integer;
  actual: productos;
begin
  for i:=2 to dl2 do begin 
    j:=i-1; actual:=v2[i];
    while((j>0)and(v2[j].precio>actual.precio)) do begin 
		v2[j+1]:=v2[j]; j:=j-1;
    end; 
    v2[j+1]:=actual;
  end;
end; 
procedure imprimirPrecio(v2:vector2;dl2:integer);
var
  i:integer;
begin
  for i:=1 to dl2 do writeln(v2[i].precio);
end;
procedure promedio(v2:vector2;dl2:integer);
var
  i:integer;
  suma,prom:real;
begin
  suma:=0;
  for i:=1 to dl2 do suma := suma+v2[i].precio;
  prom:=suma/dl2;
end;
var 
  v:vector;
  v2:vector2;
  dl2:integer;
begin
  cargar(v);
  imprimirCod(v);
  vectorNuevo(v[3],v2,dl2);
  ordenarV(v2,dl2); 
  imprimirPrecio(v2,dl2);
  promedio(v2,dl2);
end.
