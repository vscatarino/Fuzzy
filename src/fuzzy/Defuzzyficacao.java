package fuzzy;

public class Defuzzyficacao {
    private float[] val_barato = new float[20];
    private float[] val_caro = new float[20];
    private double min;
    private float quociente_barato, quociente_caro;
    private float divisor_barato, divisor_caro;

    public Defuzzyficacao(float[] val_barato, float[] val_caro, double min) {
        if (val_barato == null) {
            throw new IllegalArgumentException("O Array não contém valores válidos");
        } else if (val_barato.length == 0) {
            throw new IllegalArgumentException("O Array está vazio!!");
        }
        this.val_barato = val_barato;
        
        if (val_caro == null) {
            throw new IllegalArgumentException("O Array não contém valores válidos");
        } else if (val_caro.length == 0) {
            throw new IllegalArgumentException("O Array está vazio!!");
        }
        this.val_caro = val_caro;
        
        this.min = min;
        this.quociente_barato = 0;
        this.quociente_caro = 0;
        this.divisor_barato = 0;
        this.divisor_caro = 0;        
    }
    
    public void calculaPacoteBarato(float[] inferencia){
        if (val_barato == null) {
            throw new IllegalArgumentException("O Array não contém valores válidos");
        } else if (val_barato.length == 0) {
            throw new IllegalArgumentException("O Array está vazio!!");
        }        
        for(int i = 0; i < inferencia.length ; i++){
          float aux = 0;
          if(inferencia[i] > 0 && inferencia[i] <= 1){
              aux = (1000 - (340 * inferencia[i]));
              quociente_barato += inferencia[i] *aux;
              divisor_barato +=inferencia[i];
          }
        }
    }
    
    public void calculaPacoteCaro(float[] inferencia){
        if (val_barato == null) {
            throw new IllegalArgumentException("O Array não contém valores válidos");
        } else if (val_barato.length == 0) {
            throw new IllegalArgumentException("O Array está vazio!!");
        }   
        for(int i = 0; i < inferencia.length ; i++){
            float aux = 0;
            if(inferencia[i] > 0 && inferencia[i] <= 1){
                aux = (1000 + (340 * inferencia[i]));
                quociente_caro += inferencia[i]*aux;
                divisor_caro +=inferencia[i];
            }
        }
    }
    
    public float deffuzificar(){
        float resultado;
        calculaPacoteBarato(val_barato);
        calculaPacoteCaro(val_caro);
       
        resultado = ((quociente_barato + quociente_caro)/(divisor_barato + divisor_caro)) + (float)min;
        resultado = Math.round(resultado);
        
        return resultado;
    }
    
   
    
}
