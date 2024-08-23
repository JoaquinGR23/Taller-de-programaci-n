program comercio;
const
  df=50;
type
  sub1 = 0..31;
  sub2=1..99;
  ventas = record
	dia : sub1;
	cod: integer;
	cant: sub2;
  end;
  vector = array[1..df] of ventas;

procedure cargarReg(var r:ventas);
begin
  writeln('dia'); readln(r.dia);
  if(r.dia <>0) then begin
	r.cod:= 1+random(15);
	writeln('cant'); readln(r.cant);
  end;
end;
procedure agregar(var v:vector;var dl:integer;r:ventas);
begin
  dl:=dl+1;
  v[dl]:= r;
end;
procedure cargar(var v:vector;var dl:integer);
var 
  r:ventas;
begin
  dl:=0;
  randomize;
  cargarReg(r);
  while((r.dia <> 0) and (dl<df)) do begin 
    agregar(v,dl,r);
    cargarReg(r);
  end;
end;
procedure imprimir1(v:vector;dl:integer);
var 
  i:integer;
begin
  for i:=1 to dl do begin 
    writeln('dia ', v[i].dia); writeln('cod de prod: ', v[i].cod); writeln('cant de prod:', v[i].cant); 
  end;
end;
procedure ordenar(var v:vector;dl:integer);
var
  j,i:integer; actual:ventas;
begin
  for i:=2 to dl do begin
    j:= i-1; actual:= v[i];
    while((j>0)and(v[j].cod>actual.cod)) do begin
      v[j+1]:=v[j]; j:=j-1; 
	end;
	v[j+1]:= actual;
  end;
end;

procedure nuevaEstruc(v:vector;dl:integer;var v2:vector;var dl2,total:integer);
var
	i: integer;
begin
    dl2:=0; total:=0;
	for i:= 1 to dl do begin
		if (v[i].cod MOD 2 = 0)then begin
			dl2:= dl2 +1;
			v2[dl2]:= v[i];
			total:= total + v[i].cant;
		end;
	end;
end;
procedure imprimir2(v2:vector;dl2,total:integer);
begin
  imprimir1(v2,dl2);
  writeln('El total de producto vendidos es: ',total);
end;
var
  dl,dl2,total:integer;
  v,v2: vector;
begin 
  cargar(v,dl);
  if(dl<>0) then begin 
	imprimir1(v,dl);
	ordenar(v,dl);
	imprimir1(v,dl);
	nuevaEstruc(v,dl,v2,dl2,total);
	imprimir2(v2,dl2,total);
  end;
end.
