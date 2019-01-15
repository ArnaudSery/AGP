/**
 * 
 */
package persistence.extendeddb;

/**
 *
 */
public class SQLConfiguration {
	private static String system;
	private static String host;
	private static String base;
	private static String user;
	private static String password;
	
	
	public SQLConfiguration() {
		
	}
	
	public SQLConfiguration(String system, String host, String base, String user, String password) {
		
	}

	public static String getSystem() {
		return system;
	}

	public static void setSystem(String system) {
		SQLConfiguration.system = system;
	}

	public static String getHost() {
		return host;
	}

	public static void setHost(String host) {
		SQLConfiguration.host = host;
	}

	public static String getBase() {
		return base;
	}

	public static void setBase(String base) {
		SQLConfiguration.base = base;
	}

	public static String getUser() {
		return user;
	}

	public static void setUser(String user) {
		SQLConfiguration.user = user;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		SQLConfiguration.password = password;
	}

	public static String getUrl() {
		return "jdbc:" + system + "://" + host + "/" + base;
	}
}
