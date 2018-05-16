package simpleDP2018;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ReizigerDaoImpl extends OracleBaseDAO
								   implements ReizigerDAO  {
	public ReizigerDaoImpl() throws SQLException {
		getConnection();
	}
	
	private static ArrayList<Reiziger> alleReiziger = new ArrayList<Reiziger>(); 
/*	public List<Reiziger> findAll() {

		return alleReiziger;
	}
*/	
	public List<Reiziger> findById(int id) {
		
		return alleReiziger;
	}

	
	public List<Reiziger> findByGBdatum(Date GBdatum) {
		   List<Reiziger> gevondenReizigers = new ArrayList<Reiziger>();

		   for (Reiziger eenReiziger : alleReiziger) {
		      if (eenReiziger.getGBdatum()==GBdatum) {
		         gevondenReizigers.add(eenReiziger);
		      }
		   }

		   return gevondenReizigers;
		}


	
	
	public Reiziger save (Reiziger reiziger){
		 alleReiziger.add (reiziger);
		 return reiziger;
	}

	public Reiziger update (Reiziger reiziger){
		int x = alleReiziger.indexOf(reiziger);
		if (x == -1) {return null;}
		
		alleReiziger.set(x, reiziger);
		
		return reiziger;
		
	}
	
	public boolean delete (Reiziger r){
		return alleReiziger.remove(r);
		
	}
	
	
	    public String toString(){
		 for (Reiziger object: alleReiziger) {
			    System.out.println(object);
		 	}
		 
		    return   " ";

	    }
	    
	    
		@Override
		/* als er geen cursus is gevonden, geeft hij een lege lijst terug  */
		public List<Reiziger> findAll() {
			ArrayList<Reiziger> list = new ArrayList<Reiziger>();
			Reiziger r = null;

			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("Select * from reiziger");

				while (rs.next()) {
					r = new Reiziger(rs.getInt("REIZIGERID"), rs.getString("VOORLETTERS"), 
							rs.getString("TUSSENVOEGSEL"), rs.getString("ACHTERNAAM"),rs.getDate("GEBORTEDATUM"));
					list.add(r);
				}

				rs.close();
				stmt.close();	
			} catch (Exception e) {
				System.out.println(e);
			} 
			return list;
		}
		
	    
	
}

