import java.util.Arrays;

public class PriorityQueue <T extends Comparable<? super T>> {
	
	private static final int INITIAL_CAPACITY = 32;
	private T[] data;
	private int size;
	/**
	 * Constructor
	 */
	public PriorityQueue(){
		this.data = (T[]) new Comparable[16];
		this.size = 0;
	}
	
	public int parentOf(int i) { return (i-1) / 2;}
	public int leftChildOf(int i) {return i * 2 + 1; }
	public int rightChildOf(int i) { return i * 2 + 2; }
	
	/**
	 * Constructor
	 * @param data
	 */
	public PriorityQueue(T[] data){
		this.data = data;
	}
	
	/**
	 * peak the highest priority element
	 */
	public T peak(){
		if (size > 0) return data[0];
		else return null; 
	}
	
	/**
	 * add a new element into the data
	 */
	public void growIfFull(){
		if (size == data.length) {
			data = Arrays.copyOf(data, data.length * 2);
		}
	}
	private void siftUp(int i) {
		if (parentOf(i) >= 0 && data[parentOf(i)].compareTo(data[i]) < 0) {
			T temp = data[parentOf(i)];
			data[parentOf(i)] = data[i];
			data[i] = temp;
			siftUp(parentOf(i));
		}
	}
	
	public void add(T v) {
		growIfFull();
		data[size ++] = v;
		siftUp(size - 1);
	}
	
	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(3);
		System.out.printf("peek = 3 : %d\n", pq.peak());
		pq.add(9);
		System.out.printf("peek = 9 : %d\n", pq.peak());
		pq.add(2);
		System.out.printf("peek = 9 : %d\n", pq.peak());
	}
}
