/*
*Program łaczy wszystkie adania z baz danych (9).
*
*Utworzyłem u siebie serwer za pomocą postgresql 
*W pgAdmin utworzyłem bazę danych Advertisement
*
*następnie za pomocą metod w javie połączyłem się z powyższą bazą danych i utworzyłem nowe tabele oraz wpisy.
*Ze względu na małą ilość czasu nie mam zbytt wielu zapytań do bazy danych ale one się jeszcze pojawią w przyszłości :).
*/

package pl.alx.kpij.Ogloszenia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AdvertisementTest {

	private static ArrayList<Advertisement> advertisementList = new ArrayList<>();
	private static HashMap<String, Advertiser> advertiserList = new HashMap<>();
	private static int adwertisementCounter = 0;

	public static void main(String[] args) {
		/*
		 * ==================================================
		 * || WAZNE!!! WAZNE!!! WAZNE!!! WAZNE!!! WAZNE!!! ||
		 * ==================================================
		 *
		 * Użyj tylko raz do stworzenia tabel w bazie danych
		 */
		// addTablesToDatabase();
		// addAdvertisement();
		
		
		// saveAll();

		/*
		 * Aby przetestować program z wczytywania plików, należy po pierwszym
		 * uruchomieniu programu zakomentować powyższe linijki, aby nie dublować
		 * ogłoszeń i odkomentować metodę loadAll.
		 */
		 //loadAll();
		
		/*
		 * Wypisuje wsystkie ogłoszenia na podstawie arrayListy
		 */
		for (Advertisement adw : advertisementList) {
			System.out.println(adw);
		}
		
		/*
		 * Wypisuje wszystkich ogłoszeniodawców na podstawie hashMapy
		 */
		 advertiserList.forEach((key, value) -> {
			System.out.println(value);
		});
		 
		 /*
		  * Kilka przykładowych zaoytań do bazy danych.
		  */
		//Database.addQueryToDatabase("insert into advertiser values('994994994', 'Marian', 'Gora', 'Brzesko')");
		//Database.addQueryToDatabase("insert into advertisement values(7, 'Kupię', 'Mieszkanie', 'Kraków', 475000.0, 994994994, 'Szukam mieszkania blisko centrum.')");
		//Database.addQueryToDatabase("insert into house values(7, 4, 80.0, 0.0)");
		//Database.addQueryToDatabase("delete from house where id = 7");
		//Database.addQueryToDatabase("delete from advertisement where id = 7");
		//Database.addQueryToDatabase("delete from advertiser where phone_number = '994994994'");
		 
		/*
		 * Metody wczytują z bazy danych różne ogłoszenia i przedstawiają dane
		 */
		//Database.showAllAdvertisers("ascent");
		//Database.showAllAdvertisers("descent");
		//Database.showAllAdvertisement();
		//Database.showAllHouseAdvertisement("ascent");
		//Database.showAllHouseAdvertisement("descent");
		//Database.showAllVehiclesAdvertisement("cars");
		//Database.showAllVehiclesAdvertisement("motorcycles");
		//Database.showAllAdvertisementFromOneAdvertiser("113113113");
		//Database.showAllAdvertisementFromOneAdvertiser("123123123");
		
		/*
		 * Metody zapisujące dane z bazy danych do plików csv.
		 */
		//Database.saveAdvertiserTableToCSV();
		//Database.saveAdvertisementTableToCSV();
		//Database.saveHouseTableToCSV();
		//Database.saveCarsTableToCSV();
		//Database.saveMotorcyclesTableToCSV();
		 
		/*
		 * Metoda pozwalająca wybrać rzecz do kupienia z podanego zakresu cenowego
		 */
		// priceRange("Auto", 10000, 30000);
		 
		/*
		 * Metoda wyszukująca auta, motory lub domy, mieszkania do określonej kwoty, a
		 * powyżej odpowieniej pojemności lub powierzchni
		 */
		// maxPriceMinCapacityOrArea("Motocykl", 50000, 0.5);

	}

	public static void addTablesToDatabase() {

		Database.addQueryToDatabase(
				"create table Advertiser (phone_Number text primary key, first_Name text, last_Name text, place text)");
		Database.addQueryToDatabase(
				"create table Advertisement (id int primary key, type text, title text, place text, price decimal, phone_Number text, description text)");
		Database.addQueryToDatabase(
				"create table Cars (id int, mark text, model text, fuel text, year int, engine_Power int, mileage decimal, engine_Capacity decimal)");
		Database.addQueryToDatabase(
				"create table Motorcycles (id int, mark text, model text, fuel text, year int, engine_Power int, mileage decimal, engine_Capacity decimal)");
		Database.addQueryToDatabase(
				"create table House (id int, number_Of_Rooms int, house_Area decimal, land_Area decimal)");
		System.out.println("Utworzono tabele.");
	}

	public static void addAdvertisement() {

		Advertisement ad1 = new House("Sprzedam", "Mieszkanie", "Kraków", 350000.0, "123123123", 3, 55.5);
		ad1.setDescription("Ładne zadbane mieszkanie z balkonem i widokiem na park.");
		adwertisementCounter++;
		ad1.setId(adwertisementCounter);
		advertisementList.add(ad1);
		addToDatabaseHouse(ad1);
		Advertiser advertiser1 = new Advertiser("Jacek", "Kowalski", "Kraków", "123123123");
		advertiserList.put(advertiser1.getPhoneNumber(), advertiser1);
		addToDatabaseAdvertiser(advertiser1);

		Advertisement ad2 = new House("Sprzedam", "Dom", "Wieliczka", 550000.0, "223223223", 5, 130.0, 14.5);
		ad2.setDescription("Duży dom z garażem i podjazdem. Dwie łazienki oraz altana na ogrodzie.");
		adwertisementCounter++;
		ad2.setId(adwertisementCounter);
		advertisementList.add(ad2);
		addToDatabaseHouse(ad2);
		Advertiser advertiser2 = new Advertiser("Ala", "Kotowska", "Bochnia", "223223223");
		advertiserList.put(advertiser2.getPhoneNumber(), advertiser2);
		addToDatabaseAdvertiser(advertiser2);

		Advertisement ad3 = new Car("Sprzedam", "Auto", "Tarnów", 17000, "113113113", "Opel", "Astra", "Benzyna", 2011, 130, 202000.0, 1.9);
		ad3.setDescription("Pierwszy właściciel Niemiec płakał jak sprzedawał.");
		adwertisementCounter++;
		ad3.setId(adwertisementCounter);
		advertisementList.add(ad3);
		addToDatabaseCar(ad3);
		Advertiser advertiser3 = new Advertiser("Alex", "Top", "Tarnów", "113113113");
		advertiserList.put(advertiser3.getPhoneNumber(), advertiser3);
		addToDatabaseAdvertiser(advertiser3);

		Advertisement ad4 = new Car("Sprzedam", "Auto", "Warszawa", 88000, "554554554", "Mazda", "6", "Dizel", 2017, 190, 32000.0, 2.3);
		ad4.setDescription("Jeszcze ma folie na siedzeniach :).");
		adwertisementCounter++;
		ad4.setId(adwertisementCounter);
		advertisementList.add(ad4);
		addToDatabaseCar(ad4);
		Advertiser advertiser4 = new Advertiser("Marta", "Rak", "Warszawa", "554554554");
		advertiserList.put(advertiser4.getPhoneNumber(), advertiser4);
		addToDatabaseAdvertiser(advertiser4);

		Advertisement ad5 = new Motorcycle("Sprzedam", "Motocykl", "Gdańsk", 32000, "113113113", "Suzuki", "GSX-R750", "Benzyna", 2015, 150, 5500.0, 0.750);
		ad5.setDescription("Bez obcierek stan idealny.");
		adwertisementCounter++;
		ad5.setId(adwertisementCounter);
		advertisementList.add(ad5);
		addToDatabaseMotorcycle(ad5);

		Advertisement ad6 = new Motorcycle("Sprzedam", "Motocykl", "Wrocław", 55000, "443443443", "Kawasaki", "Ninja ZX-10RR", "Benzyna", 2019, 204, 22000.0, 1.0);
		ad6.setDescription("Włąściciel jeszcze żyje :).");
		adwertisementCounter++;
		ad6.setId(adwertisementCounter);
		advertisementList.add(ad6);
		addToDatabaseMotorcycle(ad6);
		Advertiser advertiser5 = new Advertiser("Tomas", "Wank", "Berlin", "443443443");
		advertiserList.put(advertiser5.getPhoneNumber(), advertiser5);
		addToDatabaseAdvertiser(advertiser5);

		System.out.println("Dodano kilka ogłoszeń.\n");
	}

	/*
	 * We wszystkich metodach wysyłających zapytania do bazy danych użyłem
	 * konkantacji ponieważ nie działało mi wyrażenie String.format. Baza danych
	 * wyżucała błąd związany z niepoprawną ilością podanych parametrów.
	 * Ze względu na brak czasu nie zrobiłem jeszcze tego aby wprowadzać dane wykorzystując 
	 * Stringi z ? aby uniknąć niechcianych ingerencji
	 */
	public static void addToDatabaseCar(Advertisement adw) {

		Car car = (Car) adw;
		String query1 = "insert into advertisement values (" + car.getId() + ", '" + car.getType() + "','"
				+ car.getTitle() + "', '" + car.getPlace() + "', " + car.getPrice() + ", " + car.getPhoneNumber()
				+ ", '" + car.getDescription() + "')";
		Database.addQueryToDatabase(query1);
		String query2 = "insert into cars values (" + car.getId() + ", '" + car.getMark() + "', '" + car.getModel()
				+ "', '" + car.getFuel() + "', " + car.getYear() + ", " + car.getEnginePower() + ", " + car.getMileage()
				+ ", " + car.getEngineCapacity() + ")";
		Database.addQueryToDatabase(query2);
	}

	public static void addToDatabaseMotorcycle(Advertisement adw) {

		Motorcycle motor = (Motorcycle) adw;
		String query1 = "insert into advertisement values (" + motor.getId() + ", '" + motor.getType() + "','"
				+ motor.getTitle() + "', '" + motor.getPlace() + "', " + motor.getPrice() + ", "
				+ motor.getPhoneNumber() + ", '" + motor.getDescription() + "')";
		Database.addQueryToDatabase(query1);
		String query2 = "insert into motorcycles values (" + motor.getId() + ", '" + motor.getMark() + "', '"
				+ motor.getModel() + "', '" + motor.getFuel() + "', " + motor.getYear() + ", " + motor.getEnginePower()
				+ ", " + motor.getMileage() + ", " + motor.getEngineCapacity() + ")";
		Database.addQueryToDatabase(query2);
	}

	public static void addToDatabaseHouse(Advertisement adw) {

		House house = (House) adw;
		// Database.addToDatabase(String.format("insert into advertisement values (%d,
		// '%s', '%s', '%s', %.2f, %d, '%s')", 1, "Sprzedam", "Mieszkanie", "Kraków",
		// 350000.0, 123123123, "Ładne zadbane mieszkanie z balkonem i widokiem na
		// park."));
		String query1 = "insert into advertisement values (" + house.getId() + ", ' " + house.getType() + "','"
				+ house.getTitle() + "', '" + house.getPlace() + "', " + house.getPrice() + ", "
				+ house.getPhoneNumber() + ", '" + house.getDescription() + "')";
		Database.addQueryToDatabase(query1);
		String query2 = "insert into house values (" + house.getId() + ", " + house.getNumberOfRooms() + ", "
				+ house.getHouseArea() + ", " + house.getLandArea() + ")";
		Database.addQueryToDatabase(query2);
	}
	
	public static void addToDatabaseAdvertiser(Advertiser advertiser) {
		
		String query1 = "insert into advertiser values (" + advertiser.getPhoneNumber() + ", '" + advertiser.getFirstName() + "', '" + advertiser.getLastName() + "', '" + advertiser.getPlace() + "')";
		Database.addQueryToDatabase(query1);
		
	}
	

	/*
	 * Metoda ta wczytuje ogłoszenia z pliku csv dodaje do arrayList, następnie
	 * przekazuje, każde ogłoszenie do kolejnej metody,która wysyła zapytania do
	 * bazy danych i tam dodaje dane do tabel
	 * 
	 */
	public static void loadAll() {
		try {
			File file1 = new File("OgłoszeniaDomy.csv");
			Scanner sc1 = new Scanner(file1);
			int temporary1 = 0;
			while (sc1.hasNextLine()) {
				String str = sc1.nextLine();
				String[] values = str.split(",");
				if (temporary1 > 0) {
					Advertisement ad = new House(values[1], values[2], values[3], Double.parseDouble(values[4]),
							values[5], Integer.parseInt(values[6]), Double.parseDouble(values[7]),
							Double.parseDouble(values[8]));

					ad.setDescription(values[9]);
					ad.setId(Integer.parseInt(values[0]));
					advertisementList.add(ad);
					adwertisementCounter++;
					addToDatabaseHouse(ad);
				}
				temporary1++;
			}
			sc1.close();

			File file2 = new File("OgłoszeniaAutoMotocykl.csv");
			Scanner sc2 = new Scanner(file2);
			int temporary2 = 0;
			while (sc2.hasNextLine()) {
				String str = sc2.nextLine();
				String[] values = str.split(",");
				if (temporary2 > 0 && values[2].equals("Auto")) {
					Advertisement ad = new Car(values[1], values[2], values[3], Double.parseDouble(values[4]),
							values[5], values[6], values[7], values[8], Integer.parseInt(values[9]),
							Integer.parseInt(values[10]), Double.parseDouble(values[11]),
							Double.parseDouble(values[12]));

					ad.setDescription(values[13]);
					ad.setId(Integer.parseInt(values[0]));
					advertisementList.add(ad);
					adwertisementCounter++;
					addToDatabaseCar(ad);
				}
				if (temporary2 > 0 && values[2].equals("Motocykl")) {
					Advertisement ad = new Motorcycle(values[1], values[2], values[3], Double.parseDouble(values[4]),
							values[5], values[6], values[7], values[8], Integer.parseInt(values[9]),
							Integer.parseInt(values[10]), Double.parseDouble(values[11]),
							Double.parseDouble(values[12]));

					ad.setDescription(values[13]);
					ad.setId(Integer.parseInt(values[0]));
					advertisementList.add(ad);
					adwertisementCounter++;
					addToDatabaseMotorcycle(ad);
				}
				temporary2++;
			}
			sc2.close();
			
			File file3 = new File("Ogłoszeniodawcy.csv");
			Scanner sc3 = new Scanner(file3);
			int temporary3 = 0;
			while (sc3.hasNextLine()) {
				String str = sc3.nextLine();
				String[] values = str.split(",");
				if (temporary3 > 0) {
					Advertiser ad = new Advertiser(values[1], values[2], values[3], values[0]);
					advertiserList.put(ad.getPhoneNumber(), ad);
					addToDatabaseAdvertiser(ad);
				}
				temporary3++;
			}
			sc3.close();
		} catch (FileNotFoundException e) {
			System.out.println("Nie ma takiego pliku");
		}
		System.out.println("Wczytano ogłoszeniodawców z pliku.\n");
	}
	
	//Zapisa danych do plików csv na podstawie list i map.
	public static void saveAll() {
		
		try {
			PrintWriter pwAdvertiser = new PrintWriter(new File("Ogłoszeniodawcy.csv"));
			pwAdvertiser.append("Telefon,");
			pwAdvertiser.append("Imię,");
			pwAdvertiser.append("Nazwisko,");
			pwAdvertiser.append("Miejsce");
			pwAdvertiser.append("\n");
			
			advertiserList.forEach((key, value) -> {
				pwAdvertiser.append(value.getPhoneNumber() + ", ");
				pwAdvertiser.append(value.getFirstName() + ", ");
				pwAdvertiser.append(value.getLastName() + ", ");
				pwAdvertiser.append(value.getPlace() + "");
				pwAdvertiser.append("\n");
			});
			
			pwAdvertiser.close();
			
			PrintWriter pwD = new PrintWriter(new File("OgłoszeniaDomy.csv"));
			pwD.append("Id,");
			pwD.append("Typ,");
			pwD.append("Tytuł,");
			pwD.append("Miejsce,");
			pwD.append("Cena,");
			pwD.append("Telefon,");
			pwD.append("Ilość pokoji,");
			pwD.append("Metry^2,");
			pwD.append("Działka,");
			pwD.append("Opis");
			pwD.append("\n");

			for (Advertisement adw : advertisementList) {
				if (adw.getTitle().equals("Dom") || adw.getTitle().equals("Mieszkanie")) {
					House house = (House) adw;
					pwD.append(adw.getId() + ",");
					pwD.append(adw.getType() + ",");
					pwD.append(adw.getTitle() + ",");
					pwD.append(adw.getPlace() + ",");
					pwD.append(adw.getPrice() + ",");
					pwD.append(adw.getPhoneNumber() + ",");
					pwD.append(house.getNumberOfRooms() + ",");
					pwD.append(house.getHouseArea() + ",");
					pwD.append(house.getLandArea() + ",");
					pwD.append(house.getDescription());
					pwD.append("\n");
				}
			}
			pwD.close();

			PrintWriter pwA = new PrintWriter(new File("OgłoszeniaAutoMotocykl.csv"));
			pwA.append("Id,");
			pwA.append("Typ,");
			pwA.append("Tytuł,");
			pwA.append("Miejsce,");
			pwA.append("Cena,");
			pwA.append("Telefon,");
			pwA.append("Marka,");
			pwA.append("Model,");
			pwA.append("Paliwo,");
			pwA.append("Rok,");
			pwA.append("Moc,");
			pwA.append("Przebieg,");
			pwA.append("Pojemność,");
			pwA.append("Opis");
			pwA.append("\n");

			for (Advertisement adw : advertisementList) {
				if (adw.getTitle().equals("Auto")) {

					Car car = (Car) adw;
					pwA.append(adw.getId() + ",");
					pwA.append(adw.getType() + ",");
					pwA.append(adw.getTitle() + ",");
					pwA.append(adw.getPlace() + ",");
					pwA.append(adw.getPrice() + ",");
					pwA.append(adw.getPhoneNumber() + ",");
					pwA.append(car.getMark() + ",");
					pwA.append(car.getModel() + ",");
					pwA.append(car.getFuel() + ",");
					pwA.append(car.getYear() + ",");
					pwA.append(car.getEnginePower() + ",");
					pwA.append(car.getMileage() + ",");
					pwA.append(car.getEngineCapacity() + ",");
					pwA.append(car.getDescription());
					pwA.append("\n");
				}
				if (adw.getTitle().equals("Motocykl")) {
					Motorcycle mot = (Motorcycle) adw;
					pwA.append(adw.getId() + ",");
					pwA.append(adw.getType() + ",");
					pwA.append(adw.getTitle() + ",");
					pwA.append(adw.getPlace() + ",");
					pwA.append(adw.getPrice() + ",");
					pwA.append(adw.getPhoneNumber() + ",");
					pwA.append(mot.getMark() + ",");
					pwA.append(mot.getModel() + ",");
					pwA.append(mot.getFuel() + ",");
					pwA.append(mot.getYear() + ",");
					pwA.append(mot.getEnginePower() + ",");
					pwA.append(mot.getMileage() + ",");
					pwA.append(mot.getEngineCapacity() + ",");
					pwA.append(mot.getDescription());
					pwA.append("\n");
				}
			}
			pwA.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Zapisano ogłoszenia do plików.\n");

	}

	public static void priceRange(String title, double minPrice, double maxPrice) {

		System.out.println("Rozpoczęto wyszukiwanie ogłoszeń.\n");
		int counter = 0;
		for (Advertisement adw : advertisementList) {

			if (title.equals(adw.getTitle())) {
				if (minPrice <= adw.getPrice() && maxPrice >= adw.getPrice()) {
					System.out.println(adw);
					counter++;
				}
			}
		}
		if (counter == 0) {
			System.out.println("Brak ogłoszeń spełniających twoje kryteria.\n");
		} else {
			System.out.println("Ilość ogłoszeń spełniających kryteria: " + counter + "\n");
		}

	}

	public static void maxPriceMinCapacityOrArea(String title, double maxPrice, double minCapacityOrArea) {

		System.out.println("Rozpoczęto wyszukiwanie ogłoszeń.\n");
		int counter = 0;
		for (Advertisement adw : advertisementList) {

			if (title.equals(adw.getTitle())) {
				if (title.equals("Dom") || title.equals("Mieszkanie")) {
					House house = (House) adw;
					if (maxPrice >= house.getPrice() && minCapacityOrArea <= house.getHouseArea()) {
						System.out.println(house);
						counter++;
					}
				}
				if (title.equals("Auto") || title.equals("Motocykl")) {
					Car car = (Car) adw;
					if (maxPrice >= car.getPrice() && minCapacityOrArea <= car.getEngineCapacity()) {
						System.out.println(car);
						counter++;
					}
				}
			}
		}
		if (counter == 0) {
			System.out.println("Brak ogłoszeń spełniających twoje kryteria.\n");
		} else {
			System.out.println("Ilość ogłoszeń spełniających kryteria: " + counter + "\n");
		}

	}

}
