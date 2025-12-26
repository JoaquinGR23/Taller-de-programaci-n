program parcialTurnoI;
const df=7;
type
  sub_dias=1..7;
  alquiler=record
    dniCli,numCha:integer;
  end;
  infoCarga=record
    cant:sub_dias;
    info:alquiler;
  end;
  arbol=^nodo;
  nodo=record
    ele:alquiler;
    HD,HI:arbol;
  end;
  vector=array[1..df] of arbol;
procedure cargarReg(var d:infoCarga);
begin
  writeln('ingrese el nro de chasis del auto: '); d.info.numCha:=random(15);
  if(d.info.numCha<>0)then begin 
    writeln('ingrese el dni del cliente: '); d.info.dniCli:=random(15);
    writeln('ingrese la cantidad de dias: '); d.cant:=random(15);
  end; 
end;
procedure agregar(var a:arbol; d:alquiler);
begin
  if(a=nil)then begin 
    new(a); a^.ele:=d; a^.HD:=nil; a^.HI:=nil;
  end
  else if(a^.ele.numCha>=d.numCha)then agregar(a^.HI,d)
	   else agregar(a^.HD,d);
end;
procedure inicializarVec(var v:vector);
var i:integer;
begin
  for i:=1 to df do v[i]:=nil; 
end;
procedure cargar(var v:vector);
var d:infoCarga;
begin
  randomize();
  cargarReg(d);
  inicializarVec(v);
  while(d.info.numCha<>0)do begin 
    agregar(v[d.cant],d.info);
    cargarReg(d);
  end; 
end;
procedure informarDatos(d:alquiler);
begin
  writeln('num de chasis: ', d.numCha); writeln('Dni del cliente: ', d.dniCli);
end;
procedure imprimirA(a:arbol);
begin
  if(a<>nil)then begin 
    imprimirA(a^.HI);
    informarDatos(a^.ele);
    imprimirA(a^.HD);
  end; 
end;
procedure imprimirVec(v:vector);
var i:integer;
begin
  for i:=1 to df do begin 
   writeln('-----ARBOL-----',i); imprimirA(v[i]) 
  end;
end;
function buscarAlq(a:arbol;dni:integer):integer;
var cant:integer;
begin
  if(a<>Nil)then begin
    if(a^.ele.dniCli=dni)then cant:=1
    else cant:=0;
    buscarAlq:=buscarAlq(a^.HI,dni)+buscarAlq(a^.HD,dni)+cant;
  end
  else buscarAlq:=0; 
end;
function cantAlqRealizadosPorElDniD(v:vector;dni:integer):integer;
var cant,i:integer;
begin
  cant:=0;
  for i:=1 to df do cant:=cant+buscarAlq(v[i],dni);
  cantAlqRealizadosPorElDniD:=cant;
end;
function cantAlqEnRango(a:arbol;N1,N2:integer):integer;
begin 
  if(a<>nil)then begin 
    if((a^.ele.numCha>=N1)and(a^.ele.numCha<=N2)) then cantAlqEnRango:=cantAlqEnRango(a^.HI,N1,N2)+cantAlqEnRango(a^.HD,N1,N2)+1
    else if(a^.ele.numCha>=N1)then cantAlqEnRango:=cantAlqEnRango(a^.HI,N1,N2)
		 else cantAlqEnRango:=cantAlqEnRango(a^.HD,N1,N2);
  end
  else cantAlqEnRango:=0;
end;
var v:vector; D,cant,N1,N2:integer;
begin 
  cargar(v);
  imprimirVec(v);
  writeln('ingrese un dni: '); readln(D);
  cant:=cantAlqRealizadosPorElDniD(v,D);
  writeln('cant de alquileres realizados por el dni ',D, ' es ',cant);
  writeln('ingrese el dia: '); readln(D);
  writeln('ingrese el limite inferior: '); readln(N1); writeln('ingrese el limite superior: '); readln(N2);
  cant:= cantAlqEnRango(v[D],N1,N2);
  writeln('cantidad de alquileres entre ',N1,' Y ',N2,' es ',cant);
end.
