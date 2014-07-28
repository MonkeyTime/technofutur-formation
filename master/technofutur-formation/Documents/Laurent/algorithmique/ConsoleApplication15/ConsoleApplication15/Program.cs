using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication15
{
    class Program
    {
        const int nbrMat = 5;
        double[] points = new double[nbrMat];

        public void encode()
        {
            for (int i = 0; i < nbrMat; i++)
            {
                output("Encode pts course " + (i + 1));
                points[i] = double.Parse(Console.ReadLine());
            }
        }

        public void output(String str)
        {
            Console.WriteLine(str);
        }

        public void display()
        {
            for (int i = 0; i < nbrMat; i++)
            {
                output("Pts course " + (i + 1) + ": " + points[i]);
            }
        }

        public double average()
        {
            double sum = 0;

            for (int i = 0; i < nbrMat; i++)
            {
                sum += points[i];
            }

            return sum / nbrMat;
        }

        /**
         * A procedure == (function that return no result) can contain other procedure(s)
         * 
         */
        
        /*
        public void init()
        {
            encode();
            display();
        }
        */

        static void Main(string[] args)
        {
            Program ProgInst = new Program();

            ProgInst.encode();
            ProgInst.display();

            ProgInst.output("Average: " + ProgInst.average());

            Console.Read();
        }
    }
}
