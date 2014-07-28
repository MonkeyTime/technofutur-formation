using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication17
{
    class Program
    {
        /**
         * exponent
         * 
         * @param int   the number inserted by the user
         * @param int   the exponent from the user
         * 
         * @return int  result
         * 
         */
        int exponent(int nbr, int exp)
        {
            int res = nbr;

            for(int i = 1; i < exp; i++)
            {
                res = res * nbr;
            }

            return res;
        }

        /**
         * display
         * 
         * @param int   the result to display
         * 
         * @return void
         * 
         */
        void display(int res)
        {
            string str = "";

            str += "resultat: " + res + "\r\n";

            Console.Write(str);
        }

        /**
         * Main
         * 
         * Constructor
         * 
         */
        static void Main(string[] args)
        {
            int nbr, exp;
            string rebuild;

            do {
                Program ProgObj = new Program();

                Console.Write("Nombre ou chiffre ? ");
                nbr = int.Parse(Console.ReadLine());

                Console.Write("Exposant ? ");
                exp = int.Parse(Console.ReadLine());

                ProgObj.display(ProgObj.exponent(nbr, exp));

                Console.Write("Continue ? [yes/no] ");

                rebuild = Console.ReadLine();

            } while (rebuild == "yes");
        }
    }
}
