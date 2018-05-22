package simpleDP2018;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public interface OvChipkaartDAO {
	
	public List<OvChipkaart> findAll();
	public List<OvChipkaart> findByID(int id);

	public OvChipkaart save (OvChipkaart ovChipkaart) throws SQLException ;
	public OvChipkaart update (OvChipkaart ovChipkaart);
	public boolean delete (int kaartnr );
	public List<OvChipkaart> findByKaartNummer(int kaarnummer);

}
