program ejer;
const df=12;
type 
  sub_mes=1..12;
  compras=record
    codCli,numF:integer;
    monto:real;
    mes:sub_mes;
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
  writeln('ingrese el cod de cliente'); d.codCli:=random(15);
  if(d.codCli<>0)then begin 
    writeln('ingrese el num de factura '); d.numF:=random(15);
    writeln('ingrese el mes'); d.mes:=random(12)+1;
    writeln('ingrese el monto '); d.monto:=random(15)+32.12;
  end; 
end;
procedure inicializarVec(var v:vector);
var i:integer;
begin 
  for i:=1 to df do begin 
    v[i]:=0;
  end;
end;
procedure sumaMonto(var v:vector;dl:integer; m:real);
begin 
  v[dl]:=v[dl]+m;
end;
procedure agregar(var a:arbol;d:compras);
begin
  if(a=nil)then begin 
    new(a); a^.ele.codCli:=d.codCli; a^.HI:=NIl; a^.HD:=NIl;
    inicializarVec(a^.ele.v); sumaMonto(a^.ele.v,d.mes,d.monto); writeln('-------------AQUI----------------');
  end
  else if(a^.ele.codCli=d.codCli)then sumaMonto(a^.ele.v,d.mes,d.monto)
	   else if(a^.ele.codCli>=d.codCli)then agregar(a^.HI,d)
			else agregar(a^.HD,d);
end;
procedure cargar(var a:arbol);
var d:compras;
begin 
  a:=nil;
  cargarReg(d);
  while(d.codCli<>0)do begin 
    agregar(a,d);
	cargarReg(d);
  end;
end;
procedure imprimirVec(v:vector);
var i:integer;
begin 
  for i:=1 to df do begin 
    writeln('mes ', i);
    writeln(v[i]:0:2);
  end;
end;
procedure imprimir(a:arbol);
begin
  if(a<>Nil)then begin 
    imprimir(a^.HI);
    writeln('cod cliente: ',a^.ele.codCli); imprimirVec(a^.ele.v); 
    imprimir(a^.HD);
  end; 
end;
procedure buscarMax(v:vector;var max:real;var mesMax:integer);
var i:integer;
begin 
   for i:=1 to df do begin 
     if(max<v[i])then begin 
       max:=v[i]; mesMax:=i;
     end;
   end;
end;
procedure mesQueMasGastoEseCliente(a:arbol;cli:integer;var max:real;var mesMax:integer);
begin
  if(a<>nil)then begin 
    if(a^.ele.codCli=cli) then buscarMax(a^.ele.v,max,mesMax)
    else if(a^.ele.codCli>=cli)then mesQueMasGastoEseCliente(a^.HI,cli,max,mesMax)
		 else mesQueMasGastoEseCliente(a^.HD,cli,max,mesMax);
  end; 
end;
function cantSinGastosEnDichoMes(a:arbol;mes:integer):integer;
var cant:integer;
begin 
  if(a<>nil)then begin 
    if(a^.ele.v[mes]=0)then cant:=1
    else cant:=0;
    cantSinGastosEnDichoMes:=cantSinGastosEnDichoMes(a^.HI,mes)+cantSinGastosEnDichoMes(a^.HD,mes)+cant
  end
  else cantSinGastosEnDichoMes:=0;
end;
var a:arbol; cli,mesMax,mes,cant:integer; max:real;
begin 
  randomize();
  cargar(a);
  imprimir(a);
  writeln('ingrese un cod de cliente'); readln(cli);
  mesQueMasGastoEseCliente(a,cli,max,mesMax);
  writeln('mes que mayor gasto tuvo ese cliente es ', mesMax);
  writeln('ingrese un mes'); readln(mes);
  cant:=cantSinGastosEnDichoMes(a,mes);
  writeln('la cantidad de clientes sin gastos en ese mes es ', cant);
end.
