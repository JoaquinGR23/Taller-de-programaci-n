program ejer;
const df=100;
type
  sub1=0..1000;
  cliente=record
	cod:sub1;
	dir:string;
	dl:integer;
  end;
  mensaje=record
	dirE,fecha,asunto,texto:string;
	leido:boolean;
  end;
  infoIngreso=record
	cli:cliente;
	correo:mensaje;
  end;
  vector =array[1..df]of mensaje;
  infoNodo=record
	cli:cliente;
	m:vector;
  end;
  arbol=^nodo2;
  nodo2=record
	HI,HD:arbol;
	ele:infoNodo;
  end;
procedure cargarReg(var d:infoIngreso);
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
procedure agregarV(var v:vector;var dl:integer; d:mensaje);
begin
  dl:=dl+1;
  v[dl]:=d;
end;
procedure agregar(var a:arbol; d:infoIngreso);
begin
  if(a=nil)then begin 
    new(a); a^.ele.cli:=d.cli; a^.HI:=nil; a^.HD:=nil; a^.ele.cli.dl:=0;
    agregarV(a^.ele.m,a^.ele.cli.dl,d.correo);	
  end
  else if(a^.ele.cli.cod=d.cli.cod)then begin 
		  if(a^.ele.cli.dl<df)then agregarV(a^.ele.m,a^.ele.cli.dl,d.correo)
		  else writeln('vector lleno')
	   end
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
