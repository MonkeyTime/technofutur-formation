using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication4
{
    class Program
    {
        static void Main(string[] args)
        {
            double vat, price;

            Console.WriteLine("Taux TVA: ");
            vat = double.Parse(Console.ReadLine());

            Console.WriteLine("Prix article: ");
            price = double.Parse(Console.ReadLine());

            Console.WriteLine("Votre article au prix de htva " + price + " au taux de " + vat + " % vaut tvac " + (price * (1 + (vat / 100))));

            Console.Read();
        }
    }
}
