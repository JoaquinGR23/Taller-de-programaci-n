program parcialTN_recursante2024; //18:46
const df=12;
type sub_diag='L'..'P';
	 sub_mes=1..12;
	 atenciones=record
	   mat,dni:integer;
	   mes:sub_mes;
	   diag:sub_diag;
	 end;
	 infoNodo=record
	    dni:integer;
	    diag:sub_diag;
	 end;
	 arbol=^nodo;
	 nodo=record
	   ele:infoNodo;
	   HD,HI:arbol;
	 end;
	 vector2=array[1..5]of char;
	 vector=array[1..df] of arbol;
procedure cargarReg(var d:atenciones);
var v:vector2=('L','M','N','O','P');
begin
  writeln('ingrese la matricula '); d.mat:=random(15);
  if(d.mat<>0)then begin 
    writeln('ingrese el mes '); d.mes:=random(12)+1;
    writeln('ingrese el dni '); d.dni:=random(1212)+1;
    writeln('ingrese el diagnostico '); d.diag:=v[random(5)+1];
  end; 
end;
procedure inicializarVec(var v:vector);
var i:integer;
begin
  for i:=1 to df do v[i]:=nil; 
end;
procedure agregar(var a:arbol; d:atenciones);
begin
  if(a=nil)then begin 
    new(a); a^.ele.dni:=d.dni; a^.ele.diag:=d.diag; a^.HD:=nil; a^.HI:=nil;
  end
  else if(a^.ele.dni>=d.dni)then agregar(a^.HI,d)
	   else agregar(a^.HD,d);
end;
procedure cargar(var v:vector);
var d:atenciones;
begin 
  inicializarVec(v);
  cargarReg(d);
  while(d.mat<>0)do begin 
    agregar(v[d.mes],d);
    cargarReg(d);
  end;
end;
procedure imprimirA(a:arbol);
begin
  if(a<>Nil)then begin 
    imprimirA(a^.HI);
    writeln('dni ', a^.ele.dni); writeln('diagnostico ', a^.ele.diag);
    imprimirA(a^.HD); 
  end;
end;
procedure imprimir(v:vector);
var i:integer;
begin
  for i:=1 to df do begin 
    writeln('------------ARBOL ',i,'--------------');
    imprimirA(v[i]);
  end;
end;
function ContarAtenciones(a:arbol):integer;
begin
  if(a<>Nil)then ContarAtenciones:=ContarAtenciones(a^.HI)+ ContarAtenciones(a^.HD)+1
  else ContarAtenciones:=0; 
end;
procedure mesMayorCantidadDeAtenciones(v:vector;dl:integer;var max,mesMax:integer);
var cant:integer;
begin 
  if(dl>0)then begin 
    cant:=ContarAtenciones(v[dl]);
    if(max<cant)then begin 
      max:=cant; mesMax:=dl;
    end;
    mesMayorCantidadDeAtenciones(v,dl-1,max,mesMax);
  end;
end;
function buscarDni(a:arbol; dni:integer):boolean;
begin 
  if(a<>Nil)then begin 
    if(a^.ele.dni=dni)then buscarDni:=true
    else if(a^.ele.dni>=dni)then buscarDni:=buscarDni(a^.HI,dni) 
		 else buscarDni:=buscarDni(a^.HD,dni);
  end
  else buscarDni:=false;
end;
function AtencionDelPaciente(v:vector;dni:integer):boolean;
var dl:integer; encontre:boolean;
begin 
  dl:=1; encontre:=false;
  while((dl<=df)and (not encontre))do  begin 
    encontre:=buscarDni(v[dl],dni);
    dl:=dl+1;
  end;   
  AtencionDelPaciente:=encontre;
end;	 
var v:vector; dni,max,mesMax,dl:integer;
begin 
  randomize();
  cargar(v);
  imprimir(v);
  dl:=df;
  max:=-1;
  mesMayorCantidadDeAtenciones(v,dl,max,mesMax);
  writeln('mes con mayor cantidad de atenciones es el mes ', mesMax);
  writeln('ingrese el dni '); readln(dni);
  if(AtencionDelPaciente(v,dni)) then writeln('El paciente fue atendido ')
  else writeln('El paciente no fue atendido ');
end.
