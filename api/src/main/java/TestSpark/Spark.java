package TestSpark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.SQLContext;


public class Spark {

	public static void main(String[] args) {
		
		
		SparkConf conf = new SparkConf().setMaster("local[*]").setAppName("ApiEstacao");
		JavaSparkContext ctx = new JavaSparkContext(conf);
		SQLContext sctx = new SQLContext(ctx);
		
		ReadCSV Dataframes= new ReadCSV();
		
		
		JavaRDD<String> api = ctx.textFile( Dataframes.leitor());
		JavaRDD<Estacao> estacao = api.
			map(x -> x.split(";")).
			map(o -> new Estacao(Integer.parseInt(o[0]), o[1], o[2],
			Double.parseDouble(o[4]), Double.parseDouble(o[5])));
		
		// Cria o DataFrame
		DataFrame apiDF = sctx.createDataFrame(api, Estacao.class);
		

	}

}
