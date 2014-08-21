using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication5
{
    class Avion
    {
        private string _fuel_type;
        
        private string _company;
        
        public string owner
        {
            get
            {
                return _company;
            }

            private set;
        }

        private string _latest_vendor;
        
        private int _places;
        
        public int places
        {
            get
            {
                return _places;
            }

            private set;
        }

        private int _price;

        private DateTime _purchase_date;

        public DateTime proprietary_since
        {
            get
            {
                return _purchase_date;
            }

            private set;
        }

        private double _last_refuel_quantity;

        public double last_refuel_quantity
        {
            get
            {
                return _last_refuel_quantity;
            }
            
            private set;
        }
        
        /**
         * Constructor
         * 
         */
        public Avion(string company, string fuel_type, int places)
        {
            this._company = company;
            this._fuel_type = fuel_type;
            this._places = places;
        }

        /**
         * Sell
         * 
         * @param string    The vendor
         * @param string    The buyer
         * @param int       The price
         * @param DateTime  The purchase date 
         * 
         */
        public void Sell(string vendor, string buyer, int price, DateTime date) 
        {
            this._company = buyer;
            this._latest_vendor = vendor;
            this._price = price;
            this._purchase_date = date;
        }

        /**
         * CanStartRefuel
         * 
         * @param string    The gasoline type
         * 
         * @return bool
         * 
         */
        public bool CanStartRefuel(string fuel_type)
        {
            if (this._fuel_type != fuel_type)
            {
                return false;
            }

            return true;
        }

        /**
         * OnEventEndRefuel
         * 
         * @param double    The gasoline quantity in galon
         * 
         * @return void
         * 
         */
        public void OnEventEndRefuel(double galon)
        {
            this._last_refuel_quantity = galon;
        }
    }
}
