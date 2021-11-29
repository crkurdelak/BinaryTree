import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * A recursive data structure, where each tree node has an optional left and right child node.
 *
 * @param <E> the type of value stored in this tree
 *
 * @author ckurdelak20@georgefox.edu
 */
public class BinaryTree<E> implements Iterable<E> {
    // TODO implement class
    private E _value;
    private BinaryTree<E> _parent;
    private BinaryTree<E> _leftChild;
    private BinaryTree<E> _rightChild;


    /*
    You  will  likely  want  to  create  one  or  more  private  helper  methods,  specifically
    to maintain  linkage between parent and child nodes.  Note that a user of
    class BinaryTree should not be able to set a node’s parent directly; rather, one should set a
    left or right child, which in turn maintains the parent of the new child.
     */

    /*
    Setting a left or right child to null should result in pruning the entire subtree rooted at
    that child node, and returning a reference to that subtree’s root.
     */

    /*
    Any method call that would result in the internal state of the entire structure becoming
    inconsistent (i. e.,not a binary tree),  such  as  attempting  to  set  the  left  child  of
    a  leaf  to  the  root  of  the  entire tree,  should  throw IllegalArgumentException and
    leave  the  tree  in  a  consistent  state.   Note  that this applies if and only if the
    specific case is not already handled by the aforementioned parent/child detaching strategy
     */

    /*
    Any method call that requires comparing a BinaryTree<E> to null (e. g., someTree.isAncestorOf
    (null)) should throw IllegalArgumentException, rather than spuriously returning true or false
    due to a null parent or child at some relevant level.
     */


    /**
     * Constructs a new BinaryTree object.
     *
     * @param element the element to be stored in this node
     */
    public BinaryTree(E element) {
        _value = element;
        _parent = null;
        _leftChild = null;
        _rightChild = null;
    }


    /**
     * Returns the element at this node.
     *
     * @return the element at this node
     */
    public E getElement() {
        return _value;
    }


    /**
     * Sets the value of this node to a new value.
     *
     * @param element the new value to be stored in this node
     */
    public void setElement(E element) {
        _value = element;
    }


    /**
     * Returns true if this node has a left child.
     *
     * @return true if this node has a left child
     */
    public boolean hasLeftChild() {
        return _leftChild != null;
    }


    /**
     * Returns the left child of this node.
     *
     * @return the left child of this node
     */
    public BinaryTree<E> getLeftChild() {
        return _leftChild;
    }


    /**
     * Sets the left child of this node to a new left child.
     *
     * @param child the new left child of this node
     * @return the old left child of this node
     * @throws IllegalArgumentException if child is an ancestor of this tree
     */
    public BinaryTree<E> setLeftChild(BinaryTree<E> child) {
        // TODO make it able to set child to null
        if (! child.isAncestorOf(this)) {
            BinaryTree<E> oldChild = getLeftChild();

            _leftChild = null;

            if (child.isChild()) {
                BinaryTree<E> oldParent = child.getParent();
                if (this.isLeftChildOf(oldParent)) {
                    oldParent._leftChild = null;
                } else {
                    oldParent._rightChild = null;
                }
            }

            _leftChild = child;
            child.setParent(this);

            return oldChild;
        }
        else {
            throw new IllegalArgumentException();
        }
    }


    /**
     * Returns true if this node has a right child.
     *
     * @return true if this node has a right child
     */
    public boolean hasRightChild() {
        return _rightChild != null;
    }


    /**
     * Returns the right child of this node.
     *
     * @return the right child of this node
     */
    public BinaryTree<E> getRightChild() {
        return _rightChild;
    }


    /**
     * Sets the right child of this node to a new right child.
     *
     * @param child the new right child of this node
     * @return the old right child of this node
     * @throws IllegalArgumentException if child is an ancestor of this tree
     */
    public BinaryTree<E> setRightChild(BinaryTree<E> child) {
        // TODO make it able to set child to null
        if (! child.isAncestorOf(this)) {
            BinaryTree<E> oldChild = getRightChild();

            _leftChild = null;

            if (child.isChild()) {
                BinaryTree<E> oldParent = child.getParent();
                if (this.isLeftChildOf(oldParent)) {
                    oldParent._leftChild = null;
                } else {
                    oldParent._rightChild = null;
                }
            }

            _rightChild = child;
            child.setParent(this);

            return oldChild;
        }
        else {
            throw new IllegalArgumentException();
        }
    }


