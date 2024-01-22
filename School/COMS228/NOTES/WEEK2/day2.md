# **NO ZYBOOKS UNTIL WEDNESDAY**
## **SUM**
What was talked about -

- Class Policies
- Class Structure
- "Fluffiest Lecture" - LOL
- OOP
- ADT

#
## **Class Policies:**

- Programming HW - Up to 3 days late with no penelty
- Zybooks - Check daily for updates
- Lowest 2 Lectures dropped - read PDF of the day

#
## **Lecture - OOP:**

**Topics:**

- inheritance
- objects have state
- objects have identity
- polymorphism

#
## **Inheritance**
Vehicle
->Truck
->Car
->->Sports Car
->SUV
``` java
public class Car { //this makes a car object to be called
	int fule;
	int mpg;
	static void Car(int fule, int mpg) {
		this.fule = fule;
		this.mpg = mpg;
	}
	static void Drive(){
		***
	}
}

public class SUV extends Car { 
	static void SUV(){
		***
	}
	
	static void Tow(){
		***
	}
	
}

public class Main {
	static void main(){
		SUV Saturn = new SUV(100, 25); //makes a new car SUV
		Saturn.Tow();
		Saturn.Drive();
	}
}
```

#
## **Polymorphism**
Classes use other classes
``` java
public class Car { //this makes a car object to be called
	int fule;
	int mpg;
	static void Car(int fule, int mpg) {
		this.fule = fule;
		this.mpg = mpg;
	}
}

public class Main { 
	static void main(){
		Car SUV = new Car(100, 25); //makes a new car SUV
		System.out.println(SUV.fule);
	}
}
```

#
## **Lecture Code**
``` java
Interface ISUID{
	boolean contains(int id);
	add(int id);
	int size();
}

public class ISUProcessor implements ISUID{
	int size;
}
```
```
Speed
Functionality:		Sorted Arr.:		Unsorted Arr:
size()			Instant			Instant
add()			Linear O(n)		Instant
contains()		Logarithmic		Linear
```
