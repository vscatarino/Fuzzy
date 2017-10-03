package fuzzy;

public class Fuzzificacao {
private int translado,evento;
private float aereo, cityTour, hospedagem, seguro, distancia;
float[] pertinencia = new float[21];

    public Fuzzificacao(int translado, int evento, float aereo, float cityTour, float hospedagem, float seguro, float distancia) {
        this.translado = translado;
        this.evento = evento;
        this.aereo = aereo;
        this.cityTour = cityTour;
        this.hospedagem = hospedagem;
        this.seguro = seguro;
        this.distancia = distancia;
    }

    

private float pertinenciaAereoBarato(){
    if(this.aereo <= 300)
        return 1;
    else if(this.aereo >= 500)
        return 0;
    else
        return ((float)(500 - this.aereo)/200f);
    
}

private float pertinenciaAereoMedio(){
    if(this.aereo < 300 || this.aereo > 900)
        return 0;
    else if(this.aereo >= 500 && this.aereo <= 700)
        return 1;
    else if(this.aereo >= 300 && this.aereo < 500)
        return ((float) (this.aereo - 300)/200);
    else
        return ((float) (900 - this.aereo)/200);    
}

private float pertinenciaAereoCaro(){
   if(this.aereo <= 700)
            return 0;
        else if(this.aereo >= 900)
            return 1;
        else
            return ((float) (this.aereo - 700)/200);
    }

private float pertinenciaTransladoPouco(){
    if(this.translado >= 5)
        return 0;
    else if(this.translado <= 2)
        return 1;
    else
        return((float)(5 - this.translado)/3);
}

private float pertinenciaTransladoMedio(){
    if(this.translado < 2)
        return 0;
    else if(this.translado > 11)
        return 0;
    else if(this.translado >= 2 && this.translado < 5)
        return ((float) (this.translado - 2)/3);
    else if(this.translado >= 5 && this.translado <= 8)
        return 1;
    else
        return ((float) (11 - this.translado)/3); 
}

private float pertinenciaTransladoMuito(){
   if(this.translado <= 8)
       return 0;
   else if(this.translado >= 11)
       return 1;
   else
       return((float) (this.translado - 8)/3);
}

private float pertinenciaCityTourBasico(){
    if(this.cityTour <= 20)
        return 1;
    else if(this.cityTour >= 35)
        return 0;
    else 
        return ((float) (35 - this.cityTour)/15);
    }

private float pertinenciaCityTourMedio(){
    if(this.cityTour < 20)
        return 0;
    else if(this.cityTour > 65)
        return 0;
    else if(this.cityTour >= 20 && this.cityTour < 35)
        return((float) (this.cityTour - 20)/15);
    else if(this.cityTour >= 35 && this.cityTour <= 50)
            return 1;
    else 
        return ((float)(65 - this.cityTour)/15);
}

private float pertinenciaCityTourCompleto(){
    if(this.cityTour <= 50)
            return 0;
    else if(this.cityTour >= 65)
            return 1;
    else
            return ((float) (this.cityTour - 50)/15);    
}

private float pertinenciaHotelBarato(){
    if(this.hospedagem <= 65)
        return 1;
    else if(this.hospedagem >= 85)
        return 0;
    else
        return((float) (85 - this.hospedagem)/20);   
}

private float pertinenciaHotelMedio(){
    if(this.hospedagem < 65)
        return 0;
    else if(this.hospedagem > 125)
        return 0;
    else if(this.hospedagem >= 65 && this.hospedagem < 85)
        return ((float)(this.hospedagem -65)/20);
    else if(this.hospedagem >= 85 && this.hospedagem <= 105)
        return 1;
    else 
        return((float)(125 - this.hospedagem)/20);   

}

private float pertinenciaHotelCaro(){
     if(this.hospedagem <= 105)
        return 0;
    else if(this.hospedagem >= 125)
        return 1;
    else
        return((float) (this.hospedagem - 105)/20);         
}

private float pertinenciaEventoBasico(){
    if(this.evento <= 180)
        return 1;
    else if(this.evento >= 270)
        return 0;
    else
        return ((float)(270 - this.evento)/90);
          
}

private float pertinenciaEventoMedio(){
  if(this.evento < 180)
      return 0;
  else if(this.evento > 450)
      return 0;
  else if(this.evento >= 180 && this.evento < 270)
      return((float)(this.evento - 180)/90);
  else if(this.evento >= 270 && this.evento <= 360)
      return 1;
  else
      return((float)(450 - this.evento)/90);
}

private float pertinenciaEventoCaro(){
 if(this.evento <= 360)
        return 0;
    else if(this.evento >= 450)
        return 1;
    else
        return ((float)(this.evento - 360)/90);    
}

private float pertinenciaSeguroBarato(){
    if(this.seguro <= 20)
        return 1;
    else if(this.seguro >= 40)
        return 0;
    else 
        return ((float)(40 - this.seguro)/20);
}

private float pertinenciaSeguroMedio(){
    if(this.seguro < 20)
            return 0;
    else if(this.seguro > 80)
            return 0;
    else if(this.seguro >= 20 && this.seguro < 40)
            return(this.seguro - 20)/20;
    else if(this.seguro >= 40 && this.seguro <= 60)
            return 1;
    else 
        return ((float)(80 - this.seguro)/20);      

}

private float pertinenciaSeguroCaro(){
     if(this.seguro <= 60)
        return 0;
    else if(this.seguro >= 80)
        return 1;
    else 
        return ((float)(this.seguro - 60)/20);   
}

private float pertinenciaDistanciaBaixa(){
    if(this.distancia <= 1000)
        return 1;
    else if(this.distancia >= 3000)
        return 0;
    else
        return ((float)(3000 - this.distancia)/ 2000);    
}

private float pertinenciaDistanciaAlta(){
    if(this.distancia < 1000)
        return 0;
    else if(this.distancia >= 3000)
        return 1;
    else
        return (this.distancia - 1000)/ 2000;        
}

public void calcularPert(){
    pertinencia[0] = pertinenciaAereoBarato();
    pertinencia[1] = pertinenciaAereoMedio();
    pertinencia[2] = pertinenciaAereoCaro();
    pertinencia[3] = pertinenciaTransladoPouco();
    pertinencia[4] = pertinenciaTransladoMedio();
    pertinencia[5] = pertinenciaTransladoMuito();
    pertinencia[6] = pertinenciaCityTourBasico();
    pertinencia[7] = pertinenciaCityTourMedio();
    pertinencia[8] = pertinenciaCityTourCompleto();
    pertinencia[9] = pertinenciaHotelBarato();
    pertinencia[10]= pertinenciaHotelMedio();
    pertinencia[11]= pertinenciaHotelCaro();
    pertinencia[12]= pertinenciaEventoBasico();
    pertinencia[13]= pertinenciaEventoMedio();
    pertinencia[14]= pertinenciaEventoCaro();
    pertinencia[15]= pertinenciaSeguroBarato();
    pertinencia[16]= pertinenciaSeguroMedio();
    pertinencia[17]= pertinenciaSeguroCaro();
    pertinencia[18]= pertinenciaDistanciaBaixa();
    pertinencia[19]= pertinenciaDistanciaAlta();
    }
}
