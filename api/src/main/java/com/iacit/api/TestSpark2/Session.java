package TestSpark2;

import java.util.List;

import org.apache.spark.sql.Column;
import org.apache.spark.sql.DataFrameReader;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.catalog.Database;

import com.iacit.api.entity.Estacao;
import com.iacit.api.entity.Regiao;




public class Session {
	
	public Dataset<Row> dfRegiao(){
		
		SparkSession spark = SparkSession
				.builder()
				.appName("Test")
				.master("local")
				.getOrCreate();
		
		FuncionaPFV Dataframes = new FuncionaPFV();
		List<String> FuncionaPeloAmorDeDeus = Dataframes.leitor();
		Dataset<Row> data = (Dataset<Row>) FuncionaPeloAmorDeDeus;
		
		return data;
	}
	public static void main(String[] args) {
		Session x = new Session();
		Dataset<Row> regiao = x.dfRegiao().select("REGIAO");		
				Dataset<Regiao> typedDataset = regiao
				  .as(Encoders.bean(Regiao.class));
		System.out.println(regiao);
	}
	}


