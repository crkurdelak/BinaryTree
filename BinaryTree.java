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
        // TODO find out if this is all the internal state needeed
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
     */
    public BinaryTree<E> setLeftChild(BinaryTree<E> child) {
        // TODO are we thinking about this the right way?
        // TODO keep it from setting weird stuff

        BinaryTree<E> oldChild = getLeftChild();
        // cut off current left child
        _leftChild = null;
        if (child.isChild()) {
            BinaryTree<E> oldParent = child.getParent();
            if (this.isLeftChildOf(oldParent)) {
                oldParent._leftChild = null;
            }
            else {
                oldParent._rightChild = null;
            }
        }
        // attach new left child
        _leftChild = child;
        // _leftChild of this node is new child
        // _parent of new child is this node

        child.setParent(this);

        // return old left child
        return oldChild;
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
     */
    public BinaryTree<E> setRightChild(BinaryTree<E> child) {
        // TODO implement setRightChild
        // TODO stop it from setting weird stuff

        // copy from setLeftChild and change what needs to be changed

        // cut off current right child
        // return old right child
        BinaryTree<E> oldChild = getRightChild();
        // attach new right child
        _rightChild = child;
        // _rightChild of this node is new child
        // _parent of new child is this node
        child.setParent(this);

        return oldChild;
    }


    /**
     * Returns the root of this entire tree.
     *
     * @return the root of this entire tree
     */
    public BinaryTree<E> getRoot() {
        //{entire tree}
        // TODO implement getRoot
        // where do we start on the tree in order to find the root?
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
        // TODO are we thinking about this the right way?

        // height of a tree is the max level of any of its subtrees/nodes
        // how many edges from root of this tree to its lowest leaf
        // level of lowest leaf

        // max of height of left child and height of right child, + 1
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
        // TODO implement level
        // how do we find the level, and where on the tree do we start?

        // level = length of path from this node to root of entire tree

        //{entire tree}
        // level of parent + 1
        // recursive
    }


    /**
     * Returns the degree of this subtree.
     *
     * @return the degree of this subtree
     */
    public int degree() {
        // degree of node is count of its children
        // either 0, 1, or 2
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
        // have left or right child?
        return (hasLeftChild() || hasRightChild());
    }


    /**
     * Returns true if this subtree is a child.
     *
     * @return true if this subtree is a child
     */
    public boolean isChild() {
        // have parent?
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
     * @return true if the subtree rooted at this node is full
     */
    public boolean isFull() {
        // TODO implement isFull
        // which algorithm do we use? where on the tree do we start?

        // full tree only has leaves on level h, h = height, and every non-leaf node has 2 children
        // full tree has 2^h leaves on level h, h being the height O(n)
        // alternative:
        // full tree has 2^(level number) nodes on each level
        // if size == sum from 0 to h of 2^l, l = level, h = height, then tree is full
    }


    /**
     * Returns true if the subtree rooted at this node is complete.
     *
     * @return true if the subtree rooted at this node is complete
     */
    public boolean isComplete() {
        // TODO implement isComplete
        // can we use this method in isFull or use isFull in this method?
        // where on the tree do we start?

        // a complete binary tree of height h is an otherwise full binary tree with 0 or more
        // of the rightmost leaves on level h removed
        // full trees are also complete
    }


    /**
     * Returns true if the subtree rooted at this node is degenerate.
     *
     * @return true if the subtree rooted at this node is degenerate
     */
    public boolean isDegenerate() {
        // TODO are we thinking about this the right way?

        // degenerates into a linked list / linear structure
        // no branches
        // a binary tree with max arity of 1 is termed degenerate
        // max degree of any of the tree's nodes is 1
        // (none of the nodes has more than one child)
        // degree/arity of a tree is the max degree of any of its nodes
        // the degree of a node is the number of its children (0, 1, or 2)

        // if child node is degenerate, then parent node is degenerate
        // a tree of only one node is degenerate

        // a size n tree with a height of n-1 is degenerate
        return this.height() == this.size() - 1;
    }


    /**
     * Returns true if this tree is an ancestor of the given subtree.
     *
     * @param descendant the subtree TODO describe this better
     * @return true if this tree is an ancestor of the given subtree
     */
    public boolean isAncestorOf(BinaryTree<E> descendant) {
        // TODO implement isAncestorOf
        // where on the tree do we start and how do we travel through the tree?
    }


    /**
     * Returns true if this tree is the parent of the given subtree.
     *
     * @param child the subtree TODO describe better
     * @return true if this tree is the parent of the given subtree
     */
    public boolean isParentOf(BinaryTree<E> child) {
        return this.getLeftChild() == child || this.getRightChild() == child;
    }


    /**
     * Returns true if this tree is the sibling of the given tree.
     *
     * @param sibling the tree TODO describe better
     * @return true if this tree is the sibling of the given tree
     */
    public boolean isSiblingOf(BinaryTree<E> sibling) {
        // have same parent?
        return this.getParent() == sibling.getParent();
    }


    /**
     * Returns true if this tree is the child of the given tree.
     *
     * @param parent the tree TODO describe better
     * @return true if this tree is the child of the given tree
     */
    public boolean isChildOf(BinaryTree<E> parent) {
        return this.getParent() == parent;
    }


    /**
     * Returns true if this tree is a descendant of the given tree.
     *
     * @param ancestor the tree TODO describe better
     * @return true if this tree is a descendant of the given tree
     */
    public boolean isDescendantOf(BinaryTree<E> ancestor) {
        // TODO implement isDescendantOf
        // where on the tree do we start and how do we travel through the tree?
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
        // TODO implement levelOrderIterator
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
        // TODO implement toString
        // use the in-order iterator, and on each iteration, add the value to the string
        // delimit values with commas and spaces
        // StringBuilder?

        /*
        The toString method  should  return  a  string  containing  the toString return  value  of
        each  node’s element value in the tree, as visited by an in-order traversal of the tree,
        joined by comma-space, e. g.,"A, D, B, E, C".  It is permissible to also include a [ prefix
        and ] suffix, if and only if you are using a utility toString method to generate the
        string.
         */
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
        // TODO implement LevelOrderIterator

        // very different from other traversals

        // visit nodes from level 0 to level h,
        // from left to right within a level

        // stack or *queue* to store children to visit later
        // check Bailey book for more on algorithms
    }


    /**
     * Sets the parent of this subtree to a new parent.
     *
     * @param parent the new parent of this subtree
     */
    private void setParent(BinaryTree<E> parent) {
        // TODO implement setParent
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