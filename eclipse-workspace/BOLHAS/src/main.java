
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class main {

	public static void main(String[] args) {
		int n = 5;
		if (args.length > 0) {
			n = Integer.parseInt(args[0]);
		}
		List<Integer> collect = IntStream.range(1, n + 1).boxed().collect(Collectors.toList());
		Collections.shuffle(collect);
		int[] seq = collect.stream().mapToInt(i -> i).toArray();
		System.out.println("Sequência gerada:");
		System.out.println(Arrays.toString(seq));
		System.out.println("Entrada de teste para o programa 1388: ");
		bubbleSort(seq);
	}

	public static void bubbleSort(int[] seq) {
		int trocas, turnos = 0;
		ArrayList<Integer> todasTrocas = new ArrayList<>();
		for (int i = 0; i < seq.length; i++) {
			trocas = 0;
			for (int j = seq.length - 1; j > i; j--) {
				if (seq[j - 1] > seq[j]) {
					int temp = seq[j - 1];
					seq[j - 1] = seq[j];
					seq[j] = temp;
					trocas++;
				}
			}
			if (trocas == 0) {
				break;
			} else {
				todasTrocas.add(trocas);
				turnos++;
			}
		}
		System.out.println(seq.length + " " + turnos);
		if (todasTrocas.size() == 0) {
			System.out.println("0");
		} else {
			System.out.println(todasTrocas.stream().map(String::valueOf).collect(Collectors.joining(" ")));
		}
		System.out.println("Array Ordenado");
		System.out.println(Arrays.toString(seq));
	}

}