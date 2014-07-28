using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication11
{
    class Program
    {
        /** 
         * init
         * 
         * general: display to the user a multiplication table of its choice
         * 
         * @input string choice  the choice from the user (a digit choice included from 1 to 9)
         * 
         */
        static void Main(string[] args)
        {
            int     choice, i, spaces, j;
            string  rebuild, stdOutTxt;
            const int MAX_WRITE_CHARS = 39;
            
            do
            {
                Console.WriteLine("\r\nChoisir un chiffre entre 1 et 9");

                choice = int.Parse( Console.ReadLine());
                i      = 1;
            
                if (choice > 0 && choice < 10)
                {
                    //esthetic
                    Console.WriteLine("\r\n------------------RESULT-------------------");
                    Console.WriteLine("-------------------------------------------");

                    while (i <= 10)
                    {
                        //esthetic
                        stdOutTxt = "--- ";
                        
                        stdOutTxt += "Table multiplication " + choice + ": " + choice + " x " + i + " = " + (choice * i);

                        //esthetic
                        spaces = (MAX_WRITE_CHARS - stdOutTxt.Length);
                        for (j = 0; j < spaces; j++)
                        {
                            stdOutTxt += ' ';
                        }

                        //esthetic
                        stdOutTxt += " ---";

                        Console.WriteLine(stdOutTxt);

                        //esthetic
                        if (i == 10)
                        {
                            Console.WriteLine("-------------------------------------------");
                            Console.WriteLine("-------------------------------------------\r\n");
                        }
                        
                        i++;
                    }
                }
                else
                {
                    Console.WriteLine(choice + " n'est pas un chiffre entre 1 et 9");
                }

                Console.WriteLine("\r\nContinue ? yes or no");

                rebuild = Console.ReadLine();

            } while (rebuild.ToLower() == "yes");
        }
    }
}
