import org.junit.jupiter.api.Test;

class HuffmanQueueTest {
	
	@Test
	public void test() {
		HuffmanQueue<String> queue = new HuffmanQueue<>();
		queue.push("1", 1);
		System.out.println(queue);
		queue.push("3", 3);
		System.out.println(queue);
		queue.push("2", 2);
		System.out.println(queue);
		queue.push("4", 4);
		System.out.println(queue);

		System.out.println(queue.pop());
		System.out.println(queue);
		System.out.println(queue.pop());
		System.out.println(queue);
		System.out.println(queue.pop());
		System.out.println(queue);
		System.out.println(queue.pop());
		System.out.println(queue);
		System.out.println(queue.pop());
		System.out.println(queue);
	}
	@Test
	public void test2() {
		HuffmanQueue<String> queue = new HuffmanQueue<>();
		queue.push("4", 4);
		System.out.println(queue);
		queue.push("3", 3);
		System.out.println(queue);
		queue.push("2", 2);
		System.out.println(queue);
		queue.push("1", 1);
		System.out.println(queue);
	}
	@Test
	public void test3() {
		HuffmanQueue<String> queue = new HuffmanQueue<>();
		queue.push("1500", 1500);
		System.out.println(queue);
		queue.push("3", 3);
		System.out.println(queue);
		queue.push("17-1", 17);
		System.out.println(queue);
		queue.push("1123", 1123);
		System.out.println(queue);
		queue.push("21", 21);
		System.out.println(queue);
		queue.push("1-1", 1);
		System.out.println(queue);
		queue.push("25", 25);
		System.out.println(queue);
		queue.push("1-2", 1);
		System.out.println(queue);
		queue.push("17-2", 17);
		System.out.println(queue);
		queue.push("41", 41);
		System.out.println(queue);
		queue.push("133", 133);
		System.out.println(queue);
		queue.push("1-3", 1);
		System.out.println(queue);

		System.out.println("-----------");
		
		System.out.println(queue);
		for (int i = 0; i < 15; i++) {
			System.out.println(queue.pop());
			System.out.println(queue);
		}
		System.out.println(queue);
	}

}