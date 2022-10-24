package exdataframes;

//import org.apache.log4j.Level;
//import org.apache.log4j.Logger;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class ExDataFrames {

	public static void main(String[] args) throws Exception {
		
		SparkSession spark =  SparkSession.builder().appName("Ex Dataframes 1").master("local[*]").getOrCreate();
		
		Dataset<Row> emp = spark.read()
				.option("header", true)
				.option("inferSchema", true)
				.csv("C:\\Users\\gabri\\OneDrive\\Documentos\\Gabriel\\Teste\\Teste.xlsx");
		
		emp.show();
		
	}
}
