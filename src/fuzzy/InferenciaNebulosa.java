package fuzzy;

public class InferenciaNebulosa {
    private float[] pertinencia;
    private int countBarato;
    private int countCaro;
    float[] valBarato = new float[20];
    float[] valCaro = new float[20];

    public InferenciaNebulosa(float[] pertinencia) {
        if(pertinencia == null){
            throw new IllegalArgumentException("O Array não contém valores válidos");
        }else if(pertinencia.length == 0){
            throw new IllegalArgumentException("O Array está vazio!");
        }
        
        this.pertinencia = pertinencia;
        this.countBarato = 0;
        this.countCaro = 0;
    }
    
    public void contaValor(int classificacao, float pertinencia){
        if(classificacao == 2){
            valBarato[countBarato] = pertinencia;
            countBarato++;
           }else if(classificacao == 1){
            valCaro[countCaro] = pertinencia;
            countCaro++;          
        }
    }
    
    public float inferenciaMinima(float[] inferencia){
        float aux = 999;
        if(inferencia == null){
            throw new IllegalArgumentException("O Array não contém valores válidos");
        }else if(inferencia.length == 0){
            throw new IllegalArgumentException("O Array está vazio!");
        }
        for(int i = 0; i < inferencia.length; i++){
            if(inferencia[i] < aux)
                aux = inferencia[i];            
        }        
        return aux;
    }
    
    public void inserirRegra(){
        //int auxInt;
        //float auxFloat;
        for(int i= 1; i<= 20; i++){
            //auxInt = RegrasNebulosas.classifica(i);
            //auxFloat = inferenciaMinima(RegrasNebulosas.Regras(inferencia, i));
            contaValor(RegrasNebulosas.classifica(i), inferenciaMinima(RegrasNebulosas.Regras(pertinencia, i)));
            
        }
       
    }
}
