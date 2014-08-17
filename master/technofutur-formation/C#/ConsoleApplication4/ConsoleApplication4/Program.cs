using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Globalization;

namespace ConsoleApplication4
{
    class Program
    {
        private static long CalculateFibonacci(long n)
        {
            if (n == 0) return 0;
            if (n == 1) return 1;
            return CalculateFibonacci(n - 1) + CalculateFibonacci(n - 2);
        }

        private static bool IsPrimeNumber(int x, int y = 2)
        {

            if (x == 2)
            {
                return true;
            } 
            else if (x % y == 0)
            {
                return false;
            }
            else
            {
                if (y < (x / 2))
                {
                    y++;

                    return IsPrimeNumber(x, y);
                }

                return true;
            }
        }

        private static double MakeSquareRoot(double n, int precision)
        {
            double x0 = n;
            
            double x1 = 0;

            for (int i = 0; i < precision; i++)
            {

                x1 = (x0 + (n / x0)) / 2;

                x0 = x1;
            }

            return x1;
        }

        static void Main(string[] args)
        {
            string rebuild;

            do
            {

                Console.WriteLine("Choose operation: 1 Fibonacci, 2 Factoriel, 3 nombre premier, 4 table multiplication 1 à 20, 5 Racine carrée");

                string op = Console.ReadLine();

                int operation = int.Parse(op);

                switch (operation)
                {

                    case 1:

                        StringBuilder str = new StringBuilder();

                        for (int i = 0; i < 25; i++)
                        {

                            str.Append(CalculateFibonacci(i));

                            if (i < 24)
                            {
                                str.Append(",");
                            }
                        }

                        Console.WriteLine(str.ToString());

                        break;

                    case 2:

                        Console.WriteLine("Rentrez un nombre à factoriser");

                        string entry = Console.ReadLine();

                        int nbr;

                        bool ok2 = int.TryParse(entry, out nbr);

                        if (ok2 && nbr >= 1)
                        {
                            int result = 1;

                            StringBuilder str2 = new StringBuilder();

                            for (int i = 1; i <= nbr; i++)
                            {
                                str2.Append(i);

                                if (i < nbr)
                                {
                                    str2.Append(" X ");
                                }

                                if (i == nbr)
                                {
                                    str2.Append(" = ");
                                }

                                result = result * i;
                            }

                            Console.WriteLine(str2.ToString() + result);
                        }


                        break;

                    case 3:

                        Console.WriteLine("Combien de nombre premier voulez-vous ?");

                        string entry3 = Console.ReadLine();

                        int nbr3;

                        bool ok3 = int.TryParse(entry3, out nbr3);

                        if(ok3)
                        {
                            StringBuilder str3 = new StringBuilder();

                            int n = 2; //premier nbr premier = 2 => start @ 2

                            for (int i = 1; i <= nbr3; i++)
                            {
                                if(IsPrimeNumber(n))
                                {
                                    str3.Append(n);

                                    if (i < nbr3)
                                    {
                                        str3.Append(", ");
                                    }
                                }
                                else
                                {
                                    i--;
                                }
                                
                                n++;
                            }

                            Console.WriteLine(str3.ToString());
                        }

                    break;

                    case 4:

                        StringBuilder str4 = new StringBuilder();
                        
                        for (int i = 1; i <= 5; i++)
                        {
                            str4.Append("\n------------\n");

                            str4.Append("Table: " + i);

                            str4.Append("\n------------\n");

                            for (int j = 1; j <= 20; j++)
                            {
                                str4.Append(i + " X " + j + " = " + (i * j) + "\n");
                            }
                        }

                        Console.WriteLine(str4.ToString());

                    break;

                    case 5:

                        Console.WriteLine("Entrez un nombre pour trouver sa racine carrée");

                        string entry5 = Console.ReadLine();

                        double nbr5;

                        bool ok5 = double.TryParse(entry5, out nbr5);

                        if (ok5)
                        {
                            double result5 = MakeSquareRoot(nbr5, 100);

                            int index = result5.ToString().IndexOf(",") + 1;

                            if (index != 0)
                            {
                                Console.WriteLine("La racine carrée de {0} est égal à (précision max 10 décimales): {1}", entry5, result5.ToString().Substring(0, 10 + index));
                            }
                            else
                            {
                                Console.WriteLine("La racine carrée de {0} est égal à: {1}", entry5, result5);
                            }
                        }

                    break;
                }

                Console.WriteLine("Go to menu ? [y|n]");

                rebuild = Console.ReadLine();

            } while (rebuild.ToLower() == "y");
        }
    }
}
