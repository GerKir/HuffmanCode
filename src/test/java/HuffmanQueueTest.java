import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HuffmanQueueTest {
	
	@Test
	public void test() {
		HuffmanQueue<String> queue = new HuffmanQueue<>();
		queue.push("1", 1);
		queue.push("3", 3);
		queue.push("2", 2);
		queue.push("4", 4);

		System.out.println(queue.pop());
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		System.out.println(queue.pop());
	}
	@Test
	public void test2() {
		HuffmanQueue<String> queue = new HuffmanQueue<>();
		queue.push("4", 4);
		queue.push("3", 3);
		queue.push("2", 2);
		queue.push("1", 1);
		
		queue.print();
	}
	@Test
	public void test3() {
		HuffmanQueue<String> queue = new HuffmanQueue<>();
		queue.push("1500", 1500);
		queue.push("3", 3);
		queue.push("17-1", 17);
		queue.push("1123", 1123);
		queue.push("21", 21);
		queue.push("1-1", 1);
		queue.push("25", 25);
		queue.push("1-2", 1);
		queue.push("17-2", 17);
		queue.push("41", 41);
		queue.push("133", 133);
		queue.push("1-3", 1);
		
		queue.print();

		for (int i = 0; i < 15; i++) {
			System.out.println(queue.pop());
			queue.print();
		}
		
		queue.print();
	}

}