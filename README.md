# JavaStreams
1.Short answer
        a. Name the differences between imperative and functional programming
        b. Explain the meaning of declarative programming. Give an example.
        c. Name the benefits of including functional style programming in Java
    

2)  Use Lambdas and Streams to do the following.  Hard code all the data that you need and Test it Thoroughly!    
   a)  In  ‘Program 4’  of the file I gave you, of complete Java 8 programs (At first ignore the // group Employees by department code in that program) (Run it) :  
        1)  Count the number of last names that begin with the letter  ‘B’.  Print out this number.
        2)  Print out all of the Employee objects whose last name begins with the letter  ‘B’  in sorted order.  
        3)  Print out all of the Employee objects whose last name begins with the letter  ‘B’  and change their first name and last name to be All capital letters.
        4)  Print out All of the employee objects, but if the last name begins with the letter  ‘B’,  then capitalize all the letters in the last name.  
              4.1)  Use the  Collectors.joining  method to print out All Employee objects.  (See my  presentation file  ‘Do_Last_This_Was_Lesson 9_Streams_E.docx’.)  
              4.2)  Use the  Collectors.joining  method to print out All Employee objects, and separate    each one with a delimeter of  “---\n---“.    (See my  presentation file  ‘Do_Last_This_Was_Lesson 9_Streams_E.docx’.)  
        5)  Print out all of the Employee objects’ last names, whose last name begins with the letter  ‘I’  in sorted order, and get rid of all the duplicates.  Print out only the last names.  
        6)  Print out the average of all the salaries.
        7)  Use the  ‘reduce’  method to print out the total salary of all employees.  
        8)  Print out only the first names of all the employees.  Use the  ‘map’  method to accomplish this.  
        9)  Create an infinite stream of even numbers (0, 2, 4, …) and then, eventually print out only the first 20 even numbers from this stream.  

3) 	Implement a method with the following signature and return type:
       public int countWords(List<String> words, char c, char d, int len)
which counts the number of words in the input list words that have length equal to len, that contain the character c, and that do not contain the character d.  Create a solution that uses a lambda expression.  
Hint :  Look at ALL of the methods that are available in the String class.  This will make it easier for you.
