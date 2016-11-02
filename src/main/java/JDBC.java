
	import java.io.*;
	//app that will be connected with thermostat so that we can know can the fridge freeze the water
	public class JDBC {
    public static void main(String args[]) throws IOException {
        FileOutputStream fos = new FileOutputStream("diagnosticInfo.txt");
        Informations inf=new Informations();
        //this is used only for example
     
        
        //under 0C 
		if(inf.getTemperature()<=0)  {
			
			String str="It is enought for water to freez";
			byte b[] = str.getBytes();
			
			for(int i=0;i<b.length;i++)
	        	{
	            	fos.write(b[i]);
	        	}
		
        }
		//above 1+C
		else
						{
			
			String str="It need more time for temperature to get under +1 C";
			byte b[] = str.getBytes();
			
			for(int i=0;i<b.length;i++)
	        	{
	            	fos.write(b[i]);
	        	}
		
			}
		 fos.close();
        // output so that the program is successfully finished 
        System.out.println("Data successfully written to File.");
    }
}