    /**
     * Returns the root of this entire tree.
     *
     * @return the root of this entire tree
     */
    public BinaryTree<E> getRoot() {
        BinaryTree<E> root;

        if (isChild()) {
            root = this.getParent().getRoot();
        }
        else {
            root = this;
        }

        return root;
    }


    /**
     * Returns this subtree's parent.
     *
     * @return this subtree's parent
     */
    public BinaryTree<E> getParent() {
        return _parent;
    }


    /**
     * Returns the size of this subtree.
     *
     * @return the size of this subtree
     */
    public int size() {
        int size = 0;

        if (this.hasLeftChild()) {
            size += this.getLeftChild().size();
        }
        if (this.hasRightChild()) {
            size += this.getRightChild().size();
        }
        // return size of left child + size of right child + 1
        return size + 1;
    }


    /**
     * Returns the height of this subtree.
     *
     * @return the height of this subtree
     */
    public int height() {
        int height = 0;
        int leftHeight = 0;
        int rightHeight = 0;

        if (isLeaf()){
            height = 1;
        }
        else {
            if (this.hasLeftChild()) {
                leftHeight = this.getLeftChild().height();
            }
            if (this.hasRightChild()) {
                rightHeight = this.getRightChild().height();
            }
            height = Math.max(leftHeight, rightHeight) + 1;
        }

        return height;
    }


    /**
     * Returns the level of this tree.
     *
     * @return the level of this tree
     */
    public int level() {
        int level;
        // TODO fix this one

        if (! this.getRoot().isChild()) {
            level = 0;
        }
        else {
            level = this.getParent().level() + 1;
        }

        return level;
    }


    /**
     * Returns the degree of this subtree.
     *
     * The degree of a tree is the number of its children. The degree of a binary tree can only
     * be 0, 1, or 2.
     *
     * @return the degree of this subtree
     */
    public int degree() {
        int degree;

        if (this.isParent()) {
            if (this.hasLeftChild() && this.hasRightChild()) {
                degree = 2;
            }
            else {
                degree = 1;
            }
        }
        else {
            degree = 0;
        }

        return degree;
    }


    /**
     * Returns true if this tree is the root of the entire tree.
     *
     * @return true if this tree is the root of the entire tree
     */
    public boolean isRoot() {
        return this.getParent() == null;
    }


    /**
     * Returns true if this subtree is a parent.
     *
     * @return true if this subtree is a parent
     */
    public boolean isParent() {
        return (hasLeftChild() || hasRightChild());
    }


    /**
     * Returns true if this subtree is a child.
     *
     * @return true if this subtree is a child
     */
    public boolean isChild() {
        return this.getParent() != null;
    }


    /**
     * Returns true if this subtree is a leaf.
     *
     * @return true if this subtree is a leaf
     */
    public boolean isLeaf() {
        // have no cjildren? degree == 0?
        return ! this.isParent();
    }


    /**
     * Returns true if the subtree rooted at this node is full.
     *
     * A full binary tree of height h only has leaves on level h, and every non-leaf node has 2
     * children.
     * A full binary tree has 2^h leaves on level h.
     *
     * @return true if the subtree rooted at this node is full
     */
    public boolean isFull() {
        int sum = 0;
        int height = this.height();

        for (int level = 0; level < height; level++) {
            sum += Math.pow(2, level);
        }

        return this.size() == sum;
    }


    /**
     * Returns true if the subtree rooted at this node is complete.
     *
     * A complete binary tree of height h is an otherwise full binary tree with 0 or more of the
     * rightmost leaves on level h removed.
     *
     * @return true if the subtree rooted at this node is complete
     */
    public boolean isComplete() {
        // bailey book solutions to review question

        // complete?
        // left full, right complete, height left = height right
        // right full, left complete, height right = height left + 1

        boolean complete = false;

        if (this.isLeaf()) {
            complete = true;
        }
        else {
            if (this.hasLeftChild() && this.hasRightChild()) {
                if (this.getLeftChild().isFull() && this.getRightChild().isComplete()) {
                    complete = true;
                }
                if (this.getRightChild().isFull() && this.getLeftChild().isComplete()) {
                    complete = true;
                }
            }
        }

        return complete;
    }


