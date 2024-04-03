import java.util.List;
import java.util.function.Function;
import java.util.function.BiFunction;

public class LeafNode<T> implements TreeNode<T> {
    private T data;

    public LeafNode(T data) {
        this.data = data;
    }

    @Override
    public TreeNode<T> addChild(TreeNode<T> child) {
        throw new UnsupportedOperationException("Leaf node can't add children.");
    }

    @Override
    public boolean removeChild(TreeNode<T> child) {
        return false; // Leaf nodes don't have children.
    }

    @Override
    public List<TreeNode<T>> getChildren() {
        return List.of(); // Leaf nodes don't have children.
    }

    @Override
    public void print() {
        System.out.println(this.data.toString());
    }

    @Override
    public List<T> toList() {
        return List.of(data);
    }

    @Override
    public <R> TreeNode<R> map(Function<T, R> transform) {
        return new LeafNode<>(transform.apply(data));
    }

    @Override
    public T reduce(T initialValue, BiFunction<T, T, T> combiner) {
        return combiner.apply(initialValue, data);
    }
}
