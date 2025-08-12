import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.NoSuchElementException;

// LinkedList로 Stack 구현
class LinkedStack<E> {
	private LinkedList<E> stack = new LinkedList<>();
	
	public boolean isEmpty() {
		return stack.isEmpty();
	}
	
	public E peek() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return stack.getFirst();
	}
	
	public void push(E item) {
		stack.addFirst(item);
	}
	
	public E pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return stack.removeFirst();
	}
	
	public int search(Object o) {
		int index = stack.indexOf(o);  // LinkedList의 indexOf는 0부터 시작
		if (index >= 0) {
			return index + 1;  // Stack의 search는 1부터 시작
		}
		return -1;  // 요소를 찾지 못하면 -1 반환
	}
	
	@Override
	public String toString() {
		return stack.toString();
	}
}

// LinkedList로 Queue 구현
class LinkedQueue<E> {
	private LinkedList<E> queue = new LinkedList<>();
	
	public boolean isEmpty() {
		return queue.isEmpty();
	}
	
	public boolean offer(E item) {
		return queue.add(item);  // boolean 반환 (항상 true)
	}
	
	public boolean add(E item) {
		// 이 method는 용량 제한이 있는 queue에서 주로 사용됨
		// LinkedList는 용량 제한이 없으므로 항상 성공하지만,
		// 표준 Queue interface를 따르기 위해 제공
		queue.addLast(item);  // void 반환
		return true;  // 항상 true
	}
	
	// remove()와 유사, 실패 시 null
	public E poll() {
		if (isEmpty()) {
			return null;
		}
		return queue.removeFirst();
	}
	
	// poll()과 유사, 실패 시 Exception
	public E remove() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return queue.removeFirst();
	}
	
	// element()와 유사, 실패 시 null
	public E peek() {
		if (isEmpty()) {
			return null;
		}
		return queue.getFirst();
	}
	
	// peek()과 유사, 실패 시 Exception
	public E element() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return queue.getFirst();
	}
	
	@Override
    public String toString() {
        return queue.toString();
    }
}

// main (test code)
public class LinkedStackAndQueue {
	public static void main(String[] args) {
		System.out.println("\n============== STACK ==============\n");
		LinkedStack<String> stack = new LinkedStack<>();

        System.out.println("스택이 비어있는가? " + stack.isEmpty()); // true

        // 1. push()
        stack.push("Apple");
        stack.push("Banana");
        stack.push("Cherry");
        System.out.println("push 후 스택: " + stack); // [Cherry, Banana, Apple]

        // 2. peek()
        System.out.println("peek: " + stack.peek()); // Cherry
        System.out.println("peek 후 스택: " + stack); // [Cherry, Banana, Apple]

        // 3. search()
        System.out.println("Banana는 스택의 상단에서 " + stack.search("Banana") + "번째에 있습니다."); // 2
        System.out.println("Apple은 스택의 상단에서 " + stack.search("Apple") + "번째에 있습니다.");   // 3
        System.out.println("Grape는 스택에 없습니다: " + stack.search("Grape"));   // -1

        // 4. pop()
        System.out.println("pop: " + stack.pop()); // Cherry
        System.out.println("pop: " + stack.pop()); // Banana
        System.out.println("pop 후 스택: " + stack); // [Apple]

        // 5. EmptyStackException 테스트
        stack.pop(); // Apple
        try {
            stack.pop(); // 스택이 비어있는 상태에서 pop 시도
        } catch (EmptyStackException e) {
            System.out.println("예외 발생: " + e.getMessage()); // 스택이 비어있으므로 예외 발생
        }
        
        System.out.println("\n============== QUEUE ==============\n");
        LinkedQueue<String> queue = new LinkedQueue<>();

        System.out.println("큐가 비어있는가? " + queue.isEmpty()); // true

        // 1. offer() / add()
        queue.offer("Apple");
        queue.add("Banana");
        System.out.println("offer/add 후 큐: " + queue); // [Apple, Banana]

        // 2. peek() / element()
        System.out.println("peek: " + queue.peek()); // Apple
        System.out.println("element: " + queue.element()); // Apple
        System.out.println("peek/element 후 큐: " + queue); // [Apple, Banana]

        // 3. poll() / remove()
        System.out.println("poll: " + queue.poll()); // Apple
        System.out.println("remove: " + queue.remove()); // Banana
        System.out.println("poll/remove 후 큐: " + queue); // []

        // 4. 비어있는 큐에서 poll(), peek() 테스트
        System.out.println("빈 큐에서 peek: " + queue.peek()); // null
        System.out.println("빈 큐에서 poll: " + queue.poll()); // null
        
        // 5. 예외 처리 테스트 (NoSuchElementException)
        try {
            queue.element(); // 큐가 비어있는 상태에서 element 시도
        } catch (NoSuchElementException e) {
            System.out.println("예외 발생: " + e.getMessage()); // 큐가 비어있으므로 예외 발생
        }

        try {
            queue.remove(); // 큐가 비어있는 상태에서 remove 시도
        } catch (NoSuchElementException e) {
            System.out.println("예외 발생: " + e.getMessage()); // 큐가 비어있으므로 예외 발생
        }
	}
}