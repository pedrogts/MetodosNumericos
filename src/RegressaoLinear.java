import java.util.List;
import java.util.Scanner;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class RegressaoLinear {
    public double somatorioXY(List<Double> lista1, List<Double> lista2) {
        double resultado = 0;
        for (int i = 0; i < lista1.size(); i++) {
            resultado += lista1.get(i) * lista2.get(i);
        }
        return resultado;
    }

    public double somatorio(List<Double> lista1) {
        double resultado = 0;
        for (int i = 0; i < lista1.size(); i++) {
            resultado += lista1.get(i);
        }
        return resultado;
    }

    public double somatorioQ(List<Double> lista1) {
        double resultado = 0;
        for (int i = 0; i < lista1.size(); i++) {
            resultado += lista1.get(i) * lista1.get(i);
        }
        return resultado;
    }

    public double desvioPadrao(List<Double> lista1) {
        double somaQ, soma;
        somaQ = somatorioQ(lista1);
        soma = somatorio(lista1);
        return sqrt((somaQ / lista1.size()) - pow(soma / lista1.size(), 2));
    }

    public double media(List<Double> lista1) {
        return somatorio(lista1) / lista1.size();
    }

    public double mediaXY(List<Double> lista1, List<Double> lista2) {
        return somatorioXY(lista1, lista2) / (lista1.size());
    }


    public double covariancia(List<Double> lista1, List<Double> lista2) {
        double cov;
        cov = mediaXY(lista1, lista2) - media(lista1) * media(lista2);
        return cov;
    }

    public double correlacaoPearson(List<Double> lista1, List<Double> lista2) {
        double r;
        r = covariancia(lista1, lista2) / (desvioPadrao(lista1) * desvioPadrao(lista2));
        return r;
    }

    public double coeficienteDeterminacao(List<Double> lista1, List<Double> lista2) {
        return (pow(correlacaoPearson(lista1, lista2), 2) * 100);
    }

    public double equacaoRetaB(List<Double> lista1, List<Double> lista2) {
        return (lista1.size() * somatorioXY(lista1, lista2) - somatorio(lista1) * somatorio(lista2)) / (lista1.size() * somatorioQ(lista1) - pow(somatorio(lista1), 2));
    }

    public double equacaoRetaA(List<Double> lista1, List<Double> lista2) {
        return media(lista2) - equacaoRetaB(lista1, lista2) * media(lista1);
    }

    public void print(List<Double> lista1, List<Double> lista2) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Media de X: %.6f\t\tMedia de Y: %.6f\t\tMedia de XY: %.6f\n", media(lista1), media(lista2), mediaXY(lista1, lista2));
        System.out.printf("Desvio padrao de X: %.6f\t\t\t\t\tDesvio padrao de Y: %.6f\n", desvioPadrao(lista1), desvioPadrao(lista2));
        System.out.printf("Covariancia: %.6f \t\tCorrelacao: %.6f\t\tDeterminacao: %.2f%%\n", covariancia(lista1, lista2), correlacaoPearson(lista1, lista2), coeficienteDeterminacao(lista1, lista2));
        System.out.printf("Equacao da reta: %.6f + %.6fx\n", equacaoRetaA(lista1, lista2), equacaoRetaB(lista1, lista2));
        System.out.println("Escolha um valor para x: ");
        double x = sc.nextDouble();
        sc.close();
        double y = (equacaoRetaA(lista1, lista2) + equacaoRetaB(lista1, lista2) * x);
        System.out.printf("O valor de Y: %.6f", y);
    }


}
