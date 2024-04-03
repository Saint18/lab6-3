import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.BiFunction;

public class GroupNode<T> implements TreeNode<T> {
    private T data;
    private List<TreeNode<T>> children = new ArrayList<>();

    public GroupNode(T data) {
        this.data = data;
    }

    @Override
    public TreeNode<T> addChild(TreeNode<T> child) {
        children.add(child);
        return this;
    }

    @Override
    public boolean removeChild(TreeNode<T> child) {
        return children.remove(child);
    }

    @Override
    public List<TreeNode<T>> getChildren() {
        return children;
    }

    @Override
    public void print() {
        System.out.println(data.toString());
        for (TreeNode<T> child : children) {
            child.print();
        }
    }

    @Override
    public List<T> toList() {
        List<T> list = new ArrayList<>();
        list.add(data);
        for (TreeNode<T> child : children) {
            list.addAll(child.toList());
        }
        return list;
    }

    @Override
    public <R> TreeNode<R> map(Function<T, R> transform) {
        GroupNode<R> newNode = new GroupNode<>(transform.apply(data));
        for (TreeNode<T> child : children) {
            newNode.addChild(child.map(transform));
        }
        return newNode;
    }

    @Override
    public T reduce(T initialValue, BiFunction<T, T, T> combiner) {
        T result = data;
        for (TreeNode<T> child : children) {
            result = child.reduce(result, combiner);
        }
        return combiner.apply(initialValue, result);
    }
    
    
    public T getData() {
		return data;
}
}