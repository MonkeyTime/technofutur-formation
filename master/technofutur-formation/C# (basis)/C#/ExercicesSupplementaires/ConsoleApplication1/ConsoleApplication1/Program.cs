using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    class Program
    {
        static void Main(string[] args)
        {
            //Test on a first GenericList T type with <string> param
            GenericList<string> myList1 = new GenericList<string>(); //normally with List all is object => casting mendatory, now all in a GenericList of string are string...
            
            //Add method
            myList1.Add("Hello");
            myList1.Add("World");
            
            //overload on Add method for multi Add purpose
            myList1.Add("Bruxelles", "Brussels", "Paris", "Amsterdam", "Florence", "Venise", "New York", "Newark");

            //Remove method
            myList1.Remove("Amsterdam");
            
            //Overload on Remove method for multi Remove purpose
            myList1.Remove("Venise", "Florence");

            //Count method
            double count = myList1.Count();

            Console.WriteLine("\n" + count + " element" + (count > 1 ? "s" : "") + "\n");

            //Now we can use foreach on GenericList<T> (GetEnumerator() implementation) 
            foreach (string item in myList1)
            {
                Console.WriteLine(item);
            }

            //Search method (something like a filter ??)
            GenericList<string> results = new GenericList<string>();
            
            Console.WriteLine("\nType a term to search:\n----------------------\n");
            string term = Console.ReadLine();
            
            results = myList1.Search(term);
            long nbr = results.Count();

            if (nbr > 0)
            {
                int i = 0;
                Console.WriteLine("\nSearch for \"" + term + "\" matched " + nbr + " element" + (nbr > 1 ? "s" : "") + "\n");

                foreach (string result in results)
                {
                    i++;
                    Console.WriteLine(i + ": " + result);
                }
            }
            else
            {
                Console.WriteLine("\nNo results found for your search: " + term);
            }

            //Test on a second GenericList T type with <int> param
            GenericList<int> myList2 = new GenericList<int>(); //normally with new List all is object => casting mendatory, now all in a GenericList of int are int...
            
            //Add method
            myList2.Add(123);
            myList2.Add(456);

            //overload on Add method for multi Add purpose
            myList2.Add(789, 124, 453, 458, 356, 1879, 1874, 1877, 1823, 741, 987, 654);
            
            //Remove method
            myList2.Remove(124);

            //Overload on Remove method for multi Remove purpose
            myList2.Remove(741, 654, 987);

            //Count method
            count = myList2.Count();

            Console.WriteLine("\n--------------------------------------------------------------------------------"+
                "\n" + count + " element" + (count > 1 ? "s" : "") + "\n");

            //Now we can use foreach on GenericList<T> (GetEnumerator() implementation)
            foreach (int item in myList2)
            {
                Console.WriteLine(item);
            }

            //Search method (something like a filter ??)
            GenericList<int> results2 = new GenericList<int>();
            
            Console.WriteLine("\nType a term number to search:\n-----------------------------\n");
            term = Console.ReadLine();
            
            results2 = myList2.Search(term);
            nbr = results2.Count();
            
            if (nbr > 0)
            {
                int i = 0;
                Console.WriteLine("\nSearch for \"" + term + "\" matched " + nbr + " element" + (nbr > 1 ? "s" : "") + "\n");
                
                foreach (int result in results2)
                {
                    i++;
                    Console.WriteLine(i + ": " + result);
                }
            }
            else
            {
                Console.WriteLine("\nNo results found for your search: " + term);
            }

            Console.WriteLine("\n--------------------------------------------------------------------------------"+
                "\nNavigate through 1 Cities, 2 numbers:\n-------------------------------------\n");

            switch (Console.ReadLine())
            {
                case "1":

                    string way = "+";

                    Console.WriteLine("\nUse + and - to navigate through cities, 0 to quit\n");

                    do
                    {
                        way = Console.ReadLine();

                        switch (way)
	                    {
                            case "+":

                                Console.Write("<--     " + myList1.current); //0
                                myList1.MoveNext();
                                Console.Write("   --   " + myList1.current + "   --   "); //1
                                myList1.MoveNext();
                                Console.Write(myList1.current + "     -->\n"); //2
                                myList1.MovePrevious();

                            break;
                            
                            case "-":
                                
                                myList1.MovePrevious();
                                Console.Write("<--     " + myList1.current); //0
                                myList1.MoveNext();
                                Console.Write("   --   " + myList1.current + "   --   "); //1
                                myList1.MoveNext();
                                Console.Write(myList1.current + "     -->\n"); //2
                                myList1.MovePrevious();
                                myList1.MovePrevious();

                            break;

		                    default:
                            break;
	                    }

                    } while (way == "+" || way == "-");

                break;

                case "2":

                    way = "+";

                    Console.WriteLine("\nUse + and - to navigate through numbers, 0 to quit\n");

                    do
                    {
                        way = Console.ReadLine();

                        switch (way)
	                    {
                            case "+":

                                Console.Write("<--     " + myList2.current); //0
                                myList2.MoveNext();
                                Console.Write("   --   " + myList2.current + "   --   "); //1
                                myList2.MoveNext();
                                Console.Write(myList2.current + "     -->\n"); //2
                                myList2.MovePrevious();

                                break;

                            case "-":

                                myList2.MovePrevious();
                                Console.Write("<--     " + myList2.current); //0
                                myList2.MoveNext();
                                Console.Write("   --   " + myList2.current + "   --   "); //1
                                myList2.MoveNext();
                                Console.Write(myList2.current + "     -->\n"); //2
                                myList2.MovePrevious();
                                myList2.MovePrevious();

                                break;

		                    default:
                            break;
	                    }

                    } while (way == "+" || way == "-");

                break;

                default:
                break;
            }

            //Extra: Understand get and set with a set of a + 1 on all values from GenericList<int>
            Console.WriteLine("\n--------------------------------------------------------------------------------" +
                "\nUnderstand automated get & set\n");

            nbr = myList2.Count();

            Console.WriteLine("\n> Values are...\n");

            //Before access to the automated set, values are...
            foreach (int item in myList2)
            {
                Console.WriteLine(item);
            }

            //We set automatically by accessor (only here for example)
            for (int i = 0; i < nbr; i++)
            {
                //Here we access to the automated set system simply by access directly to the this._items[index] (public mode accessor)
                /* property (public access) |           | the new value */
                           myList2[i]             =         myList2[i] + 1;
                /* property (public access) |           | the new value */
                //"the code block for the set accessor is executed when the property is assigned a new value"
                //"The code block for the get accessor is executed when the property is read"
            }

            Console.WriteLine("\n> Now values are...\n");

            //Now values are...
            foreach (int item in myList2)
            {
                Console.WriteLine(item);
            }

            Console.ReadLine();
        }
    }
}
