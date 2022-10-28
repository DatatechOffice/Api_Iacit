package TestSpark;

import java.io.FileReader;  
import com.opencsv.CSVReader;

public class ReadCSV {
	  
	   
	public String leitor()  
	{
	String tokenn = null;
	CSVReader reader = null;  
	String[] nextLine;
	try  
	{  
	//parsing a CSV file into CSVReader class constructor  
	reader = new CSVReader(new FileReader("C:\\Users\\gabri\\OneDrive\\Área de Trabalho\\Nova pasta\\database.csv"));  
	
	//reads one line at a time  
	while ((nextLine = reader.readNext()) != null)  
	{  
	for(String token : nextLine)  
	{  
	System.out.print(token);
	if (token != null) {
		tokenn = token;
	}
	else {
		break;
	}
	}  
	System.out.print("\n");  
	}  
	}  
	catch (Exception e)   
	{  
	e.printStackTrace();  
	}
	return tokenn;  
	}  
	}  

