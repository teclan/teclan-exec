package teclan.exec;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		String pre = "E:\\Repository\\Codes\\java\\teclan-exec\\UnxUtils\\usr\\local\\wbin\\";
		
		ArrayList<String> parms = new ArrayList<String>();
		parms.add("-d ");
		parms.add("yesterday ");
		parms.add("+%Y-%m-%d ");

		String[] param = new String[] { "-d", "yesterday", " +%Y-%m-%d" };

		try {
			String result = Executor.exec(pre + "udate.exe", parms.toArray());

			System.out.println(result);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}
