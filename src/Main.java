import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RegressaoLinear regressaoLinear = new RegressaoLinear();
        List<Double> lista1 = new ArrayList<Double>();
        List<Double> lista2 = new ArrayList<Double>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o tamanho da lista: ");
        int tam1 = scanner.nextInt();
        for (int i = 0; i < tam1; i++) {
            System.out.println("Digite o valor da lista X: ");
            lista1.add(scanner.nextDouble());
        }
        for (int i = 0; i < tam1; i++) {
            System.out.println("Digite o valor da lista Y: ");
            lista2.add(scanner.nextDouble());
        }
        regressaoLinear.print(lista1, lista2);
    }
}
