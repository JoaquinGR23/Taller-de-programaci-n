program ejer1;
const
  df=15;
type
  vector=array[1..df]of integer;

procedure cargar(var v:vector;var dl:integer);
var
  num:integer;
begin
  num:=random(146)+10;
  if((dl<df)and(num<>20)) then begin 
    dl:=dl+1;
    v[dl]:=num;
    cargar(v,dl);
  end;
  
end;
procedure imprimirSinRecursion(v:vector; dl:integer);
var i:integer;
begin
  for i:=1 to dl do writeln(v[i])
end;
procedure imprimirConRecursion(v:vector;dl:integer);
begin
  if(dl>0)then begin
    imprimirConRecursion(v,dl-1); writeln(v[dl]);
  end; 
end;
function sumaPar(v:vector;dl:integer):integer;
begin 
  if(dl>0)then if(v[dl]mod 2 = 0)then sumaPar:=v[dl]+sumaPar(v,dl-1)
			   else sumaPar:=sumaPar(v,dl-1)
  else sumaPar:=0;
end;
function maximo(v:vector;dl,max:integer):integer;
begin
  if(dl>0) then begin 
    if(max<v[dl])then max:=v[dl];
	maximo:=maximo(v,dl-1,max);
  end
  else maximo:= max;
end;
function busqueda(v:vector;dl,valor:integer):boolean;
begin
  if(dl>0) then begin 
	if(v[dl]=valor) then busqueda:=true
	else busqueda:=busqueda(v,dl-1,valor);
  end
  else busqueda:= false;
end;
{procedure imprimirDig(v:vector;dl:integer);
begin
end;}
var
  dl,max,valor:integer;
  v:vector;
begin
randomize();
dl:=0; 
cargar(v,dl);
writeln('IMPRIMIR SIN RECURSION');
imprimirSinRecursion(v,dl);
writeln('IMPRIMIR CON RECURSION');
imprimirConRecursion(v,dl);
writeln('suma de pares ',sumaPar(v,dl));
max:=-9999;
writeln('maximo del vector ',maximo(v,dl,max));
readln(valor);
if(busqueda(v,dl,valor)) then writeln('se encontro ')
else writeln('no se encontro ');
//imprimirDig(v,dl);
end.
