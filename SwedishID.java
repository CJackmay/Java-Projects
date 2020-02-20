public class SwedishID {
	private DateFormat birthday;
	private  int checksum;
	private boolean valid;

	public long initialchecksum;

	public SwedishID(){
	}

	public SwedishID(String ID){
		String I_D = ID.replaceAll("\\-", "");
		int points1 = 0, points2 = 0, points3 = 0, points4 = 0, points5 = 0, points6 = 0, points7 = 0, points8 = 0, points9 = 0;
		char p1 = I_D.charAt(2);
		points1 = Character.getNumericValue(p1) * 2;
		if (points1 >10){
			int nbh = points1 % 10;
			int nif = points1 / 10;
			points1 = nbh+nif;
		}
		//System.out.println("Start"+points1);
		char p2 = I_D.charAt(3);
		points2 = Character.getNumericValue(p2);
		//System.out.println(points2);

		char p3 = I_D.charAt(4);
		points3 = Character.getNumericValue(p3) * 2;
		if (points3 >10){
			int nbh = points3 % 10;
			int nif =points3 / 10;
			points3 = nbh+nif;
		}
		//System.out.println(points3);

		char p4 = I_D.charAt(5);
		points4 = Character.getNumericValue(p4);
		//System.out.println(points4);

		char p5 = I_D.charAt(6);
		points5 = Character.getNumericValue(p5) * 2;
		if (points5 >10){
			int nbh = points5 % 10;
			int nif =points5 / 10;
			points5 = nbh+nif;
		}
		//System.out.println(points5);

		char p6 = I_D.charAt(7);
		points6 = Character.getNumericValue(p6);
		//System.out.println(points6);

		char p7 = I_D.charAt(8);
		points7 = Character.getNumericValue(p7) * 2;
		if (points7 >10){
			int nbh = points7 % 10;
			int nif =points7 / 10;
			points7 = nbh+nif;
		}
		//System.out.println(points7);

		char p8 = I_D.charAt(9);
		points8 = Character.getNumericValue(p8);
		//System.out.println(points8);

		char p9 = I_D.charAt(10);
		points9 = Character.getNumericValue(p9) * 2;
		if (points9 >10){
			int nbh = points9 % 10;
			int nif =points9 / 10;
			points9 = nbh+nif;
		}
		//System.out.println(points9);

		int initialtotal = points1+points2+points3+points4+points5+points6+points7+points8+points9;

		//System.out.println(total);
		int total = 10 - (initialtotal % 10);

		if (total == 10){
			this.checksum = 0;
		}
		else{
			this.checksum = total;
		}

		long id = Long.parseLong(I_D.trim());
		int bdy =(int) (id / 10000) / 10000;
		int bdm =(int) (id / 1000000) % 10;
		int bd =(int) (id / 10000) % 100;
		long last = (id / 10) % 1000;

		initialchecksum = id % 10000;

		/*System.out.println(bdy);
		System.out.println(bdm);
		System.out.println(bd);
		System.out.println(last);*/

		String thechecksum = Long.toString(last) + Integer.toString(checksum);
		this.checksum = (int) Long.parseLong(thechecksum.trim());
		//System.out.println("checksum = "+checksum);

		this.birthday = new DateFormat(bdy, bdm, bd,  '!', 'b');

	}

	public String getBirth(){
		return birthday.getDate(true);
	}

	public String showID(){
		//String thisbirthday = birthday.getDate(true);
		return birthday.getDate(true) +'-'+ Integer.toString(checksum);
	}

	public boolean isFemale(){
		int check = checksum % 10;
		return check % 2 == 0;
	}

	public int comparedTo(SwedishID otherID){
		if (birthday.getDate(true).equals(otherID.birthday.getDate(true))){
			return 0;
		}
		else if (birthday.getYear() < otherID.birthday.getYear() ){
			return -1;
		}
		else{
			return 1;
		}
	}

	public boolean validID(){
		return checksum == initialchecksum;
	}
}




