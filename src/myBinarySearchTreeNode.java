class myBinarySearchTreeNode{
  int myValue;
  myBinarySearchTreeNode left;
  myBinarySearchTreeNode right;

  /**
   * Creates a new node with empty child pointers
   * @param inValue the value of this node
   */
  myBinarySearchTreeNode(int inValue) {
    myValue = inValue;
  }

  /**
   * Creates a new Binary Search Tree rooted at the first value in the array
   * by inserting elements into the tree in the order they are given in A.
   * @param A the list of elements to insert into the BST
   */
  myBinarySearchTreeNode(int[] A) {
    if ( A.length==0 ) return;
    myValue = A[0];
    for ( int i=1 ; i<A.length ; i++ )
      insert(A[i]);
  }

  /**
   * This method takes a new integer as input and decides if it should be placed:
   *  - as the left child,
   *  - as the right child,
   *  - in the left subtree,
   *  - or in the right subtree.
   * If the value already exists in the tree, no action is taken.
   * @param inValue the value to (potentially) add to the tree
   */
  public void insert(int inValue) {
    //if inValue is already in the tree, do not insert duplicates
    if ( myValue==inValue ) {
      System.out.println("Tree did not insert duplicate value: " + inValue);
      return;
    }
    //if inValue is less than this node, it goes to the left subtree OR make it the left child
    if ( inValue<myValue )
      if ( left==null ) left = new myBinarySearchTreeNode(inValue);
      else left.insert(inValue);
    else
      //if inValue is greater than this node, it goes to the right subtree OR make it the right child
      if ( right==null ) right = new myBinarySearchTreeNode(inValue);
      else right.insert(inValue);
  }

  /**
   * This method recursively calculates the height of the entire (sub)tree.
   * This method will take O(n) time
   * @return the max height of the tree
   */
  public int height() {
    int L = 0, R = 0;
    //check the left subtree, if it exists
    if ( left!=null )
      L = left.height() + 1;
    //check the right subtree, if it exists
    if ( right!=null )
      R = right.height() + 1;
    //return the largest subtree's height + this height
    return Math.max(L,R);
  }

  /**
   * This method recursively calculates the depth of a given search value.
   * If the given value is not in the tree, this method returns -1.
   * Note that if the tree is a proper BST, this method should complete in O(log n) time.
   * Additionally, remember that the depth is the number of nodes on the path from a node to the root
   *  (i.e. the number of the recursie calls).
   * @param search the key to search for in the tree
   * @return the depth of the node containing search, -1 if not found
   */
  public int depth(int search) {
    //we found search at this node, so return 0
    if ( search==myValue )
      return 0;
    int L = 0, R = 0;
    //check the left subtree, if search key is supposed to be there
    if ( search<myValue && left!=null )
      L = left.depth(search) + 1; //add 1 because we traveled there!
    //check the right subtree, if the search key is supposed to be there
    if ( search>myValue && right!=null )
      R = right.depth(search) + 1; //add 1 because we traveled there!
    //the search value cannot be found in this tree
    if ( L==0 && R==0 )
      return -1;
    //return the depth we found the value in the tree
    return Math.max(L,R);
  }

  /**
   * Utility function included so you can debug your solution.
   */
  public void print() { print(""); }

  /**
   * Helper method to print() function.
   */
  private void print(String prefix) {
    System.out.println(prefix + myValue);
    prefix = prefix.replace('\u251C', '\u2502');
    prefix = prefix.replace('\u2514', ' ');
    if(left != null) left.print(prefix + "\u251C ");
    if(right != null) right.print(prefix + "\u2514 ");
  }
} 
