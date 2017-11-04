using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Assignment
{
    public partial class Form1 : Form
    {
        Random random = new Random();
        static long total_time = 0;
        List<string> icons = new List<string>()
        {
            "!","!","N","N",",",",","k","k",
            "b","b","v","v","w","w","z","z"
        };

        Label first, second;
        public Form1()
        {
            InitializeComponent();
            assign_icon();

        }

        private void assign_icon()
        {
            Label label;
            int random_num;
            for (int i = 0; i < tableLayoutPanel1.Controls.Count; i++)
            {
                if (tableLayoutPanel1.Controls[i] is Label)
                {
                    label = (Label)tableLayoutPanel1.Controls[i];
                }
                else
                {
                    continue;
                }
                random_num = random.Next(0, icons.Count);
                label.Text = icons[random_num];
                //to ensure not always repeated
                icons.RemoveAt(random_num);
            }
        }

        private void label_click(object sender, EventArgs e)
        {
            //possible three is clicked within the third time

            if (first != null && second != null)
            {
                return;
            }

            //to make sure the type is Label ; null if not
            Label click_label = sender as Label;
            if (click_label == null)
            {
                return;
            }

            //check if he clicks twice the same
            if (click_label.ForeColor == Color.Black)
            {
                return;
            }

            //check if its the first icon is clicked
            if (first == null)
            {
                first = click_label;
                first.ForeColor = Color.Black;
                return;
            }

            //for second click
            second = click_label;
            second.ForeColor = Color.Black;

            winner_done();

            if (first.Text == second.Text)
            {
                first = null;
                second = null;
            }
            else
            {
                //start timer to either disable
                timer1.Start();
            }
        }

        private void winner_done()
        {
            Label label;
            for(int i=0;i<tableLayoutPanel1.Controls.Count;i++){
                label = tableLayoutPanel1.Controls[i] as Label;
                if (label != null && label.ForeColor == label.BackColor)
                {
                    return;
                }
            }
            total_time = total_time / 60;
            MessageBox.Show("You won,Congrats!"+ "\nScore : "+total_time);
            Close();
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            total_time = total_time + 750;
            timer1.Stop();
            first.ForeColor = first.BackColor;
            second.ForeColor = second.BackColor;

            first = null;
            second = null;
        }
    }
}
