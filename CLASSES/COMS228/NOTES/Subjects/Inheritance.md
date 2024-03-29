# Code Reference
## Inheritance: 
> Using insects and bugs we learn how to type cast and understand inheritance.
# Code
### Bee
``` java
package insect;

public class Bee extends Insect implements Locomotion, Pollination, Cloneable
{
	private String swarm; 
	
	public Bee(int size, String color, String swarm)
	{
		super(size, color);
		this.swarm = swarm; 
	}
	
	public String getSwarm()
	{
		return swarm; 
	}
	
	@Override
	public void move()
	{
		System.out.println("fly"); 
	}
	
	@Override 
	public void attack()
	{
		System.out.println("sting"); 
	}
	
	@Override
	public boolean pollinate()
	{
		return true; 
	}
	
	public void makeHoney()
	{
		System.out.println("Orange Blossom"); 
	}


	@Override
	public boolean equals(Object o)   
	{
		if (o == null || o.getClass() != getClass())
		{
			return false;
		}
	
		// typecast o to Bee so that we can compare data members
		Bee b = (Bee) o;
	
		// Compare the data members and return accordingly
		return b.size == size  
			     && (b.color == color || b.color != null && b.color.equals(color))
			     && (b.swarm == swarm || b.swarm != null && b.swarm.equals(swarm));
	}
	

	@Override
	public Object clone()   
	{
		try
		{
			// default clone() does field-by-field copying, thus of the values  
			// of size, color, and swarm 
			Bee b = (Bee) super.clone(); 
			return b; 
		}
		catch (CloneNotSupportedException e)
		{
			return null;
		} 
		
		// an alternative below, without calling super.clone(), is 
		// considered against the API practice of creating a copy of 
		// an object at runtime without knowing its type.
//		Bee b = new Bee(size, color, swarm); 
//		return b;
	}
	
}
```

### Grasshopper

``` java
package insect;

public abstract class Grasshopper extends Insect implements Locomotion 
{	
	public Grasshopper(int size, String color)
	{
		super(size, color); 
	}

	@Override
	public void move()
	{
		System.out.println("hop"); 
	}
	
	
	@Override 
	public void attack()
	{
		System.out.println("bite"); 
	}

	public String feedOn()
	{
		return "grass"; 
	}
	
	public abstract String antennae();
}
```

### Insect
``` java
package insect;


public abstract class Insect implements Comparable<Insect> 
{
	protected int size;			// inches 
	protected String color;
 
	
	public Insect(int size, String color) 
	{
		this.size = size;
		this.color = color;
	}

	public int getSize() 
	{
		return size;
	}

	public String getColor() 
	{
		return color;
	}
	
	@Override 
	public int compareTo(Insect i)
	{
	    return size - i.getSize();
	}  

	public abstract void attack();	
}
```

### InsectComparator

``` java
package insect;

import java.util.Comparator;

public class InsectComparator implements Comparator<Insect>
{
	@Override
	public int compare(Insect i1, Insect i2)
	{
	    return i1.getSize() - i2.getSize();
	}  
}
```

### Katydid
``` java
package insect;

public class Katydid extends Grasshopper
{
	public Katydid(int size, String color) 
	{
		super(size, color); 
	}

	@Override
	public String feedOn()
	{
		return "variety"; 
	}
	
	@Override
	public String antennae()
	{
		return "Long"; 
	}
}
```

### Locomotion
``` java
package insect;

public interface Locomotion 
{
	void move(); 
}
```

### Locust
``` java
package insect;

public class Locust extends Grasshopper
{
	public Locust(int size, String color)
	{
		super(size, color); 
	}
	
	
	@Override
	public String antennae()
	{
		return "Short"; 
	}
}
```

### Mantis
``` java
package insect;

public class Mantis extends Insect implements Locomotion, Pollination
{
	public Mantis(int size, String color)
	{
		super(size, color); 
	}
	
	@Override
	public void move()
	{
		System.out.println("crawl"); 
	}
	
	@Override 
	public boolean pollinate()
	{
		return false; 
	}

	@Override 
	public void attack()
	{
		System.out.println("strike"); 
	}
		
	public Grasshopper preyOn()
	{
		return new Locust(3, "Brown"); 
	}
}
```

### Pollination
``` java
package insect;

public interface Pollination 
{
	boolean pollinate(); 
}
```


# Abstract Classes
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

example:
``` java
public class abstract Obj1{
	public void DoSomething();
	public void DoSomethingElse();
}
```



# Extends
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

