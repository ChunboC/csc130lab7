package lab7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * <p>
 * Title: Lab7App.java
 * </p>
 *
 * <p>
 * Description: Application class for CovidCase. It scans the covid-19 data from
 * WHO website, displays a report for today's covid cases, and lets user pick a
 * country to display its covid report.
 * </p>
 *
 * @author Chunbo Cheng
 */
public class Lab7App {

	public static void main(String[] args) {
		LinkedList<CovidCase> cases = new LinkedList<>();
		LinkedList<CovidCase> yesterdayCases = new LinkedList<>();
		File file = new File("WHO-COVID-19-global-data.csv");
		Scanner scan = null;

		if (!file.exists())
			createFile();
		try {
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		scan.nextLine();
		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			String regex = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";
			String[] values = line.split(regex);
			CovidCase temp = new CovidCase(values);
			LocalDate tempDate = temp.getDateReported();
			LocalDate todayDate = LocalDate.now();
			int month = todayDate.getMonthValue();
			int day = todayDate.getDayOfMonth();
			LocalDate pastDate = LocalDate.of(2020, month, day);
			if (tempDate.equals(pastDate))
				cases.add(temp);
			else if (tempDate.equals(pastDate.minusDays(1)))
				yesterdayCases.add(temp);
		}
		if (cases.isEmpty())
			cases = yesterdayCases;
		System.out.println(cases);

		scan = new Scanner(System.in);
		String prompt = "Enter country code or q to quit: ";
		while (true) {
			CovidCase temp;

			System.out.print(prompt);
			String input = scan.nextLine();

			if (input.length() == 1 && (input.charAt(0) == 'q' || input.charAt(0) == 'Q')) {
				System.out.println("Program ended...");
				break;
			} else {
				temp = new CovidCase(null, input, null, null, 0, 0, 0, 0);
				if (!cases.contains(temp)) {
					System.out.println("Country not found. Please try again.\n");
				} else {
					temp = cases.get(cases.indexOf(temp));
					System.out.println();
					System.out.println("COVID-19 Data for " + temp.getCountry());
					System.out.println("Cases to today: " + String.format("%,d", temp.getNewcases()));
					System.out.println("Deaths to today: " + String.format("%,d", temp.getNewDeaths()));
					System.out.println("Cumulative Cases to date: " + String.format("%,d", temp.getCumulativeCases()));
					System.out
							.println("Cumulative Deaths to date: " + String.format("%,d", temp.getCumulativeDeaths()));
					System.out.println();
					prompt = "Enter another country code or q to quit: ";
				}
			}
		}
		scan.close();
	}

	public static void createFile() {
		URL url;
		Scanner scan = null;
		PrintWriter writer = null;
		try {
			url = new URL("https://covid19.who.int/WHO-COVID-19-global-data.csv");
			scan = new Scanner(url.openStream());
			writer = new PrintWriter("WHO-COVID-19-global-data.csv");
			while (scan.hasNextLine())
				writer.println(scan.nextLine());
		} catch (IOException e) {
			System.out.println("IOException: " + e.getMessage());
			System.exit(1);
		} finally {
			scan.close();
			writer.close();
		}
	}
}
