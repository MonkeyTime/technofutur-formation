using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ConsoleApplication7
{
    class Program
    {

        public struct SecondDegre
        {
            public double A, B, C; 
            public double? X1, X2;

            public bool Resoudre(double a, double b, double c)
            {
                double delta;

                this.A = a;
                this.B = b;
                this.C = c;

                delta = (this.B * this.B) - (4 * (this.A * this.C));

                if (delta > 0)
                {
                    this.X1 = (-this.B + Math.Sqrt(delta)) / (2 * this.A);
                    this.X2 = (-this.B - Math.Sqrt(delta)) / (2 * this.A);

                    return true;
                }
                
                if (delta == 0)
                {
                    this.X1 = this.X2 = -(this.B / (2 * this.B));

                    return true;
                }

                this.X1 = this.X2 = null;

                return false;
            }
        }

        static void Main(string[] args)
        {
            string rebuild;

            do
            {
                Console.WriteLine("Enter value of A != 0, B & C");

                double a, b, c;

                bool ok1 = double.TryParse(Console.ReadLine(), out a);
                bool ok2 = double.TryParse(Console.ReadLine(), out b);
                bool ok3 = double.TryParse(Console.ReadLine(), out c);

                if (ok1 && ok2 && ok3)
                {
                    SecondDegre equation = new SecondDegre();

                    bool result = equation.Resoudre(a, b, c);

                    if (result)
                    {
                        if (equation.X1 == equation.X2)
                        {
                            Console.WriteLine(string.Format("Admet une racine double \n{0}", equation.X1));
                        }
                        else
                        {
                            Console.WriteLine(string.Format("Deux solutions admises \n{0}\n{1}", equation.X1, equation.X2));
                        }
                    }
                    else
                    {
                        Console.WriteLine("Pas de solution réelle.");
                    }
                }

                Console.WriteLine("Return to menu ? [y|n]");

                rebuild = Console.ReadLine();

            } while (rebuild.ToLower() == "y");
        }
    }
}
