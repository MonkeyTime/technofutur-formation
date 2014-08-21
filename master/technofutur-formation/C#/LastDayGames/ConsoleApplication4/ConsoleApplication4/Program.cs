using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace ConsoleApplication4
{

    delegate void DelegateOff(DateTime now, DateTime life);

    class Program
    {
        public struct Characteristics
        {
            public double weight, height;
        }
        
        public struct Lamp
        {
            public Characteristics dimensions;
            public double lumens, watt, diameter, price;
            public DateTime life_expectancy;
            public string manufacturer, name, colors;
            public bool economic, recyclable;

            public bool TurnOn()
            {
                Console.WriteLine("Lamp On");

                life_expectancy = DateTime.Now.AddMilliseconds(5000);

                return true;
            }

            public bool TurnOff()
            {
                Console.WriteLine("Lamp Off");

                return false;
            }

            public void Life()
            {
                Console.WriteLine("Lamp Life");
            }
        }

        static void Main(string[] args)
        {
            Lamp lamp = new Lamp();

            lamp.manufacturer = "Phillips";
            lamp.name         = "Lumia";
            lamp.colors       = "Metal";
            lamp.economic     = true;
            lamp.recyclable   = true;
            lamp.diameter     = 105.5;
            lamp.dimensions.weight = 10.512;
            lamp.dimensions.height = 89.5;
            lamp.lumens       = 300;
            lamp.watt         = 7.5;
            lamp.price        = 189;

            lamp.TurnOn();

            DateTime now;

            do
            {
                lamp.Life();

                System.Threading.Thread.Sleep(1000);

                now = DateTime.Now; 

            } while (now < lamp.life_expectancy);

            
            if (now >= lamp.life_expectancy)
            {
                lamp.TurnOff();

                Console.WriteLine("Lamp broken");
            }

            Console.ReadLine();
        }
    }
}
