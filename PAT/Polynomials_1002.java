import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.*;
import java.util.Vector;
import java.util.Iterator;
class  Polynomials_1002
{
	


	public static void main(String[] args) 
	{
		try{
		int  e;
		float coe;
	    Attr []tmp=new Attr[1];
		Vector <Attr>poly=new <Attr>Vector();
		System.out.println("please input number of nonzero terms:k||A");
		Scanner in=new Scanner(System.in);
        int a=in.nextInt();
		while(a>0){
              System.out.println("please input the coe");
			  coe=in.nextFloat();
			  System.out.println("please input the e");
			  e=in.nextInt();
			  poly.add(new Attr(coe,e));
			  a--;

		}
		System.out.println("please input number of nonzero terms:k||B");
   		a=in.nextInt();
        while(a>0){
              System.out.println("please input the coe");
			  coe=in.nextFloat();
			  System.out.println("please input the e");
			  e=in.nextInt();
              
			  if(cmp(poly,new Attr(coe,e),tmp)){
                   
				  int loc=poly.indexOf(tmp[0]);
				  System.out.printf("the a' loc %d",loc);
				  poly.get(loc).coe+=coe;
			  }
			  else{
                  poly.add(new Attr(coe,e));
			  }
             a--; 
		}
           show(poly);       
		}catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
		

	}


public static boolean cmp(Vector <Attr>v,Attr a,Attr []target){
   Iterator<Attr> it = v.iterator();
   while (it.hasNext()){
	   Attr tmp= (Attr)it.next();
       if(tmp.e==a.e){
           target[0]=tmp;
		   return true;
	   }
   }
return false;
}

public static void show(Vector <Attr>v){
   Iterator<Attr> it = v.iterator();
   System.out.printf("the poly :%d ",v.size());
   while (it.hasNext()){
	   Attr a=(Attr)it.next();
        System.out.printf("%d ",a.e);
		System.out.printf("%9.2f ",a.coe);
   }
}
	

}



	class Attr
{
	public float coe=0;
	public int e=0;
	public  Attr(float coe,int e){
		this.coe=coe;
		this.e=e;
	}
}
