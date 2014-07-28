using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Diagnostics;
using System.ComponentModel;

namespace ConsoleApplication1
{
    class Program
    {
        static void Main(string[] args)
        {
            ProcessClass processesObjectInstance = new ProcessClass();
            processesObjectInstance.GetConsoleAndManageAll();
        }
    }

    class ProcessClass
    {
        public void GetConsoleAndManageAll()
        {
            const int MAX_WRITE_CHARS = 50;
            string line, rebuild, procName;
            int procPid, i, spaces;

            Process[] processes = Process.GetProcesses();

            //esthetic
            Console.WriteLine("\r\n-------------------------PROCESS----------------------------");
            Console.WriteLine("------------------------------------------------------------");

            foreach (Process Proc in processes)
            {
                line = "PNAME : " + Proc.ProcessName + " ";
                
                //esthetic
                spaces = (MAX_WRITE_CHARS - line.Length);
                for (i= 0; i < spaces; i++)
                {
                    line += ' ';
                }
                line += "PID : " + Proc.Id;

                Console.Write(line + "\r\n");
            }

            //esthetic
            Console.WriteLine("-------------------------------------------------------------");

            do
            {
                Console.WriteLine("kill a new process by pid or by name or exit ? (Choose: pid or name or exit - first letter work also)");

                rebuild = Console.ReadLine();

                if (rebuild.ToLower() == "pid" || rebuild.ToLower() == "p")
                {
                    Console.WriteLine("Choose process by its id");

                    procPid = int.Parse(Console.ReadLine());

                    try
                    {
                        Process ProcLocalById = Process.GetProcessById(procPid);
                        ProcLocalById.Kill();

                    }
                    catch (Exception e)
                    {
                       Console.Write(e.Message);
                    }
                }

                if (rebuild.ToLower() == "name" || rebuild.ToLower() == "n")
                {
                    Console.WriteLine("Choose process by its name");

                    procName = Console.ReadLine();

                    try
                    {
                        Process[] ProcLocalByName = Process.GetProcessesByName(procName);
                        ProcLocalByName[0].Kill();
                    }
                    catch (Exception e)
                    {
                        Console.Write(e.Message);
                    }
                }

            } while ((rebuild.ToLower() == "pid" || rebuild.ToLower() == "name" || rebuild.ToLower() == "p" || rebuild.ToLower() == "n"));
        }
    }
}
