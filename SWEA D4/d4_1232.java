// 1232 사칙연산
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class d4_1232 {
	static class Node {
		int operand;
		char operator;
		int leftChild;
		int rightChild;

		public Node(int operand, char operator, int leftChild, int rightChild) {
			this.operand = operand;
			this.operator = operator;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
		}
	}
	static Node[] tree;

	static int evaluate(Node node) {
		if (node.operator == ' ') {
			return node.operand;
		}

		int x = evaluate(tree[node.leftChild]);
		int y = evaluate(tree[node.rightChild]);

		switch (node.operator) {
		case '+':
			return x + y;
		case '-':
			return x - y;
		case '*':
			return x * y;
		case '/':
			return (int)(x / y);
		}
		return 0;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		for (int t = 1; t <= 10; t++) {
			// Input
			int N = Integer.parseInt(br.readLine());
			tree = new Node[N + 1];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int index = Integer.parseInt(st.nextToken());
				String op = st.nextToken();

				if (op.matches("[+\\-*/]")) {
					int leftChild = Integer.parseInt(st.nextToken());
					int rightChild = Integer.parseInt(st.nextToken());
					tree[index] = new Node(0, op.charAt(0), leftChild, rightChild);
				} else {
					tree[index] = new Node(Integer.parseInt(op), ' ', 0, 0);
				}
			}

			// Output
			sb.append("#").append(t).append(" ").append(evaluate(tree[1])).append("\n");
		}
		System.out.println(sb.toString());
	}
}
