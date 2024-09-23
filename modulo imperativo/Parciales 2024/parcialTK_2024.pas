program parcialTK_2024;

type
  sub_genero=1..15;
  infoLibro=record
    isbn,anio:integer;
    codGen:sub_genero;
  end;
  infoCarga=record
    codAu:integer;
    info:infoLibro;
  end;
  lista=^nodo;
  nodo=record
    ele:infoLibro;
    sig:lista;
  end;
  infoNodo=record
    codAu:integer;
    lis:lista;
  end;
  arbol=^nodo2;
  nodo2=record
    ele:infoNodo;
    HD,HI:arbol;
  end;
  reg=record
    codAu,cant:integer;
  end;
  listaNueva=^nodo3;
  nodo3=record
    ele:reg;
    sig:listaNueva;
  end;
procedure cargarReg(var d:infoCarga);
begin
  writeln('ingrese el isb: '); d.info.isbn:=random(15);
  if(d.info.isbn<>0)then begin 
    writeln('ingrese el cod de autor: '); d.codAu:=random(15);
    writeln('ingrese el anio: '); d.info.anio:=random(23)+2000; 
    writeln('ingrese el cod de genero: '); d.info.codGen:=random(15)+1;
  end; 
end;
procedure agregarL(var l:lista; d:infoLibro);
var nuevo:lista;
begin
  new(nuevo); nuevo^.ele:=d; nuevo^.sig:=l; l:=nuevo; 
end;
procedure agregar(var a:arbol;d:infoCarga);
begin
  if(a=nil)then begin 
    new(a); a^.ele.codAu:=d.codAu; a^.ele.lis:=nil; a^.HI:=NIL; a^.HD:=NIL;
    agregarL(a^.ele.lis,d.info);
  end
  else if(a^.ele.codAu=d.codAu)then agregarL(a^.ele.lis,d.info)
	   else if(a^.ele.codAu>=d.codAu)then agregar(a^.HI,d)
			else agregar(a^.HD,d);
end;
procedure cargar(var a:arbol);
var d:infoCarga;
begin 
  a:=nil; randomize();
  cargarReg(d);
  while(d.info.isbn<>0)do begin
    agregar(a,d);
    cargarReg(d);
  end;
end;
procedure imprimirL(l:lista);
begin
  writeln('------LIBROS DEL AUTOR----');
  while(l<>nil)do begin 
    writeln('isb: ',l^.ele.isbn); writeln('anio: ',l^.ele.anio); writeln('cod de genero: ',l^.ele.codGen);
    l:=l^.sig;
  end; 
end;
procedure imprimir(a:arbol);
begin
  if(a<>nil)then begin 
    imprimir(a^.HI);
    writeln('cod de autor: ',a^.ele.codAu); imprimirL(a^.ele.lis);
    imprimir(a^.HD);
  end; 
end;
function contarLibros(l:lista):integer;
var cant:integer;
begin
  cant:=0;
  while(l<>nil)do begin 
    cant:=cant+1; l:=l^.sig;
  end;
  contarLibros:=cant; 
end;
procedure armarNodo(cant,autor:integer;var nodo:reg);
begin
  nodo.codAu:=autor; nodo.cant:=cant; 
end;
procedure agregarLNueva(var l:listaNueva;nodo:reg);
var nuevo:listaNueva;
begin
  new(nuevo); nuevo^.ele:=nodo; nuevo^.sig:=l; l:=nuevo; 
end;
procedure generarLista(l:lista; autor:integer;var l2:listaNueva);
var 
  cant:integer;  nodo:reg;
begin
  cant:=contarLibros(l);
  armarNodo(cant,autor,nodo);
  agregarLNueva(l2,nodo); 
end;
procedure crearNuevaLista(a:arbol;cod:integer;var l:listaNueva);
begin 
  if(a<>Nil)then begin 
    if(a^.ele.codAu<=cod)then crearNuevaLista(a^.HD,cod,l)
    else begin 
      generarLista(a^.ele.lis,a^.ele.codAu,l);
      crearNuevaLista(a^.HI,cod,l);
      crearNuevaLista(a^.HD,cod,l);
    end;
  end;
end;
procedure imprimirLNueva(l:listaNueva);
begin
  while(l<>nil)do begin 
    writeln('cod de autor: ', l^.ele.codAu); writeln('cantidad de libros: ', l^.ele.cant);
    l:=l^.sig;
  end; 
end;
procedure autorConMayorCantidadDeLibros(l:listaNueva;var cantMayor,codMayor:integer);
begin
  if(l<>nil) then begin 
    if(cantMayor<l^.ele.cant)then begin 
      cantMayor:=l^.ele.cant; codMayor:=l^.ele.codAu;
    end;
    autorConMayorCantidadDeLibros(l^.sig,cantMayor,codMayor);
  end; 
end;
var a:arbol; l:listaNueva; cod,cantMayor,codMayor:integer;
begin 
  cargar(a); //PUNTO A
  imprimir(a);
  writeln('ingrese un codigo: '); readln(cod);
  l:=nil;
  crearNuevaLista(a,cod,l);//PUNTO B
  imprimirLNueva(l);
  cantMayor:=-1;
  autorConMayorCantidadDeLibros(l,cantMayor,codMayor); //PUNTO C
  writeln('cod de autor: ',codMayor, ' y su cantidad de libros ', cantMayor);
end.
