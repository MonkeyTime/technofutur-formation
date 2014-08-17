using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication3
{
    interface IAnimal
    {
        /*
        protected static double _MEDIAN_HYDRATION_RATE;
        protected static double _MEDIAN_ASSIMILATION_RATE;
        protected static double _MEDIAN_STRESS_RATE;
        protected static double _REST_HOURS_RECOMMANDED;
        protected static double _MEDIAN_LIFE_EXPECTANCY;
         */

        string familly { get; }
        string name { get; }
        double lifetime { get; }

        void Drink(double qt_water);
        void Eat(double qt_food);
        void Sleep(double hours);
    }
}
