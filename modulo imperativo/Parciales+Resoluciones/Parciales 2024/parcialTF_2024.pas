program parcialTF_2024;
const df=8;
type
  sub_material=1..8;
  artesanias=record
    ID, dni:integer;
    codMaterial:sub_material;
  end;
  infoNodo=record
    dni,cant:integer;
  end;
  arbol=^nodo;
  nodo=record
    ele:infoNodo;
    HD,HI:arbol;
  end;
  reg=record
    mat:string;
    cant:integer;
  end;
  vector=array[1..df] of reg;
procedure inicializarVec(var v:vector);
var i:integer;
begin 
  for i:=1 to df do v[i].cant:=0;
  v[1].mat:='madera'; v[2].mat:='yeso'; v[3].mat:='ceramica'; v[4].mat:='vidrio'; v[5].mat:='acero'; v[6].mat:='porcelana'; 
  v[7].mat:='lana'; v[8].mat:='carton';
end;
procedure cargarReg(var d:artesanias);
begin
  writeln('ingrese el dni del artesano'); d.dni:=random(15);
  if(d.dni<>0)then begin 
    writeln('ingrese el num de identificacion de la artesania: '); d.ID:=random(152); 
    writeln('ingrese el cod del material base '); d.codMaterial:=random(8)+1; 
  end; 
end;
procedure agregar(var a:arbol;dni:integer);
begin
   if(a=nil)then begin 
     new(a); a^.ele.dni:=dni; a^.HI:=nil; a^.HD:=nil; a^.ele.cant:=1;
   end
   else if(a^.ele.dni=dni)then a^.ele.cant:=a^.ele.cant+1 
		else if(a^.ele.dni>=dni)then agregar(a^.HI,dni)
			 else agregar(a^.HD,dni);
end;
procedure agregarVec(var cant:integer);
begin
  cant:=cant+1; 
end;
procedure cargarEstructuras(var a:arbol;var v:vector);
var d:artesanias; 
begin
  a:=nil; randomize();
  inicializarVec(v);
  cargarReg(d);
  while(d.dni<>0)do begin 
    agregar(a,d.dni);
    agregarVec(v[d.codMaterial].cant);
    cargarReg(d);
  end; 
end;
procedure imprimirA(a:arbol);
begin
  if(a<>Nil)then begin 
    imprimirA(a^.HI);
    writeln('dni del artesano: ',a^.ele.dni); writeln('cantidad de artesanias: ',a^.ele.cant);
    imprimirA(a^.HD);
  end;
end;
procedure imprimirVec(v:vector);
var i:integer;
begin 
  for i:=1 to df do begin 
    writeln('cod ',i,': ',v[i].mat, ' cantidad de artesanias: ', v[i].cant);
  end;
end;
function cantArtesanosMenoresAlDniIngresado(a:arbol; dni:integer):integer;
begin
  if(a<>Nil)then begin 
    if(a^.ele.dni>=dni) then cantArtesanosMenoresAlDniIngresado:= cantArtesanosMenoresAlDniIngresado(a^.HI,dni)
    else cantArtesanosMenoresAlDniIngresado:=cantArtesanosMenoresAlDniIngresado(a^.HI,dni)+ cantArtesanosMenoresAlDniIngresado(a^.HD,dni)+1
  end
  else cantArtesanosMenoresAlDniIngresado:=0; 
end;
procedure ordenarVec(var v:vector;var nom:string);
var i,j:integer; actual:reg;
begin
  for i:=2 to df do begin 
    j:=i-1; actual:=v[i];
    while((j>0)and(v[j].cant>actual.cant)) do begin
      v[j+1]:=v[j]; j:=j-1;
    end;
    v[j+1]:=actual;
  end;
  nom:=v[df].mat;
end;
var a:arbol; v:vector; cant,dni:integer; nom:string;
begin 
  cargarEstructuras(a,v); //PUNTO A
  imprimirA(a);
  imprimirVec(v);
  writeln('ingrese un dni: '); readln(dni);
  cant:= cantArtesanosMenoresAlDniIngresado(a,dni); //PUNTO B
  writeln('la cantidad de artesanos con dni menor al dni ingresado es: ', cant);
  ordenarVec(v,nom); //PUNTO C
  imprimirVec(v);
  writeln('nombre del material base con mayor cantidad de artesanias: ',nom);
end.
