program parcial;
const df=5;
type
  sub_cat=1..5;
  compras=record
    codV,codCli:integer;
    cat:sub_cat;
  end;
  infoNodo=record
    codV,cant:integer;
  end;
  arbol=^nodo;
  nodo=record
    ele:infoNodo;
    HD,HI:arbol;
  end;
  reg=record
    cat:string;
    cant:integer;
  end;
  vector=array[1..df] of reg;
procedure inicializarV(var v:vector);
var i:integer;
begin
  for i:=1 to df do v[i].cant:=0;
  v[1].cat:='full'; v[2].cat:='super'; v[3].cat:='media'; v[4].cat:='normal'; v[5].cat:='estandar'; 
end;
procedure cargarReg(var d:compras);
begin
  writeln('ingrese el cod de cliente: '); d.codCli:=random(15);
  if(d.codCli<>0)then begin 
    writeln('ingrese el cod de videojuego: '); d.codV:=random(15);
    writeln('ingrese la categoria: '); d.cat:=random(5)+1;
  end; 
end;
procedure agregar(var a:arbol;codV:integer);
begin
  if(a=nil)then begin 
    new(a); a^.ele.codV:=codV; a^.HI:=nil; a^.HD:=nil; a^.ele.cant:=1;
  end
  else if(a^.ele.codV=codV)then a^.ele.cant:=a^.ele.cant+1 
	   else if(a^.ele.codV>=codV)then agregar(a^.HI,codV) 
			else agregar(a^.HD,codV);
end;
procedure contarV(var cant:integer);
begin
  cant:=cant+1; 
end;
procedure cargarEstructuras(var a:arbol;var v:vector);
var d:compras;
begin
  a:=nil;
  randomize();
  inicializarV(v);
  cargarReg(d);
  while(d.codCli<>0)do begin 
    agregar(a,d.codV);
    contarV(v[d.cat].cant);
    cargarReg(d);
  end; 
end;
procedure imprimirA(a:arbol);
begin
  if(a<>nil)then begin 
    imprimirA(a^.HI);
    writeln('cod de videojuego: ', a^.ele.codV); writeln('cant de compras: ', a^.ele.cant);
    imprimirA(a^.HD);
  end; 
end;
procedure imprimirV(v:vector);
var i:integer;
begin
  for i:=1 to df do writeln(v[i].cat, ' y su cantidad de compras: ',v[i].cant) 
end;
function cantSupAunCodIngresado(a:arbol;cod:integer):integer;
begin 
  if(a<>nil)then begin 
    if(a^.ele.codV>cod) then cantSupAunCodIngresado:=cantSupAunCodIngresado(a^.HI,cod)+ cantSupAunCodIngresado(a^.HD,cod)+1
    else cantSupAunCodIngresado:=cantSupAunCodIngresado(a^.HD,cod);
  end
  else cantSupAunCodIngresado:=0;
end;
procedure ordenarVec(var v:vector;var cat:string);
var i,j:integer; actual:reg;
begin 
  for i:=2 to df do begin 
    j:=i-1; actual:=v[i];
    while((j>0)and(v[j].cant<actual.cant)) do begin 
      v[j+1]:=v[j];  j:=j-1; 
    end;
    v[j+1]:=actual;
  end;
  cat:=v[df].cat;
end;
var a:arbol; v:vector; cant,cod:integer; cat:string;
begin 
  cargarEstructuras(a,v);
  imprimirA(a);
  imprimirV(v);
  writeln('ingrese un codigo: '); readln(cod);
  cant:= cantSupAunCodIngresado(a,cod);
  writeln('cantidad de videojuegos con cod superior al ingresado: ', cant);
  ordenarVec(v,cat);
  imprimirV(v);
  writeln('categoria con menor cantidad: ',cat);
end.
