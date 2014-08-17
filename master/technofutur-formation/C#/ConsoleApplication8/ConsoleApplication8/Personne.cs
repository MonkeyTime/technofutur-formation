using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ConsoleApplication8
{
    class Personne
    {
        public string FirstName {get; private set;}
        public string LastName {get; private set;}
        public DateTime BirthDate;

        /**
         * Constructor
         * 
         * @param string    The firstname
         * @param string    The lastname
         * @param DateTime  The birthdate object
         * 
         */
        public Personne(string first, string last, DateTime date)
        {
            this.FirstName = first;
            this.LastName = last;
            this.BirthDate = date;
        }
    }
}
