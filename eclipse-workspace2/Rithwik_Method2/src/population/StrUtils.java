package population;

public class StrUtils {
	public WorldBankEntry parseWorldBankEntry(String str) {
		WorldBankEntry entry = null;
		int loc = str.lastIndexOf("\","); // looking for last ",
		if (loc > 1) {
			str = str.substring(1, loc);
			String[] arr = str.split("\",\""); // "," " => \"
			String country = arr[0];
			String code = arr[1];
			String indicator = arr[2];
			System.out.println("arr size = " + arr.length);
			// the 62 value is for 2018
			try {
				long population = Long.parseLong(arr[arr.length-1]);
				entry = new WorldBankEntry(country, code, indicator, population);
			} catch (NumberFormatException e) {
				return null;
			}
		}
		return entry;
	}

	public int parsePopulation(String string) {
		int loc = string.indexOf(':');
		string = string.substring(loc + 1);
		string = string.trim();
		string = string.replaceAll(",", "");
		int pop = Integer.parseInt(string);
		return pop;
	}

	public String parseCountry(String string) {
		// "This population of the USA: 380,000,000"
		int loc = string.indexOf(':');
		string = string.substring(0, loc);
		loc = string.lastIndexOf(' ');
		string = string.substring(loc);
		string = string.trim();
		return string;
	}
}
