*Date:02/07/2024*
*-Attendance Was Taken-*
# Homework
- Homework 1, due Feb 23rd
- Zybooks due Today
- Zybooks due Monday

# **Topics**
- Exceptions
- Static Variables
# **Summary**
## Exceptions
why do run time exceptions exist? So that the machine can recover and doesn't break anything.
They are used to help understand what is broken in your code. 

# **In class**


Example:
``` java
publi class ErrorTest{
	public void main(){
		
		try{// If anything in here throws an exception the code will stop and go to catch
			File inputFile = new File(fileName);
			FileReader f = new FileReader(file);
			
		} catch (FileNotFoundException e){ // Do this if error is FileNotFoundException
			System.out.println("File not located.");
		}
	}
}

```
