import java.util.Scanner;
import javax.swing.JOptionPane;

public class Calculator
{
	public static void main(String[] arg)
	{
		String shape = arg[0];
		Scanner sc = new Scanner (System.in);
		if(shape.equals("square"))
		{
			int s = Integer.parseInt(arg[1]);
			int A = (s * s);
			JOptionPane.showMessageDialog(null, A);
		}
		
		else if(shape.equals("rectangle"))
		{
			int l = Integer.parseInt(arg[0]);
			int w = Integer.parseInt(arg[1]);
			int A = (l * w);
			JOptionPane.showMessageDialog(null, A);
		}
		
		else if(shape.equals("parallelogram"))
		{
			int b = Integer.parseInt(arg[0]);
			int h = Integer.parseInt(arg[1]);
			int A = (b * h);
			JOptionPane.showMessageDialog(null, A);
		}
		
		else if(shape.equals("trapezoid"))
		{
			double b1 = Double.parseDouble(arg[0]);
			double b2 = Double.parseDouble(arg[1]);
			double d = ((b1 + b2) / 2);
			double A = (d * Double.parseDouble(arg[2]));
			JOptionPane.showMessageDialog(null, A);
		}
		
		else if(shape.equals("triangle"))
		{
			double b = Double.parseDouble(arg[0]);
			double h = Double.parseDouble(arg[1]);
			double A = ((1/2) * b * h);
			JOptionPane.showMessageDialog(null, A);
		}
		
		else if(shape.equals("circle"))
		{
			double pi = 3.14;
			double r = Double.parseDouble(arg[0]);
			double A = pi * r * r;
			JOptionPane.showMessageDialog(null, A);
		}
		
		else if(shape.equals("ellipse"))
		{
			double pi = 3.14;
			double a = Double.parseDouble(arg[0]);
			double b = Double.parseDouble(arg[1]);
			double A = (pi * a * b);
			JOptionPane.showMessageDialog(null, A);
		}
		
		else
		{
			JOptionPane.showMessageDialog(null, "Shape not available for area calculation. Please Try again!"); 
		}
	}
}