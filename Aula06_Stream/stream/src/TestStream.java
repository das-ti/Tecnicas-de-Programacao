
import java.util.Arrays;
import java.util.List;

public class TestStream {

    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);
        numeros.stream().map(n -> n * 2).forEach(System.out::println);
        numeros.forEach(System.out::println);
        List<String> frutas = Arrays.asList("Banana",
                "Maçã", "Uva", "Laranja", "Abacaxi");
        List<String> fFiltradas = frutas.stream()
                .filter(f -> f.length() > 5)
                .toList();
        fFiltradas.forEach(System.out::println);
        int somaDobroPares = numeros.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n*2)
                .reduce(0, Integer::sum);
        System.out.println("Resultado: " + somaDobroPares);

    }
}
