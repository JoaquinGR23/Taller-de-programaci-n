program parcial_Turno_OP;
const df=10;
type
  sub_sucursal=1..10;
  ventas=record
    dniCli:integer;
    codSuc:sub_sucursal;
  end;
  paraLista=record
    numFac:integer;
    monto:real;
  end;
  infoCarga=record
    info:paraLista;
    v:ventas;
  end;
  lista=^nodo;
  nodo=record
    ele:paraLista;
    sig:lista;
  end;
  infoNodo=record
    dniCli:integer;
    lis:lista;
  end;
  arbol=^nodo2;
  nodo2=record
    ele:infoNodo;
    HD,HI:arbol;
  end;
  vector = array[1..df]of integer;
procedure cargarReg(var d:infoCarga);
begin
  writeln('ingrese el dni del cliente: '); d.v.dniCli:=random(15);
  if(d.v.dniCli<>0)then begin 
    writeln('ingrese el cod de la sucursal: '); d.v.codSuc:=random(10)+1;
    writeln('ingrese el nro de factura: '); d.info.numFac:=random(150);
    writeln('ingrese el monto: '); d.info.monto:=random(15)+63.12;
  end;
   
end;
procedure inicializarVec(var v:vector);
var i:integer;
begin 
  for i:=1 to df do v[i]:=0;
end;
procedure agregarL(var l:lista; d:paraLista);
var nuevo:lista;
begin
  new(nuevo); nuevo^.ele:=d; nuevo^.sig:=l; l:=nuevo;
end;
procedure agregar(var a:arbol;d:infoCarga);
begin
  if(a=Nil)then begin 
    new(a); a^.ele.dniCli:=d.v.dniCli; a^.HI:=nil; a^.HD:=nil; a^.ele.lis:=nil;
    agregarL(a^.ele.lis,d.info);
  end
  else if(a^.ele.dniCli=d.v.dniCli)then agregarL(a^.ele.lis,d.info)
	   else if(a^.ele.dniCli>=d.v.dniCli)then agregar(a^.HI,d)
			else agregar(a^.HD,d);
end;
procedure agregarVec(var v:vector; dl:sub_sucursal);
begin
  v[dl]:=v[dl]+1; 
end;
procedure cargarEstructuras(var a:arbol;var v:vector);
var d:infoCarga;
begin 
  a:=nil;
  randomize();
  cargarReg(d);
  inicializarVec(v);
  while(d.v.dniCli<>0) do begin
    agregar(a,d);
    agregarVec(v,d.v.codSuc);
    cargarReg(d);
  end;
end;
procedure imprimirL(l:lista);
begin
  while(l<>Nil)do begin 
    writeln('nro de factura: ', l^.ele.numFac);
    writeln('monto: ', l^.ele.monto:0:2); 
    l:=l^.sig;
  end; 
end;
procedure imprimirA(a:arbol);
begin
  if(a<>nil)then begin 
    imprimirA(a^.HI);
    writeln('dni del cliente: ', a^.ele.dniCli); imprimirL(a^.ele.lis);
    imprimirA(a^.HD);
  end; 
end;
procedure imprimirVec(v:vector);
var i:integer;
begin 
  for i:=1 to df do writeln(v[i]);
end;
function contarFac(l:lista; m:real):integer;
var cant:integer;
begin
  cant:=0;
  while(l<>Nil)do begin 
    if(l^.ele.monto>m)then cant:=cant+1;
	l:=l^.sig;
  end;
  contarFac:=cant;  
end;
function cantFacMayoresAlMontoIngresado(a:arbol;dni:integer;monto:real):integer;
begin 
  if(a<>nil)then begin 
    if(a^.ele.dniCli=dni)then cantFacMayoresAlMontoIngresado:=contarFac(a^.ele.lis,monto)
    else if(a^.ele.dniCli>=dni)then cantFacMayoresAlMontoIngresado:=cantFacMayoresAlMontoIngresado(a^.HI,dni,monto) 
	     else cantFacMayoresAlMontoIngresado:=cantFacMayoresAlMontoIngresado(a^.HD,dni,monto);
  end
  else cantFacMayoresAlMontoIngresado:=0;
end;
procedure codConMayorCantDeVentas(v:vector;df:integer;var mayor,cod:integer);
begin
  if(df>0)then begin 
    if(v[df]>mayor) then begin 
      mayor:=v[df]; cod:=df;
    end;
    codConMayorCantDeVentas(v,df-1,mayor,cod); 
  end; 
end;
var a:arbol; v:vector; monto:real; dni,cant,mayor,cod:integer;
begin 
  cargarEstructuras(a,v);
  imprimirA(a);
  imprimirVec(v);
  writeln('ingrese el dni: '); readln(dni);
  writeln('ingrese el monto: '); readln(monto);
  cant:= cantFacMayoresAlMontoIngresado(a,dni,monto);
  writeln('cantidad de num de facturas: ', cant);
  mayor:=-1; 
  codConMayorCantDeVentas(v,df,mayor,cod);
  writeln('el cod con mayor cantidad de ventas: ',cod);
end.
