package algotithm;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;

/*--------------- 线性表类 -------------*/
class Linear_Array
{
	private int ini_array[];
	private int array_size;
	
	public Linear_Array(){
		ini_array=new int[100];
		array_size=0;//当前数组的大小
	}
	
	public Linear_Array(Linear_Array oriArray){
		ini_array=oriArray.ini_array;
		array_size=oriArray.array_size;
	}
	
	public Linear_Array(int[] oriArray){
		ini_array=oriArray;
		array_size=oriArray.length;
	}

	public int get_size(){
		return array_size;
	}
	
	public boolean insert_array(int pos,int value){//插入数据
		if(pos<0 || pos>array_size){
			System.out.println("wrong action!!!");
			return false;
		}
		else{
			//System.out.println(array_size);
			ini_array[array_size]=0;
			array_size++;
			for (int j=array_size-1;j>pos;j--){
				ini_array[j]=ini_array[j-1];
			}
			ini_array[pos]=value;
			return true;
		}
	}
	
	public void display_array(){//显示
		if(array_size==0)
			System.out.println("empty array!");
		else{
			System.out.print("the array is: ");
			for (int i=0;i<array_size;i++)
				System.out.print(ini_array[i]+" ");
				System.out.print('\n');
		}
	}
	public boolean delete_array(int pos){
		if(array_size==0){
			System.out.println("empty array");
			return false;
		}
		if(pos>array_size-1||pos<0){
			System.out.println("wrong action!!!");
			return false;
		}
		else{
			for (int i=pos;i<array_size-1;i++){
				ini_array[i]=ini_array[i+1];
			}
			array_size--;
			return true;
		}	
	}
	public int find_array(int value){
		if(array_size==0){
			System.out.println("empty array");
			return -1;
		}
		for (int i=0;i<array_size;i++){
			if (ini_array[i]==value){
				return i;
			}
		}
		return -1;	
	}
}


public class Array_Practice {
	
	
	//public mybubble()
	
	
	//write a test data file with random integer
	public static void WritetoTXT(){
		try{
			FileOutputStream fos = new FileOutputStream(new File("d:\\test.dat"),true); 
			int temp;
			for (int j=0;j<1500;j++){
				temp=new Random().nextInt(100000);
				fos.write((Integer.toString(temp)+" ").getBytes());
				//fos.write(System.getProperty("line.separator").getBytes());
			}
			fos.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}	
	
	public static void main(String[] args) {
		int[] x={1,2,3,4,5};
		Linear_Array _aArray = new Linear_Array();
		
		for (int j=0;j<5;j++){
			if(!_aArray.insert_array(j,j*8))
				break;
			}
		_aArray.display_array();
		//if(_aArray.insert_array(0, 11111))
			//_aArray.display_array();
		if (_aArray.delete_array(-1))
			_aArray.display_array();
	}

}
