// Binary tree, Binary search tree 구현

/* 
 * Binary Tree : 배열로 구현
 */
class BinaryTree {
    private int[] tree;
    private int size;

    // 배열의 크기를 지정하여 초기화합니다.
    public BinaryTree(int capacity) {
        tree = new int[capacity];
        size = 0;
    }

    // 루트 노드를 추가합니다.
    public void addRoot(int data) {
        if (size == 0) {
            tree[0] = data;
            size = 1;
        } else {
            System.out.println("루트 노드가 이미 존재합니다.");
        }
    }

    // 특정 노드의 왼쪽 자식을 추가합니다.
    public void addLeft(int parentIndex, int data) {
        int leftChildIndex = 2 * parentIndex + 1;
        if (leftChildIndex < tree.length) {
            tree[leftChildIndex] = data;
            if (leftChildIndex >= size) {
                size = leftChildIndex + 1;
            }
        } else {
            System.out.println("배열 크기를 초과했습니다.");
        }
    }

    // 특정 노드의 오른쪽 자식을 추가합니다.
    public void addRight(int parentIndex, int data) {
        int rightChildIndex = 2 * parentIndex + 2;
        if (rightChildIndex < tree.length) {
            tree[rightChildIndex] = data;
            if (rightChildIndex >= size) {
                size = rightChildIndex + 1;
            }
        } else {
            System.out.println("배열 크기를 초과했습니다.");
        }
    }

    // 배열을 출력하여 트리 구조를 확인합니다.
    @Override
    public String toString() {
    	StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tree.length; i++) {
        	sb.append(tree[i]).append(" ");
        }
        return sb.toString();
    }
}

/* 
 * Binary Search Tree : 연결리스트로 구현
 */
class BinarySearchTree {
	// Node : 연결리스트 방식
	private class Node {
		int data;
		Node left;
		Node right;
		
		// Node Constructor
		public Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}
    Node root;

    // Tree Constructor
    public BinarySearchTree() {
        root = null;
    }
    
    // 노드 삽입
    public void add(int data) {
        root = addNode(root, data);
    }
    
    private Node addNode(Node current, int data) {
        if (current == null) {
            return new Node(data);
        }
        
        // 데이터가 현재 노드보다 작으면 왼쪽으로 이동
        if (data < current.data) {
            current.left = addNode(current.left, data);
        } 
        // 데이터가 현재 노드보다 크면 오른쪽으로 이동
        else if (data > current.data) {
            current.right = addNode(current.right, data);
        } 
        // 데이터가 같으면 아무것도 하지 않음 (중복 방지)
        else {
            return current;
        }
        
        return current;
    }
    
    // 노드 삭제
    public void delete(int data) {
    	root = deleteNode(root, data);
    }
    
    private Node deleteNode(Node current, int data) {
    	if (current == null) {
            return null;
        }

        if (data == current.data) {
            // 자식 노드가 없거나 하나만 있는 경우
            if (current.left == null) {
                return current.right;
            }
            if (current.right == null) {
                return current.left;
            }
            // 자식 노드가 두 개 있는 경우
            current.data = findSmallestValue(current.right);
            current.right = deleteNode(current.right, current.data);
            return current;
        }
        if (data < current.data) {
            current.left = deleteNode(current.left, data);
            return current;
        }
        current.right = deleteNode(current.right, data);
        return current;
    }
    
    private int findSmallestValue(Node root) {
    	// 가장 작은 값 찾기 (삭제 작업 시 사용)
    	return root.left == null
    	? root.data
    	: findSmallestValue(root.left);
    }
    
    // 특정 값 탐색
    public boolean contains(int data) {
        return containsNode(root, data);
    }
    
    private boolean containsNode(Node current, int data) {
        if (current == null) {
            return false;
        }
        
        if (data == current.data) {
            return true;
        }
        
        // 데이터가 현재 노드보다 작으면 왼쪽으로, 크면 오른쪽으로 이동
        return data < current.data
          ? containsNode(current.left, data)
          : containsNode(current.right, data);
    }
    
    // 중위 순회
    public void traverse(Node node) {
        if (node != null) {
            traverse(node.left);
            System.out.print(" " + node.data);
            traverse(node.right);
        }
    }
}

// MAIN
public class Tree {
    public static void main(String[] args) {
        // 이진 트리 예제
        System.out.println("\n======= 배열로 구현한 이진 트리 =======\n");
        BinaryTree bt = new BinaryTree(10);
        bt.addRoot(10);
        bt.addLeft(0, 5);  // 10의 왼쪽 자식
        bt.addRight(0, 15);  // 10의 오른쪽 자식
        bt.addLeft(1, 3);  // 5의 왼쪽 자식
        bt.addRight(1, 7);  // 5의 오른쪽 자식
        System.out.println(bt.toString());  // 출력: 10 5 15 3 7 0 0 0 0 0
        
        // 이진 탐색 트리 예제
        System.out.println("\n=== 연결리스트로 구현한 이진 탐색 트리 ===\n");
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(10);
        bst.add(5);
        bst.add(15);
        bst.add(3);
        bst.add(7);
        
        System.out.print("중위 순회 (정렬된 순서):");
        bst.traverse(bst.root);  // 출력: 3 5 7 10 15
        System.out.println();

        System.out.println("값 5 삭제 후...");
        bst.delete(5);
        System.out.print("중위 순회:");
        bst.traverse(bst.root);  // 출력: 3 7 10 15
        System.out.println();

        System.out.println("값 7 탐색: " + bst.contains(7));  // 출력: true
        System.out.println("값 9 탐색: " + bst.contains(9));  // 출력: false
    }
}
