/*
 * Baza danych utworzona w pgAdmin następnie tabele zostały dodane i wypełnione przez ten program.
 * 
 * 
*/
package pl.alx.kpij.Ogloszenia;

import java.io.File;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	
	private static final String server = "jdbc:postgresql://localhost:5432/Advertisement"; 
	private static final String login = "postgres";
	private static final String password = "Post12345";
	
	public Database() {
		
	}
	
	public static void addQueryToDatabase(String sqlQueries) {
		
		try (
				Connection c = DriverManager.getConnection(server, login, password);
				Statement stmt = c.createStatement();
				){
			stmt.executeUpdate(sqlQueries);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	
	public static void saveAdvertiserTableToCSV() {
		
		try (
				Connection c = DriverManager.getConnection(server, login, password);
				Statement stmt = c.createStatement();
				ResultSet result = stmt.executeQuery("select * from advertiser");
				PrintWriter pwAdvertiser = new PrintWriter(new File("OgłoszeniodawcyZBazyDanych.csv"));
				){
			pwAdvertiser.append("Telefon, Imie, Nazwisko, Miejsce\n");
			
			while (result.next()) {
				String firstName = result.getString("first_name");
				String lastName = result.getString("last_name");
				String place = result.getString("place");
				String phoneNumber = result.getString("phone_number");
				
				String advertiser = String.format("%s, %s, %s, %s\n", firstName, lastName, place, phoneNumber);	
				pwAdvertiser.append(advertiser)	;
			}
		} catch (SQLException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}	
	}
	
	public static void saveAdvertisementTableToCSV() {
		
		try (
				Connection c = DriverManager.getConnection(server, login, password);
				Statement stmt = c.createStatement();
				ResultSet result = stmt.executeQuery("select * from advertisement");
				PrintWriter pwAdvertisement = new PrintWriter(new File("OgłoszeniaZBazyDanych.csv"));
				){
			pwAdvertisement.append("Id, Typ, Tytuł, Miejsce, Cena, Telefon, Opis\n");
			
			while (result.next()) {
				int id = result.getInt("id");
				String type = result.getString("type");
				String title = result.getString("title");
				String place = result.getString("place");
				double price = result.getDouble("price");
				int phoneNumber = result.getInt("phone_number");
				String description = result.getString("description");
				
				String advertisement = String.format("%d, %s, %s, %s, %.2f, %d, %s\n", id, type, title, place, price, phoneNumber, description);	
				pwAdvertisement.append(advertisement)	;
			}
		} catch (SQLException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}	
	}
	
	public static void saveHouseTableToCSV() {
		
		try (
				Connection c = DriverManager.getConnection(server, login, password);
				Statement stmt = c.createStatement();
				ResultSet result = stmt.executeQuery("select * from house");
				PrintWriter pwHouse = new PrintWriter(new File("DomyZBazyDanych.csv"));
				){
			pwHouse.append("Id, Ilość pokoji, Metry^2, Działka\n");
			
			while (result.next()) {
				int id = result.getInt("id");
				int numberOfRooms = result.getInt("number_of_rooms");
				double houseArea = result.getDouble("house_area");
				double landArea = result.getDouble("land_area");
				
				String house = String.format("%d, %d, %.2f, %.2f\n", id, numberOfRooms, houseArea, landArea);	
				pwHouse.append(house);
			}
		} catch (SQLException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}	
	}
	
	public static void saveCarsTableToCSV() {
		
		try (
				Connection c = DriverManager.getConnection(server, login, password);
				Statement stmt = c.createStatement();
				ResultSet result = stmt.executeQuery("select * from cars");
				PrintWriter pwCars = new PrintWriter(new File("AutaZBazyDanych.csv"));
				){
			pwCars.append("Id, Marka, Model, Paliwo, Rok, Moc, Przebieg, Pojemność\n");
			
			while (result.next()) {
				int id = result.getInt("id");
				String mark = result.getString("mark");
				String model = result.getString("model");
				String fuel = result.getString("fuel");
				int year = result.getInt("year");
				int enginePower = result.getInt("engine_power");
				double mileage = result.getDouble("mileage");
				double engineCapacity = result.getDouble("engine_capacity");
				
				String car = String.format("%d, %s, %s, %s, %d, %d, %.2f, %.2f\n", id, mark, model, fuel, year, enginePower, mileage, engineCapacity);	
				pwCars.append(car);
			}
		} catch (SQLException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}	
	}
	
	public static void saveMotorcyclesTableToCSV() {
		
		try (
				Connection c = DriverManager.getConnection(server, login, password);
				Statement stmt = c.createStatement();
				ResultSet result = stmt.executeQuery("select * from motorcycles");
				PrintWriter pwMotorcycles = new PrintWriter(new File("MotocykleZBazyDanych.csv"));
				){
			pwMotorcycles.append("Id, Marka, Model, Paliwo, Rok, Moc, Przebieg, Pojemność\n");
			
			while (result.next()) {
				int id = result.getInt("id");
				String mark = result.getString("mark");
				String model = result.getString("model");
				String fuel = result.getString("fuel");
				int year = result.getInt("year");
				int enginePower = result.getInt("engine_power");
				double mileage = result.getDouble("mileage");
				double engineCapacity = result.getDouble("engine_capacity");
				
				String car = String.format("%d, %s, %s, %s, %d, %d, %.2f, %.2f\n", id, mark, model, fuel, year, enginePower, mileage, engineCapacity);	
				pwMotorcycles.append(car);
			}
		} catch (SQLException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}	
	}
	
	
	public static void showAllAdvertisement() {

		System.out.println("Lista wszystkich ogłoszeń wczytana z bazy danych:");
		
		try (
				Connection c = DriverManager.getConnection(server, login, password);
				Statement stmt = c.createStatement();
				ResultSet result = stmt.executeQuery("select * from advertisement");
				){
			while (result.next()) {
				String type = result.getString("type");
				String title = result.getString("title");
				String place = result.getString("place");
				double price = result.getInt("price");
				String phoneNumber = result.getString("phone_number");
				String description = result.getString("description");
				System.out.printf("\n%s %s w miejscowości %s za %.2fzł. Mój numer to: %s.\n%s\n", type, title, place, price, phoneNumber, description);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	public static void showAllAdvertisers(String orderBy) {
		
		String sqlQuery;
		if (orderBy.equals("ascent")) {
			sqlQuery =  "select * from advertiser order by last_name asc";
		} else {
			sqlQuery =  "select * from advertiser order by last_name desc";
		}
		System.out.println("Lista wszystkich ogłoszeniodawców wczytana z bazy danych:");
		
		try (
				Connection c = DriverManager.getConnection(server, login, password);
				Statement stmt = c.createStatement();
				ResultSet result = stmt.executeQuery(sqlQuery);
				){
			while (result.next()) {
				String firstName = result.getString("first_name");
				String lastName = result.getString("last_name");
				String place = result.getString("place");
				String phoneNumber = result.getString("phone_number");
				System.out.printf("\n%s %s z miejscowości %s, numer telefonu: %s.\n", firstName, lastName, place, phoneNumber);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	public static void showAllAdvertisementFromOneAdvertiser(String phoneNumberString) {
		
		int counter = 0;
		try (
				Connection c = DriverManager.getConnection(server, login, password);
				Statement stmt = c.createStatement();
				ResultSet result = stmt.executeQuery("select * from advertisement left join advertiser using(phone_number) where phone_number = '" + phoneNumberString + "';");
				){
			while (result.next()) {
				String type = result.getString("type");
				String title = result.getString("title");
				String place = result.getString("place");
				double price = result.getInt("price");
				String phoneNumber = result.getString("phone_number");
				String description = result.getString("description");
				String firstName = result.getString("first_name");
				String lastName = result.getString("last_name");
				if (counter == 0) {
					System.out.printf("\nWszystkie oferty wystawione przez %s %s\n", firstName, lastName);
				}
				counter++;
				System.out.printf("\n%s %s w miejscowości %s za %.2fzł. Mój numer to: %s.\n%s\n", type, title, place, price, phoneNumber, description);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	public static void showAllHouseAdvertisement(String orderBy) {
		
		System.out.println("Lista ogłoszeń kupna/sprzedaży domów i mieszkań wczytana z bazy danych:");
		String sqlQuery;
		if (orderBy.equals("ascent")) {
			sqlQuery =  "select * from advertisement join house using(id) order by price asc";
		} else {
			sqlQuery =  "select * from advertisement join house using(id) order by price desc";
		}
		try (
				Connection c = DriverManager.getConnection(server, login, password);
				Statement stmt = c.createStatement();
				ResultSet result = stmt.executeQuery(sqlQuery);
				){
			while (result.next()) {
				String type = result.getString("type");
				String title = result.getString("title");
				String place = result.getString("place");
				double price = result.getInt("price");
				String phoneNumber = result.getString("phone_number");
				String description = result.getString("description");
				int numberOfRooms = result.getInt("number_of_rooms");
				double houseArea = result.getInt("house_area");
				double landArea = result.getInt("land_area");
				String landAreaString;
				if (landArea > 0) {
					landAreaString = title + " posiada działkę o powierzchni " + landArea;
				} else {
					landAreaString = title + " nie posiada działki.";
				}
				System.out.printf("\n%s %s w miejscowości %s za %.2fzł. Mój numer to: %s.\nIlość pokoji to %d, a powierzchnia %s wynosi %.2f. %s\n%s\n", type, title, place, price, phoneNumber, numberOfRooms, title, houseArea,landAreaString, description);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	public static void showAllVehiclesAdvertisement(String vehicle) {
		
		String sqlQuery;
		if (vehicle.equals("cars")) {
			System.out.println("\nLista ogłoszeń kupna/sprzedaży samochodów wczytana z bazy danych:");
			sqlQuery = "select * from advertisement join cars using(id)";
		} else {
			System.out.println("\nLista ogłoszeń kupna/sprzedaży motocykli wczytana z bazy danych:");
			sqlQuery = "select * from advertisement join motorcycles using(id)";
		}
		
		try (
				Connection c = DriverManager.getConnection(server, login, password);
				Statement stmt = c.createStatement();
				ResultSet result = stmt.executeQuery(sqlQuery);
				){
			while (result.next()) {
				String type = result.getString("type");
				String title = result.getString("title");
				String place = result.getString("place");
				double price = result.getInt("price");
				String phoneNumber = result.getString("phone_number");
				String description = result.getString("description");
				String mark = result.getString("mark");
				String model = result.getString("model");
				int year = result.getInt("year");
				double mileage = result.getInt("mileage");
				double engineCapacity = result.getDouble("engine_capacity");
				String fuel = result.getString("fuel");
				int enginePower = result.getInt("engine_power");
				
				System.out.printf("\n%s %s w miejscowości %s za %.2fzł. Mój numer to: %s.\n%s %s z %d roku, ma przejechane %.1fkm. %s ma silnik o pojemności %.2f %s, który generuje %d KM.\n%s\n", type, title, place, price, phoneNumber, mark, model, year, mileage, title, engineCapacity, fuel, enginePower, description);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}




/*
 * Kilka zapytan do baz danych do pgAdmin
 * 
 * --select * from advertisement;
 * --select * from advertisement left join advertiser using(phone_number);
 * --select * from advertisement join house using(id);
 * --select * from advertisement join cars using(id);
 * --select * from advertisement join motorcycles using(id);
 * --select * from advertisement join motorcycles using(id) join advertiser using(phone_number);
 * --drop table advertisement;
 * --delete from motorcycles
 * 
 * create table Advertisement (id int primary key, type text, title text, place text, price decimal, phone_Number text, description text)
 * create table Advertiser (phone_Number text primary key, first_Name text, last_Name text, place text)
 * create table Cars (id int, mark text, model text, fuel text, year int, engine_Power int, mileage decimal, engine_Capacity decimal)
 * create table Motorcycles (id int, mark text, model text, fuel text, year int, engine_Power int, mileage decimal, engine_Capacity decimal)
 * create table House (id int, number_Of_Rooms int, house_Area decimal, land_Area decimal)
 * 
 * 
 * 
*/

