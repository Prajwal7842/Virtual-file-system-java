// Author: Utkarsh Nigam 11-12-2018
import virtual_file_system.*;
class Nary_Tree
{
   protected class T_Node
   {
      File_d data;
      T_Node left_child;
      T_Node right_sibling;
   }
   T_Node nary_getT_node(File_d fd)
   {
      T_Node temp = new T_Node();
      temp.data = new File_d();
      temp.data.file_size = fd.file_size;
      temp.data.file_name = fd.file_name;
      temp.data.file_path = fd.file_path;
      temp.data.file_type = fd.file_type;
      return temp;
   }
   T_Node nary_copyT_node(T_Node node)
   {
      T_Node temp = new T_Node();
      temp_data = new File_d();
      temp.data.file_size = node.data.file_size;
      temp.data.file_name = node.data.file_name;
      temp.data.file_path = node.data.file_path;
      return temp;
   }
   T_Node nary_root_init()
   {
      T_Node root = new T_node();
      root.data = new File_d();
      root.data.file_path = "/";
      root.data.file_name = "/";
      root.data.file_type = "dir";
      root.left_child = null;
      root.right_sibling = null;
      return root;
   }
   int nary_findsibling(T_Node root, String d, T_Node resultnode)
   {
      if(root.right_sibling == null)
        return Error.NOTFOUND; 
      T_Node node = root;
      while(node.right_sibling!=null)
      {
        if(d.equals(node.right_sibling.data.file_name)&&"dir".equals(node.right_sibling.data.file_type))
        {
	  resultnode = node.right_sibling;
	  return Error.FOUND; 
	}
	node = node.right_sibling;
      }
      return Error.NOTFOUND; 
   }
   int nary_insert_node_final(T_Node root, File_d d, int token_index)
   {


