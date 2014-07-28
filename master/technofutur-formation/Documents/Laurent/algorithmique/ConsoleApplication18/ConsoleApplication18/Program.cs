using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication18
{
    class Program
    {
        /**
         * IsA30DaysMonth
         * 
         * Verify if a month is a 30 days month
         * 
         * @param int   The month for verification
         * 
         * @return bool  true on success, false on failure
         * 
         **/
        bool IsA30DaysMonth(int month)
        {
            if (month <= 12 && month > 0 && month != 2)
            {
                return (month <= 7 && IsPair(month)) || (month > 7 && !IsPair(month));
            } 
            //else february month is already false

            return false;
        }

        /** 
         * IsPair
         * 
         * Verify if a number or a digit is pair or impair
         * 
         * @param int       the number or digit for verification
         * 
         * @return bool     true on success, false on failure
         * 
         **/
        bool IsPair(int nbr)
        {
            return nbr % 2 == 0;
        }

        /** 
         * IsBisextile
         * 
         * Verify if a year is a bisextile year
         * 
         * @param int       the year for verification
         * 
         * @return bool     true on success, false on failure
         * 
         **/
        bool IsBisextile(int year)
        {
            return (year % 400 == 0) || (year % 100 != 0 && year % 4 == 0);
        }

        /** 
         * IsAValidDate
         * 
         * verify if the current date is valid
         * 
         * @param int       day
         * @param int       month
         * @param int       year
         * 
         * @return bool     true on success, false on failure
         * 
         **/
        bool IsAValidDate(int day, int month, int year) 
        {
            if (IsA30DaysMonth(month) && day <= 30 && month != 2) 
            {
                return true;
            }
            else if (!IsA30DaysMonth(month) && day <= 31 && month != 2)
            {
                return true;
            }
            else if (month == 2 && day <= 29 && IsBisextile(year)) 
            {
                return true;
            }
            else if (month == 2 && day <= 28 && !IsBisextile(year))
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        /**
         * Main
         * 
         * Main constructor
         * 
         **/
        static void Main(string[] args)
        {
            int day, month, year;
            string rebuild;

            do
            {

                Program ProgObject = new Program();

                Console.WriteLine("jour");
                day = int.Parse(Console.ReadLine());

                Console.WriteLine("mois");
                month = int.Parse(Console.ReadLine());

                Console.WriteLine("année");
                year = int.Parse(Console.ReadLine());

                if (ProgObject.IsAValidDate(day, month, year))
                {
                    Console.WriteLine("GOOD");
                }
                else
                {
                    Console.WriteLine("BAD");
                }

                Console.WriteLine("Continue [yes/no]");

                rebuild = Console.ReadLine();

            } while (rebuild.ToLower() == "yes");
        }
    }
}
