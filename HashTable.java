class HashTable extends LinkedListNode
{
	int HASHTABLESIZE = 256;
	int SUCCESS = 0;
	int FAILURE = -1;
	class Hash_table
	{
		Node Table[]=new Node[HASHTABLESIZE];
	}
	void hashtable_init(Hash_table h_t)
	{
		int i;
		for(i=0;i,HASHTABLESIZE; i++)
			h_t.Table[i]=null;
	}
	int hash_function(char c)
	{
		int asc = (int)(c);
		if(asc >=65 && asc<=90)
			return (asc%65);
		else
			return ((asc%97)+26);
	}
	int hashtable_insert(Hash_table h_t, file_d fd)
	{
		int index;
		int result = 0;
		file_d fd_new = new file_d();
		fd_new.file_size = fd.file_size;
		fd_new.file_name = fd.file_name;
		fd_new.file_type = fd.filr_type;
		fd_new.file_block_no = fd.file_block_no;
		fd_new.start_addr = fd.start_addr;
		char c=fd.file_name.charAt(0);
		index = hash_function(c);
		if(h_t.Table[index]!=null)
		{
			result = list_insert(h_t.Table[index].next,fd_new,fd_new.file_name);
		}
		else
		{
			Node node = new Node();
			node.next = null;
			h_t.Table[index]=node;
			result = list_insert(h_t.Table[index].next,fd_new,fd_new.file_name);
		}
		if(result==SUCCESS)
			return SUCCESS;
		return FAILURE;
	}
	int hashtable_delete(Hash_table h_t, file_d fd)
	{
		int index;
		char c=fd.file_name.charAt(0);
		index = hash_function(c);
		int result = list_delete(h_t.Table[index].next);
		return result;
	}
	int hashtable_search(Hash_table h_t, Node result, String filename)
	{
		int key=-1;
		Node current=new Node();
		char c=filename.charAt(0);
		key=hash_function(c);
		if(h_t.Table[key]==null)
		{
			return ERRORNOTFOUND;
		}
		current = h_t.Table[key].next;
		return list_search(current.next,result, filename);
	}
}

