public class HuffmanQueue<E> {
	public static final int DEFAULT_CAPACITY = 256;
	private final Object[] queue;
	private int size = 0;

	public HuffmanQueue() {
		this.queue = new Object[DEFAULT_CAPACITY];
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) {
			sb.append("[")
					.append(i)
					.append("] ")
					.append(queue[i])
					.append("\n");
		}
		return sb.toString();
	}

	public void push(E value, int weight) {
		if (size >= queue.length) {
			throw new IllegalStateException("Queue is full");
		}
		HuffmanQueueEntry<E> entry = new HuffmanQueueEntry<>(value, weight);
		push(entry);
	}

	private synchronized void push(HuffmanQueueEntry<E> entry) {
		queue[size++] = entry;
		if (size == 1) {
			return;
		}

		int childNumber = size;
		int parentNumber = getParentNumber(size);
		while (shouldSwap(childNumber, parentNumber)) {
			swapElements(childNumber, parentNumber);
			childNumber = parentNumber;
			parentNumber = getParentNumber(childNumber);
		}
	}

	public synchronized E pop() {
		if (size == 0) {
			throw new IllegalStateException("Queue is empty");
		}
		
		HuffmanQueueEntry<E> root = (HuffmanQueueEntry<E>) queue[0];
		HuffmanQueueEntry<E> lastElement = (HuffmanQueueEntry<E>) queue[--size];
		
		queue[0] = lastElement;
		queue[size] = null;
		
//		todo: refactoring
		int parent = 1;
		int leftChild = getLeftChild(parent);
		int rightChild = getRightChild(parent);
		int minChildNumber = findMin(leftChild, rightChild);
		while (shouldSwap(minChildNumber, parent)) {
			swapElements(minChildNumber, parent);
			parent = minChildNumber;
			leftChild = getLeftChild(parent);
			rightChild = getRightChild(parent);
			minChildNumber = findMin(leftChild, rightChild);
		}
		return root.getValue();
	}

	private HuffmanQueueEntry<E> getElement(int elementNumber) {
		return ((HuffmanQueueEntry<E>) queue[--elementNumber]);
	}

	private int getParentNumber(int childNumber) {
		return childNumber / 2;
	}

	private int getLeftChild(int parentNumber) {
		return parentNumber * 2;
	}

	private int getRightChild(int parentNumber) {
		return (parentNumber * 2) + 1;
	}

	private boolean shouldSwap(int childNumber, int parentNumber) {
		if (childNumber == 1) {
			return false;
		}
		int childWeight = getElement(childNumber).getWeight();
		int parentWeight = getElement(parentNumber).getWeight();
		return childWeight < parentWeight;
	}

	private boolean shouldSwap(int leftChildNumber, int rightChildNumber, int parentNumber) {
		int min = findMin(leftChildNumber, rightChildNumber);
		return shouldSwap(min, parentNumber);
	}

	private int findMin(int leftChild, int rightChild) {
		HuffmanQueueEntry<E> left = getElement(leftChild);
		if (left == null) {
			return getParentNumber(leftChild);
		}
		HuffmanQueueEntry<E> right = getElement(rightChild);
		if (right == null) {
			return leftChild;
		}
		int compareResult = Integer.compare(left.getWeight(), right.getWeight());
		return compareResult > 0
				? rightChild
				: leftChild;
	}

	private void swapElements(int newElementNumber, int parentNumber) {
		HuffmanQueueEntry<E> newElement = getElement(newElementNumber);
		HuffmanQueueEntry<E> parent = getElement(parentNumber);
		queue[--newElementNumber] = parent;
		queue[--parentNumber] = newElement;
	}
}
