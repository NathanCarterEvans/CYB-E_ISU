# Classes
## Making a class
Classes are also referred to as objects. Objects have methods. Every class is automaticaly a child of Object.

structure
``` java
[public, private, protected] {static} {abstract} class [Name] {extends:[Name]}{
	//Methods
}
```

Example:
``` java
public class Obj1{ // non abstract
	// Something
}
```

``` java
public abstract class Obj1{ // abstract class
	// Something
}
```

``` java
public class Obj2 extends Obj1{ // Inherited class
	// something
}
```
 
 ## Abstract:
 >In object-oriented programming, an abstract class is a special kind of class that cannot be instantiated on its own. Think of it as a blueprint for other classes. It's like having a basic idea or a plan for something, but you can't use the plan as it is; you have to build something based on that plan.
>
>Here’s why you might want to use an abstract class:
>
>1. To Provide a Base Template: Abstract classes are great when you have a base class that should define certain functionalities, but the exact implementation of those functionalities should be left to the derived classes. It's like saying, “Hey, any class that comes from me needs to have these methods, but you decide how to do it.”
>
>2. To Avoid Code Duplication: If several classes share common methods or attributes, you can put all these common parts in an abstract class and then inherit them in the other classes. It's a neat way of keeping your code clean and avoiding repeating the same stuff everywhere.
>
>3. To Enforce a Contract for Derived Classes: By defining abstract methods in the abstract class, you ensure that all subclasses implement these methods. It's like setting rules for the subclasses, saying, “If you're going to be my subclass, you've got to include these methods.”
>
>abstract classes are a bit like setting the ground rules for other classes. They provide a template and enforce certain protocols, making sure that all the derived classes follow the same basic design, but allowing each subclass to have its own specific behavior. It's a way to organize and structure your code in a flexible and efficient manner.

# Extends:
> The extends keyword in Java is used to create a subclass of an existing class. This is part of inheritance, which is a key feature of object-oriented programming. Inheritance allows a new class to acquire the properties and behaviors (methods) of an existing class.
>
> breakdown of how it works:
> 
>1. Inheritance: When a class extends another class, it inherits all the non-private methods and properties from the parent (or superclass). This means you can reuse code from the superclass in the subclass.
>
>2. Overriding Methods: In the subclass, you can override methods of the superclass. This means you can provide a specific implementation for a method that was defined in the superclass.
>
>3. Super Keyword: The super keyword is used in the subclass to call the constructor and methods of the superclass.
>
>4. Access Modifiers: The access modifiers like public, protected, and private determine whether inherited classes can access the superclass's fields and methods.

# Methods
Methods are functions within a class. They are what the object can do. For instance a Bird is an object and birds can fly. 

structure
``` java
public class Obj1{
	[public, private, protected] {static} [return type] [name]({[type] [name]}){
		// stuff
	}
}
```

Example:
``` java
// Example Dynamic/Non static
public class Bird{
	int height = 0;
	public void Fly(int distance){ // non static non returning method
		height += distance;
	}
	
	public int getHeight(){ // non static int returning method
		return height;
	}
}

// Example static
public static class Animal{
	int location =0;
	public static void Run(int distance){ // static non returning method
		location += distance;
	}
	
	public static int getLocation(){ // static int returning method
		return location;
	}
}
```

## Main Methods
There are specifc methods that java recognizes by default. One of which is the main method. This method will be run on runtime. 
note, there can only be one main method per class.

Example:
``` java
// Main class named main
public class main{
	public void main(){
		// do something
	}
}

// main class named camera
public class camera{
	public void main(){
		// do something else
	}
}
```
Both classes are acceptable. Note the main method will run anytime the class is referenced as well.
so if you were to make a new camera it would re run  the main method

## Instantiate methods
You can also have a method named the same as your class. This method will run only when the a new form of the class is made, this is were you put your instance variables.

Example: 
``` java
public class Obj1{
	public void Obj1(){
		// do something
	}
}

public class Rectangle{
	int height;
	int width;
	
	public void Rectangle(int width, int height){
		this.width = width;
		this.height = height;
	}
	
	public int area(){
		return width*height;
	}
}
```
