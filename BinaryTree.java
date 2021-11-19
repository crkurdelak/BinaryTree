import java.util.Iterator;

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

    // TODO make 4 different inner iterator classes

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
        // TODO find out if this is right
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
        // TODO find out if this is right
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
        // TODO implement setLeftChild
        // cut off current left child
        // return old left child
        // attach new left child
        // _leftChild of this node is new child
        // _parent of new child is this node
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
        // cut off current right child
        // return old right child
        // attach new right child
        // _rightChild of this node is new child
        // _parent of new child is this node
    }


    /**
     * Returns the root of this entire tree.
     *
     * @return the root of this entire tree
     */
    public BinaryTree<E> getRoot() {
        //{entire tree}
        // TODO implement getRoot
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
        // return size of left child + size of right child + 1
        // TODO base case
        return _leftChild.size() + _rightChild.size() + 1;
    }


    /**
     * Returns this subtree's size.
     *
     * @return this subtree's size
     */
    public int height() {
        // TODO implement height
        // height of a tree is the max level of any of its subtrees/nodes
        // how many edges from root of this tree to its lowest leaf
        // level of lowest leaf

        // max of height of left child and height of right child, + 1
    }


    /**
     * Returns the level of this tree.
     *
     * @return the level of this tree
     */
    public int level() {
        // TODO implement level
        //{entire tree}
        // level of parent + 1
    }


    /**
     * Returns the degree of this subtree.
     *
     * @return the degree of this subtree
     */
    public int degree() {
        // TODO implement degree
        // degree of node is count of its children
        // either 0, 1, or 2
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
        // TODO see if this is the best way to do it
        return this.degree() == 0;
    }


    /**
     * Returns true if the subtree rooted at this node is full.
     *
     * @return true if the subtree rooted at this node is full
     */
    public boolean isFull() {
        // TODO implement isFull
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
        // TODO implement isDegenerate
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
    }


    /**
     * Returns true if this tree is an ancestor of the given subtree.
     *
     * @param descendant the subtree TODO describe this better
     * @return true if this tree is an ancestor of the given subtree
     */
    public boolean isAncestorOf(BinaryTree<E> descendant) {
        // TODO implement isAncestorOf
    }


    /**
     * Returns true if this tree is the parent of the given subtree.
     *
     * @param child TODO describe
     * @return true if this tree is the parent of the given subtree
     */
    public boolean isParentOf(BinaryTree<E> child) {
        return this.getLeftChild() == child || this.getRightChild() == child;
    }


    /**
     * Returns true if this tree is the sibling of the given tree.
     *
     * @param sibling TODO describe
     * @return true if this tree is the sibling of the given tree
     */
    public boolean isSiblingOf(BinaryTree<E> sibling) {
        // have same parent?
        return this.getParent() == sibling.getParent();
    }


    /**
     * Returns true if this tree is the child of the given tree.
     *
     * @param parent TODO describe
     * @return true if this tree is the child of the given tree
     */
    public boolean isChildOf(BinaryTree<E> parent) {
        return this.getParent() == parent;
    }


    /**
     * Returns true if this tree is a descendant of the given tree.
     *
     * @param ancestor TODO describe
     * @return true if this tree is a descendant of the given tree
     */
    public boolean isDescendantOf(BinaryTree<E> ancestor) {
        // TODO implement isDescendantOf
    }


    /**
     *
     * @return
     */
    public Iterator<E> iterator() {
        // TODO implement Iterator
        return inOrderIterator();
    }


    /**
     *
     * @return
     */
    public Iterator<E> preOrderIterator() {
        // TODO implement preOrderIterator
    }


    /**
     *
     * @return
     */
    public Iterator<E> inOrderIterator() {
        // TODO implement inOrderIterator
    }


    /**
     *
     * @return
     */
    public Iterator<E> postOrderIterator() {
        // TODO implement postOrderIterator
    }


    /**
     *
     * @return
     */
    public Iterator<E> levelOrderIterator() {
        // TODO implement levelOrderIterator
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

        /*
        The toString method  should  return  a  string  containing  the toString return  value  of
        each  node’s element value in the tree, as visited by an in-order traversal of the tree,
        joined by comma-space, e. g.,"A, D, B, E, C".  It is permissible to also include a [ prefix
        and ] suffix, if and only if you are using a utility toString method to generate the
        string.
         */
    }


    /**
     *
     */
    private class PreOrderIterator<E> implements Iterator<E> {
        // TODO implement PreOrderIterator

        // recursive

        // visit self
        // visit left child
        // visit right child

        // can start at any node and iterate over its subtree

        // self first
        // left child's subtree in pre-order second (recursive)
        // right child's subtree in pre-order third (recursive)
    }


    /**
     *
     */
    private class InOrderIterator<E> implements Iterator<E> {
        // TODO implement InOrderIterator

        private Queue<E> _queue; // initialize this as a LinkedList

        // ctor:
        // inOrder() (private helper that enqueues stuff according to algorithm rules)

        // inOrder {
        //  inOrder(leftChild)
        //  inOrder(rightChild)
        // }

        // next() just goes thru queue

        // recursive private helper method

        // recursive

        // visit left child's subtree
        // visit self
        // visit right child's subtree
    }


    /**
     *
     */
    private class PostOrderIterator<E> implements Iterator<E> {
        // TODO implement PostOrderIterator

        // recursive

        // visit left child's subtree
        // visit right child's subtree
        // visit self
    }


    /**
     *
     */
    private class LevelOrderIterator<E> implements Iterator<E> {
        // TODO implement LevelOrderIterator

        // very different from other traversals

        // visit nodes from level 0 to level h,
        // from left to right within a level

        // stack or *queue* to store children to visit later
        // check Bailey book for more on algorithms
    }

}