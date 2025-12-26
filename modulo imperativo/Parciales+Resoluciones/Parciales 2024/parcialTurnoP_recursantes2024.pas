program parcialTurnoP_recursantes2024;//20:19
const df=5;
type 
     compras=record
       codC,codCli:integer;
       cat:string;
     end;
     infoNodo=record
       codC,cant:integer;
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
     vector3=array[1..df]of string;
     vector2=array[1..df]of reg;
procedure cargarReg(var d:compras;var dl:integer);
var v:vector3=('full','super','media','normal','basica');
begin 
  writeln('ingrese codigo de cliente'); d.codCli:=random(15);
  if(d.codCli<>0)then begin 
    writeln('ingrese codigo de compra '); d.codC:=random(152);
    writeln('ingrese la categoria '); 
    dl:=random(5)+1;
    d.cat:=v[dl];
  end;
end;
procedure agregar(var a:arbol; codC:integer);
begin
  if(a=nil)then begin 
    new(a); a^.ele.codC:=codC; a^.HI:=nil; a^.HD:=nil; a^.ele.cant:=1;
  end
  else if(a^.ele.codC=codC)then a^.ele.cant:=a^.ele.cant+1  
       else if(a^.ele.codC>=codC)then agregar(a^.HI,codC)
			else agregar(a^.HD,codC);
end;
procedure inicializarVec(var v:vector2);
var i:integer;
begin
  for i:=1 to df do v[i].cant:=0;
  v[1].cat:='full'; v[2].cat:='super'; v[3].cat:='media'; v[4].cat:='normal'; v[5].cat:='basica';
end;
procedure incrementarVec(var cant:integer);
begin
  cant:=cant+1; 
end;
procedure cargarEstructuras(var a:arbol;var v:vector2);
var d:compras; dl:integer;
begin 
  cargarReg(d,dl);
  inicializarVec(v);
  while(d.codCli<>0)do begin 
    agregar(a,d.codC);
    incrementarVec(v[dl].cant);
    cargarReg(d,dl);
  end;
end;
procedure imprimir(a:arbol);
begin
  if(a<>Nil)then begin 
   imprimir(a^.HI);
   writeln('cod de comida ', a^.ele.codC); writeln('cantidad ', a^.ele.cant);
   imprimir(a^.HD); 
  end;
end;
procedure imprimirVec(v:vector2);
var i:integer;
begin 
  for i:=1 to df do begin 
    writeln('------categoria ',i,'---------');
    writeln('categoria: ',v[i].cat, ' cantidad ',v[i].cant);
  end;
end;
function cantComprasDeUnCliente(a:arbol;cod:integer):integer;
begin
  if(a<>nil)then begin 
     if(a^.ele.codC=cod) then cantComprasDeUnCliente:=a^.ele.cant
	 else if(a^.ele.codC>=cod)then cantComprasDeUnCliente:=cantComprasDeUnCliente(a^.HI,cod) 
		  else cantComprasDeUnCliente:=cantComprasDeUnCliente(a^.HD,cod);
  end 
  else cantComprasDeUnCliente:=0;
end;
procedure ordenarVec(var v:vector2;var cat:string);
var i,j:integer; aux:reg;
begin 
  for i:=2 to df do begin 
    j:=i-1; aux:=v[i];
    while((j>0)and(v[j].cant>aux.cant)) do begin 
      v[j+1]:=v[j]; j:=j-1;
    end;
    v[j+1]:=aux;
  end;
  cat:=v[df].cat;
end;
var a:arbol; v:vector2; cod,cant:integer; cat:string;
begin 
  randomize();
  cargarEstructuras(a,v);
  imprimir(a);
  imprimirVec(v);
  writeln('ingrese un codigo de comida'); readln(cod);
  cant:=cantComprasDeUnCliente(a,cod);
  writeln('cantidad de compras a ese codigo es ', cant);
  ordenarVec(v,cat);
  writeln('categoria ', cat);
end.
