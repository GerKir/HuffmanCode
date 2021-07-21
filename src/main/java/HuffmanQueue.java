public class HuffmanQueue<E> {
	public static final int DEFAULT_CAPACITY = 256;
	private final Object[] queue;
	private int size = 0;

	public HuffmanQueue() {
		this.queue = new Object[DEFAULT_CAPACITY];
	}

	public void push(E value, int weight) {
		HuffmanQueueEntry<E> entry = new HuffmanQueueEntry<>(value, weight);
		push(entry);
	}

	public void push(HuffmanQueueEntry<E> entry) {
		for (int elementIndex = 0; elementIndex < size; elementIndex++) {
			HuffmanQueueEntry<E> element = getElement(elementIndex);
			if (entry.getWeight() < element.getWeight()) {
				queue[elementIndex] = entry;
				push(element);
				return;
			}
		}
		queue[size++] = entry;
	}

	private HuffmanQueueEntry<E> getElement(int index) {
		return ((HuffmanQueueEntry<E>) queue[index]);
	}

	public E pop() {
		if (size == 0) {
			return null;
		}
		HuffmanQueueEntry<E> entity = (HuffmanQueueEntry<E>) queue[0];
		for (int i = 0; i < size; i++) {
			queue[i] = queue[i + 1];
		}
		size--;
		return entity.getValue();
	}

	public void print() {
		for (int i = 0; i < size; i++) {
			System.out.println("[" + i + "] " + queue[i]);
		}
	}
}
