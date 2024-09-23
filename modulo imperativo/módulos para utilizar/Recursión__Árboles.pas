{  -----------------------------------------VECTOR RECURSIÓN------------------------------------------- }
procedure imprimirConRecursion(v:vector;dl:integer);
begin
  if(dl>0)then begin
    imprimirConRecursion(v,dl-1); writeln(v[dl]);
  end; 
end;

<<-----------MAXIMO Y MINIMO----------->>
function maximo(v:vector;dl,max:integer):integer;
begin
  if(dl>0) then begin 
    if(max<v[dl])then max:=v[dl];
	maximo:=maximo(v,dl-1,max);
  end
  else maximo:= max;
end;

function minimo(v:vector;dl,min:integer):integer;
begin
  if(dl>0) then begin 
    if(min>v[dl])then min:=v[dl];
	minimo:=minimo(v,dl-1,min);
  end
  else minimo:= min;
end;

begin 
max:=-9999;
writeln('maximo del vector ',maximo(v,dl,max));

min:=9999;
writeln('minimo del vector ',minimo(v,dl,min));
end.
{  -----------------------------------------LISTA RECURSIÓN------------------------------------------- }
procedure imprimirLista(l:lista);
begin
  if(l<>nil)then begin 
	writeln(l^.ele); 
	imprimirLista(l^.sig);
  end;
end;

procedure imprimirInverso(l:lista);
begin
  if(l<>nil)then begin  
	imprimirInverso(l^.sig);
	writeln(l^.ele);
  end;
end;

function minimoL(l:lista; min:integer):integer;
begin
   if(l<>nil)then begin if(min>l^.ele) then min:=l^.ele;
				  minimoL:=minimoL(l^.sig,min);
   end
   else minimoL:=min;
end;

begin
 min:=9999;
 writeln('minimo  de la lista ',minimoL(l,min));
end.
{  -----------------------------------------ÁRBOL------------------------------------------- }
<<----------CONTADOR DE NODOS EN RANGO QUE SUPERAN A UN VALOR X------------>>
function cantDePacientesEntre2Dnis(a:arbol;dni1,dni2,valor:integer):integer;
var cant:integer;
begin
  if(a<>nil)then begin
    if((a^.ele.dni>=dni1)and(a^.ele.dni<=dni2))then begin
      if(a^.ele.cantT>valor) then cant:=1 
      else cant:=0;
      cantDePacientesEntre2Dnis:=cantDePacientesEntre2Dnis(a^.HI,dni1,dni2,valor)+ cantDePacientesEntre2Dnis(a^.HD,dni1,dni2,valor)+cant;
    end 
    else if(a^.ele.dni>=dni1)then cantDePacientesEntre2Dnis:=cantDePacientesEntre2Dnis(a^.HI,dni1,dni2,valor)
		else cantDePacientesEntre2Dnis:=cantDePacientesEntre2Dnis(a^.HD,dni1,dni2,valor);
  end
  else cantDePacientesEntre2Dnis:=0; 
end;

BEGIN 
  cant:= cantDePacientesEntre2Dnis(a,dni1,dni2,X);
END.

<<----------CONTADOR DE NODOS DE TODO EL ARBOL------------>>
function cantSocios(a:arbol):integer;
begin
  if(a<>nil)then cantSocios:= cantSocios(a^.HI)+ cantSocios(a^.HD)+1
  else cantSocios:=0;
end; 

BEGIN 
  cant:= cantSocios(a);
END.

<<----------CONTADOR DE NODOS DE TODO EL ARBOL------------>>
{  -----------------------------------------VECTOR ELIMINAR ELEMENTOS EN RANGO------------------------------------------- }
program ejemplo;

type
procedure EliminarRango(var v:vector;var dl:integer;cod1,cod2:integer);
var i,indiceIzq,indiceDer,salto:integer;
begin 
  i:=1;
  while((i<dl)and(v[i].cod<codIzq)) do i:=i+1
  indiceIzq:=i;
  while((i<dl)and(v[i].cod<=codDer)) do i:=i+1
  indiceDer:=i;
  
  salto:=indiceDer-indiceIzq;
  while((indiceIzq+salto)<=dl) do begin 
    v[indiceIzq]:=v[indiceIzq+salto];
    indiceIzq:=indiceIzq+1;
  end;
  dl:=dl-salto;
end;

var v:vector; cod1,cod2:integer;
begin 
  readln(cod1); readln(cod2);
  EliminarRango(v,dl,cod1,cod2); 
end.
