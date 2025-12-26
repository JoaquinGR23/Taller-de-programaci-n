program parcial; 
const df=24;
type 
  sub_fecha=2000..2023;
  poliza=record
    dniCli:integer;
    valor,sumaA:real;
    fechaV:sub_fecha;
  end;
  arbol=^nodo;
  nodo=record
    ele:poliza;
    HD,HI:arbol;
  end;
  lista=^nodo2;
  nodo2=record
    ele:poliza;
    sig:lista;
  end;
  vector=array[1..df]of lista;
procedure cargarReg(var d:poliza);
begin 
  writeln('ingrese el dni cliente '); d.dniCli:=random(15)-1;
  if(d.dniCli<>-1)then begin 
    writeln('ingrese la suma acumulada '); d.sumaA:=random(15); 
    writeln('ingrese el valor de la cuota '); d.valor:=random(15)+64.30;
    writeln('ingrese la fecha de vencimiento '); d.fechaV:=random(24)+2000;
  end; 
end;

procedure agregar(var a:arbol;d:poliza);
begin
  if(a=nil)then begin 
    new(a); a^.ele:=d; a^.HI:=nil; a^.HD:=nil;
  end
  else if(a^.ele.sumaA>=d.sumaA)then agregar(a^.HI,d)
			else agregar(a^.HD,d);
end;
procedure cargar(var a:arbol);
var d:poliza;
begin
  cargarReg(d);
  while(d.dniCli<>-1)do begin 
    agregar(a,d);
    cargarReg(d);
  end; 
end;

procedure informarDatos(d:poliza);
begin
    writeln('suma agregada es ',d.sumaA:0:2); 
    writeln('dni cliente ',d.dniCli);
    writeln('valor de la cuota ', d.valor:0:2); 
    writeln('fecha de vencimiento ',d.fechaV); 
end;
procedure imprimir(a:arbol);
begin
  if(a<>nil)then begin 
    imprimir(a^.HI);
    informarDatos(a^.ele);
    imprimir(a^.HD);
  end; 
end;
procedure inicializarVec(var v:vector);
var i:integer;
begin
  for i:=1 to df do v[i]:=nil; 
end;
procedure agregarVec(var l:lista;d:poliza);
var ant,actual,nuevo:lista;
begin
    new(nuevo); nuevo^.ele:=d; nuevo^.sig:=nil;
    if(l=nil)then l:=nuevo 
    else begin
      actual:=l;
      while((actual<>nil)and(actual^.ele.dniCli<nuevo^.ele.dniCli))do begin 
        ant:=actual;
        actual:=actual^.sig;
      end;
      if(actual=l)then begin 
        nuevo^.sig:=l; l:=nuevo;
      end  
      else begin 
        ant^.sig:=nuevo; nuevo^.sig:=actual;
      end;
    end;
end;
procedure nuevaEstructura(a:arbol;var v:vector;valor:real);
begin
  if(a<>nil)then begin 
    if(a^.ele.sumaA>=valor)then nuevaEstructura(a^.HI,v,valor)
    else begin
       agregarVec(v[a^.ele.fechaV-1999],a^.ele); 
       nuevaEstructura(a^.HI,v,valor);
       nuevaEstructura(a^.HD,v,valor);
    end
  end; 
end;
procedure imprimirL(l:lista);
begin
  while(l<>nil)do begin 
     informarDatos(l^.ele);
     l:=l^.sig;
  end; 
end;
procedure imprimirV(v:vector);
var i:integer;
begin 
  for i:=1 to df do begin 
    writeln('------------------------');
    writeln('LISTA ', i);
    writeln('------------------------');
    imprimirL(v[i])
  end;
end;
function buscarLista(l:lista;dni:integer):integer;
var cant:integer;
begin
  cant:=0;
  while(l<>nil)do begin 
    if(l^.ele.dniCli=dni)then cant:=cant+1;
    l:=l^.sig;
  end; 
  buscarLista:=cant;
end; 
function cantPolizasDeUnDni(v:vector;dni:integer):integer;
var cant,i:integer;
begin 
  cant:=0;
  for i:=1 to df do cant:=cant+buscarLista(v[i],dni); 
  cantPolizasDeUnDni:=cant;
end;
var
  a:arbol;
  v:vector;
  valor:real;
  dni,cant:integer;
begin 
  a:=nil;
  randomize();
  cargar(a);
  imprimir(a);
  inicializarVec(v);
  writeln('ingrese el valor '); readln(valor);
  nuevaEstructura(a,v,valor);
  imprimirV(v);
  writeln('ingrese un dni '); readln(dni);
  cant:=cantPolizasDeUnDni(v,dni);
  writeln('La cantidad de polizas que tiene el dni ',dni, ' es ',cant);
end.
