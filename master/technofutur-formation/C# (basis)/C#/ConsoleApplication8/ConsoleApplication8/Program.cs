using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ConsoleApplication8
{
    class Program
    {
        static void Main(string[] args)
        {
            string rebuild = "", secret = "";
            int type, essai = 0;

            Personne person = new Personne("Laurent", "Bertrand", DateTime.Parse("02/02/1978"));
            Courant account = new Courant(person, "123456789", 1000);
            Epargne epargne = new Epargne(person, "234567890");
            Banque bank = new Banque();

            do
            {
                Console.WriteLine("Secret");
                secret = Console.ReadLine();

                essai++;

            } while (essai <= 2 && secret != "1234");

            if (essai > 2)
            {
                Console.WriteLine("Trop d'essai. Votre carte est bloquée.");
            }
            else
            {
                do
                {
                    Console.WriteLine("Menu: 1 withdraw, 2 deposit, 3 add account, 4 remove account, 5 Ajouter intérêt annuel, 0 exit");
                    type = int.Parse(Console.ReadLine());
                    double sum = 0;
                    int accountType;

                    switch (type)
                    {
                        case 1:

                            Console.WriteLine("1 Compte courant, 2 Compte épargne");
                            accountType = int.Parse(Console.ReadLine());

                            Console.WriteLine("How many ?");
                            sum = double.Parse(Console.ReadLine());

                            if (accountType == 1)
                            {
                                account.Withdraw(sum);
                            }

                            if (accountType == 2)
                            {
                                DateTime date = epargne.DateDernierRetrait;

                                if (date != DateTime.Parse("01/01/0001 00:00:00"))
                                {
                                    Console.WriteLine("Date dernier retrait: " + date);
                                }
                                epargne.Withdraw(sum);
                            }

                        break;

                        case 2:

                            Console.WriteLine("1 Compte courant, 2 Compte épargne");
                            accountType = int.Parse(Console.ReadLine());

                            Console.WriteLine("How many ?");
                            sum = double.Parse(Console.ReadLine());

                            if (accountType == 1)
                            {
                                account.Deposit(sum);
                            }

                            if (accountType == 2)
                            {
                                epargne.Deposit(sum);
                            }

                        break;

                        case 3:

                            bank.AddAccount(account);

                        break;

                        case 4:

                            string numero = account.Number;
                            bank.DeleteAccount(numero);

                        break;

                       
                        case 5:
                            
                            Console.WriteLine("1 Compte courant, 2 Compte épargne");
                            accountType = int.Parse(Console.ReadLine());

                            if (accountType == 1)
                            {
                                account.AppliquerInteret();
                                double sold = account.GetSold();
                                Console.WriteLine("Solde pour votre compte courant après intérêt: " + sold);
                            }

                            if (accountType == 2)
                            {
                                epargne.AppliquerInteret();
                                double sold = epargne.GetSold();
                                Console.WriteLine("Solde pour votre compte épargne après intérêt: " + sold);
                            }

                        break;

                        case 0:
                        default:
                            return;
                    }

                    Console.WriteLine("Continue ? [y|n]");
                    rebuild = Console.ReadLine();

                } while (rebuild.ToLower() == "y");
            }

            Console.ReadLine();
        }
    }
}
