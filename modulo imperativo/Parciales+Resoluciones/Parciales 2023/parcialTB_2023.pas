program parcialTB2023; 

type
  sub_dia=1..31;
  compra=record
    dia:sub_dia;
    cant:integer;
    monto:real;
  end;
  infoCarga=record
    codCli:integer;
    c:compra;
  end;
  lista=^nodo1;
  nodo1=record
    ele:compra;
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
  writeln('cant '); c.c.cant:=random(15);
  if(c.c.cant<>0)then begin 
    writeln('cod '); c.codCli:=random(10); writeln('monto '); c.c.monto:=random(15)+15.12; writeln('dia '); c.c.dia:=random(31)+1;
  end; 
end;
procedure agregarL(var l:lista; d:compra);
var nuevo:lista;
begin
  new(nuevo); nuevo^.ele:=d; nuevo^.sig:=l; l:=nuevo;
end;
procedure agregar(var a:arbol;c:infoCarga);
begin 
  if(a=nil)then begin 
    new(a); a^.ele.codCli:=c.codCli; a^.ele.com:=nil; a^.HI:=nil; a^.HD:=nil;
    agregarL(a^.ele.com,c.c);
  end
  else if(a^.ele.codCli=c.codCli)then agregarL(a^.ele.com,c.c)
	   else if(a^.ele.codCli>=c.codCli)then agregar(a^.HI,c)
			else agregar(a^.HD,c)
end;
procedure carga(var a:arbol);
var c:infoCarga;
begin 
  cargarReg(c);
  while(c.c.cant<>0)do begin 
    agregar(a,c);
    cargarReg(c);
  end;
end;
procedure imprimirL(l:lista);
begin
  while(l<>nil)do begin 
   writeln('dia ', l^.ele.dia); 
   writeln('cant ', l^.ele.cant);
   writeln('monto ', l^.ele.monto:0:2); 
   l:=l^.sig;
  end; 
end;
function comprasRealizadas(a:arbol;cod:integer):lista;
begin
  if(a<>nil)then begin 
    if(a^.ele.codCli=cod) then comprasRealizadas:=a^.ele.com
    else if(a^.ele.codCli>=cod)then comprasRealizadas:=comprasRealizadas(a^.HI,cod) 
		 else comprasRealizadas:=comprasRealizadas(a^.HD,cod);
  end
  else comprasRealizadas:=nil;
end;
procedure mayorL(l:lista;var max:integer; var monto:real);
begin
   if(l<>nil)then begin 
     if(max<l^.ele.cant)then begin 
        max:=l^.ele.cant; monto:=l^.ele.monto;
     end;
     mayorL(l^.sig,max,monto);
   end;
end;

procedure imprimirDatos(d:infoNodo);
begin
  writeln('cod cliente ', d.codCli); imprimirL(d.com);
end;
procedure imprimirA(a:arbol);
begin
  if(a<>nil)then begin
    imprimirA(a^.HI);
    imprimirDatos(a^.ele);
    imprimirA(a^.HD);
  end;
end;
var
  a:arbol;
  cod,max:integer;
  l2:lista;
  montoMayor:real;
begin 
  a:=nil;
  carga(a);
  imprimirA(a);
  writeln('ingrese un codigo '); readln(cod);
  l2:=comprasRealizadas(a,cod); 
  imprimirL(l2);
  max:=-1;
  mayorL(l2,max,montoMayor);
  writeln('monto mayor ', montoMayor:0:2);
end.
