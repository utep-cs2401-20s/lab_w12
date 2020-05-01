import static org.junit.jupiter.api.Assertions.*;

class myBinarySearchTreeNodeTester {
    myBinarySearchTreeNode test;

    /**
     * NOTE: This test should be the first test to run as it tests the first constructor.
     * Tests the default constructor. If this constructor does not work, the tree cannot be made.
     * This case will test the creation of single nodes in the tree.
     *
     * Inputs:
     *  - create a new node with a positive integer root value (10)
     *
     * Expected output:
     *  - a new node will be created that has a myValue of 10
     *  - there is no left and no right right child for this new node
     */
    @org.junit.jupiter.api.Test
    void constructor() {
        test = new myBinarySearchTreeNode(10);
        assertEquals(test.myValue,10);
        assertNull(test.left);
        assertNull(test.right);
    }

    /**
     * NOTE: This test uses on the second constructor.
     * Tests the insert method's behavior on the following:
     *  - values to insert that are LESS THAN the root will be placed in the left
     *  - values to insert that are GREATER THAN the root will be placed in the right
     *  - values to insert that are EQUAL TO the root will not be placed
     * This case will test the design of the tree is to our description.
     *
     * Inputs:
     *  - a new tree made with a negative root value (-50)
     *  - insert a duplicate value: -50
     *  - insert a value less than root: -100
     *  - insert a value greater than root: 0
     *  - insert a value less than the root's left: -1000
     *  - insert a value greater than the root's right: 1000
     *
     * Expected output:
     *  - a new node will be created that has a myValue of -50
     *  - it's left child will have a myValue of -100
     *  - it's right child will have a myValue of 0
     *  - there are no children for the root's left child and for the root's right child
     *  - a message to the user that the duplicated element could not be inserted
     */
    @org.junit.jupiter.api.Test
    void insert() {
        int[] val = new int[]{-50,-50,-100,0,-1000,1000};
        test = new myBinarySearchTreeNode(val);
        assertEquals(val[0],test.myValue);
        assertEquals(val[2],test.left.myValue);
        assertEquals(val[3],test.right.myValue);
        //no 3rd level of nodes
        assertEquals(val[4],test.left.left.myValue);
        assertNull(test.left.right);
        assertNull(test.right.left);
        assertEquals(val[5],test.right.right.myValue);
    }

    /**
     * Tests if the height() method counts the height of trees correctly.
     * This case tests if the height is calculated correctly for balanced and unbalanced trees.
     *
     * Inputs:
     *  - a tree of 1 node, values: Integer.MAX_VALUE
     *  - a tree of 5 nodes, values: 5,4,3,2,1 (where the tree grows to the left)
     *  - a tree of 5 nodes, values: 1,2,3,4,5 (where the tree grows to the right)
     *  - a tree of 7 nodes, values: 8,4,3,5,10,9,11 (where the tree is balanced)
     *
     * Expected Output:
     *  - a tree of 1 node has height 0
     *  - a tree of 5 nodes, growing left, has height 4
     *  - a tree of 5 nodes, growing right, has height 4
     *  - a tree of 7 nodes, balanced, has height 2
     */
    @org.junit.jupiter.api.Test
    void height() {
        //tree with only the root
        test = new myBinarySearchTreeNode(Integer.MAX_VALUE);
        assertEquals(0,test.height());
        //unbalanced tree: left
        test = new myBinarySearchTreeNode(new int[]{5,4,3,2,1});
        assertEquals(4,test.height());
        //unbalanced tree: right
        test = new myBinarySearchTreeNode(new int[]{1,2,3,4,5});
        assertEquals(4,test.height());
        //balanced tree
        test = new myBinarySearchTreeNode(new int[]{8,4,3,5,10,9,11});
        assertEquals(2,test.height());
    }

    /**
     * Tests if the depth() method counts the depth to a node correctly.
     * This case tests if the height is calculated correctly for balanced and unbalanced trees.
     *
     * Inputs:
     *  - a tree of 7 nodes, values: 8,4,3,5,10,9,11 (where the tree is balanced)
     *
     * Expected Output:
     *  - the depth of node whose value is 10 is 1
     *  - the depth of node whose value is 8 is 0 (the root)
     *  - the depth of a node whose value is not in the tree (Integer.MIN_VALUE)
     */
    @org.junit.jupiter.api.Test
    void depth() {
        test = new myBinarySearchTreeNode(new int[]{8,4,3,5,10,9,11});
        assertEquals(1,test.depth(10));
        assertEquals(0,test.depth(8));
        assertEquals(-1,test.depth(Integer.MIN_VALUE));
    }
}