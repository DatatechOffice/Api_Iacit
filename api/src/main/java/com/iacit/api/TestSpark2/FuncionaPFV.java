package TestSpark2;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

public class FuncionaPFV {
	  
	   
	public List<String> leitor()  
	{
	ArrayList<String> Jorge = new ArrayList<String>();
	String tokenn = null;
	CSVReader reader = null;  
	String[] nextLine = null;
	try  
	{  
	//parsing a CSV file into CSVReader class constructor  
	reader = new CSVReader(new FileReader("C:\\Users\\gabri\\OneDrive\\Área de Trabalho\\Nova pasta\\database.csv"));  
	
	//reads one line at a time  
	while ((nextLine = reader.readNext()) != null){  
	for(String token : nextLine){  
//	System.out.print(token);
	if (token != null){
		tokenn = token; 
	}
	else{
		continue;
	}
	}  
//	System.out.print("\n");  
	}  
	}  
	catch (Exception e){  
	e.printStackTrace();  
	}
	return Jorge = ((ArrayList<String>)nextLine);  
	}  
	}  

