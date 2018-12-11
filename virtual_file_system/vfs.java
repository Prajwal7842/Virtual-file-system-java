package virtual_file_system;
class File_d
{
  public String file_name;
  public String file_path;
  public String file_type;
  public long file_block_no;
  public long file_size, start_addr;
}
public class vfs
{
  public String vfs_label;
  public long vfs_size;
  public long no_of_blocks;
  public long block_size;
  public long max_num_f_d;
  public long num_f_d_used;
  public long datablkPoint;
  public long freelistPoint;
  public long file_d_arrayPoint;
}
class Free_list
{
  public long block_num;
  public char isFull; //y=full n=not full
}
class Data_block
{
  public String data;
  public long next;
  public long block_num;
}
/* 
String getFileType(String);
File_d prepareFileDescriptor(String path, String filename, String filetype);
*/

