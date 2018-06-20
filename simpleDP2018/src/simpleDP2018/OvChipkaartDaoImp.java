package simpleDP2018;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OvChipkaartDaoImp extends OracleBaseDAO implements OvChipkaartDAO {

	public OvChipkaartDaoImp() throws SQLException {
		getConnection();
	}

	private static ArrayList<OvChipkaart> alleOv = new ArrayList<OvChipkaart>();


	public OvChipkaart update(OvChipkaart ovc) {
		int krtnmr = ovc.getKaartNummer();
		
		try {
			String sql = "update  OV_CHIPKAART set GELDIGTOT= ? , KLASSE=?  , SALDO= ? , REIZIGERID =? where KAARTNUMMER=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
/*			int ov = stmt.executeUpdate("update OV_CHIPKAART set GELDIGTOT='"+ovc.getGeldigTot()+"', KLASSE= "+ ovc.getKlasse()+
					", SALDO= "+ ovc.getSaldo() +", REIZIGERID = "+ ovc.getReizegerID() +" where KAARTNUMMER= "+ovc.getKaartNummer());*/
			stmt.setDate(1,ovc.getGeldigTot());
			stmt.setInt(2,ovc.getKlasse());
			stmt.setDouble(3,ovc.getSaldo());
			stmt.setInt(4,ovc.getReizegerID());
			stmt.setInt(5, ovc.getKaartNummer());
			
			stmt.close();
			System.out.println(sql + " row updated");

		} catch (Exception e) {
			System.out.println(e);
		}
		return ovc;
	}

	public boolean delete(int kaartnr) {
		
		try {
			Statement stmt = conn.createStatement();
			int ov = stmt.executeUpdate("Delete from OV_CHIPKAART where KAARTNUMMER= "+ kaartnr);
			
			
			stmt.close();
			System.out.println(ov + " row deleted");
			if (ov == 0){
				return false;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	
		return true;

	}


	@Override
	/* als er geen cursus is gevonden, geeft hij een lege lijst terug */
	public List<OvChipkaart> findAll() {
		ArrayList<OvChipkaart> list = new ArrayList<OvChipkaart>();

		try {
			Statement stmt = conn.createStatement();
			ResultSet ov = stmt.executeQuery("Select * from OV_CHIPKAART");

			while (ov.next()) {
				OvChipkaart o = new OvChipkaart(ov.getInt("KAARTNUMMER"), ov.getDate("GELDIGTOT"), ov.getInt("KLASSE"),
						ov.getDouble("SALDO"), ov.getInt("REIZIGERID"));
				list.add(o);
			}

			ov.close();
			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return list;
	}

	// find by kaartnummer
	public List<OvChipkaart> findByKaartNummer(int kaartnr) {
		ArrayList<OvChipkaart> gevondenOv = new ArrayList<OvChipkaart>();

		try {
			Statement stmt = conn.createStatement();
			ResultSet ov = stmt.executeQuery("Select * from OV_CHIPKAART where KAARTNUMMER=" + kaartnr);
			while (ov.next()) {
				OvChipkaart o = new OvChipkaart(ov.getInt("KAARTNUMMER"), ov.getDate("GELDIGTOT"), ov.getInt("KLASSE"),
						ov.getDouble("SALDO"), ov.getInt("REIZIGERID"));
				gevondenOv.add(o);
			}

			ov.close();
			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return gevondenOv;
	}

	// find by reizigerid
	public List<OvChipkaart> findByID(int id) {
		ArrayList<OvChipkaart> gevondenOv = new ArrayList<OvChipkaart>();

		try {
			Statement stmt = conn.createStatement();
			ResultSet ov = stmt.executeQuery("Select * from OV_CHIPKAART where REIZIGERID=" + id);
			while (ov.next()) {
				OvChipkaart o = new OvChipkaart(ov.getInt("KAARTNUMMER"), ov.getDate("GELDIGTOT"), ov.getInt("KLASSE"),
						ov.getDouble("SALDO"), ov.getInt("REIZIGERID"));
				gevondenOv.add(o);
			}

			ov.close();
			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return gevondenOv;
	}
	
	public List<OvChipkaart> findByReiziger(Reiziger r) {
		ArrayList<OvChipkaart> gevondenOv = new ArrayList<OvChipkaart>();

		try {
			Statement stmt = conn.createStatement();
			ResultSet ov = stmt.executeQuery("Select * from OV_CHIPKAART where REIZIGERID="+ r.getIdNr());
			while (ov.next()) {
				OvChipkaart o = new OvChipkaart(ov.getInt("KAARTNUMMER"), ov.getDate("GELDIGTOT"), ov.getInt("KLASSE"),
						ov.getDouble("SALDO"), ov.getInt("REIZIGERID"));
				o.setOvhouder(r);
				gevondenOv.add(o);
			}

			ov.close();
			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return gevondenOv;
	}
	
	// save
	public OvChipkaart save(OvChipkaart ov) throws SQLException {
	
		try {
		String sql = "INSERT INTO OV_CHIPKAART (KAARTNUMMER, GELDIGTOT, KLASSE, SALDO, REIZIGERID) values (?,?,?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(sql);


		stmt.setInt(1, ov.getKaartNummer());
		stmt.setDate(2,ov.getGeldigTot());
		stmt.setInt(3,ov.getKlasse());
		stmt.setDouble(4,ov.getSaldo());
		stmt.setInt(5,ov.getReizegerID());


		int result = stmt.executeUpdate();
		stmt.close();


		
		if (result == 0)
			return null;
		else
			return ov;

		} catch (Exception e) {
			System.out.println(e);
		}
	return ov;

	}

}
