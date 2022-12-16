
package tripleminheap;
import java.util.Scanner;
public class TripleMinHeap {

	int[] dizi;

	public int parent(int x) {
		return (x - 1) / 3;
	}

	public int left(int x) {
		return (x * 3) + 1;
	}

	public int middle(int x) {
		return (x * 3) + 2;
	}

	public int right(int x) {
		return (x * 3) + 3;
	}

	public boolean MinHeapKontrol(int[] dizi) {

		for (int i = 0; i < dizi.length / 3; i++) {
			int left = 3 * i + 1;
			int middle = 3 * i + 2;
			int right = 3 * i + 3;

			if (left < dizi.length && dizi[i] > dizi[left]) {
				return false;
			}
			if (middle < dizi.length && dizi[i] > dizi[middle]) {
				return false;
			}
			if (right < dizi.length && dizi[i] > dizi[right]) {
				return false;
			}
		}
		System.err.println("\n\nGIRILEN DEGERLER HALIHAZIRDA MIN HEAP YAPISINDA");
		return true;
	}

	public void buildMinHeap() {
		if (MinHeapKontrol(dizi) == false) {
			for (int i = (dizi.length / 3) - 1; i >= 0; i--) {
				minHeapify(i);
			}

			System.err.println("\n\nMIN HEAP YAPISI : ");
			for (int i : dizi) {
				System.out.print(i + " ");
			}

		}
	}

	private void minHeapify(int index) {
		int smallest = index;
		int left = left(index);
		int middle = middle(index);
		int right = right(index);

		if (left < dizi.length && dizi[left] < dizi[smallest]) {
			smallest = left;
		}
		if (middle < dizi.length && dizi[middle] < dizi[smallest]) {
			smallest = middle;
		}
		if (right < dizi.length && dizi[right] < dizi[smallest]) {
			smallest = right;
		}

		if (smallest != index) {
			int temp = dizi[index];
			dizi[index] = dizi[smallest];
			dizi[smallest] = temp;

			minHeapify(smallest);
		}
	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.print("virgülden sonra boşluk bırakmadan sayilari giriniz : ");
		String girdi = input.nextLine();

		String[] dizi = girdi.split(",", 100);

		int[] AnaDizi = new int[dizi.length];

		for (int counter = 0; counter < dizi.length; counter++) {

			AnaDizi[counter] = Integer.parseInt(dizi[counter]);
		}

		TripleMinHeap heap = new TripleMinHeap();
		heap.dizi = AnaDizi;
		heap.buildMinHeap();

	}
}
