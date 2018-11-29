package codingpractice.datastructure;

public class BinaryTree implements StructureGenerator {

	@Override
	public Node generateStructureWithRandomData() {
		Node n = new Node("25", 
				new Node("15",
						new Node("10", 
								new Node("4"),
								new Node("12")),
						new Node("22",
								new Node("18"),
								new Node("24"))),
				new Node("50",
						new Node("35",
								new Node("31"),
								new Node("44")),
						new Node("70",
								new Node("66"),
								new Node("90")))
				);
		
		return n;
	}
}
