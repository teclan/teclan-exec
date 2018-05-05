package teclan.exec;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.google.common.base.Joiner;

public class Executor {

	public static String exec(String cmd) throws Exception {
		return exec(cmd, null);
	}

	public static String exec(String cmd, Object... parms) throws Exception {

		return exec(cmd, toStringArray(parms));
	}

	public static String exec(String cmd, String[] parms) throws Exception {

		StringBuilder result = new StringBuilder();

		try {
			Runtime rt = Runtime.getRuntime();
			Process ps = null;

			if (parms == null || parms.length < 1) {
				ps = rt.exec(cmd);
			} else {
				String option = Joiner.on(" ").join(parms);
				ps = rt.exec(cmd + " " + option);
			}

			InputStream is = ps.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			String line;

			while ((line = reader.readLine()) != null) {
				result.append(line);
			}
			ps.waitFor();
			is.close();
			reader.close();
			ps.destroy();
		} catch (Exception e) {
			throw e;
		}
		return result.toString();
	}

	private static String[] toStringArray(Object[] parms) {

		String[] ps = new String[parms.length];

		System.arraycopy(parms, 0, ps, 0, parms.length);

		return ps;

	}

}
