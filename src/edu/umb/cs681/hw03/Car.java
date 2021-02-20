package edu.umb.cs681.hw03;

import java.util.ArrayList;


import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Car{

	private String make, model;
	private int mileage, year;
	private int price;
	private int dominationCount = 0;

	// default constructor
	public Car() {
	}

	// constructor with arguments
	public Car(String make, String model, int mileage, int year, int price) {
		super();
		this.make = make;
		this.model = model;
		this.mileage = mileage;
		this.year = year;
		this.price = price;
	}

	public Car(String make, String model, int year) {
		this.make = make;
		this.model = model;
		this.year = year;
	}

	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public int getMileage() {
		return mileage;
	}

	public int getYear() {
		return year;
	}

	public int getPrice() {
		return price;
	}

	public int getDominationCount() {
		return this.dominationCount;
	}

	public void setDominationCount(Car car, ArrayList<Car> usedCar) {
		int counter = 0;
		for (Car cr : usedCar) {
			// this refer to the car' variable in CarTest class.
			if ((Float.compare(car.getPrice(), cr.getPrice())) > 0) {
				counter++;
			}
			if ((Integer.compare(car.getYear(), cr.getYear())) < 0) {
				counter++;
			}
			if ((Integer.compare(car.getMileage(), cr.getMileage())) > 0) {
				counter++;
			}

			if (counter > 1) {
				this.dominationCount++;
				counter = 0;// compared to another car.
			}
			counter = 0;

		}
	}

	// price
	public static void sortCarByPriceAscending(List<Car> usedCar) {
		usedCar = usedCar.stream().sorted((Car car1 , Car car2) -> (int) (car1.getPrice() - car2.getPrice())).collect(Collectors.toList());
		//print it out
		usedCar.forEach((Car a) -> System.out.println(a.getMake()));
	}

	public static void sortCarByPriceDescending(List<Car> usedCar) {
		usedCar = usedCar.stream().sorted((Car car1 , Car car2) -> (int) (car2.getPrice() - car1.getPrice())).collect(Collectors.toList());
		usedCar.forEach((Car a) -> System.out.println(a.getMake()));
	}

	// Mileage
	public static void sortCarByMileageAscending(List<Car> usedCar) {
		usedCar = usedCar.stream().sorted((Car car1 , Car car2) -> (int) (car1.getMileage() - car2.getMileage())).collect(Collectors.toList());
		usedCar.forEach((Car a) -> System.out.println(a.getMake()));
	}

	public static void sortCarByMileageDescending(List<Car> usedCar) {
		usedCar = usedCar.stream().sorted((Car car1 , Car car2) -> (int) (car2.getMileage() - car1.getMileage())).collect(Collectors.toList());
		usedCar.forEach((Car a) -> System.out.println(a.getMake()));
	}

	// Year
	public static void sortCarByYearAscending(List<Car> usedCar) {
		usedCar = usedCar.stream().sorted((Car car1 , Car car2) -> (int)(car1.getYear() - car2.getYear())).collect(Collectors.toList());
		usedCar.forEach((Car car) -> System.out.println(car.getMake()));
	}

	public static void sortCarByYearDescending(List<Car> usedCar) {
		usedCar = usedCar.stream().sorted((Car car1 , Car car2) -> (int)(car2.getYear() - car1.getYear())).collect(Collectors.toList());
		usedCar.forEach((Car car) -> System.out.println(car.getMake()));
	}

	
	// Pareto
	//ascending means the best cars to the worst cars
	public static void sortCarByParetoAscending(List<Car> usedCar) {
		usedCar = usedCar.stream().sorted((Car car1 , Car car2) -> (int) (car1.getDominationCount() - car2.getDominationCount())).collect(Collectors.toList());
		usedCar.forEach((Car car) -> System.out.println(car.getMake()));
	}
	//descending means the worst cars to the best cars
	public static void sortCarByParetoDescending(List<Car> usedCar) {
		usedCar = usedCar.stream().sorted((Car car1 , Car car2) -> (int) (car2.getDominationCount() - car1.getDominationCount())).collect(Collectors.toList());
		usedCar.forEach((Car car) -> System.out.println(car.getMake()));
	}
	
	@Override
	public String toString() {
		return "Car [make=" + make + ", model=" + model + ", mileage=" + mileage + ", year=" + year + ", price=" + price
				+ "]";
	}

}
