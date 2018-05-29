
public class BinarySearchTree {
	private TreeNode root;
	public BinarySearchTree(){
		root = null;
	}
	private static class TreeNode{
		private TreeNode p;
		private TreeNode l;
		private TreeNode r;
		private String key;
		private int value;
	}
	public TreeNode getRoot(){
		return root;
	}
	public void preOrderWalk(TreeNode x){
		if(x != null){
			System.out.println(x.key+" "+x.value);
			preOrderWalk(x.l);
			preOrderWalk(x.r);
		}
	}
	public int nodeValue(TreeNode x){
		return x.value;
	}
	public void treeInsert(String key, int value){
		TreeNode z = new TreeNode();
		z.key = key;
		z.value = value;
		TreeNode y = null;
		TreeNode x = root;
		while(x != null){
			y = x;
			if(z.key.compareTo(x.key) < 0){
				x = x.l;
			}
			else{
				x = x.r;
			}
		}
		z.p = y;
		if(y == null){
			root = z;
		}
		else if(z.key.compareTo(y.key) < 0){
			y.l = z;
		}else{
			y.r = z;
		}
	}
	public TreeNode treeSearch(TreeNode x, String key){
		if(x == null || key.equals(x.key)){
			return x;
		}
		if(key.compareTo(x.key) < 0){
			return treeSearch(x.l, key);
		}
		else{
			return treeSearch(x.r,key);
		}
	}
	public TreeNode minimum(TreeNode x){
		while(x.l != null){
			x = x.l;
		}
		return x;
	}
	public TreeNode successor(TreeNode x){
		if(x.r != null){
			return minimum(x.r);
		}
		TreeNode y = x.p;
		while(y != null && x == y.r){
			x = y;
			y = y.p;
		}
		return y;
	}
	private void transplant(TreeNode u, TreeNode v){
		if(u.p == null){
			root = v;
		}
		else if(u == u.p.l){
			u.p.l = v;
		}
		else{
			u.p.r = v;
		}
		if(v != null){
			v.p = u.p;
		}
	}
	public TreeNode treeDelete(String key){
		TreeNode z = treeSearch(root,key);
		TreeNode y = null;
		TreeNode x = null;
		if(z.l == null){
			transplant(z,z.r);
		}
		else if(z.r == null){
			transplant(z,z.l);
		}
		else{
			y = minimum(z.r);
			if(y.p != z){
				transplant(y,y.r);
				y.r = z.r;
				y.r.p = y;
			}
			transplant(z,y);
			y.l = z.l;
			y.l.p = y;
		}
		return z;
	}
}
