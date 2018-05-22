package simpleDP2018;

import java.sql.SQLException;
import java.util.List;
import java.sql.Date;

public class Main {

	public static void main(String[] args) throws SQLException {

		ReizigerDAO rDAO = new ReizigerDaoImpl();
		OvChipkaartDAO oDAO = new OvChipkaartDaoImp();
//		findByReizigerId(rDAO);
		printAll(rDAO);
//		printAll(oDAO);
//		findByKaartNummer(oDAO);
//		SaveOv(oDAO);
//		updateOv(oDAO);
//		deleteOv(oDAO);

	}

	private static void printAll(ReizigerDAO rDAO) {

		System.out.println("Opgeslagen Reiziger :");
		List<Reiziger> rList = rDAO.findAll();
		for (Reiziger robject : rList) {
			System.out.println(robject);
		}


	}

	private static void printAll(OvChipkaartDAO oDAO) {
		List<OvChipkaart> oList = oDAO.findAll();

		System.out.println("Opgeslagen Ov Chipkaarten");

		for (OvChipkaart object : oList) {
			System.out.println(object);
		}
	}

	private static void findByKaartNummer(OvChipkaartDAO oDAO) {
		int nummer = 90537;
		List<OvChipkaart> oList = oDAO.findByKaartNummer(nummer);

		System.out.println("Ov Chipkaarten met kaarnummer " + nummer + ":");

		for (OvChipkaart object : oList) {
			System.out.println(object);
		}

	}
	
	private static void findByReizigerId(ReizigerDAO rDAO) {
		int nummer = 2;
		List<Reiziger> rList = rDAO.findById(nummer);

		System.out.println("Ov Chipkaarten met kaarnummer " + nummer + ":");

		for (Reiziger rbject : rList) {
			System.out.println(rbject);
		}

	}

	// save ovchipkaart
	private static void SaveOv(OvChipkaartDAO oDAO) throws SQLException {
		OvChipkaart result = null;
		OvChipkaart newOv = new OvChipkaart(90000,"31-12-2019", 2, (50), 5);
		System.out.println("Test Save(OvChipkaart)");
		result = oDAO.save(newOv);
		System.out.println("Ov chipkaart opgeslagen: " + result);

	};

	private static void deleteOv(OvChipkaartDAO oDAO) {
		boolean x = oDAO.delete(90000);
		if (x == true) {
			System.out.println("Ov met Kaartnummer 90000 is verwiderd!");
		}
		;
	};

	private static void updateOv(OvChipkaartDAO oDAO) {

		List<OvChipkaart> oList = oDAO.findByKaartNummer(90000);

		for (OvChipkaart object : oList) {
			System.out.println("was: " + object);

			OvChipkaart newOv = new OvChipkaart(90000, "31-12-2020", 2, 100, 5);
			oDAO.update(newOv);

			List<OvChipkaart> oList2 = oDAO.findByKaartNummer(90000);

			for (OvChipkaart object2 : oList2) {
				System.out.println("and now : " + object2);

			}
			;
		}

	}

}
