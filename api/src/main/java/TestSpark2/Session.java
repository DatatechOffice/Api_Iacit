package TestSpark2;

import org.apache.spark.sql.Column;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.DataFrameReader;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.catalog.Database;

import com.iacit.api.entity.Estacao;




public class Session {

	public static void main(String[] args) {
		
		SparkSession spark = SparkSession
				.builder()
				.appName("Test")
				.master("local")
				.getOrCreate();
		
		FuncionaPFV Dataframes = new FuncionaPFV();
		DataFrameReader dataFrameReader = spark.read();
		Dataset<Row> data = dataFrameReader.option("header", "true")
				.text(Dataframes.leitor());
		
		Dataset<Row> responseWithSelectedColumns = data.select(col("est_codigo"), 
				col("est_longitude"), 
				col("est_nome_estacao"), 
				col("est_data_fundacao"), 
				col("est_latitude"), 
				col("est_altitude"));
		Dataset<Estacao> typedDataset = responseWithSelectedColumns.as(Encoders.bean(Estacao.class));
	}

	private static Column col(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
