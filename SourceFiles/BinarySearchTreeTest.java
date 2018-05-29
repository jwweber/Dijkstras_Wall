
public class BinarySearchTreeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testCaseOne();
	}
	public static void testCaseOne(){
		BinarySearchTree bst = new BinarySearchTree();
		bst.treeInsert("(a,b)", 10);
		bst.treeInsert("(c,b)", 12);
		bst.treeInsert("(a,g)", 3);
		bst.treeInsert("(f,g)", 6);
		bst.treeInsert("(f,b)", 1);
		bst.treeInsert("(b,c)", 7);
		bst.preOrderWalk(bst.getRoot());
		System.out.println();
		System.out.println(bst.nodeValue(bst.treeSearch(bst.getRoot(), "(a,g)")));
		System.out.println();
		System.out.println();
		System.out.println(bst.nodeValue(bst.getRoot()));
		System.out.println();
		System.out.println(bst.nodeValue(bst.treeDelete("(f,g)")));
		bst.preOrderWalk(bst.getRoot());
		System.out.println();
		System.out.println(bst.nodeValue(bst.treeDelete("(a,b)")));
		bst.preOrderWalk(bst.getRoot());
		System.out.println();
		System.out.println(bst.nodeValue(bst.treeDelete("(f,b)")));
		bst.preOrderWalk(bst.getRoot());
		System.out.println();
		System.out.println(bst.nodeValue(bst.treeDelete("(a,g)")));
		bst.preOrderWalk(bst.getRoot());
		System.out.println();
		System.out.println(bst.nodeValue(bst.treeDelete("(c,b)")));
		bst.preOrderWalk(bst.getRoot());
		System.out.println();
		System.out.println(bst.nodeValue(bst.treeDelete("(b,c)")));
		bst.preOrderWalk(bst.getRoot());
		}
}
