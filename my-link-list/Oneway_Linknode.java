package algotithm;

/* ----------  单节点类定义 -----------*/
class LinkNode{
	private LinkNode next;
	private int value;
	public LinkNode(){
		next = null;
		value = -1;
	}
	public LinkNode(LinkNode tmpLink){
		next = tmpLink.next;
		value = tmpLink.GetValue();
	}
	public LinkNode(int tmpvalue){
		value = tmpvalue;
		next = null;
	}

	public int GetValue(){
		return value;
	}
	public boolean SetNext(LinkNode tmpLink){
		next = tmpLink;
		return true;
	}
	public void node_display(){
		System.out.println(value);
	}
	public LinkNode GetNext(){
		return next;
	}
}
/* ----------  建立单向链表 -----------*/
class LinkList{
	private int LinkSize;
	private LinkNode headNode;
	private LinkNode currentNode;
	public LinkList(){
		LinkSize = 0;
		headNode = new LinkNode();
		currentNode = new LinkNode();
	}
	public int GetLinkSize(){
		return LinkSize;
	}
	public boolean SetLinkSize(int size){
		if(size<0)
			return false;
		LinkSize = size;
		return true;
	}
	public boolean Insert_Node(int value,int pos){
		if (LinkSize<0){
			System.out.println("empty list");
			return false;
		}
		if (pos>LinkSize||pos<0){/*防止确定的位置过小*/
			System.out.println("Wrong Pos!!!");
			return false;
		}
		LinkNode NewLinkNode = new LinkNode(value);
		
		if (LinkSize==0){//如果放置在头文件的位置
			headNode.SetNext(NewLinkNode);
			NewLinkNode.SetNext(null);
			LinkSize++;

			return true;
		}
		
		currentNode = headNode;//.GetNext();
		
		LinkNode tmpNode = new LinkNode(currentNode);
		
		for (int i=0;i<pos;i++){
			
			//currentNode = currentNode.GetNext();
			//System.out.println(currentNode.GetValue());
			tmpNode = currentNode.GetNext();
			currentNode = tmpNode;
		}
	
		NewLinkNode.SetNext(currentNode.GetNext());
		
		currentNode.SetNext(NewLinkNode);
		
		LinkSize++;
		System.out.println("finsh insert");
		return true;
	}
	public boolean Delete_Node(int pos){
		if (LinkSize<=0){
			System.out.println("empty list");
			return false;
		}
		if (pos>LinkSize||pos<0){
			System.out.println("Wrong Pos!!!");
			return false;
		}
		currentNode = headNode.GetNext();
		for (int i=0;i<pos;i++){
			currentNode = currentNode.GetNext();
		}
		currentNode.SetNext(currentNode.GetNext().GetNext());
		LinkSize--;
		return true;
	}
	public boolean Display_LinkList(){
		if (LinkSize<=0){
			System.out.println("empty list");
			return false;
		}
		//headNode.SetNext(currentNode);
		currentNode = headNode.GetNext();
		LinkNode tmpNode = new LinkNode(currentNode);
		for (int i=0;i<LinkSize;i++){
			System.out.print(currentNode.GetValue());
			System.out.print("\t");
			currentNode = tmpNode.GetNext();
			tmpNode = currentNode;
		}
		return true;
	}
}

public class Oneway_Linknode {

	public static void main(String[] args) {
		
		LinkList myList = new LinkList();
		
		myList.Insert_Node(123, 0);
		
		myList.Insert_Node(456, 0);
		
		myList.Insert_Node(789, 3);
		myList.Display_LinkList();
		return;
	}

}
