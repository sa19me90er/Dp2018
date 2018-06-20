package simpleDP2018;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReizigerDaoImpl extends OracleBaseDAO implements ReizigerDAO {
	public ReizigerDaoImpl() throws SQLException {
		getConnection();
	}

	public Reiziger findById(int id) {


		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from reiziger where REIZIGERID=" + id);

			while (rs.next()) {
				Reiziger r = new Reiziger(rs.getInt("REIZIGERID"), rs.getString("VOORLETTERS"), rs.getString("TUSSENVOEGSEL"),
						rs.getString("ACHTERNAAM"), rs.getDate("GEBORTEDATUM"));
				OvChipkaartDaoImp oDAO = new OvChipkaartDaoImp();
				List<OvChipkaart> OvVanReiziger = oDAO.findByReiziger(r);

				r.setKarten(OvVanReiziger);
				Reiziger result = r;
				
				return r;
			}

			rs.close();
			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}
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

				OvChipkaartDaoImp oDAO = new OvChipkaartDaoImp();

				r = new Reiziger(rs.getInt("REIZIGERID"), rs.getString("VOORLETTERS"), rs.getString("TUSSENVOEGSEL"),
						rs.getString("ACHTERNAAM"), rs.getDate("GEBORTEDATUM"));

				List<OvChipkaart> OvVanReiziger = oDAO.findByReiziger(r);

				r.setKarten(OvVanReiziger);

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