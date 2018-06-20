package simpleDP2018;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public interface ReizigerDAO {
	public List<Reiziger> findAll();
	public Reiziger findById(int id);
//	public Reiziger save (Reiziger reiziger);
//	public Reiziger update (Reiziger reiziger);
//	public boolean delete (Reiziger r);
	
	
	
//	public void closeConnection ();

}
