program parcialTurnoA; 

type 
  compras=record
	numF,cant_prod:integer;
	monto:real;
  end;
  infoCarga=record
    codCli:integer;
    c:compras;
  end;
  lista=^nodo1;
  nodo1=record
    ele:compras;
    sig:lista;
  end;
  infoNodo=record
    codCli:integer;
    com:lista;
  end;
  arbol=^nodo2;
  nodo2=record
    ele:infoNodo;
    HD,HI:arbol;
  end;
procedure cargarReg(var c:infoCarga);
begin
  writeln('cod de cliente'); c.codCli:=random(15);
  if(c.codCli<>0)then begin 
    writeln('numero de factura '); c.c.numF:=random(1500); writeln('cant de productos '); c.c.cant_prod:=random(85); writeln('monto '); c.c.monto:=random(150)+35.24;
  end; 
end;
procedure agregarL(var l:lista; d:compras);
var nuevo:lista;
begin
  new(nuevo); nuevo^.ele:=d; nuevo^.sig:=l; l:=nuevo; 
end;
procedure agregar(var a:arbol;c:infoCarga);
begin
  if(a=nil)then begin 
    new(a); a^.ele.codCli:=c.codCli; a^.ele.com:=nil; a^.HD:=NIL; a^.HI:=NIL;
    agregarL(a^.ele.com,c.c);
  end
  else if(a^.ele.codCli=c.codCli)then agregarL(a^.ele.com,c.c)
	   else if(a^.ele.codCli>=c.codCli)then agregar(a^.HI,c)
			else agregar(a^.HD,c);
end;
procedure carga(var a:arbol);
var c:infoCarga;
begin
  cargarReg(c);
  while(c.codCli<>0)do begin
    agregar(a,c);
    cargarReg(c);
  end; 
end;
procedure obtenerCantYmonto(l:lista;var c:integer;var m:real);
begin
  c:=0; m:=0;
  while(l<>nil) do begin
    c:=c+1; m:=m+l^.ele.monto;
    l:=l^.sig;
  end; 
end;
procedure cantidadComprasYmontoTotalGastado(a:arbol;cli:integer;var cant:integer;var montoT:real);
begin
   if(a<>nil)then begin 
     if(a^.ele.codCli=cli)then begin 
       obtenerCantYmonto(a^.ele.com,cant,montoT)
     end
     else if(a^.ele.codCli>=cli)then cantidadComprasYmontoTotalGastado(a^.HI,cli,cant,montoT)
		  else cantidadComprasYmontoTotalGastado(a^.HD,cli,cant,montoT);
   end;
end;
procedure generarL(l:lista;var nuevaL:lista;num1,num2:integer); 
begin 
  while(l<>nil)do begin 
    if((l^.ele.numF>=num1) and (l^.ele.numF<=num2))then agregarL(nuevaL,l^.ele);
    l:=l^.sig;
  end;
end;
procedure ComprasEntreNumDeFacturas(a:arbol;numFac1,numFac2:integer;var nuevaL:lista);
begin
  if(a<>nil)then begin 
    generarL(a^.ele.com,nuevaL,numFac1,numFac2); 
    ComprasEntreNumDeFacturas(a^.HI,numFac1,numFac2,nuevaL);
    ComprasEntreNumDeFacturas(a^.HD,numFac1,numFac2,nuevaL);
  end;
end;

procedure imprimirL(l:lista);
begin 
  while(l<>nil) do begin 
    writeln('num de factura ', l^.ele.numF); writeln('CANT DE PRODUCTOS ', l^.ele.cant_prod); writeln('monto  ', l^.ele.monto:0:2);
    l:=l^.sig;
  end;
end;
procedure informarDatos(d:infoNodo);
begin
   writeln('cod de cliente ', d.codCli); imprimirL(d.com); 
end;
procedure imprimir(a:arbol);
begin
  if(a<>nil) then begin 
    imprimir(a^.HI);
    informarDatos(a^.ele);
    imprimir(a^.HD);
  end;
end;

var 
  a:arbol;
  cli,cantTotal,numFac1,numFac2:integer;
  montoTotal:real;
  l2:lista;
begin 
  randomize();
  a:=nil;
  carga(a);
  imprimir(a);
  writeln('ingrese un cod de cliente '); readln(cli);
  cantidadComprasYmontoTotalGastado(a,cli,cantTotal,montoTotal);
  writeln('cantidad total de compras, ', cantTotal, ' monto total gastado ', montoTotal:0:2);
  writeln('ingrese el primer numero de factura '); readln(numFac1);
  writeln('ingrese el segundo numero de factura '); readln(numFac2);
  l2:=nil;
  ComprasEntreNumDeFacturas(a,numFac1,numFac2,l2);
  if(l2<>nil)then imprimirL(l2)
  else writeln('lista vacia');
end.
