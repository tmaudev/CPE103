/* Program 4: Student
 *
 * Authors: Tyler Mau (tmau) and Jeffrey Tang (jtang14)
 * Date: November 14, 2013
 *
 * Description: Student class that represents a student with an ID and Last Name
 */

public class Student
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

   //Compares Parameter Student ID to This Student ID
   public boolean equals(Object other)
   {
      if(other == null)
      {
         return false;
      }

      if(other instanceof Student)
      {
         if(this.studentID == ((Student)other).studentID)
         {
            return true;
         }
      }
      return false;
   }

   //Return Student Information as String
   public String toString()
   {
      return ("{ id: " + studentID + ", name: " + lastName + " }");
   }

   //Returns Hash Code
   public int hashCode()
   {
      Long temp = studentID;
      return temp.hashCode();
   }
}
