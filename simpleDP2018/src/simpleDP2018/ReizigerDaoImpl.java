package simpleDP2018;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ReizigerDaoImpl extends OracleBaseDAO
								   implements ReizigerDAO  {
	public ReizigerDaoImpl() throws SQLException {
		getConnection();
	}
	
	public List<Reiziger> findById(int id) {
/*		
		List<Reiziger> reiziger = new ArrayList<Reiziger>();
		List<OvChipkaart> rezigerOv= ((Reiziger) reiziger).getKarten();

		try {
			Statement stmt = conn.createStatement();
			ResultSet ov = stmt.executeQuery("Select * from Ov_Chipkaart where REIZIGERID=" +id);

			while (ov.next()) {
				OvChipkaart ovc =  new OvChipkaart(ov.getInt("KAARTNUMMER"), ov.getString("GELDIGTOT"), ov.getInt("KLASSE"),
						ov.getInt("SALDO"), ov.getInt("REIZIGERID"));
				rezigerOv.add(ovc);
			}

			ov.close();
			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return rezigerOv;
*/
		return null;
	}
	


	
	


	    
		@Override
		public List<Reiziger> findAll() {
			ArrayList<Reiziger> list = new ArrayList<>();
	
			Reiziger r = null;

			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("Select * from reiziger");

				while (rs.next()) {
					
					OvChipkaartDaoImp oDAO= new OvChipkaartDaoImp();
					
					
					
					r = new Reiziger(rs.getInt("REIZIGERID"), rs.getString("VOORLETTERS"), 
						rs.getString("TUSSENVOEGSEL"), rs.getString("ACHTERNAAM"),rs.getDate("GEBORTEDATUM"));
					
					List<OvChipkaart> OvVanReiziger= oDAO.findByReiziger(r);

					r.setKarten(OvVanReiziger);


					list.add(r);


//					for (OvChipkaart object : OvVanReiziger) {
////						if (object==null || OvVanReiziger.isEmpty()) 
////						{System.out.println("nog geen ov chipkaart");} 
////						else
//						System.out.println(object);
//					}					
					
				}
				rs.close();
				stmt.close();	
			} catch (Exception e) {
				System.out.println(e);
			} 			
			return list;			
		}	
}