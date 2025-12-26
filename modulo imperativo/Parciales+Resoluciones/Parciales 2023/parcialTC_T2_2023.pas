program ParcialTC2;
const df=12;
type 
  sub_mes=1..12;
  compras=record
    codCli:integer;
    mes:sub_mes;
    monto:real;
  end;
  vector=array[1..df] of real;
  infoNodo=record
    codCli:integer;
    v:vector;
  end;
  arbol=^nodo;
  nodo=record
    ele:infoNodo;
    HD,HI:arbol;
  end;
procedure cargarReg(var d:compras);
begin
  writeln('ingrese el codigo '); d.codCli:=random(25); 
  if(d.codCli<>0)then begin 
    writeln('ingrese el mes de la compra '); d.mes:=random(12)+1; 
    writeln('ingrese el monto  de la compra '); d.monto:=random(15)+64.24; 
  end;
end;
procedure inicializarVec(var v:vector);
var i:integer;
begin 
  for i:=1 to df do v[i]:=0
end;
procedure cargarVec(var v:vector;dl:integer;m:real);
begin
  v[dl]:=v[dl]+m; 
end;
procedure agregar(var a:arbol;d:compras);
begin 
  if(a=nil)then begin 
    new(a); a^.ele.codCli:=d.codCli; a^.HI:=nil; a^.HD:=nil;
    inicializarVec(a^.ele.v); cargarVec(a^.ele.v,d.mes,d.monto);
  end
  else if(a^.ele.codCli=d.codCli)then cargarVec(a^.ele.v,d.mes,d.monto)
	   else if(a^.ele.codCli>=d.codCli)then agregar(a^.HI,d)
			else agregar(a^.HD,d);
end;
procedure cargar(var a:arbol);
var d:compras;
begin
  a:=nil;
  randomize();
  cargarReg(d);
  while(d.codCli<>0)do begin 
    agregar(a,d);
    cargarReg(d);
  end; 
end;
procedure imprimirV(v:vector);
var i:integer;
begin 
  for i:=1 to df do writeln(v[i]:0:2)
end;
procedure imprimir(a:arbol);
begin
  if(a<>nil)then begin
    imprimir(a^.HI);
    writeln('cod de cliente ',a^.ele.codCli); imprimirV(a^.ele.v);
    imprimir(a^.HD);
  end; 
end;
function buscarVec(v:vector):integer;
var 
  i,mes:integer;
  max:real;
begin 
  max:=-1;
  for i:=1 to df do begin 
    if(v[i]>max)then begin 
      max:=v[i]; mes:=i;
    end;
  end;
  buscarVec:=mes;
end;
function buscarMesdeMayorGasto(a:arbol;cod:integer):integer;
begin
  if(a<>nil)then begin
    if(a^.ele.codCli=cod)then buscarMesdeMayorGasto:=buscarVec(a^.ele.v)
    else if(a^.ele.codCli=cod)then buscarMesdeMayorGasto:=buscarMesdeMayorGasto(a^.HI,cod) 
		 else buscarMesdeMayorGasto:=buscarMesdeMayorGasto(a^.HD,cod);
  end
  else buscarMesdeMayorGasto:=0; 
end;
function cantClientesSinGastosDeUnMes(a:arbol;mes:integer):integer;
var cant:integer;
begin
  if(a<>nil)then begin 
    if(a^.ele.v[mes]=0)then cant:=1
    else cant:=0;
    cantClientesSinGastosDeUnMes:=cantClientesSinGastosDeUnMes(a^.HI,mes)+cantClientesSinGastosDeUnMes(a^.HD,mes)+cant;
  end
  else cantClientesSinGastosDeUnMes:=0;
end;
var
  mesM,cod,cant,mes:integer; 
  a:arbol;
begin 
  cargar(a);
  imprimir(a);
  writeln('ingrese un cod de cliente'); read(cod);
  mesM:=buscarMesdeMayorGasto(a,cod);
  writeln('el mes con mayor gasto de dicho cliente es ', mesM);
  writeln('ingrese el mes '); read(mes);
  cant:=cantClientesSinGastosDeUnMes(a,mes);
  writeln('cantidad de clientes sin gastos en dicho mes es: ',cant);
end.
