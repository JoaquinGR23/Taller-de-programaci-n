program p4e2;
type
  str80=string[80];
  int80=0..80;
  socios=record
    num:integer;
    edad: int80;
    nom:str80;
  end;
  arbol=^nodo;
  nodo=record
	HI,HD:arbol;
	ele:socios;
  end;
  vectorNom=array[0..9]of str80;
procedure cargarReg(var s:socios);
var v:vectorNom=('joaquin','jorge','jose','vilma','juan','rodrigo','mauro','damian','josefina','ana');
begin
  s.num:=random(15);
  if(s.num <>0)then begin 
	s.edad:=random(81); s.nom:=v[random(10)];
  end;
end;
procedure agregar(var a:arbol; s:socios);
begin
  if(a=nil)then begin 
    new(a); a^.ele:=s; a^.HI:=nil; a^.HD:=nil; 
  end
  else if(a^.ele.num>=s.num)then agregar(a^.HI,s)
       else agregar(a^.HD,s);
end;
procedure cargar(var a:arbol);
var
  s:socios;
begin
  cargarReg(s);
  if(s.num <> 0)then begin 
	agregar(a,s);
	cargar(a);
  end;
end;
procedure informarDatos(dato:socios);
begin
  writeln('num de socio: ', dato.num); writeln('edad de socio: ', dato.edad); writeln('nom de socio: ', dato.nom); 
end;
procedure datosSociosCreciente(a:arbol);
begin
  if(a<>nil)then begin 
	datosSociosCreciente(a^.HI);
	informarDatos(a^.ele);
	datosSociosCreciente(a^.HD);
  end; 
end;
function informarSocioMasGrande(a:arbol):integer;
{i. Informar el número de socio más grande. Debe invocar a un módulo recursivo que retorne dicho valor.}
begin
  if(a^.HD<>nil)then informarSocioMasGrande:=informarSocioMasGrande(a^.HD)
  else informarSocioMasGrande:=a^.ele.num;
end;
function EncontrarSocio(a:arbol):arbol;
begin
  if(a^.HI<>nil) then EncontrarSocio:=EncontrarSocio(a^.HI)
  else EncontrarSocio:=a; 
end;
procedure informarDatosDelSocioMasChico(a:arbol);
{ii. Informar los datos del socio con el número de socio más chico. Debe invocar a unmódulo recursivo que retorne dicho socio.}
var socio:arbol;
begin 
  socio:=EncontrarSocio(a);
  if(socio<>nil) then begin 
    informarDatos(socio^.ele);
  end;
end;
function buscarSocio(a:arbol;num:integer):boolean;
{iii. Leer un valor entero e informar si existe o no existe un socio con ese valor. 
Debe invocar a un módulo recursivo que reciba el valor leído y retornar verdadero o falso.}
begin 
  if(a<>nil)then begin 
    if(a^.ele.num=num)then buscarSocio:=true
    else if(a^.ele.num>=num)then buscarSocio:=buscarSocio(a^.HI,num) 
		else buscarSocio:=buscarSocio(a^.HD,num);
  end
  else buscarSocio:=false;
end;
function cantSociosEntreCodigos(a:arbol;inf,sup:integer):integer;
{iv. Leer e informar la cantidad de socios cuyos códigos se encuentran comprendidos
entre los valores leídos. Debe invocar a un módulo recursivo que reciba los valores
leídos y retorne la cantidad solicitada.}
begin
  if(a<>nil)then begin 
    if((a^.ele.num>=inf)and(a^.ele.num<=sup))then cantSociosEntreCodigos:=cantSociosEntreCodigos(a^.HI,inf,sup)
    +cantSociosEntreCodigos(a^.HD,inf,sup)+1 
    else if(a^.ele.num>=inf)then cantSociosEntreCodigos:=cantSociosEntreCodigos(a^.HI,inf,sup) 
		 else cantSociosEntreCodigos:=cantSociosEntreCodigos(a^.HD,inf,sup);
  end
  else cantSociosEntreCodigos:=0; 
end;
var
 num,inf,sup,cant:integer;
 a:arbol;
begin
  a:=nil;
  randomize();
  cargar(a);
  if(a<> nil)then begin  
    writeln('CRECIENTE ');
    datosSociosCreciente(a);
    writeln('el socio mas grande es ',informarSocioMasGrande(a));
    informarDatosDelSocioMasChico(a);
    writeln('ingrese el socio a buscar '); readln(num);
    writeln('socio a encontrar: ', buscarSocio(a,num));
    writeln('ingrese el el limite inferior '); readln(inf); writeln('ingrese el limite superior '); readln(sup);
    cant:=cantSociosEntreCodigos(a,inf,sup);
    writeln('cantidad de socio entre ',inf,' y ',sup,' es ',cant);
  end; 
end.
