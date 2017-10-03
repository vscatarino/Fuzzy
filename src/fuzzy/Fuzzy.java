package fuzzy;

import java.util.Scanner;

public class Fuzzy {

      public static void main(String[] args) {
           Scanner t = new Scanner(System.in);
        int translado = 9;
        int evento = 365;
        float aereo = 877; 
        float cityTour = 55;
        float hospedagem = 115;
        float seguro = 35;
        float distancia = 2030;
        float min = 500;
        float resultado;
       System.out.println("Digite o valor total dos eventos:");
       evento = t.nextInt();
       
       System.out.println("Digite o número de pessoas para o translado:");
       translado = t.nextInt();
       
       System.out.println("Digite o valor total de passagens aéreas:");
       aereo = t.nextFloat();
       
       System.out.println("Digite o valor do city tour:");
       cityTour = t.nextFloat();
       
       System.out.println("Digite o valor total da hospedagem:");
       hospedagem = t.nextFloat();
       
       System.out.println("Digite o valor total do seguro viagem:");
       seguro = t.nextInt();
       
       System.out.println("Informe a distância entre a origem e o destino:");
       distancia = t.nextInt();
       
       Fuzzificacao fuzzificacao = new Fuzzificacao(translado, evento, 
                aereo, cityTour, hospedagem, seguro, distancia);
       fuzzificacao.calcularPert(); //Está calculando todas as pertinências perfeitamente       
            
       InferenciaNebulosa infNeb = new InferenciaNebulosa(fuzzificacao.pertinencia);
       infNeb.inserirRegra();
       
      Defuzzyficacao defuzzyfica = new Defuzzyficacao(infNeb.valBarato, infNeb.valCaro, min);
       resultado = (float) defuzzyfica.deffuzificar();
       System.out.printf("O valor da viagem será: R$ %.2f \n", resultado * 3.167);
    }
    
}
