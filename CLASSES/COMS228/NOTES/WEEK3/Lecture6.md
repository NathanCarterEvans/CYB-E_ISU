*Date:02/02/2024*
*-No Attendance-*
# Homework
- 3 New Zybooks, due Wednesday

# **Summary**
- More class inheritance
- Touching on .equals method 

# **Lecture:**

## Types of Classes:
> Public: anyone in class can view
> Protected: can only be seen by descendants
> Private: kind of pointless for classes. It means no one can see or call it

## .Equals()
 `Obj1 == Obj2` is wrong. when using the ``==`` comparator only compares slots in memory

example:
``` java
p = new Obj1(3); //value = 3; Location in memory = 0xFF01
q = new Obj1(3); //value = 3; Location in memory = 0x01F3

System.Out.Println(p==q)// Prints out false
```

The reason is because 0xFF01 is not the same as 0x01F3. Even though their values are both 3. 
In order to use ``==`` you would have to define what is being compared.

example:
``` java
p = new Obj1(3); //value = 3; Location in memory = 0xFF01
q = new Obj1(3); //value = 3; Location in memory = 0x01F3

System.Out.Println(p.value == q.value)// Prints out true
```

Alternately you can use the `.equals()` method. Every class has this as an inherited method from object.
What this does is instead of comparing points in memory, it compares every value in the Objects;

example:
``` java
p = new Obj1(3); //value = 3; Location in memory = 0xFF01
q = new Obj1(3); //value = 3; Location in memory = 0x01F3

System.Out.Println(p.equals(q))// Prints out true
```

There will be times you want .equals to only compare one variable. in that case you would need to write an @override.

example of object class @override:
``` java
public class Obj1{
	int value;
	public void main(int value){
		this.value = value;
	}
	
	@override
	public Boolean equals(Obj1 obj){
		return obj.value == this.value;
	}
}
```

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

# In class activity
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