example:
``` java
public class abstract Obj1{
	public void DoSomething();
	public void DoSomethingElse();
}

public class Obj2 extends Obj1{
	
	public void DoSomething(){ // without this there is an error
		//Something
	}
	
	public void DoSomethingElse(){ // without this there is an error
		//Something Else
	}
}
```

# Coding Examples/Practice
1. 
``` java		
		Locomotion l; 	 // okay 
		Grasshopper g;   // okay
```

2. 
``` java
		// no instantiation of an interface variable 
		// compile error: Cannot instantiate the type Pollination 
		Pollination p = new Pollination(); 
		
		// no instantiation of an abstract class variable 
		// compile error: Cannot instantiate the type Insect
 		Insect i = new Insect(3, "Green"); 
		
		// same instantiation error 
		Insect i = new Grasshopper(2, "Brown");  
```

3. 
``` java
		Katydid k = new Katydid(3, "Green"); 

		Grasshopper g = k; 
		
		Locomotion l = new Katydid(3, "Brown"); 

		g = l;   // compile error: Cannot convert from Locomotion (supertype) to Grasshopper (subtype)

		// how to fix? 
		// downcast 
		g = (Locust) l; 
		g = (Katydid) l; // compile okay; ClassCastException thrown at execution
```

4. 		
``` java		
		Grasshopper g = new Locust(3, "Red"); 
		Katydid k = (Katydid) g; // ClassCastException thrown at execution 
			

		// compile error: Type mismatch cannot convert from Mantis to Grasshopper 
		g = new Mantis(4, "Green"); 
```

5.  
``` java 
		// static type: Locomotion 
		// dynamic type: Katydid 
		Locomotion l = new Katydid(3, "Brown"); 
		l.attack();  // attack() undefined for Locomotion (static type) 
```
		
6. 
``` java		
		// static type: Locomotion (interface)
		// dynamic type: Locust ->  Bee 
		Locomotion l = new Locust(2, "Black"); 
		l.move();  // "hop" - use the version for Grasshopper (closest ancestor of dynamic type)

		l = new Bee(1, "Gold", "Hill"); 
		l.move();  // "fly" - use the version for Bee (dynamic type) 
```
		
7.  
``` java
		// static type: Insect (abstract class) 
		// dynamic type: Katydid -> Mantis 
		Insect i = new Katydid(2, "Green"); 
		i.attack();  // "bite" 

		i = new Mantis (4, "Green"); 
		i.attack();  // "strike"
```

8. 
``` java	
		// static type: Insect
		// dynamic type: Katydid 
		Insect k = new Katydid(3, "Green"); 
		
		k.attack();  // "bite" 
		
		k.antenna(); // antenna() is undefined for Insect
```
		
9. 
``` java
		// static type: Grasshopper
		// dynamic type: Katydid 
		Grasshopper g = new Katydid(3, "Golden"); 
		System.out.println(g.feedOn()); // "variety"  not "grass"
```
		
10. 		
``` java			
		Pollination p = new Bee(1, "Golden-Black", "Lake"); 
		
		// compile error: getSwarm() undefined method for Pollination (static type)
		p.getSwarm(); 

		// how to fix? downcast 
		((Bee) p).getSwarm();  // "Lake" 
```
		
11. 
``` java			
	    	Mantis m = new Mantis(5, "Green"); 
	   	m.move();  // "crawl"

	    	Insect i = m.preyOn(); 
	    	i.move();  // compile error: move() undefined method for Insect

	    	// how to fix? 
	    	((Grasshopper) i).move();  // "hop"	
```

12. 
``` java		
		Insect i = new Mantis(4, "Yellow"); 
		((Mantis) i).move();    // "crawl" 
		((Mantis) i).preyOn().attack();  // preyOn() returns a Locust object; "bite" 

		i = new Bee(1, "Golden-Black", "Hill"); 
		((Bee) i).makeHoney();  // "Orange Blossom"
```

13. 
``` java 
		// upcasting a class variable to a superclass is not useful other than fooling 
		// the compiler.  There are two reasons: 
		// 
		//   1. The class already inherits every method that the superclass is willing to share. 
		//   2. In case of a call to a method, implemented by both the class and this superclass,
		//      the version for the class is always invoked following the principle of dynamic binding. 
        	Mantis m = new Mantis(4, "Green"); 
        	((Insect) m).attack();  // "strike" 
        
        	// ClassCastException: Mantis cannot be cast to Bee
        	((Bee) ((Insect) m)).makeHoney(); 
```
