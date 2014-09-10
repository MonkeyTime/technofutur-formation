using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ConsoleApplication6
{
    class Program
    {

        public struct Address
        {
            public int number, cp;
            public string street, city, region;
        }

        public struct Position
        {
            public int degre, minute, seconde;
            public string direction;
        }

        public struct Person
        {
            public string firstname, lastname, email;
            public Address address;
        }

        public struct Payment
        {
            private int account, total;

            public bool is_negative()
            {
                return this.total < 0;
            }

            private void add(int sum)
            {
                this.total += sum;
            }

            public void transfert(object accountNumber, int sumTransfert)
            {
                this.total -= sumTransfert;
            }
        }

        static void Main(string[] args)
        {
            Position position;
            Person person;
            Address address;

            position.degre = 20;
            position.minute = 54;
            position.seconde = 38;

            person.firstname = "Laurent";
            person.lastname = "B";
            person.email = "lol@gmail.tld";

            address.city = "Charleroi";
            address.cp = 6041;
            address.street = "Avenue Jean Mermoz";
            address.number = 3;
            address.region = "Belgium";

            person.address.city = "Liège";
            person.address.cp = 4000;
            person.address.street = "Rue Lorem Ipsum";
            person.address.number = 6;
            person.address.region = "Belgium";

            Console.WriteLine(person.address.street);
            Console.ReadLine();
        }
    }
}
