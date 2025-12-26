program ejer2;

type
  lista = ^nodo;
  nodo=record
	ele:integer;
	sig:lista;
  end;
procedure cargarL(var l:lista; num:integer);
var nuevo:lista;
begin 
  new(nuevo); nuevo^.ele:=num; nuevo^.sig:=l; l:=nuevo;
end;
procedure cargar(var l:Lista);
var num:integer;
begin
  num:= random(100)+100;
  while(num<>100) do begin
	cargarL(l,num);
	num:= random(100)+100;
  end;
end; 
procedure imprimirLista(l:lista);
begin
  if(l<>nil)then begin 
	writeln(l^.ele); 
	imprimirLista(l^.sig);
  end;
end;
procedure imprimirInv(l:lista);
begin
  if(l<>nil)then begin  
	imprimirInv(l^.sig);
	writeln(l^.ele);
  end;
end;
function minimoL(l:lista; min:integer):integer;
begin
   if(l<>nil)then begin if(min>l^.ele) then min:=l^.ele;
				  minimoL:=minimoL(l^.sig,min);
   end
   else minimoL:=min;
end;
function busquedaL(l:lista;valor:integer):boolean;
begin
   if(l<>nil)then if(valor=l^.ele)then busquedaL:=true
				  else busquedaL:=busquedaL(l^.sig,valor)
   else busquedaL:=false;
end;
var
  l:lista;
  min,valor:integer;
begin
 l:=nil;
 randomize();
 cargar(l);
 writeln('imprime NORMAL');
 imprimirLista(l); 
 writeln('imprime invertido');
 imprimirInv(l);
 min:=9999;
 writeln('minimo  de la lista ',minimoL(l,min));
 readln(valor);
 if(busquedaL(l,valor)) then writeln('se encontro ')
 else writeln('no se encontro ');
end.
