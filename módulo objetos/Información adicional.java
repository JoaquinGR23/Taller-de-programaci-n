<---------------------------TIPOS DE INICIALIZACION DE MATRICES Y VECTORES--------------------------->
  1) Llevar dimension logica
  Cuando el enunciado no especifica en que posicion debe agregarse el elemento.

  this.dl=0                                                               
  this.vector = new tipo_dato [this.df];
public void agregar(Objeto e){
  if(this.dl<this.df) {
    this.vector[dl]=e;  this.dl++;
  }  
}

this.matriz = new tipo_dato[this.filas][this.columnas];
this.vectorContador = new int [this.filas];    //CADA POSICION DEL VECTOR REPRESENTA LA FILA Y CADA VALOR DE LA POSICION REPRESENTA LA COLUMNAS.
for(int i=0;i<this.filas;i++){
  this.vectorContador[i]=0;
}
public void agregar(Objeto e, int Fila){ //RECORDAR QUE LOGICAMENTE SE LE RESTA -1 PORQUE TANTO EL VECTOR COMO LA MATRIZ EMPIEZAN EN LA POSICION (0) O (0,0) 
 if((Fila <= this.fila)&&(this.vectorContador[Fila-1]<this.columnas)) {  //VERIFICA SI ESTA DENTRO DE LAS DIMENSIONES DE LA MATRIZ
            this.matriz[Fila-1][this.vectorConador[Fila-1]]=e; this.vectorContador[Fila-1]++;  
        } 
}

2) Sin dimension logica  y sin inicializar cada posicion
  Cuando el enunciado especifica en que posicion debe agregarse el elemento.

  this.vector = new tipo_dato [this.df];
  for(int i=0;i<this.df;i++){
    this.vector[i]=null;
  }
  public void agregar(Objeto e, int pos){
    if(pos-1<this.df) {
      this.vector[pos-1]=e;  
    }  
  }

   this.matriz= new tipo_dato[this.filas][this.columnas];
        for(int i=0;i<this.filas;i++){
            for(int j=0;j<this.columnas;j++) this.matriz[i][j]=null;
        }
    }

    public void agregar(Objeto e,int X, int Y){
        this.matriz[X-1][Y-1]=e; 
    }
  3) Sin dimension logica  y ademas inicializar cada posicion

    this.vector = new tipo_dato [this.df];
  for(int i=0;i<this.df;i++){
    this.vector[i]= new tipo_dato(elementos del constructor);
  }


   this.matriz= new tipo_dato[this.filas][this.columnas];
        for(int i=0;i<this.filas;i++){
            for(int j=0;j<this.columnas;j++) this.matriz[i][j]= new tipo_dato(elementos del constructor);
        }
    }


    
