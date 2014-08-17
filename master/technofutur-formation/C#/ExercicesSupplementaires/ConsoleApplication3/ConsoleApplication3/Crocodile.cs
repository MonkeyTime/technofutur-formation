using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication3
{
    class Crocodile : IAnimal
    {
        private static double _MEDIAN_HYDRATION_RATE = 0.80;
        private static double _MEDIAN_ASSIMILATION_RATE = 0.80;
        private static double _MEDIAN_STRESS_RATE = 0.05;
        private static double _REST_HOURS_RECOMMANDED = 14;
        private static double _MEDIAN_LIFE_EXPECTANCY = 85;

        public double lifetime { get; private set; }

        private double _hydration;
        private double _assimilation;
        private string _name;
        private double _repose;
        private double _exhaust;

        private string _familly = "reptiliens";
        public string familly
        {
            get
            {
                return _familly;
            }
        }

        private double _weight;

        public double weight
        {
            get
            {
                return this._weight;
            }
        }

        public string name
        {
            get
            {
                return this._name;
            }
        }

        public Crocodile(string name, double age, double weight, double hours = 0)
        {

            this._name = name;
            this._weight = weight;
            this.lifetime = _MEDIAN_LIFE_EXPECTANCY - age;
            this._hydration = 0.8;
            this._assimilation = 0.8;
            this._exhaust = (hours / _REST_HOURS_RECOMMANDED) * _MEDIAN_STRESS_RATE;
            this._repose = 1 - _MEDIAN_STRESS_RATE;

            if (this._exhaust > 1)
            {
                this._exhaust = _MEDIAN_STRESS_RATE;
                this._repose = 0;

                Console.WriteLine("Votre crocodile " + this._name + " a fait un long voyage pour arriver dans votre zoo, il doit dormir car son taux de repos est de (0%). Son hydratation est cependant bonne (" + this._hydration * 100 + "%) et sa capacité d'assimilation est de (" + this._assimilation * 100 + "%)\n");
            }
            else
            {
                Console.WriteLine("Votre crocodile " + this._name + " a fait un long voyage pour arriver dans votre zoo mais son taux de repos est encore suffisant (" + this._repose + "%). Son hydratation est cependant bonne (" + this._hydration * 100 + "%) et sa capacité d'assimilation est de (" + this._assimilation * 100 + "%)\n");
            }
        }

        public void Drink(double qt_water)
        {
            if (this._hydration < 1)
            {
                this._hydration += (qt_water * _MEDIAN_HYDRATION_RATE);

                if (this._hydration > 1)
                {
                    this._hydration = 1;
                }
            }

            Console.WriteLine("Votre crocodile " + this._name + " vient de boire, il a un taux d'hydratation de (" + this._hydration * 100 + "%)\n");
        }

        public void Eat(double qt_food)
        {
            if (this._assimilation < 1)
            {
                this._assimilation += (qt_food * _MEDIAN_ASSIMILATION_RATE);

                if (this._assimilation > 1)
                {
                    this._weight += (this._assimilation - 1);
                    this._assimilation = 1;

                    Console.WriteLine("Votre crocodile " + this._name + " vient certainement de grossir, son poid est maintenant estimé à (" + this._weight + " kg)\n");
                }
            }

            Console.WriteLine("La capacité d'assimilation de votre crocodile " + this._name + " est à (" + this._assimilation * 100 + "%)\n");
        }

        public void Sleep(double hours)
        {
            if (this._repose < 1)
            {
                this._repose += (hours / _REST_HOURS_RECOMMANDED) - this._exhaust;

                if (this._repose > 1)
                {
                    this._repose = 1;
                    this._exhaust = _MEDIAN_STRESS_RATE;
                }
            }

            Console.WriteLine("Votre crocodile " + this._name + " vient de dormir, son taux de repos est de (" + this._repose * 100 + "%)\n");
        }
    }
}
