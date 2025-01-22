import java.util.Stack;

public class Queue {
    public static void main(String[] args) {
        Q queue = new Q();
        queue.push(new taskB());
        queue.push(new taskA());
        queue.peek().run();
        queue.pop().run();
        queue.pop().run();
        queue.pop().run(); // error
    }
}
abstract class GenericTask {
    public abstract void run();
}
class taskA extends GenericTask {
    @Override
    public void run() {
        System.out.println("POOOP!");
    }
}
class taskB extends GenericTask {
    @Override
    public void run() {
        System.out.println("PEEEE!");
    }
}
class Q {
    private Stack<GenericTask> queued = new Stack<>();
    private Stack<GenericTask> active = new Stack<>();
    public void push(GenericTask task) {
        System.out.println("Pushed task!");
        queued.push(task);
    }
    public GenericTask pop() {
        if (active.empty()) {
            shift();
        }
        return active.pop();
    }
    public GenericTask peek() {
        if (active.empty()) {
            shift();
        }
        return active.peek();
    }
    public void shift() {
        if (queued.empty()) {
            throw new RuntimeException("No tasks queued!");
        }
        while (!queued.empty()) {
            System.out.println("Shifted!");
            active.push(queued.pop());
        }
    }
}
