program parcialTH2023; 

type 
  sub_mes=1..12;
  alquileres=record
    dniCli,anio:integer;
    mes:sub_mes;
  end;
  infoCarga=record
    patente:integer;
    alq: alquileres; 
  end;
  lista=^nodo2;
  nodo2=record
    ele:alquileres;
    sig:lista;
  end;
  infoNodo=record
    patente:integer;
    lis:lista;
  end;
  arbol=^nodo1;
  nodo1=record
    ele:infoNodo;
    HD,HI:arbol;
  end;
procedure cargarReg(var d:infoCarga);
begin 
  writeln('ingrese la patente '); d.patente:=random(15);
  if(d.patente<>0)then begin 
    writeln('ingrese el dni del cliente '); d.alq.dniCli:=random(40); 
    writeln('ingrese el anio '); d.alq.anio:=random(70)+1955; 
    writeln('ingrese el mes '); d.alq.mes:=random(12)+1;
  end;
end;
procedure agregarL(var l:lista; d:alquileres);
var nuevo:lista;
begin
  new(nuevo); nuevo^.ele:=d; nuevo^.sig:=l; l:=nuevo; 
end;
procedure agregar(var a:arbol; d:infoCarga);
begin
   if(a=nil) then begin 
     new(a); a^.ele.patente:=d.patente; a^.ele.lis:=nil; a^.HI:=NIL; a^.HD:=NIL;
     agregarL(a^.ele.lis,d.alq);
   end
   else if(a^.ele.patente=d.patente)then  agregarL(a^.ele.lis,d.alq)
        else if(a^.ele.patente>=d.patente)then agregar(a^.HI,d)
			 else agregar(a^.HD,d)
end;
procedure carga(var a:arbol);
var d:infoCarga;
begin 
  cargarReg(d);
  while(d.patente<>0)do begin 
    agregar(a,d);
    cargarReg(d);
  end;
end; 
function contAlquileres(l:lista; dni:integer):integer;
var cont:integer;
begin
  cont:=0;
  while(l<>Nil)do begin
    if(l^.ele.dniCli= dni)then cont:=cont+1;
    l:=l^.sig;
  end; 
  contAlquileres:=cont;
end;
function cantAlquileresDelDni(a:arbol; d:integer):integer;
var cant:integer;
begin
  if(a<>nil)then begin 
    cant:=contAlquileres(a^.ele.lis,d);
    cantAlquileresDelDni:= cantAlquileresDelDni(a^.HI,d)+ cantAlquileresDelDni(a^.HD,d)+cant;
  end
  else cantAlquileresDelDni:=0;  
end;
function contAnios(l:lista; anio:integer):integer;
var cont:integer;
begin
  cont:=0;
  while(l<>Nil)do begin
    if(l^.ele.anio= anio)then cont:=cont+1;
    l:=l^.sig;
  end; 
  contAnios:=cont;
end;
function cantPatentesEnRango(a:arbol;num,x,y:integer):integer;
var cant:integer;
begin
  if(a<>nil)then begin 
    if((a^.ele.patente>=x)and(a^.ele.patente<=y))then begin 
      cant:=contAnios(a^.ele.lis,num);  
      cantPatentesEnRango:=cantPatentesEnRango(a^.HI,num,x,y)+cantPatentesEnRango(a^.HD,num,x,y)+cant;
    end
    else if(a^.ele.patente>=x) then cantPatentesEnRango:=cantPatentesEnRango(a^.HI,num,x,y)
         else cantPatentesEnRango:=cantPatentesEnRango(a^.HD,num,x,y);
  end
  else cantPatentesEnRango:=0; 
end;
procedure imprimirL(l:lista);
begin
  while(l<>nil)do begin 
    writeln('dni del cliente ', l^.ele.dniCli); writeln('anio ', l^.ele.anio); writeln('mes ', l^.ele.mes);
    l:=l^.sig;
  end; 
end;
procedure imprimir(a:arbol);
begin 
  if(a<>Nil) then begin 
    imprimir(a^.HI);
    writeln('patente ', a^.ele.patente); imprimirL(a^.ele.lis);
    imprimir(a^.HD);
  end;
end;
var
  a:arbol;
  d,cant,cantPat,num,x,y:integer;
begin 
  randomize();
  a:=nil;
  carga(a);
  imprimir(a);
  writeln('ingrese un dni '); readln(d);
  cant:= cantAlquileresDelDni(a,d);
  writeln('La cantidad de alquileres realizados por el DNI ', d, ' es: ', cant);
  writeln('ingrese un anio '); readln(num); writeln('ingrese el limite inferior '); readln(x); writeln('ingrese el limite superior '); readln(y);
  cantPat:= cantPatentesEnRango(a,num,x,y);
  writeln('La cantidad de alquileres realizados para las patentes entre ', x, ' e ', y, ' durante el anio ', num, ' es: ', cantPat);
end.
