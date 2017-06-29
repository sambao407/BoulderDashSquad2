
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Arrays;

public class Connect {


		  public static void main(String[] args) {

		    try {

		      Class.forName("com.mysql.jdbc.Driver");

		      String url = "jdbc:mysql://localhost/tableau_niveau?useSSL=false&serverTimezone=UTC";

		      String user = "root";

		      String password = "";

		         
		      Connection conn = DriverManager.getConnection(url, user, password);

		      //Création d'un objet Statement

		      Statement state = conn.createStatement();

		      ResultSet result = state.executeQuery("SELECT * FROM level WHERE N_Level = 4");
		      
		      
		      
		      while(result.next()) {
		    	
			      int X = 1;
			      int len = 10;
			     
			      char[][] listeStrings = new char[len][len];
			      
			      for(int i = 0; i < len; i++) {
			    	  
			    	  for(int j = 0; j < len; j++){
			    	  
			    	  listeStrings[i][j] = result.getString("X").charAt(i*len+j);
			    	  System.out.print(result.getString("X").charAt(i*len+j));
			    	  
			    	 
			      }
			    	  System.out.println("");
			      }
			      
			 }
		      


		    } catch (Exception e) {

		      e.printStackTrace();

		    }      

	}
		  
		
			  

}

