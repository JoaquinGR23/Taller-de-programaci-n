program e3p4;

type 
  venta=record
    codV,codP,cantU:integer;
    monto:real;
  end;
  infoNodo=record
    codP,cantT:integer;
    montoT:real;
  end;
  arbol=^nodo;
  nodo=record
    ele:infoNodo;
    HD,HI:arbol;
  end;
procedure cargarReg(var d:venta);
begin
  writeln('cod de venta '); d.codV:=random(15)-1;
  if(d.codV<>-1)then begin 
    writeln('cod de producto '); d.codP:=random(15);
    writeln('cant de unidades '); d.cantU:=random(15)+64;
    writeln('monto '); d.monto:=random(15)+64.15;
  end; 
end;
procedure agregar(var a:arbol;v:venta);
begin
  if(a=nil)then begin
    new(a); a^.ele.codP:=v.codP; a^.HI:=nil; a^.HD:=nil;
    a^.ele.cantT:=v.cantU; a^.ele.montoT:=v.cantU*v.monto;   
  end 
  else if(a^.ele.codP=v.codP)then begin 
         a^.ele.cantT:=a^.ele.cantT+v.cantU; a^.ele.montoT:=a^.ele.montoT+v.cantU*v.monto;   
       end 
       else if(a^.ele.codP>=v.codP)then agregar(a^.HI,v)  
			else agregar(a^.HD,v);
end;
procedure cargar(var a:arbol);
{a. Almacenar los productos vendidos en una estructura eficiente para la búsqueda por
código de producto. De cada producto deben quedar almacenados su código, la
cantidad total de unidades vendidas y el monto total. De cada venta se lee código de
venta, código del producto vendido, cantidad de unidades vendidas y precio unitario. El
ingreso de las ventas finaliza cuando se lee el código de venta -1.}
var d:venta;
begin 
  cargarReg(d);
  while(d.codV<>-1)do begin 
    agregar(a,d);
    cargarReg(d);
  end;
end;
procedure informarDatos(d:infoNodo);
begin
  writeln('cod de prod ',d.codP); writeln('cant de productos ',d.cantT); writeln('monto total ',d.montoT:0:2);  
end;
procedure imprimir(a:arbol);
{b. Imprimir el contenido del árbol ordenado por código de producto.}
begin
  if(a<>nil)then begin 
    imprimir(a^.HI);
    informarDatos(a^.ele);
    imprimir(a^.HD);
  end; 
end;
procedure CodMax(a:arbol;var max,cod:integer);
{c. Retornar el código de producto con mayor cantidad de unidades vendidas.}
begin
  if(a<>nil)then begin
    if(max<a^.ele.cantT)then begin 
      max:=a^.ele.cantT; cod:=a^.ele.codP;
    end;
    CodMax(a^.HI,max,cod);
    CodMax(a^.HD,max,cod);
  end; 
end; 
function cantCodmenores(a:arbol;cod:integer):integer;
{d. Retornar la cantidad de códigos que existen en el árbol que son menores que un valor
que se recibe como parámetro.}
begin
  if(a<>nil)then begin 
    if(a^.ele.codP>=cod)then cantCodmenores:=cantCodmenores(a^.HI,cod)
    else cantCodmenores:=cantCodmenores(a^.HI,cod)+ cantCodmenores(a^.HD,cod)+1 
  end
  else cantCodmenores:=0; 
end;
function montoTotalEntreCodigos(a:arbol;cod1,cod2:integer):real;
{e. Retornar el monto total entre todos los códigos de productos comprendidos entre dos
valores recibidos (sin incluir) como parámetros}
begin
  if(a<>Nil)then begin 
    if((a^.ele.codP>cod1)and(a^.ele.codP<cod2))then montoTotalEntreCodigos:=montoTotalEntreCodigos(a^.HI, cod1,cod2)+
    montoTotalEntreCodigos(a^.HD, cod1,cod2)+a^.ele.montoT
    else if(a^.ele.codP>cod1)then montoTotalEntreCodigos:=montoTotalEntreCodigos(a^.HI, cod1,cod2) 
	     else montoTotalEntreCodigos:=montoTotalEntreCodigos(a^.HD, cod1,cod2);
  end
  else montoTotalEntreCodigos:=0; 
end;

var 
  a:arbol;
  montoT:real;
  max,cod,cant,cod1,cod2:integer;
begin 
  a:=nil;
  randomize();
  cargar(a);
  imprimir(a);
  max:=-1;
  CodMax(a,max,cod);
  writeln('cod con mayor cantidad de unidades vendidas ',cod);
  writeln('ingrese el codigo '); readln(cod);
  cant:=cantCodmenores(a,cod);
  writeln('la cantidad de codigos menores al valor ingresado es ',cant);
  writeln('ingrese el limite inferior '); readln(cod1); writeln('ingrese el limite superior '); readln(cod2);
  montoT:=montoTotalEntreCodigos(a,cod1,cod2);
  writeln('monto total entre los 2 codigos es ',montoT:0:2);  
end.
