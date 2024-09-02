program e3p3;

type
  infoMateria=record  //para la lista
    cod:integer;
    nota:real;
    fecha:string;
  end;
  infoCarga=record  //Informacion de ingreso
    leg:integer;
    mat:infoMateria;
  end;
  lista=^nodo1;
  nodo1=record
    ele:infoMateria;
    sig:lista;
  end;
  infoNodo=record  //para el arbol
    legajo:integer;
    dato:lista;
  end; 
  arbol=^nodo2;
  nodo2=record
	ele:infoNodo;
	HI,HD:arbol;
  end;
  info=record  
    legajo:integer;
    prom:real;
  end;
  lista2=^nodo3;   //Lista nueva
  nodo3=record
    ele:info;
    sig:Lista2;
  end;
procedure cargarReg(var d:infoCarga);
begin 
  writeln('legajo '); readln(d.leg);
  if(d.leg<>0)then begin 
    writeln('codigo de materia '); readln(d.mat.cod); 
    writeln('nota '); readln(d.mat.nota); 
    writeln('fecha '); readln(d.mat.fecha);
  end;
end;


procedure agregarL(var l:lista;d:infoMateria);
var nuevo:lista;
begin
  new(nuevo); nuevo^.ele:=d; nuevo^.sig:=l; l:=nuevo;
end;


procedure agregar(var a:arbol;d:infoCarga);
begin
  if(a=nil)then begin 
    new(a);  a^.ele.legajo:=d.leg; a^.ele.dato:=nil; a^.HI:=nil; a^.HD:=nil;
    agregarL(a^.ele.dato,d.mat);
  end
  else if(a^.ele.legajo=d.leg)then agregarL(a^.ele.dato,d.mat) 
	   else if(a^.ele.legajo>=d.leg) then agregar(a^.HI,d)
			else agregar(a^.HD,d);
end;


procedure cargar(var a:arbol);
var d:infoCarga;
begin 
  cargarReg(d);
  if(d.leg<>0)then begin 
    agregar(a,d);
    cargar(a);
  end;
end;


function legajoImpar(a:arbol):integer;
var resto:integer;
begin 
  if(a<>nil)then begin 
    resto:= (a^.ele.legajo mod 2);
    legajoImpar:= resto + legajoImpar(a^.HI)+ legajoImpar(a^.HD);
  end
  else legajoImpar:=0;
end;


function cantAprobadas(l:lista):integer;
var cont:integer;
begin
   cont:=0;
   while(l<>nil)do begin 
     if(l^.ele.nota >=4) then cont:=cont+1;
	 l:=l^.sig;
   end;
   cantAprobadas:=cont;
end;
procedure datosAlumno(d:infoNodo);
begin
  writeln('su legajo es ',d.legajo, ' la cantidad de materias aprobas es: ', cantAprobadas(d.dato)); 
end;
procedure InformarDatos(a:arbol);
begin
  if(a<>nil)then begin 
    informarDatos(a^.HI);
    datosAlumno(a^.ele);
    informarDatos(a^.HD);
  end; 
end;
function promDelAlu(l:lista):real;
var 
  cont:integer;
  notas:real;
begin
  cont:=0; notas:=0;
  while(l<>nil)do begin 
    cont:=cont+1; notas:=notas+l^.ele.nota; l:=l^.sig;
  end;
  promDelAlu:=(notas/cont); 
end;
procedure agregarLnueva(var l:lista2;leg:integer; p:real);
var nuevo:lista2;
begin
  new(nuevo); nuevo^.ele.legajo:=leg; nuevo^.ele.prom:=p; nuevo^.sig:=l; l:=nuevo;
end;
procedure promediosDeLosAlumnos(a:arbol;valor:real;var l:lista2);
var prom:real;
begin 
  if(a<>nil)then begin 
	prom:= promDelAlu(a^.ele.dato);
	if(prom>valor)then agregarLnueva(l,a^.ele.legajo, prom); 
	promediosDeLosAlumnos(a^.HI,valor,l);
	promediosDeLosAlumnos(a^.HD,valor,l);
  end;
end;
procedure imprimirL(l:lista2);
begin 
  while(l<>nil)do begin 
    writeln('legajo ',l^.ele.legajo); writeln('promedio ',l^.ele.prom); l:=l^.sig;
  end; 
end;
var
  a:arbol;
  l:lista2;
  valor:real;
begin 
  a:=nil;
  cargar(a);
  writeln('cantidad de alumnos con legajo impar ',legajoImpar(a));
  InformarDatos(a);
  readln(valor);
  l:=nil;
  promediosDeLosAlumnos(a,valor,l);
  imprimirL(l); 
end.
