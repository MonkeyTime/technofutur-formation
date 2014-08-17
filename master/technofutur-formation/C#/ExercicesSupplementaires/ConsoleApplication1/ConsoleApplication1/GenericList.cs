using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    class GenericList<T>
    {
        private List<T> _items;

        public T this[int index]
        {
            get
            {
                return (T)_items[index];
            } 
            set //Only here to demonstrate automated set
            {
                _items[index] = value;
            }
        }

        /**
         * @attr private _current   Init current
         * 
         */
        private int _current = 0;

        /**
         * Navigate through this (_items reference object type T => public get)
         * 
         */
        public T current
        {
            get { return this[_current]; }
        }

        /**
         * Constructor
         * 
         */
        public GenericList()
        {
            this._items = new List<T>();
        }

        /**
         * Add
         * 
         * Method to add an item to a GenericList
         * 
         * @param U:T   Item to add
         * 
         * @return void
         * 
         */
        public void Add<U>(U item) where U : T
        {
            this._items.Add(item);
        }

        /**
         * Remove
         * 
         * Method to remove an item from a GenericList
         * 
         * @param U:T   Item to remove
         * 
         * @return void
         * 
         */
        public void Remove<U>(U item) where U : T
        {
            this._items.Remove(item);
        }

        /**
         * Add
         * 
         * Overload of local Method Add to add multi items to a GenericList
         * 
         * @params U:T[]   Items to add (params chained)
         * 
         * @return void
         * 
         */
        public void Add<U>(params U[] items) where U : T
        {
            for (int i = 0; i < items.Length; i++)
            {
                this._items.Add(items[i]);
            }
        }

        /**
         * Remove
         * 
         * Overload of local Method Remove to remove multi items from a GenericList
         * 
         * @params U:T[]   Items to remove (params chained)
         * 
         * @return void
         * 
         */
        public void Remove<U>(params U[] items) where U : T
        {
            for (int i = 0; i < items.Length; i++)
            {
                this._items.Remove(items[i]);
            }
        }

        /**
         * Count
         * 
         * Count items from a GenericList
         * 
         * @return long
         * 
         */
        public long Count()
        {
            return this._items.Count;
        }

        /**
         * GetEnumerator
         * 
         * foreach available on GenericList<T> type
         * 
         * @yield return IEnumerator
         * 
         */
        public IEnumerator GetEnumerator()
        {
            foreach (T item in _items)
            {
                if (item == null)
                {
                    continue;
                }

                yield return item;
            }
        }

        /**
         * Search
         * 
         * Search term in a GenericList
         * 
         * @param string        Pattern to search
         * 
         * @return GenericList  GenericList of results with only the matched results
         * 
         */
        public GenericList<T> Search(string pattern)
        {
            Regex regex = new Regex(pattern, RegexOptions.Compiled | RegexOptions.IgnoreCase);

            GenericList<T> results = new GenericList<T>();

            for (int i = 0; i < this.Count(); i++)
            {
                string str = this._items[i].ToString();

                foreach (Match match in Regex.Matches(str, @"" + pattern + ""))
                {
                    results.Add(_items[i]);
                }
            }

            return results;
        }

        /**
         * MoveNext
         * 
         * Set current = current + 1 or Set to key zero
         * 
         * @return void
         * 
         */
        public void MoveNext()
        {
            _current++;

            if (_current >= _items.Count)
            {
                _current = 0;
            }
        }

        /**
         * MovePrevious
         * 
         * Set current = current - 1 or Set to latest key
         * 
         * @return void
         * 
         */
        public void MovePrevious()
        {
            _current--;

            if (_current < 0)
            {
                _current = _items.Count - 1;
            }
        }
    }
}
