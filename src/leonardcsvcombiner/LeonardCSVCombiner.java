package leonardcsvcombiner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class LeonardCSVCombiner {

//Set Up Variables

public static void main(String[] args) throws FileNotFoundException, IOException {

File folder = new File("C:\\Users\\tremanleo\\Documents\\NetBeansProjects\\LeonardScraperLauncher\\CSVSection");
File[] listOfFiles = folder.listFiles();
File UrlLoaderFile2 = new File("holder.txt");

int CounterOfFiles = 0;
int CountUpToNumber = 0;
int CountUpToNumberDoublecheck = 0;
int subloopcount = 0;
int CountTo8 = 0;
String line4 = "";
String StuffToWrite2 = "";
String[] HolderOfCSVToCombine = new String[999999];
String[] HoldEveryLineArray = new String[99999999];

//Establish the number of CSV to scrape
//Write CSV To String Array
for (File file : listOfFiles) 
{
    System.out.println(file);
    if (file.isFile()) 
        {
                
                        HolderOfCSVToCombine[CounterOfFiles] = file.getName();
                        UrlLoaderFile2 = file; 
                        BufferedReader br4 = new BufferedReader(new FileReader(UrlLoaderFile2));
                            while ((line4 = br4.readLine()) != null) 
                            {          
                            HoldEveryLineArray[CountUpToNumber] = line4;        
                            System.out.println(CountUpToNumber);  
                            System.out.println(HoldEveryLineArray[CountUpToNumber]);  
                            CountUpToNumber++;
                            }

                             br4.close();             
                        CounterOfFiles++;                
         }
}
//This is for doublechecking for other invisible files if it breaks
 while (CountUpToNumberDoublecheck != CountUpToNumber)
         {
           System.out.println(HoldEveryLineArray[CountUpToNumberDoublecheck]);             
         CountUpToNumberDoublecheck++;    
         }
   CountUpToNumberDoublecheck = 0;
 //Print To A New Combined CSV File

File f4 = new File("C:\\Users\\tremanleo\\Documents\\OutputForScrapers\\CombinedLeonardScraper"+ ".csv");
FileWriter fw = new FileWriter(f4);
PrintWriter out = new PrintWriter(fw);     
  out.print("Item Number" + "," + "Actual Pin Diameter" + "," + "Actual Pin Diameter Tolerance" + "," + "Annealed Head" + "," + "D Nominal Pin Diameter" + "," + "H Head Diameter" + "," + "L Overall Length" + "," + "Price" + "," + "\n");  
 while (CountUpToNumberDoublecheck != CountUpToNumber)
 {
if(CountTo8 == 1)
{
 out.print("\n");  
  System.out.println("\n");
 CountTo8 = 0;
}
fw.flush(); 
out.flush();
System.out.println(CountUpToNumberDoublecheck);
StuffToWrite2 = HoldEveryLineArray[CountUpToNumberDoublecheck];   
out.print(StuffToWrite2);  
System.out.println(StuffToWrite2);
CountTo8++;
CountUpToNumberDoublecheck++;
 }
    }    
}