using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ConsoleApplication5
{
    class Program
    {
        private static bool IsPrimeNumber(int x, int y = 2)
        {

            if (x == 2)
            {
                return true;
            }
            else if (x == 1)
            {
                return false;
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

        protected static int origRow;
        protected static int origCol;

        protected static void WriteAt(string s, int x, int y)
        {
            try
            {
                Console.SetCursorPosition(origCol + x, origRow + y);
                Console.Write(s);
            }
            catch (ArgumentOutOfRangeException e)
            {
                Console.Clear();
                Console.WriteLine(e.Message);
            }
        }

        static void Main(string[] args)
        {
            string rebuild;

            do
            {
                Console.Clear();

                Console.WriteLine("Choose operation: 1 nombre premier, 2 nombre premier (optimisé), 3 string.ToCharArray, 4 quit");

                string op = Console.ReadLine();

                if (op != "")
                {
                    int operation = int.Parse(op);

                    switch (operation)
                    {

                        case 1:

                            Console.Clear();

                            Console.WriteLine("Entrez un nombre pour découvrir les nombres premiers avant ce nombre");

                            string entry1 = Console.ReadLine();

                            int nbr1;

                            bool ok1 = int.TryParse(entry1, out nbr1);

                            if (ok1)
                            {
                                ArrayList list = new ArrayList();

                                int i = 0;

                                while (i < nbr1)
                                {
                                    if (IsPrimeNumber(i))
                                    {
                                        list.Add(i);
                                    }

                                    i++;
                                }

                                int count = list.Count;
                                int j = 0;
                                StringBuilder str1 = new StringBuilder();

                                foreach (int item in list)
                                {
                                    j++;

                                    str1.Append(item);

                                    if (j != count)
                                    {
                                        str1.Append(", ");
                                    }
                                }

                                str1.Append("\n");

                                Console.Clear();

                                Console.Write(str1.ToString());
                            }
                            else
                            {
                                Console.Clear();

                                Console.Write("Merci de choisir un nombre\n");
                            }

                        break;


                        case 2:

                            Console.Clear();

                            Console.WriteLine("Entrez un nombre pour découvrir les nombres premiers avant ce nombre (version optimisée)");

                            string entry2 = Console.ReadLine();

                            int nbr2;

                            bool ok2 = int.TryParse(entry2, out nbr2);

                            if (ok2)
                            {
                                Dictionary<int, int> dico = new Dictionary<int, int>();

                                int i = 0;

                                for (int j = 0; j <= nbr2; j++)
                                {
                                    if (IsPrimeNumber(j))
                                    {
                                        dico.Add(i, j);
                                        i++;
                                    }
                                }

                                int count = dico.Count;
                                int k = 0;
                                StringBuilder str2 = new StringBuilder();

                                foreach (KeyValuePair<int, int> item in dico)
                                {
                                    k++;

                                    str2.Append("dico[" + item.Key + "] = " + item.Value);

                                    if (k != count)
                                    {
                                        str2.Append(", ");
                                    }
                                }

                                str2.Append("\n");

                                Console.Clear();

                                Console.Write(str2.ToString());
                            }
                            else
                            {
                                Console.Clear();

                                Console.Write("Merci de choisir un nombre\n");
                            }

                        break;


                        case 3:

                            Console.Clear();
                            
                            Console.WriteLine("Introduisez un premier nombre");

                            string entry3 = Console.ReadLine();

                            Console.WriteLine("Introduisez un second nombre");

                            string entry4 = Console.ReadLine();

                            double nbr3, nbr4;

                            bool ok3 = double.TryParse(entry3, out nbr3);

                            bool ok4 = double.TryParse(entry4, out nbr4);

                            if (ok3 && ok4)
                            {
                                Array arr3 = entry3.ToCharArray();
                                Array arr4 = entry4.ToCharArray();

                                List<int> array3 = new List<int>();
                                List<int> array4 = new List<int>();

                                int count3 = arr3.Length;
                                int count4 = arr4.Length;


                                int c4 = count4;
                                
                                //We add some zero @ the new dynamic Array (List) 
                                //for a more simple and easy addition in the next step
                                while (c4 > count3)
                                {
                                    array3.Add(0);
                                    c4--;
                                }
                                
                                foreach (char item in arr3)
                                {
                                    array3.Add(int.Parse(item.ToString()));
                                }
                                
                                int c3 = count3;

                                //We add some zero @ the new dynamic Array (List) 
                                //for a more simple and easy addition in the next step
                                while (c3 > count4)
                                {
                                    array4.Add(0);
                                    c3--;
                                }
                                
                                foreach (char item in arr4)
                                {
                                    array4.Add(int.Parse(item.ToString()));
                                }

                                int i = 0;

                                //To clean the console
                                Console.Clear();
                                origRow = Console.CursorTop;
                                origCol = Console.CursorLeft;

                                WriteAt("Repo", 0, 0);
                                WriteAt("   +", 0, 2);
                                WriteAt("   =", 0, 4);

                                int len = count3 > count4 ? count3 : count4;
                                
                                //We build a new array for the rest of each calculation, 
                                //array with n cases + 1 for (maybe) a rest @ the addition of the last 2 digits.
                                int[] rest = new int[len + 1];

                                //We loop reverse to scribe from right to left in the console application
                                for(int j = len - 1; j != -1; j--) //cheating - 1 to not get each j arrays keys with blabla[j + 1] (except the rest)
                                {
                                    // The result of addition from each digits (by column)
                                    int result = (int)rest[j+1] + (int)array3[j] + (int)array4[j]; // The sum of the rest + the two digits.

                                    //Maybe a rest for the next calculation ?? Build-it and push-it to the good array
                                    if (result > 9)
                                    {
                                        rest[j] = (int)rest[j] + 1; //rest 1 (default value of array of int is zero for others report)
                                        result = result - 10; //We want to display only the last char if result > 9
                                    }

                                    int whitespace = (len - 1) - i + 6; //Calculate general whitespace

                                    WriteAt(rest[j].ToString(), whitespace - 1, 0); //We write the rest to the console with whitespace correction
                                    WriteAt(array3[j].ToString(), whitespace, 1); // We write the good digit for operande 1
                                    WriteAt(array4[j].ToString(), whitespace, 2); // We write the good digit for operande 2
                                    WriteAt("-", whitespace, 3); // We write the end of line
                                    WriteAt(result.ToString(), whitespace, 4); // We write the sum of the 2 digits + its rest.
                                    
                                    if (j == 0 && rest[0] == 1) // We write the 1 if the rest is lonely @ end of calculation
                                    {
                                        WriteAt("-", whitespace - 1, 3);
                                        WriteAt("1", whitespace - 1, 4);
                                    }

                                    i++; //We increase the i for digits positions (whitespaces)

                                    System.Threading.Thread.Sleep(1000); //Sleep to show the app work
                                }

                                Console.WriteLine("\n");
                            }
                            else
                            {
                                Console.Clear();

                                Console.Write("Merci de choisir des nombres\n");
                            }

                        break;

                        case 4:

                            return;
                    }
                }

                Console.WriteLine("Go to menu ? [y|n]");

                rebuild = Console.ReadLine();

            } while (rebuild.ToLower() == "y");
        }
    }
}