    /**
     * Returns true if the subtree rooted at this node is degenerate.
     *
     * A size n tree with a height of n-1 is degenerate.
     *
     * @return true if the subtree rooted at this node is degenerate
     */
    public boolean isDegenerate() {
        return this.height() == this.size() - 1;
    }


    /**
     * Returns true if this tree is an ancestor of the given subtree.
     *
     * @param descendant the other tree to test if this tree is the ancestor of
     * @return true if this tree is an ancestor of the given subtree
     * @throws IllegalArgumentException if the given descendant is null
     */
    public boolean isAncestorOf(BinaryTree<E> descendant) {
        if (descendant != null) {
            boolean isAncestor;

            if (this.isParentOf(descendant)) {
                isAncestor = true;
            } else {
                if (descendant.getParent() != null) {
                    isAncestor = this.isAncestorOf(descendant.getParent());
                } else {
                    isAncestor = false;
                }
            }

            return isAncestor;
        }
        else {
            throw new IllegalArgumentException();
        }
    }


    /**
     * Returns true if this tree is the parent of the given subtree.
     *
     * @param child the other tree to test if this tree is the parent of
     * @return true if this tree is the parent of the given subtree
     * @throws IllegalArgumentException if the given child is null
     */
    public boolean isParentOf(BinaryTree<E> child) {
        if (child != null) {
            return this.getLeftChild() == child || this.getRightChild() == child;
        }
        else {
            throw new IllegalArgumentException();
        }
    }


    /**
     * Returns true if this tree is the sibling of the given tree.
     *
     * @param sibling the other tree to test if this tree is the sibling of
     * @return true if this tree is the sibling of the given tree
     * @throws IllegalArgumentException if the given sibling is null
     */
    public boolean isSiblingOf(BinaryTree<E> sibling) {
        if (sibling != null) {
            return this.getParent() == sibling.getParent();
        }
        else {
            throw new IllegalArgumentException();
        }
    }


    /**
     * Returns true if this tree is the child of the given tree.
     *
     * @param parent the other tree to test if this tree is the child of
     * @return true if this tree is the child of the given tree
     * @throws IllegalArgumentException if the given parent is null
     */
    public boolean isChildOf(BinaryTree<E> parent) {
        if (parent != null) {
            return this.getParent() == parent;
        }
        else {
            throw new IllegalArgumentException();
        }
    }


    /**
     * Returns true if this tree is a descendant of the given tree.
     *
     * @param ancestor the other tree to test if this tree is the descendant of
     * @return true if this tree is a descendant of the given tree
     * @throws IllegalArgumentException if the given ancestor is null
     */
    public boolean isDescendantOf(BinaryTree<E> ancestor) {
        if (ancestor != null) {
            boolean isDescendant;

            if (ancestor.isParentOf(this)) {
                isDescendant = true;
            } else {
                if (this.getParent() != null) {
                    isDescendant = this.getParent().isDescendantOf(ancestor);
                } else {
                    isDescendant = false;
                }
            }

            return isDescendant;
        }
        else {
            throw new IllegalArgumentException();
        }
    }


    /**
     * Returns a new iterator that uses in-order traversal.
     *
     * @return a new iterator that uses in-order traversal
     */
    public Iterator<E> iterator() {
        return inOrderIterator();
    }


    /**
     * Returns a new iterator that uses pre-order traversal.
     *
     * @return a new iterator that uses pre-order traversal
     */
    public Iterator<E> preOrderIterator() {
        return new PreOrderIterator(this);
    }


    /**
     * Returns a new iterator that uses in-order traversal.
     *
     * @return a new iterator that uses in-order traversal
     */
    public Iterator<E> inOrderIterator() {
        return new InOrderIterator(this);
    }


