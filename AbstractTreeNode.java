
/*
AbstractTreeNode takes its orders from TreeNode and sets up the basic, very simple, structure of a tree node. 
You'll have to fix the class declaration and complete this file. 
*/

public abstract class AbstractTreeNode<T> {
	protected T data; // data we store in the node
	protected AbstractTreeNode<T> parent; // reference to parent node

	// constructor initializes node with data
	public AbstractTreeNode(T data) {
		this.data = data;
		this.parent = null;
	}

	// constructor to initialize node with data and parent
	public AbstractTreeNode(T data, AbstractTreeNode<T> parent) {
		this.data = data;
		this.parent = parent;
	}

	// getter for data
	public T getData() {
		return data;
	}

	// setter for data
	public void setData(T data) {
		this.data = data;
	}

	// getter for parent of node
	public AbstractTreeNode<T> getParent() {
		return parent;
	}

	// sets the parent of node
	public void setParent(AbstractTreeNode<T> parent) {
		this.parent = parent;
	}

	// abstract method to add a child to node
	public abstract AbstractTreeNode<T> addChild(AbstractTreeNode<T> child);

	// abstract method to remove a child
	public abstract boolean removeChild(AbstractTreeNode<T> child);

	// method to check if node is a leaf
	public abstract boolean isLeaf();

	// abstract method to print node information. will be implemented by subclasses.
	public abstract void printEmployees();

	
	//traverse method. visit parent node first. 
	public abstract void traversePreOrder();
	
}
