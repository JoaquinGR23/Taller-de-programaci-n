program parcialTD; //20:33

type 
  pasaje=record
    codV,codCli:integer;
    monto:real;
  end;
  infoCarga=record
	p:pasaje;
	codDes:integer;
  end;
  lista=^nodo1;
  nodo1=record
    ele:pasaje;
    sig:lista;
  end;
  infoNodo=record
    codDes:integer;
    p:lista;
  end;
  arbol=^nodo2;
  nodo2=record
    ele:infoNodo;
    HD,HI:arbol;
  end;
procedure cargaReg(var d:infoCarga);
begin 
  writeln('monto '); d.p.monto:=random(10);
  if(d.p.monto<>0)then begin 
	writeln('cod de cliente '); d.p.codCli:=random(1000); writeln('cod de viaje '); d.p.codV:=random(1000); 
	writeln('cod de destino '); d.codDes:=random(30);
  end;
end;
procedure agregarL(var l:lista; d:pasaje);
var nuevo:lista;
begin 
  new(nuevo); nuevo^.ele:=d; nuevo^.sig:=l; l:=nuevo;
end;
procedure agregar(var a:arbol;d:infoCarga);
begin
  if(a=nil) then begin 
    new(a); a^.ele.codDes:=d.codDes; a^.ele.p:=nil; a^.HI:=NIL; a^.HD:=NIL;
    agregarL(a^.ele.p,d.p);
  end
  else if(a^.ele.codDes=d.codDes)then agregarL(a^.ele.p,d.p) 
	   else if(a^.ele.codDes>=d.codDes)then agregar(a^.HI,d)
			else agregar(a^.HD,d);
end;
procedure carga(var a:arbol);
var d:infoCarga;
begin 
  cargaReg(d);
  while(d.p.monto<>0)do begin 
    agregar(a,d);
    cargaReg(d);
  end;
end;
procedure imprimirL(l:lista);
begin
  while(l<>nil)do begin 
    writeln('cod de viaje ',l^.ele.codV); writeln('cod de cliente ',l^.ele.codCli); writeln('monto ',l^.ele.monto:0:2);  
    l:=l^.sig;
  end;
end;
procedure informarDatos(d:infoNodo);
begin
  writeln('cod de destino ',d.codDes); imprimirL(d.p);
end;
procedure imprimirA(a:arbol);
begin 
  if(a<>nil) then begin 
	imprimirA(a^.HI);
	informarDatos(a^.ele);
	imprimirA(a^.HD);
  end;
end;

function pasajesDeLaCiudad(a:arbol;cod:integer):lista;
begin
  if(a<>nil) then begin 
    if(a^.ele.codDes=cod)then pasajesDeLaCiudad:=a^.ele.p
    else if(a^.ele.codDes>=cod)then pasajesDeLaCiudad:=pasajesDeLaCiudad(a^.HI,cod)
		else pasajesDeLaCiudad:=pasajesDeLaCiudad(a^.HD,cod);
  end
  else pasajesDeLaCiudad:=nil; 
end;
function contarPasajes(l:lista):integer;
var cont:integer;
begin
  cont:=0;
  while(l<>nil)do begin
    cont:=cont+1; l:=l^.sig;
  end; 
  contarPasajes:=cont;
end;
procedure mayorPasajesVendidos(a:arbol; var max,cod:integer);
var cantActual:integer;
begin
  if(a<>nil)then begin 
    cantActual:=contarPasajes(a^.ele.p);
    if(max<cantActual)then begin 
      max:=cantActual; cod:=a^.ele.codDes;
    end;
    mayorPasajesVendidos(a^.HI,max,cod);
    mayorPasajesVendidos(a^.HD,max,cod);
  end; 
end;
var
  l2:lista;
  a:arbol;
  cod,maximo,codMax:integer;
begin 
  a:=nil;
  randomize();
  carga(a);
  if(a<>nil)then begin 
    imprimirA(a);
    writeln('ingrese un cod de ciudad de destino '); readln(cod);
    l2:=pasajesDeLaCiudad(a,cod);
    if(l2<>nil) then imprimirL(l2)
    else writeln('lista vacia');
    maximo:=-999;
    mayorPasajesVendidos(a,maximo,codMax);
    writeln('el codigo de la ciudad con mayor cantidad de pasajes vendidos es ', codMax);
  end
  else writeln('arbol vacio ');
end.