    /**
     * Returns a new iterator that uses post-order traversal.
     *
     * @return a new iterator that uses post-order traversal
     */
    public Iterator<E> postOrderIterator() {
        return new PostOrderIterator(this);
    }


    /**
     * Returns a new iterator that uses level-order traversal.
     *
     * @return a new iterator that uses level-order traversal
     */
    public Iterator<E> levelOrderIterator() {
        return new LevelOrderIterator(this);
    }


    /**
     * Returns a string containing the toString return value of each node's element value in the
     * tree.
     *
     * Returns strings as visited by an in-order transversal of the tree, joined by comma-space,
     * e.g. "A, D, B, E, C".
     *
     * @return a string containing the toString return value of each node's element value in the
     * tree
     */
    public String toString() {
        StringBuilder outputStringBuilder = new StringBuilder();

        for (E element : this) {
            // TODO build string
            outputStringBuilder.append(element);
            outputStringBuilder.append(", ");
        }

        String outputString = outputStringBuilder.toString();
        return outputString;
    }


    /**
     * An iterator that uses pre-order traversal to traverse a binary tree.
     */
    private class PreOrderIterator<E> implements Iterator<E> {
        // visit self
        // visit left child
        // visit right child

        private Queue<E> _queue; // initialize this as a LinkedList
        Iterator<E> _queueIter;

        /**
         * Constructs a new PreOrderIterator.
         *
         * @param tree the tree to iterate over
         */
        public PreOrderIterator(BinaryTree<E> tree) {
            _queue = new LinkedList<E>();
            this.preOrder(tree);
            _queueIter = _queue.iterator();
        }


        /**
         * Populates a queue with the elements of the tree in the correct order.
         *
         * A private recursive helper method.
         *
         * @param tree the tree to iterate over
         * @return
         */
        private void preOrder(BinaryTree<E> tree) {
            // visit self
            _queue.add(tree.getElement());
            // visit left child
            if (tree.hasLeftChild()) {
                preOrder(tree.getLeftChild());
            }
            // visit right child
            if (tree.hasRightChild()) {
                preOrder(tree.getRightChild());
            }
        }


        /**
         * Returns true if there is another element in this iteration.
         *
         * @return true if there is another element in this iteration
         */
        public boolean hasNext() {
            return _queueIter.hasNext();
        }


        /**
         * Returns the next element in this iteration.
         *
         * @return the next element in this iteration
         * @throws NoSuchElementException if there are no more elements in the iteration
         */
        public E next() {
            if (hasNext()) {
                return _queueIter.next();
            }
            else {
                throw new NoSuchElementException();
            }
        }
    }


    /**
     * An iterator that uses in-order traversal to traverse a binary tree.
     */
    private class InOrderIterator<E> implements Iterator<E> {
        private Queue<E> _queue; // initialize this as a LinkedList
        Iterator<E> _queueIter;

        /**
         * Constructs a new InOrderIterator.
         *
         * @param tree the tree to iterate over
         */
        public InOrderIterator(BinaryTree<E> tree) {
            _queue = new LinkedList<E>();
            this.inOrder(tree);
            _queueIter = _queue.iterator();
        }


        /**
         * Populates a queue with the elements of the tree in the correct order.
         *
         * A private recursive helper method.
         *
         * @param tree the tree to iterate over
         * @return
         */
        private void inOrder(BinaryTree<E> tree) {
            // visit left child
            if (tree.hasLeftChild()) {
                inOrder(tree.getLeftChild());
            }
            // visit self
            _queue.add(tree.getElement());
            // visit right child
            if (tree.hasRightChild()) {
                inOrder(tree.getRightChild());
            }
        }


        /**
         * Returns true if there is another element in this iteration.
         *
         * @return true if there is another element in this iteration
         */
        public boolean hasNext() {
            return _queueIter.hasNext();
        }


        /**
         * Returns the next element in this iteration.
         *
         * @return the next element in this iteration
         * @throws NoSuchElementException if there are no more elements in the iteration
         */
        public E next() {
            if (hasNext()) {
                return _queueIter.next();
            }
            else {
                throw new NoSuchElementException();
            }
        }
    }


