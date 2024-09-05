program e2p3;

type
  ventas=record
    fecha:string;
	cant:integer;
  end;
  infoCarga=record //informacion de ingreso
    cod:integer;
    v:ventas;
  end;
  arbol=^nodo1; //arbol A de ventas por cod, los repetidos a la derecha
  nodo1=record
	ele:infoCarga;
	HI,HD:arbol;
  end;
  infoNodo2=record
    cod,cant:integer;
  end;
  arbol2=^nodo2; // arbol B de cantidad total vendida por codigo
  nodo2=record
	HD,HI:arbol2;
	ele:infoNodo2;
  end;
  lista=^nodo;
  nodo=record
	ele:ventas;
	sig:lista;
  end;
  infoNodo3=record
	cod:integer;
	v:lista;
  end;
  arbol3=^nodo3; // arbol C con listas
  nodo3=record
	HD,HI:arbol3;
	ele:infoNodo3;
  end;
  vector=array[0..5]of string;
procedure cargarDatos(var d:infoCarga);
var v:vector=('12/11/2017','12/8/2019','21/10/2018','23/16/2017','20/03/2018','09/01/2019');
begin
  d.cod:=random(6);
  if(d.cod<>0)then begin 
    d.v.fecha:= v[random(9)]; d.v.cant:=random(20)+1;
  end; 
end;
procedure cargarReg(d:infoCarga;var B:infoNodo2);
begin
  if(d.cod<>0) then begin 
	B.cod:=d.cod;  B.cant:=d.v.cant; 
  end; 
end;
procedure agregarA(var a:arbol; dato:infoCarga);
begin 
  if(a=nil)then begin 
    new(a); a^.ele.cod:=dato.cod; a^.ele.v:=dato.v; a^.HI:=nil; a^.HD:=nil;
  end
  else if(a^.ele.cod>dato.cod)then agregarA(a^.HI,dato)
	   else agregarA(a^.HD,dato);
end;
procedure agregarB(var a:arbol2; dato:infoNodo2); 
begin 
  if(a=nil)then begin 
	 new(a);  a^.ele.cod:=dato.cod; a^.ele.cant:=dato.cant; a^.HI:=NIL; a^.HD:=NIL;
  end
  else if(a^.ele.cod = dato.cod)then a^.ele.cant:=a^.ele.cant + dato.cant
	   else if(a^.ele.cod >= dato.cod)then agregarB(a^.HI,dato)
			else agregarB(a^.HD,dato);
end;
procedure agregarL(var l:lista; d:ventas);
var
  nuevo:lista;
begin 
  new(nuevo); nuevo^.ele:=d; nuevo^.sig:=l; l:=nuevo;
end;
procedure agregarC(var a:arbol3;dato:infoCarga); 
begin
  if(a=nil)then begin 
    new(a); a^.ele.cod:=dato.cod; a^.ele.v:=nil;
    agregarL(a^.ele.v,dato.v); a^.HI:=NIL; a^.HD:=NIL;
  end
  else if(a^.ele.cod=dato.cod)then agregarL(a^.ele.v,dato.v)
       else if(a^.ele.cod>=dato.cod)then agregarC(a^.HI,dato)
			else agregarC(a^.HD,dato);
end;
procedure cargaArboles(var a:arbol;var b:arbol2;var c:arbol3);
var
  nodo2:infoNodo2; d:infoCarga;
begin
  cargarDatos(d);  
  cargarReg(d,nodo2); //armar el nodo del arbol B
  if(d.cod<>0)then begin 
    agregarA(a,d);
    agregarB(b,nodo2);
    agregarC(c,d);
	cargaArboles(a,b,c);
  end; 
end;
function busquedaFecha(a:arbol;f:string):integer;
var prodVendidos:integer;
begin
  if(a<>nil)then begin 
    if(a^.ele.v.fecha=f)then prodVendidos:= a^.ele.v.cant
    else prodVendidos:=0;
    busquedaFecha:= busquedaFecha(a^.HI,f)+busquedaFecha(a^.HD,f)+prodVendidos; 
  end
  else busquedaFecha:=0;
end;

procedure buscarMax(a:arbol2;var max,cod:integer); 
begin
  if(a<>nil)then begin
	if(a^.ele.cant>max)then begin 
	  max:=a^.ele.cant; cod:= a^.ele.cod;
	end;
	buscarMax(a^.HI,max,cod);
	buscarMax(a^.HD,max,cod);
  end;
end;

procedure informar(d:infoCarga);
begin
  writeln('cod ',d.cod); writeln('fecha ',d.v.fecha); writeln('cant ',d.v.cant); 
end;
procedure imprimir1(a:arbol);
begin
   if(a<>nil)then begin
     imprimir1(a^.HI);
     informar(a^.ele);
     imprimir1(a^.HD); 
   end;
end;
procedure imprimir2(a:arbol2);
begin
   if(a<>nil)then begin
     imprimir2(a^.HI);
     writeln('cod ',a^.ele.cod); writeln('cantidad ',a^.ele.cant);
     imprimir2(a^.HD); 
   end;
end;
procedure imprimirL(l:lista);
begin
  while(l<>nil)do begin
    writeln('fecha ', l^.ele.fecha); writeln('cant ', l^.ele.cant); l:=l^.sig;
  end;  
end;
procedure informar2(cod:integer;l:lista);
begin
  writeln('cod ', cod); imprimirL(l); 
end;
procedure imprimir3(a:arbol3);
begin
   if(a<>nil)then begin
     imprimir3(a^.HI);
     informar2(a^.ele.cod,a^.ele.v);
     imprimir3(a^.HD); 
   end;
end;
function contarVentas(l:lista):integer;
var cont:integer;
begin
  cont:=0;
  while(l<>nil)do begin 
    cont:=cont+1; l:=l^.sig;
  end; 
  contarVentas:=cont;
end;
procedure actualizarMax(var max,cod:integer;cant,nuevoCod:integer);
begin
  if(max<cant)then begin 
    max:=cant; cod:= nuevoCod;
  end; 
end;
procedure codMax(a:arbol3;var max,cod:integer); 
var cant:integer;
begin
  if(a<>nil)then begin 
    cant:=contarVentas(a^.ele.v);
    actualizarMax(max,cod,cant,a^.ele.cod);
    end;
	codMax(a^.HI,max,cod);
	codMax(a^.HD,max,cod);
end;

var
  a:arbol;
  b:arbol2;
  c:arbol3;
  f:string;
  max,cod:integer;
begin
  randomize();
  a:=nil; b:=nil; c:=nil;
  cargaArboles(a,b,c);
  writeln('						ARBOL 1 					');
  imprimir1(a);
  writeln('						ARBOL 2 					');
  imprimir2(b);
  writeln('						ARBOL 3 					');
  imprimir3(c);
  readln(f);
  writeln('cantidad total de productos vendidos en la fecha es: ',busquedaFecha(a,f)); //deberia generarse un modulo para cargar dia,mes,anio de la fecha pero para este ejercicio no hace falta
  max:=-9999;
  buscarMax(b,max,cod);  
  writeln('el cod que tiene mas cantidades vendidas es ',cod);
  max:=-1; 
  codMax(c,max,cod);
  writeln('cod de producto con mayor cantidad de ventas vendidas', cod);
end.

