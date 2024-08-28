program p3e1;
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
procedure datosSociosDecreciente(a:arbol);
begin
  if(a<>nil)then begin 
	datosSociosDecreciente(a^.HD);
	informarDatos(a^.ele);
	datosSociosDecreciente(a^.HI);
  end; 
end;
procedure mayorEdad(a:arbol;var max,num:integer);
begin 
  if(a<>nil)then begin
	if(a^.ele.edad>max) then begin 
	  max:= a^.ele.edad; num:=a^.ele.num;
	end;
	mayorEdad(a^.HI,max,num);
	mayorEdad(a^.HD,max,num);
  end;
end;
function AumentarEdad(a:arbol):integer; //Implementar la funcion 
var resto: integer;
begin
  if (a<>nil)then begin 
     resto:= a^.ele.edad mod 2;
     if (resto = 1) then a^.ele.edad:= a^.ele.edad + 1;
     AumentarEdad:= resto + AumentarEdad (a^.HI) + AumentarEdad (a^.HD);
  end 
  else AumentarEdad:= 0
end;

procedure aumentarEdadEinformarCantidad(a:arbol);  
begin
   writeln('cantidad de socios con edad aumentada ',AumentarEdad(a));
end; 
function busquedaNom(a:arbol;nom:str80):boolean; 
begin
  if(a<>nil)then begin 
    if(a^.ele.nom=nom)then busquedaNom:=true
    else busquedaNom:= busquedaNom(a^.HI,nom) or busquedaNom(a^.HD,nom)
  end
  else busquedaNom:=false; 
end;
// OTRA FORMA DE BUSCAR EL NOMBRE 
{function busquedaNom2(a:arbol;nom:str80):boolean; //chequear busqueda
var existe:boolean;
begin
  if(a<>nil)then begin 
    if(a^.ele.nom=nom)then busquedaNom2:=true
    else begin 
      existe:= busquedaNom2(a^.HI,nom);
      if(not existe)then existe:=busquedaNom2(a^.HD,nom);
      busquedaNom2:=existe;
    end;
  end
  else busquedaNom2:=false;
end;
}
FUNCTION cantSocios(a:arbol):integer;
begin
  if(a<>nil)then cantSocios:= cantSocios(a^.HI)+ cantSocios(a^.HD)+1
  else cantSocios:=0;
end; 

function sumaEdades(a:arbol):integer;
begin
  if(a<>nil)then sumaEdades:= a^.ele.edad+ sumaEdades(a^.HI)+ sumaEdades(a^.HD)
  else sumaEdades:=0;
end;

{procedure recorrerArbol(a:arbol;var suma,cant:integer);  //MEJOR FORMA PARA IMPRIMIR EL PROMEDIO DE EDADES
begin
  if(a<>nil)then begin 
    recorrerArbol(a^.HI,suma,cant);
    suma:= suma + a^.ele.edad;
    cant:=cant+1;
    recorrerArbol(a^.HD,suma,cant);
  end 
end;}
function promedioEdades(a:arbol):real; //Promedio 
//var suma,cant: integer;
begin
   //suma:=0; cant:=0;
   //recorrerArbol(a,suma,cant);
   //promedioEdades:= (suma/cant);
   promedioEdades:= (sumaEdades(a)/cantSocios(a));
end;
var
 a:arbol;
 max,num:integer;
 nom:str80;
begin
  a:=nil;
  randomize();
  cargar(a);
  if(a<> nil) then begin 
    writeln('CRECIENTE ');
    datosSociosCreciente(a);
    writeln('DECRECIENTE ');
    datosSociosDecreciente(a);
    max:=-9999;
    mayorEdad(a,max,num);
    writeln('num de socio con mayor edad',num);
	aumentarEdadEinformarCantidad(a);
	readln(nom);
	if(busquedaNom(a,nom))then writeln('existe un socio con ese nombre')
	else writeln('NO existe un socio con ese nombre'); 
	{if(busquedaNom2(a,nom))then writeln('existe un socio con ese nombre')  //OTRA FORMA DE BUSCAR UN NOMBRE 
	else writeln('NO existe un socio con ese nombre');}
	writeln('cantidad de socios ',cantSocios(a));
	writeln('promedio de edades de los socios ',promedioEdades(a)); 
  end;
end.
