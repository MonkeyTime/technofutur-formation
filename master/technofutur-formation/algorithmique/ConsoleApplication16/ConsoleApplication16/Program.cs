using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication16
{
    class Program
    {
        const int 
            MIN = 1, 
            MAX = 100;
        int
            min, 
            max;
        string 
            pair,
            res;

        /**
         * display
         * 
         * write to the console
         * 
         * @param string    the string to write
         * @param string    the output style (possible choice: inline or block)
         * 
         */
        void display(String str, String type)
        {
            switch (type)
            {
                case "block":
                    Console.WriteLine(str);
                break;

                case "inline":
                default:
                    Console.Write(str);
                break;

            }
        }

        /**
         * listen
         * 
         * Console.ReadLine generic
         * 
         * @return string
         * 
         */
        string listen()
        {
            return Console.ReadLine();
        }

        /**
         * init
         * 
         * initialize the app (user define themself min and max in this step)
         * 
         * @return void
         * 
         */
        void init()
        {
            do {

                display("minimum ? ", "inline");
                min = int.Parse(listen());

                display("maximum ? ", "inline");
                max = int.Parse(listen());

                display("pair or impair ? ", "inline");
                pair = listen();

            } while (!min_max_ok());
        }

        /**
         * min_max_ok
         * 
         * verify if <min> is strictly inferior for <max> and <min> >= MIN and <max> <= MAX
         * 
         * @return bool     true on success, false on failure
         * 
         */
        bool min_max_ok()
        {
            return (min < max) && (min >= MIN) && (max <= MAX);
        }

        /**
         * is_pair
         * 
         * verify if a digit or a number is pair
         * 
         * @return bool     true on success, false on failure
         * 
         */
        bool is_pair(int nbr)
        {
            return nbr % 2 == 0 ? true : false;
        }

        /**
         * get_pair
         * 
         * verify if user want pair or impair
         * 
         * @return bool     true on success, false on failure
         * 
         */
        bool get_pair()
        {
            return pair == "pair" ? true : false;
        }

        /**
         * result
         * 
         * output the result to the console output
         * 
         * @return void
         * 
         */
        void result(bool get_pair)
        {
            res = "";

            for (int i = min; i <= max; i++)
            {
                if (i == min)
                {
                    res += "\r\n";
                }

                res += is_pair(i) && get_pair ? "le carré de " + i + ": " + exponent(i) + "\r\n" : !is_pair(i) && !get_pair ? "le carré de " + i + ": " + exponent(i) + "\r\n" : "\r\n";
            }

            display(res, "block");
        }

        int exponent(int nbr)
        {
            return nbr * nbr;
        }                                                                                                                                                                                                           

        /**
         * Main
         * 
         * Constructor
         * 
         */
        static void Main(string[] args)
        {
            string rebuild;

            Program ProgInst = new Program();

            do {

                ProgInst.init();

                ProgInst.result(ProgInst.get_pair());

                ProgInst.display("Continue ? [yes/no] ", "inline");

                rebuild = ProgInst.listen();

                if (rebuild == "yes")
                {
                    ProgInst.display("", "block");
                }

            } while (rebuild == "yes");
        }
    }
}
