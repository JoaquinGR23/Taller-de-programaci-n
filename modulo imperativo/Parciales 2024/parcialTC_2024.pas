program parcialTC2024; 

type sub_dia=1..31;
	 envios=record 
	   codCli:integer;
	   dia:sub_dia;
	   peso:real;
	 end;	
	 infoCarga=record
       codP:integer;
       e:envios;
      end;
      lista=^nodo2;
      nodo2=record
        ele:envios;
        sig:lista;
      end;
      infoNodo=record
        codP:integer;
        lis:lista;
      end;
      arbol=^nodo;
      nodo=record
        ele:infoNodo;
        HD,HI:arbol;
      end;
procedure cargarReg(var d:infoCarga);
begin
  writeln('ingrese el cod de cliente '); d.e.codCli:=random(50); 
  if(d.e.codCli<>0)then begin 
    writeln('ingrese el cod postal '); d.codP:=random(15); 
    writeln('ingrese el dia '); d.e.dia:=random(31)+1; 
    writeln('ingrese el peso '); d.e.peso:=random(15)+32.24; 
  end;
end;
procedure agregarL(var l:lista; d:envios);
var nuevo:lista;
begin
  new(nuevo); nuevo^.ele:=d; nuevo^.sig:=l; l:=nuevo; 
end;
procedure agregar(var a:arbol;d:infoCarga);
begin
  if(a=nil)then begin 
    new(a); a^.ele.codP:=d.codP; a^.HD:=nil; a^.HI:=nil; a^.ele.lis:=nil;
    agregarL(a^.ele.lis,d.e);
  end
  else if(a^.ele.codP=d.codP)then agregarL(a^.ele.lis,d.e) 
	   else if(a^.ele.codP>=d.codP)then agregar(a^.HI,d)
			else agregar(a^.HD,d);
end;
procedure carga(var a:arbol);
var d:infoCarga;
begin
  cargarReg(d);
  while(d.e.codCli<>0)do begin 
     agregar(a,d);
    cargarReg(d);
  end; 
end;
procedure imprimirL(l:lista);
begin
  while(l<>nil)do begin 
    writeln('cod de cliente ',l^.ele.codCli); 
    writeln(' dia ', l^.ele.dia);  
    writeln('peso ', l^.ele.peso:0:2);
    l:=l^.sig;
  end; 
end;
procedure imprimir(a:arbol);
begin
  if(a<>Nil)then begin 
    imprimir(a^.HI);
     writeln('el cod postal es ', a^.ele.codP); imprimirL(a^.ele.lis);
    imprimir(a^.HD);
  end; 
end;
function enviosDelCodPostal(a:arbol;cod:integer):lista;
begin
  if(a<>nil)then begin
    if(a^.ele.codP=cod)then enviosDelCodPostal:=a^.ele.lis  
    else if(a^.ele.codP>=cod)then enviosDelCodPostal:=enviosDelCodPostal(a^.HI,cod) 
		else enviosDelCodPostal:=enviosDelCodPostal(a^.HD,cod);
  end
  else enviosDelCodPostal:=nil; 
end;
procedure obtenerMaximo(peso:real;cliente:integer;var max,min:real;var codMax,codMin:integer);
begin
   if(max<peso) then begin 
       max:=peso; codMax:=cliente;
     end;
end;
procedure obtenerMinimo(peso:real;cliente:integer;var max,min:real;var codMax,codMin:integer);
begin
  if(min>peso) then begin 
    min:=peso; codMin:=cliente;
  end; 
end;
procedure maxYminDeLaLista(l:lista;var max,min:real;var codMax,codMin:integer);
begin 
   if(l<>nil)then begin 
     obtenerMaximo(l^.ele.peso,l^.ele.codCli,max,min,codMax,codMin);
     obtenerMinimo(l^.ele.peso,l^.ele.codCli,max,min,codMax,codMin);    
     maxYminDeLaLista(l^.sig,max,min,codMax,codMin);
   end;
end;
var a:arbol; l:lista; cod,codMax,codMin:integer; max,min:real;
begin
  a:=nil;
  carga(a);
  imprimir(a);
  writeln('ingrese un cod de postal'); readln(cod);
  l:=enviosDelCodPostal(a,cod);
  writeln('---------------');
  writeln('LISTA: ');
  writeln('---------------');
  imprimirL(l); 
  max:=-1; min:=9999; 
  maxYminDeLaLista(l,max,min,codMax,codMin);
  writeln('el cod de cliente maximo es ', codMax, ' y cod de cliente min ', codMin); 
end.
