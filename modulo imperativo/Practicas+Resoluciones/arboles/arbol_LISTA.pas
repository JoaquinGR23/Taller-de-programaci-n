program ejer;
type
  sub1=0..1000;
  cliente=record   //INFORMACION PRINCIPAL DEL ARBOL
	cod:sub1;
	dir:string;
  end;
  mensaje=record  //INFORMACION DE LA LISTA
	dirE,fecha,asunto,texto:string;
	leido:boolean;
  end;
  infoIngreso=record	//INFORMACION PRINCIPAL DE INGRESAR
	cli:cliente;  //PARA EL NODO DEL ARBOL
	correo:mensaje;	//PARA EL NODO DE LA LISTA
  end;
  lista=^nodo;
  nodo=record
	ele:mensaje;
	sig:lista;
  end;
  infoNodo=record   //INFORMACION DEL NODO DEL ARBOL
	cli:cliente;
	m:lista;
  end;
  arbol=^nodo2;
  nodo2=record
	HI,HD:arbol;
	ele:infoNodo;
  end;
procedure cargarReg(var d:infoIngreso); //CARGA DE TODA LA INFORMACION
var i:integer;
begin
  readln(d.cli.cod);
  if(d.cli.cod<>0) then begin 
	readln(d.cli.dir); 
	readln(d.correo.dirE); 
	readln(d.correo.fecha); 
	readln(d.correo.asunto); 
	readln(d.correo.texto); 
	writeln('ingrese 1 si el msj fue leido sino pulse cualquier tecla en caso contrario');
	readln(i);
	d.correo.leido:=(i=1);
	
  end; 
end;
procedure agregarL(var l:lista; d:mensaje); 
var nuevo:lista;
begin
  new(nuevo); nuevo^.ele:=d; nuevo^.sig:=l; l:=nuevo;
end;
procedure agregar(var a:arbol; d:infoIngreso);
begin
  if(a=nil)then begin 
    new(a); a^.ele.cli:=d.cli; a^.HI:=nil; a^.HD:=nil; a^.ele.m:=nil;
    agregarL(a^.ele.m,d.correo);	
  end
  else if(a^.ele.cli.cod=d.cli.cod)then agregarL(a^.ele.m,d.correo)
       else if(a^.ele.cli.cod>=d.cli.cod)then agregar(a^.HI,d) 
			else agregar(a^.HD,d);
end;
procedure cargar(var a:arbol);
var d:infoIngreso;
begin 
  cargarReg(d);
  if(d.cli.cod<>0)then begin 
    agregar(a,d);
    cargar(a);
  end;
end;
var
 a:arbol;
begin 
  a:=nil;
  cargar(a);
end.
