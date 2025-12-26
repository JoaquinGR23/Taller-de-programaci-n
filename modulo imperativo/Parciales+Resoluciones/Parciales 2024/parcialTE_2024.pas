program parcialTE_2024;
const df=7;
type 
  sub_genero=1..7;
  libros=record
    isb,codAu:integer;
    codGen:sub_genero;
  end;
  infoNodo=record
    codAu,cant:integer;
  end;
  arbol=^nodo;
  nodo=record
    ele:infoNodo;
    HD,HI:arbol;
  end;
  reg=record
    codGen:string;
    cant:integer; 
  end;
  vector=array[1..df] of reg;
procedure inicializarVec(var v:vector);
var i:integer;
begin
  for i:=1 to df do v[i].cant:=0;
  v[1].codGen:='literario'; v[2].codGen:='filosofia'; v[3].codGen:='biologia'; v[4].codGen:='arte'; v[5].codGen:='computacion'; 
  v[6].codGen:='medicina'; v[7].codGen:='ingenieria';  
end;
procedure cargarReg(var d:libros);
begin
  writeln('ingrese el isbn'); d.isb:=random(15);
  if(d.isb<>0)then begin 
    writeln('ingrese el cod de autor'); d.codAu:=random(15);
    writeln('ingrese el cod de genero '); d.codGen:=random(7)+1;
  end;   
end;
procedure agregarVec(var cant:integer);
begin
  cant:=cant+1; 
end;
procedure agregar(var a:arbol; cod:integer);
begin 
  if(a=nil)then begin 
    new(a); a^.ele.codAu:=cod; a^.HI:=nil; a^.HD:=nil; a^.ele.cant:=1;
  end
  else if(a^.ele.codAu=cod)then a^.ele.cant:=a^.ele.cant+1
		else if(a^.ele.codAu>=cod)then agregar(a^.HI,cod) 
			 else agregar(a^.HD,cod);
end;
procedure cargarEstructuras(var a:arbol;var v:vector);
var d:libros; 
begin
  randomize();
  a:=nil;
  inicializarVec(v);
  cargarReg(d);
  while(d.isb<>0)do begin 
    agregar(a,d.codAu);
    agregarVec(v[d.codGen].cant);
    cargarReg(d);
  end; 
end;
procedure imprimirA(a:arbol);
begin
  if(a<>Nil)then begin 
    imprimirA(a^.HI);
    writeln('cod de autor ', a^.ele.codAu); writeln('cantida de libros de ese autor ', a^.ele.cant);
    imprimirA(a^.HD);
  end; 
end;
procedure imprimirV(v:vector);
var i:integer;
begin 
  for i:=1 to df do writeln('genero: ',v[i].codGen,' y su cant de libros: ',v[i].cant);
end;
procedure ordenarVec(var v:vector;var nom:string);
var i,j:integer; actual:reg;
begin 
  for i:=2 to df do begin 
    j:=i-1; actual:=v[i];
    while((j>0)and(v[j].cant<actual.cant)) do begin 
      v[j+1]:=v[j];  j:=j-1; 
    end;
    v[j+1]:=actual;
  end;
  nom:=v[1].codGen;
end;
function cantLibrosEntreCodigos(a:arbol;cod1,cod2:integer):integer;
begin
  if(a<>Nil)then begin 
    if((a^.ele.codAu>=cod1)and(a^.ele.codAu<=cod2)) then cantLibrosEntreCodigos:=cantLibrosEntreCodigos(a^.HI,cod1,cod2)+
		cantLibrosEntreCodigos(a^.HD,cod1,cod2)+a^.ele.cant
    else if(a^.ele.codAu>=cod1)then cantLibrosEntreCodigos:= cantLibrosEntreCodigos(a^.HI,cod1,cod2)
		 else cantLibrosEntreCodigos(a^.HD,cod1,cod2);
  end
  else cantLibrosEntreCodigos:=0; 
end;
var 
  a:arbol; v:vector; nom:string; cant,cod1,cod2:integer;
begin 
  cargarEstructuras(a,v); //INCISO A
  imprimirA(a);
  imprimirV(v);
  ordenarVec(v,nom); //INCISO B
  imprimirV(v);
  writeln('el nombre de genero con mayor cantidad de libros vendidos es ', nom);
  writeln('ingrese el cod inferior '); readln(cod1);
  writeln('ingrese el cod superior '); readln(cod2);
  cant:= cantLibrosEntreCodigos(a,cod1,cod2); //INCISO C
  writeln('cantidad de libros entre ',cod1,' y ',cod2,' es ',cant);
end.
