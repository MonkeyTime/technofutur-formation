using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ConsoleApplication3
{
    class Program
    {
        static void Main(string[] args)
        {

            string rebuild;

            do {

                Console.WriteLine("Choose operation: 1 calculate, 2 BBAN verification, 3 BBAN to IBAN conversion");

                string op = Console.ReadLine();

                int operation = int.Parse(op);

                switch(operation) {

                    case 1:
                
                        float nbr1, nbr2;

                        Console.WriteLine("Choisissez un premier nombre");

                        string str1 = Console.ReadLine();

                        Console.WriteLine("Choisissez un deuxième nombre");

                        string str2 = Console.ReadLine();

                        bool ok1 = float.TryParse(str1, out nbr1);

                        bool ok2 = float.TryParse(str2, out nbr2);

                        if (ok1 && ok2)
                        {

                            Console.WriteLine(string.Format("Resultat: division entière: {0}, Modulo: {1}, Division: {2}", (int)nbr1 / (int)nbr2, nbr1 % nbr2, nbr1 / nbr2));
                        }
                        else
                        {
                            Console.WriteLine("Merci de choisir un nombre");
                        }

                    break;

                    case 2:

                        Console.WriteLine("Entrez un BBAN pour vérification");

                        string bban = Console.ReadLine();

                        if (bban.Length == 12)
                        {
                            string lastdigits = bban.Substring(10, 2);

                            string firstdigits = bban.Substring(0, 10);

                            //Console.WriteLine(lastdigits + ' ' + firstdigits);

                            if (long.Parse(firstdigits) % 97 == long.Parse(lastdigits) || long.Parse(firstdigits) % 97 == 0 && lastdigits == "97")
                            {
                                Console.WriteLine("OK");
                            }
                            else
                            {
                                Console.WriteLine("KO");
                            }
                        }
                        else
                        {
                            Console.WriteLine("Merci d'encoder un compte en banque de 12 caractères numériques");
                        }

                    break;

                    case 3:

                        Console.WriteLine("BBAN to IBAN conversion. Merci d' entrez un BBAN");

                        string bban2 = Console.ReadLine();

                        if (bban2.Length == 12)
                        {
                            string lastdigits2 = bban2.Substring(10, 2);

                            string str = string.Format("{0}{1}111400", lastdigits2, lastdigits2);

                            //98 - (mod97(str)) =  control
                            long control = (long)98 - (long.Parse(str) % 97);

                            Console.WriteLine(string.Format("BE{0}{1}", (int)control, bban2));
                        }
                        else
                        {
                            Console.WriteLine("Merci d'encoder un compte en banque de 12 caractères numériques");
                        }

                    break;
                }

                Console.WriteLine("Go to menu ? [y|n]");

                rebuild = Console.ReadLine();

            } while(rebuild.ToLower() == "y");
        }
    }
}