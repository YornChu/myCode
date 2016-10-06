import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.FileNotFoundException;
class ABFormat 
{
	public static void main(String[] args) 
	{
		String lineTxt = null;
	try{
		  
		  String filePath="C:\\Users\\Administrator\\Desktop\\实验课\\PAT_Jdk\\input.txt";
		  File file = new File(filePath);
		  if(file.isFile() && file.exists()){ //判断文件是否存在
                    
             BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                    
             lineTxt = bufferedReader.readLine();
			}
		  
	}     catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		String[] line=lineTxt.split(" ");
		if(line.length>2){
		System.out.println("the file is wrong");
		System.exit(1);
		}
	  long A=Integer.valueOf(line[0]);
	  System.out.printf("the A is %d",A);
	  long B=Integer.valueOf(line[1]);
      System.out.printf("the B is %d",B);
      long sum=A+B;
	  System.out.printf("the sum is %d",sum);
	  String sum_str=String.valueOf(sum);
	  System.out.println("the sum is "+sum_str);
	  int len=sum_str.length();
	  
	  int i=len-1;
	  String tmp="";
      System.out.printf("the tmp.len is %d",tmp.length());
	  while(i>=0)
	  {
           
			tmp=sum_str.charAt(i)+tmp;
			i--;
			System.out.println("the tmp is"+tmp);
			if(sum_str.charAt(i)!='-'){

			if(tmp.length()%3==0){
				 System.out.printf("the tmp.len in if is %d",tmp.length());
                 tmp=","+tmp;
			}
		   }
		   else{
			   break;
		   }
			
	  }
     System.out.println("the answer is"+tmp);
	}
}
