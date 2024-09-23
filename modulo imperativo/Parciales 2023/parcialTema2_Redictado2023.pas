program parcialT2;  

type
  sub_dia=1..31;
  sub_mes=1..12;
  doc_impreso=record
    codUsu:integer;
    cant:integer;
    dia:sub_dia;
    mes:sub_mes;
  end;
  lista=^nodo1;
  nodo1=record
    ele:doc_impreso;
    sig:lista;
  end;
  arbol=^nodo2;
  nodo2=record
    ele:doc_impreso;
    HD,HI:arbol;
  end;
procedure cargarReg(var d:doc_impreso);
begin
  writeln('ingrese el cod de usuario que imprimio '); d.codUsu:=random(15);
  if(d.codUsu<>0)then begin 
    writeln('ingrese la cantidad de paginas impresas '); d.cant:=random(150);
    writeln('ingrese el dia '); d.dia:=random(31)+1;
    writeln('ingrese el mes '); d.mes:=random(12)+1;
  end; 
end;
procedure agregar(var a:arbol;d:doc_impreso);
begin
  if(a=nil)then begin 
    new(a); a^.ele:=d; a^.HI:=nil; a^.HD:=nil;    
  end
  else if(a^.ele.codUsu>=d.codUsu)then agregar(a^.HI,d)
	        else agregar(a^.HD,d);
end;
procedure cargar(var a:arbol);
var d:doc_impreso;
begin
  cargarReg(d);
  while(d.codUsu<>0)do begin 
    agregar(a,d);
    cargarReg(d);
  end; 
end;
procedure informarDatos(d:doc_impreso);
begin
    writeln('cod de usuario ', d.codUsu); 
    writeln('cantidad de paginas impresas ',d.cant); 
    writeln('dia ', d.dia); 
    writeln('mes ',d.mes); 
end;
procedure imprimir(a:arbol);
begin
  if(a<>Nil)then begin 
    imprimir(a^.HI);
    informarDatos(a^.ele);
    imprimir(a^.HD); 
  end;
end;
procedure agregarL(var l:Lista;d:doc_impreso);
var nuevo:lista;
begin 
  new(nuevo); nuevo^.ele:=d; nuevo^.sig:=l; l:=nuevo;
end;
procedure ListaNueva(a:arbol;cod1,cod2:integer;var l:lista);
begin
  if(a<>nil)then begin 
    if((a^.ele.codUsu>=cod1)and(a^.ele.codUsu<=cod2))then begin 
      agregarL(l,a^.ele);
      ListaNueva(a^.HI,cod1,cod2,l);
      ListaNueva(a^.HD,cod1,cod2,l);
    end 
    else if(a^.ele.codUsu>=cod1)then ListaNueva(a^.HI,cod1,cod2,l)
		 else ListaNueva(a^.HD,cod1,cod2,l);
  end; 
end;
procedure imprimirL(l:lista);
begin
  while(l<>Nil)do begin 
    informarDatos(l^.ele);
    l:=l^.sig;
  end; 
end;
function SumaPagImpresas(l:lista):integer;
begin
  if(l<>nil)then SumaPagImpresas:=SumaPagImpresas(l^.sig)+l^.ele.cant
  else SumaPagImpresas:=0; 
end;
var
  a:arbol;
  l:lista;
  cod1,cod2,total:integer;
begin 
  randomize();
  cargar(a);
  imprimir(a);
  l:=nil;
  writeln('ingrese el limite inferior '); readln(cod1);
  writeln('ingrese el limite superior '); readln(cod2);
  ListaNueva(a,cod1,cod2,l);
  imprimirL(l);
  total:=SumaPagImpresas(l);
  writeln('suma total de paginas impresas de los documentos ', total);
end.
