public class HuffmanQueueEntry<T> {
	public HuffmanQueueEntry(T value, int weight) {
		this.value = value;
		this.weight = weight;
	}
	
	private final T value;
	private final int weight;

	public T getValue() {
		return value;
	}


	public int getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return getValue().toString() + '|' + getWeight();
	}
}
