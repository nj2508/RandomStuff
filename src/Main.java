public class Main {
    public static void main(String[] args) {
        TreeNode first = new TreeNode('a');
        TreeNode current = first;
        for (int i = 1; i <= 10; i++) {
            TreeNode node = new TreeNode((char) ('a' + i));
            if (i == 3) {
                node.data = "PENIS!!!!!";
            }
            current.addChild(node);
            if (i == 10) {
                current = first;
            } else {
                current = node;
            }
        }

        System.out.println(TreeNodes.search(first, 'j').data);
        first.append(new TreeNode('l'));
        TreeNodes.print(first);

    }
}
class TreeNode<T> {
    public TreeNode next;
    public T data;
    public TreeNode(T data) {
        this.next = null;
        this.data = data;
    }
    public void addChild(TreeNode child) {
        this.next = child;
    }
    public boolean hasNext() {
        return this.next != null;
    }
    public void append(TreeNode child) {
        if (this.hasNext()) {
            next.append(child);
        } else {
            this.next = child;
        }
    }
    public TreeNode step(int steps) {
        if (steps > 0) {
            if (next != null) {
                return next.step(steps - 1);
            } else {
                return null;
            }
        } else {
            return this;
        }
    }
}
class TreeNodes {
    public static <S> TreeNode search(TreeNode start, S data) {
        System.out.println("Searching for: " + data);
        TreeNode current = start;
        while (current != null) {
            if (data == current.data) {
                return current;
            }
            current = current.step(1);
        }
        throw new RuntimeException("Failed to find a match!");
    }
    public static void print(TreeNode start) {
        System.out.println(start.data);
        if (start.hasNext()) print(start.next);
    }
}