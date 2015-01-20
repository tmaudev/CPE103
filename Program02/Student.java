/* Program 2: Student
 *
 * Authors: Tyler Mau and Jeffrey Tang
 * Date: October 14, 2013
 *
 * Description: Student class that represents a student with an ID and Last Name
 */

public class Student implements Comparable<Student>
{
   //Private Instance Variable to Hold Student ID
   private long studentID;
   //Private Instance Variable to Hold Last Name of Student
   private String lastName;

   //Constructor Creates Student with ID and Last Name
   public Student(long id, String name)
   {
      studentID = id;
      lastName = name;
   }

   //Compares Student to Other Students
   public int compareTo(Student other)
   {
      //Returns Negative If This Student ID < Other Student ID
      if(this.studentID < other.studentID)
      {
         return -1;
      }
      //Returns Positive If This Student ID > Other Student ID
      else if(this.studentID > other.studentID)
      {
         return 1;
      }
      //Return Zero If Equal
      return 0;
   }

   //Return Student Information as String
   public String toString()
   {
      return ("{ id: " + studentID + ", name: " + lastName + " }");
   }
}
