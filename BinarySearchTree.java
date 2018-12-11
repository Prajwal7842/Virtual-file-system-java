import virtual_file_system.*;
public class BinarySearchTree
{
  final static int BST_SUCCESSFUL_INSERTION = 0;
  final static int BST_DUPLICATE_INSERTION = 1;
  final static int BST_SUCCESSFUL_DELETION = 0;
  final static int BST_UNSUCCESSFULL_DELETION = 1;
  static int size = 0;
  protected class Node
  {
     File_d data;
     Node left;
     Node right;
  }
  /*---------Inserts a node in the binary search tree---------*/
  int bst_insert(Node node, File_d key)
  {
     int status;
     if(node == null)
     {
        node = new Node();
        if(node==null)
	{
	// System.out.println("Out of space!!");
	}
	else
	{
	   node.data = initialise_f_d(node.data);
	   node.data.file_path = key.file_path;
	   node.data.file_block_no = key.file_block_no;
	   node.data.file_name = key_file_name;
	   node.data.file_size = key.file_size;
	   node.data.start_addr = key.start_addr;
	   node.data.file_type = key.file_type;
	   node.left=node.right=null;
	}
	return BST_SUCCESSFUL_INSERTION;
     }
     else
     {
        String a;
	a = node.data.file_path;
	if(a.compareTo(key.file_path)>0)
	  status = bst_insert(node.left,key);
	else if(a.compareTo(key.file_path)<0)
	  status = bst_insert(node.right,key);
	else
	   return BST_DUPLICATE_INSERTION;
     }
     return status;
   }
   /*------ Prints inorder traversal of the binary search tree--------*/
   void inorder(Node node)
   {
      if(node == null && size==0)
      {
         System.out.println("\ntree is empty);
	 size++;
      }
      if(node!= null)
      {
        size++;
	inorder(node.left);
	System.out.println(node.data.file_path + "\t");
	inorder(node.right);
      }
   }
   /*-------Finds a minimum node in the right subtree of the specified node-------*/
   Node bst_findMin(Node node)
   {
      if(node==null)
        return null;
      else if(node.left==null)
        return node;
      else
        return bst_findMin(node.left);
   }
   /*------Deletes a node from the binary search tree-------*/
   int bst_delete(Node node, File_d key)
   {
       Node temp_node = new Node();
       int st= 0;
       if(node == null)
         return BST_UNSCUCCESSFULL_DELETION;
       else if(key.file_path.compareTo(node.data.file_path)>0)
       {
         //Go Left
	 st = bst_delete(node.left,key);
       }
       else if(key.file_path.compareTo(node.data.file_path)<0)
       {
         //Go Right
	 st = bst_delete(node.right,key);
       }
       //if element to be deleted is found
       else if (node.left!=null&&node.right!=null)
       {
          temp_node = bst_findMin(node.right);
	  node.data.file_path = temp_node.data.file_path;
	  st = bst_delete(node.right,temp_node.data);
       }
       else
       {
          temp_node = node;
	  if(node.left==null)
	     node = node.right;
	  else if(node.right == null)
	     node = node.left;
	     // some problem
	  return BST_SUCCESSFULL_DELETION;
       }
       return st;
    }
    /*-------Searches the specified node in the binary search tree and returns the nod    e if found------*/
    Node bst_find(Node node, String absolute_path)
    {
       if(node==null)
          return null;
       else if(absolute_path.compareTo(node.data.file_path)>0)
          return bst_find(node.left,absolute_path);
       else if(absolute_path.compareTo(node.data.file_path)<0)
          return bst_find(node.right,absoulute_path);
       else
          return node;
    }
    /*-------initialize f_d---------*/
    File_d initialise_f_d(File_d fd)
    {
       //fd.file_id=-1;
       fd.file_name = new String();
       fd.file_path = new String();
       fd.file_size = fd.file_block_no = -1;
       return fd;
    }
}    
