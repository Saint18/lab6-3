import java.util.List;
import java.util.function.Function;
import java.util.function.BiFunction;

public interface TreeNode<T> {
    TreeNode<T> addChild(TreeNode<T> child);
    boolean removeChild(TreeNode<T> child);
    List<TreeNode<T>> getChildren();
    void print();
    List<T> toList();
    <R> TreeNode<R> map(Function<T, R> transform);
    T reduce(T initialValue, BiFunction<T, T, T> combiner);
}
