program parcialTF;
const df=15;
type
  sub_mes=0..12;
  sub_Diag=1..15;
  atenciones=record
    dni:integer;
    mes:sub_mes;
    codD:sub_Diag;
  end;
  vector=array[1..df]of integer;
  infoNodo=record
   dni,cantT:integer;
  end;
  arbol=^nodo;
  nodo=record
    ele:infoNodo;
    HI,HD:arbol;
  end;
procedure inicializarVec(var v:vector);
var i:integer;
begin
  for i:=1 to df do v[i]:=0; 
end;
procedure cargarReg(var d:atenciones);
begin
  writeln('ingrese el mes '); d.mes:=random(13);
  if(d.mes<>0)then begin 
    writeln('ingrese el dni '); d.dni:=random(123);
    writeln('ingrese el cod de diagnostico '); d.codD:=random(15)+1;
  end; 
end;
procedure cargarVec(var v:vector;dl:integer);
begin 
  v[dl]:=v[dl]+1;
end;
procedure agregar(var a:arbol;d:atenciones);
begin
  if(a=Nil)then begin 
    new(a); a^.ele.dni:=d.dni; a^.HI:=nil; a^.HD:=nil;
    a^.ele.cantT:=1;
  end
  else if(a^.ele.dni=d.dni)then a^.ele.cantT:=a^.ele.cantT+1
		else if(a^.ele.dni>=d.dni)then agregar(a^.HI,d)
			 else agregar(a^.HD,d);
end;
procedure estructurasDeDatos(var a:arbol;var v:vector);
var d:atenciones;
begin 
  cargarReg(d);
  inicializarVec(v);
  while(d.mes<>0)do begin 
    agregar(a,d);
    cargarVec(v,d.codD);
    cargarReg(d);
  end; 
end;
procedure imprimir(a:arbol);
begin
  if(a<>Nil)then begin 
    imprimir(a^.HI);
     writeln('dni del paciente ', a^.ele.dni,' y cantidad TOTAL de atenciones: ', a^.ele.cantT);
    imprimir(a^.HD);
  end; 
end; 
procedure imprimirV(v:vector);
var i:integer;
begin
  for i:=1 to df do writeln(v[i]); 
end;
function cantDePacientesEntre2Dnis(a:arbol;dni1,dni2,valor:integer):integer;
var cant:integer;
begin
  if(a<>nil)then begin
    if((a^.ele.dni>=dni1)and(a^.ele.dni<=dni2))then begin
      if(a^.ele.cantT>valor) then cant:=1 
      else cant:=0;
      cantDePacientesEntre2Dnis:=cantDePacientesEntre2Dnis(a^.HI,dni1,dni2,valor)+ cantDePacientesEntre2Dnis(a^.HD,dni1,dni2,valor)+cant;
    end 
    else if(a^.ele.dni>=dni1)then cantDePacientesEntre2Dnis:=cantDePacientesEntre2Dnis(a^.HI,dni1,dni2,valor)
		else cantDePacientesEntre2Dnis:=cantDePacientesEntre2Dnis(a^.HD,dni1,dni2,valor);
  end
  else cantDePacientesEntre2Dnis:=0; 
end;
function cantAtencionCeros(v:vector;df:integer):integer;
var cont:integer;
begin
  if(df>0)then begin 
    if(v[df]=0)then cont:=1
    else cont:=0;
    cantAtencionCeros:=cantAtencionCeros(v,df-1)+cont; 
  end
  else cantAtencionCeros:=0; 
end;
var
  a:arbol;
  v:vector;
  valor,x,y,cant:integer;
begin
  a:=nil;
  randomize();
  estructurasDeDatos(a,v);
  imprimir(a);
  imprimirV(v);
  writeln('ingrese el primer dni '); readln(x);
  writeln('ingrese el segundo dni '); readln(y);
  writeln('ingrese la cantidad de atenciones '); readln(valor);
  cant:=cantDePacientesEntre2Dnis(a,x,y,valor);
  writeln('cantida de atenciones mayores a ',valor,' entre el dni ',x,' y el dni ',y,' es ',cant); 
  cant:=cantAtencionCeros(v,df);
  writeln('cantidad de diagnosticos para los cuales la cantidad de atenciones fue cero ',cant);
end.
