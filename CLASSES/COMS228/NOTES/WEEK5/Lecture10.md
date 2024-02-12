*Date:02/12/2024*
*-Attendance Was Taken-*
# Homework
- Homework 1, due Feb 23rd

# **Topics**
- Copy shallow vs Deep
- Static Variables
# **Summary**
## Variables
* method Variables: Created as parameters
* Object Variables: Only exists in the current object
* Class Variables: Are static variables, like global but for all objects of this class
* Static: Are a part of the class, only one copy of this var that is shared between all objects of a class

## Shallow Copy
> Shallow copy is making a copy of the face value of an object. 
> You will use this for most cases.

## Deep Copy
>

# **In class**

### **Static**
> Static variables and classes are instance based, if a variable is static then anythign that is in that class can see it and modify it
___

### **Shallow Copying:**
Method 1: Use a copy constructor
Method 2: Write a makeCopy() method
Method 3: Overwrite the clone() method

``` java
public class Point implements Cloneable{// Only implement If using the @Override
	/*
	 * Default constructor
	 */
	Point(){}
	
	/*
	 * Parameterized constructor
	 */
	Point(int x, int y){}
	
	/*
	 * Method 1
	 * Copy Constructor
	 * Creates a new object with the same values
	 */
	Point(Point other){
		x = other.x;
		y = other.y
	}
	
	/*
	 * Method 2
	 * create a function that makes a copy
	 */ 
	public Point makeCopy(){
		Point newPoint = new Point();
		newPoint.x = x;
		newPoint.y = y;
		return newPoint;
	}
	
	/*
	 * Method 3
	 * Override Clone Function
	 * Before doing this we must
	 *  1. make the containing class implement Clonebale
	 *  2. We want to @Override clone() method
	 *  3. We want to catch an exception inside the override
	 */
	@Override
	public Point clone(){
		Point result;
		try{
			result = (Point) super.cone(); // must cast to Current Object
		} catch (CloneNotSupportedException e{
			// Do nothing
		}
		return result;
	}
}

// Example of use
// Copy Constructor
Point p = new point(1,2);
point q = new point(p);

// makeCopy()
Point p = new Point(1,2);
Point q = p.makeCopy();
				 
// Overriding clone()
point p = new Point(1,2);
point q = p.clone(); // Literly just 1:1 copies memory to a new slot
// 0xFF01223 -> 0xAD011
```
