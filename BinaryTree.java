/**
 *
 * @param <E>
 *
 * @author ckurdelak20@georgefox.edu
 */
public class BinaryTree<E> {
    // TODO implement class

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

    }


    /**
     *
     * @return
     */
    public BinaryTree<E> getRoot() {
        //{entire tree}
    }


    /**
     *
     * @return
     */
    public BinaryTree<E> getParent() {

    }


    /**
     *
     * @return
     */
    public int size() {
        // reurn size of left child + size of right child + 1
    }


    /**
     *
     * @return
     */
    public int height() {

    }


    /**
     *
     * @return
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
        // have no cjildren?
    }


    /**
     *
     * @return
     */
    public boolean isFull() {

    }


    /**
     *
     * @return
     */
    public boolean isComplete() {

    }


    /**
     *
     * @return
     */
    public boolean isDegenerate() {

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

    }


    /**
     *
     * @param sibling
     * @return
     */
    public boolean isSiblingOf(BinaryTree<E> sibling) {
        // have same parent?
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

