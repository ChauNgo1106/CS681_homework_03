package edu.umb.cs681.hw03;

import java.util.ArrayList;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

public class mainCar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Car car1 = new Car("Lexus", "LS", 10000, 2008, 12500);
		Car car2 = new Car("Toyota", "Camry", 4501, 2012, 15500);
		Car car3 = new Car("Audi", "Q3", 2300, 2019, 35000);
		Car car4 = new Car("Chevrolet", "Malibu", 8800, 2014, 21550);
		ArrayList<Car> usedCar = new ArrayList<>();

		usedCar.add(car1);
		usedCar.add(car2);
		usedCar.add(car3);
		usedCar.add(car4);

		System.out.println("Used cars information");
		System.out.println(car1.toString());
		System.out.println(car2.toString());
		System.out.println(car3.toString());
		System.out.println(car4.toString());
		System.out.println();

		//// Find a min price of car's price from used car
		int min = usedCar.stream().map((Car car) -> car.getPrice()).reduce(0, (result, carPrice) -> {
			if (result == 0)
				return carPrice;
			else if (carPrice <= result)
				return carPrice;
			else
				return result;
		});
		System.out.println("In the list of used Car, the minimum price is : $" + min);
		System.out.println();

		//// Find a max price of car's price from used car
		int max = usedCar.stream().map((Car car) -> car.getPrice()).reduce(0, (result, carPrice) -> {
			if (result == 0)
				return carPrice;
			else if (carPrice >= result)
				return carPrice;
			else
				return result;
		});
		System.out.println("In the list of used Car, the maximum price is : $" + max);
		System.out.println();

		//// Count the number of used Car in the list
		int count = usedCar.stream().map((Car car) -> car.getMake()).reduce(0, (result, carMaker) -> ++result,
				(finalResult, intermediateResult) -> finalResult);
		System.out.println("In the list of used Car, the number of used car is : " + count + " cars");
		System.out.println();
	}

}
