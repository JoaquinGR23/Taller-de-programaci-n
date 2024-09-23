program parcialTC2023;
const df=12;
type
 sub_mes=1..12;
 sub_dia=1..31;
 infoVideojuego=record
	codV:integer;
	dia:sub_dia;
	mes:sub_mes;
 end;
 compras=record
   codCli:integer;
   v:infoVideojuego;
 end;
 lista=^nodo1;
 nodo1=record
   ele:infoVideojuego;
   sig:lista;
 end;
 infoNodo=record
   cod:integer;
   com:lista;
 end;  
 arbol=^nodo2;
 nodo2=record
   ele:infoNodo;
   HI,HD:arbol;
 end;
 reg=record
   cant,mes:integer;
 end;
 vector=array[1..df]of reg;
procedure inicializarVec(var v:vector);
var i:integer;
begin
  for i:=1 to 12 do begin 
    v[i].mes:=i; v[i].cant:=0; 
  end;
end;
procedure cargaReg(var c:compras);
begin
  c.codCli:=random(8);
  if(c.codCli<>0)then begin 
	c.v.codV:=random(100); c.v.dia:=random(31)+1; c.v.mes:=random(12)+1;
  end; 
end;
procedure agregarL(var l:lista; d:infoVideojuego);
var nuevo:lista;
begin 
  new(nuevo); nuevo^.ele:=d; nuevo^.sig:=l; l:=nuevo;
end;
procedure agregar(var a:arbol;c:compras);
begin
  if(a=nil)then begin 
    new(a); a^.ele.cod:=c.codCli; a^.ele.com:=nil; a^.HI:=nil; a^.HD:=nil;
    agregarL(a^.ele.com,c.v);
  end
  else if(a^.ele.cod=c.codCli)then agregarL(a^.ele.com,c.v)
	   else if(a^.ele.cod>=c.codCli) then agregar(a^.HI,c)
		    else agregar(a^.HD,c);
end;
procedure contVec(var v:vector;var dl:sub_mes);
begin
   v[dl].cant:=v[dl].cant+1;
end;
procedure cargar(var a:arbol;var v:vector);
var c:compras;
begin 
  cargaReg(c);
  inicializarVec(v);
  while(c.codCli<>0)do begin 
    agregar(a,c);
    contVec(v,c.v.mes);
    cargaReg(c);
  end;
end;
function compraCli(a:arbol;num:integer):lista;
begin 
  if(a<>nil)then begin 
    if(a^.ele.cod=num) then compraCli:=a^.ele.com
    else if(a^.ele.cod>=num)then compraCli:=compraCli(a^.HI,num) 
		 else compraCli:=compraCli(a^.HD,num);
  end
  else compraCli:=NIL;
end;
procedure ordenarVec(var v:vector);
var i,j:integer; actual:reg;
begin 
  for i:=2 to df do begin 
    j:=i-1; actual:=v[i];
    while((j>0)and(v[j].cant<actual.cant)) do begin 
     v[j+1]:=v[j]; j:=j-1; 
    end;
    v[j+1]:=actual;
  end;
end;
procedure imprimirV(v:vector);
var i:integer;
begin 
  for i:=1 to df do writeln('cantidad ',v[i].cant,' del mes ',v[i].mes);
end;
procedure imprimirL(l:lista);
begin
  while(l<>nil)do begin 
	writeln('cod del videojuego ',l^.ele.codV); writeln('dia ', l^.ele.dia); writeln('mes ',l^.ele.mes); 
	l:=l^.sig;
  end;
end;
procedure informarDatos(d:infoNodo);
begin
  writeln('cod: ',d.cod); imprimirL(d.com);  
end;
procedure imprimirA(a:arbol);
begin
  if(a<>nil)then begin 
    imprimirA(a^.HI);
    informarDatos(a^.ele);
    imprimirA(a^.HD); 
  end;
end;
var
  a:arbol;
  v:vector;
  num:integer;
  l:lista;
begin 
  randomize();
  a:=nil;
  cargar(a,v);
  imprimirA(a);
  writeln('ingrese un num de cliente '); readln(num);
  l:= compraCli(a,num);
  if(l<>nil)then imprimirL(l)
  else writeln('lista vacia');
  writeln('vector sin ordenar');
  imprimirV(v);
  ordenarVec(v);
  writeln('vector ordenado');
  imprimirV(v);
end.
