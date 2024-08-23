program expensas;
const 
  df = 300;
type
  oficinas = record
	cod,dni: integer;
	valor: real;
  end;
  vector = array[1..df] of oficinas;
procedure agregar(var v:vector;var dl:integer;r:oficinas);
begin
  dl:=dl+1;
  v[dl]:=r;
end;
procedure cargarReg(var r:oficinas);
begin
  readln(r.cod);
  if(r.cod <>-1) then begin 
	readln(r.dni);
	readln(r.valor);
  end; 
end;
procedure cargar(var v:vector;var dl:integer);
var
  r:oficinas;
begin
  dl:=0;
  cargarReg(r);
  while((dl<df) and (r.cod <> -1)) do begin 
	agregar(v,dl,r);
	cargarReg(r);
  end; 
end;
procedure ordenarIns(var v:vector;dl:integer);
var
  i,j:integer; actual:oficinas;
begin 
  for i:=2 to dl do begin
    j:=i-1; actual:=v[i];
	while((j>0)and(actual.cod<v[j].cod)) do begin
	  v[j+1]:=v[j]; j:=j-1; 
	end;
	v[j+1]:=actual;
  end;
end;
procedure ordenarSel(var v:vector;dl:integer);
var
  i,j,pos:integer;
  aux:oficinas;
begin
  for i:=1 to dl-1 do begin 
    pos:=i;
	for j:=i+1 to dl do if(v[pos].cod>v[j].cod) then pos:=j;
	aux:= v[pos];
	v[pos]:=v[i];
	v[i]:=aux;
  end;
end; 
procedure imprimir(v:vector;dl:integer);
var
i: integer;
begin
  for i:=1 to dl do writeln(v[i].cod);
end;
var
  v: vector;
  dl:integer;
begin
  cargar(v,dl);
  imprimir(v,dl);
  if(dl <>0) then begin
    ordenarIns(v,dl); 
	imprimir(v,dl);
	ordenarSel(v,dl);
	imprimir(v,dl);
  end; 
end.
