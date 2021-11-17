/**
 *
 * @param <E>
 *
 * @author ckurdelak20@georgefox.edu
 */
public class BinaryTree<E> {
    // TODO implement class
    private BinaryTree<E> _parent;
    private BinaryTree<E> _leftChild;
    private BinaryTree<E> _rightChild;

    /**
     *
     * @param element
     */
    public BinaryTree(E element) {

    }


    /**
     *
     * @return
     */
    public E getElement() {

    }


    /**
     *
     * @param element
     */
    public setElement(E element) {

    }


    /**
     *
     * @return
     */
    public boolean hasLeftChild() {

    }
    // _leftChild != null


    /**
     *
     * @return
     */
    public BinaryTree<E> getLeftChild() {

    }


    /**
     *
     * @param child
     * @return
     */
    public BinaryTree<E> setLeftChild(BinaryTree<E> child) {
        // cut off current left child
        // return old left child
        // attach new left child
        // _leftChild of this node is new child
        // _parent of new child is this node
    }


    /**
     *
     * @return
     */
    public boolean hasRightChild() {

    }


    /**
     *
     * @return
     */
    public BinaryTree<E> getRightChild() {

    }


    /**
     *
     * @param child
     * @return
     */
    public BinaryTree<E> setRightChild(BinaryTree<E> child) {
        // cut off current right child
        // return old right child
        // attach new right child
        // _rightChild of this node is new child
        // _parent of new child is this node
    }


    /**
     * Returns the root of this tree.
     *
     * @return the root of this tree
     */
    public BinaryTree<E> getRoot() {
        //{entire tree}
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
    }


    /**
     * Returns this subtree's size.
     *
     * @return this subtree's size
     */
    public int height() {
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
        //{entire tree}
        // level of parent + 1
    }


    /**
     *
     * @return
     */
    public int degree() {
        // degree of node is count of its children
        // either 0, 1, or 2
    }


    /**
     *
     * @return
     */
    public boolean isRoot()
    {
        //{entire tree}
        // return parent == null
    }


    /**
     *
     * @return
     */
    public boolean isParent() {
        // have left or right child?
        return (hasLeftChild() || hasRightChild());
    }


    /**
     *
     * @return
     */
    public boolean isChild() {
        // have parent?
    }


    /**
     *
     * @return
     */
    public boolean isLeaf() {
        // have no cjildren? degree == 0?
        return this.degree() == 0;
    }


    /**
     * Returns true if the subtree rooted at this node is full.
     *
     * @return true if the subtree rooted at this node is full
     */
    public boolean isFull() {
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
        // degenerates into a linked list / linear structure
        // no branches
        // a 1-ary binary tree is termed degenerate
        // max degree of any of the tree's nodes is 1
        // (none of the nodes has more than one child)
        // degree/arity of a tree is the max degree of any of its nodes
        // the degree of a node is the number of its children (0, 1, or 2)

        // if child node is degenerate, then parent node is degenerate
    }


    /**
     *
     * @param descendant
     * @return
     */
    public boolean isAncestorOf(BinaryTree<E> descendant) {

    }


    /**
     *
     * @param child
     * @return
     */
    public boolean isParentOf(BinaryTree<E> child) {

        return this.getLeftChild() == child || this.getRightChild() == child;
    }


    /**
     *
     * @param sibling
     * @return
     */
    public boolean isSiblingOf(BinaryTree<E> sibling) {
        // have same parent?
        return this.getParent() == sibling.getParent();
    }


    /**
     *
     * @param parent
     * @return
     */
    public boolean isChildOf(BinaryTree<E> parent) {

    }


    /**
     *
     * @param ancestor
     * @return
     */
    public boolean isDescendantOf(BinaryTree<E> ancestor) {

    }


    /**
     *
     * @return
     */
    public Iterator<E> iterator() {

    }


    /**
     *
     * @return
     */
    public Iterator<E> preOrderIterator() {

    }


    /**
     *
     * @return
     */
    public Iterator<E> inOrderIterator() {

    }


    /**
     *
     * @return
     */
    public Iterator<E> postOrderIterator() {

    }


    /**
     *
     * @return
     */
    public Iterator<E> levelOrderIterator() {

    }


    /**
     *
     * @return
     */
    public String toString() {

    }
}