    /**
     * An iterator that uses post-order traversal to traverse a binary tree.
     */
    private class PostOrderIterator<E> implements Iterator<E> {
        // visit left child's subtree
        // visit right child's subtree
        // visit self
        private Queue<E> _queue; // initialize this as a LinkedList
        Iterator<E> _queueIter;

        /**
         * Constructs a new PreOrderIterator.
         *
         * @param tree the tree to iterate over
         */
        public PostOrderIterator(BinaryTree<E> tree) {
            _queue = new LinkedList<E>();
            this.postOrder(tree);
            _queueIter = _queue.iterator();
        }


        /**
         * Populates a queue with the elements of the tree in the correct order.
         *
         * A private recursive helper method.
         *
         * @param tree the tree to iterate over
         * @return
         */
        private void postOrder(BinaryTree<E> tree) {
            // visit left child
            if (tree.hasLeftChild()) {
                postOrder(tree.getLeftChild());
            }
            // visit right child
            if (tree.hasRightChild()) {
                postOrder(tree.getRightChild());
            }
            // visit self
            _queue.add(tree.getElement());
        }


        /**
         * Returns true if there is another element in this iteration.
         *
         * @return true if there is another element in this iteration
         */
        public boolean hasNext() {
            return _queueIter.hasNext();
        }


        /**
         * Returns the next element in this iteration.
         *
         * @return the next element in this iteration
         * @throws NoSuchElementException if there are no more elements in the iteration
         */
        public E next() {
            if (hasNext()) {
                return _queueIter.next();
            }
            else {
                throw new NoSuchElementException();
            }
        }
    }


    /**
     * An iterator that uses level-order traversal to traverse a binary tree.
     */
    private class LevelOrderIterator<E> implements Iterator<E> {
        private Queue<E> _queue; // initialize this as a LinkedList
        Iterator<E> _queueIter;

        /**
         * Constructs a new LevelOrderIterator.
         *
         * @param tree the tree to iterate over
         */
        public LevelOrderIterator(BinaryTree<E> tree) {
            _queue = new LinkedList<E>();
            this.levelOrder(tree);
            _queueIter = _queue.iterator();
        }


        /**
         * Populates a queue with the elements of the tree in the correct order.
         *
         * A private recursive helper method.
         *
         * @param tree the tree to iterate over
         * @return
         */
        private void levelOrder(BinaryTree<E> tree) {
            BinaryTree<E> tempQueue;
            Queue<BinaryTree<E>> queue = new LinkedList<BinaryTree<E>>();
            Queue<E> outputQueue = new LinkedList<E>();

            queue.add(tree.getRoot());

            while (! queue.isEmpty()) {
                tempQueue = queue.remove();
                if (tempQueue.hasLeftChild()) {
                    queue.add(tempQueue.getLeftChild());
                }
                if (tempQueue.hasRightChild()) {
                    queue.add(tempQueue.getRightChild());
                }
                outputQueue.add(tempQueue.getElement());
            }
        }


        /**
         * Returns true if there is another element in this iteration.
         *
         * @return true if there is another element in this iteration
         */
        public boolean hasNext() {
            return _queueIter.hasNext();
        }


        /**
         * Returns the next element in this iteration.
         *
         * @return the next element in this iteration
         * @throws NoSuchElementException if there are no more elements in the iteration
         */
        public E next() {
            if (hasNext()) {
                return _queueIter.next();
            }
            else {
                throw new NoSuchElementException();
            }
        }
    }


    /**
     * Sets the parent of this subtree to a new parent.
     *
     * @param parent the new parent of this subtree
     */
    private void setParent(BinaryTree<E> parent) {
        _parent = parent;
    }


    /**
     * Returns true if this tree is the left child of the given tree.
     *
     * @param parent the given tree
     * @return true if this tree is the left child of the given tree
     */
    private boolean isLeftChildOf(BinaryTree<E> parent) {
        return this == parent.getLeftChild();
    }


    /**
     * Returns true if this tree is the right child of the given tree.
     *
     * @param parent the given tree
     * @return true if this tree is the right child of the given tree
     */
    private boolean isRightChildOf(BinaryTree<E> parent) {
        return this == parent.getRightChild();
    }

}