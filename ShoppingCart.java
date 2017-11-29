package main;
import java.util.*;
public class ShoppingCart implements CartOperation 
{
	float tax_percentage, invoiceAmount;
	static ArrayList<Product> shop = new ArrayList<Product>();
	
	public ShoppingCart(float tax_percentage)
	{
		this.tax_percentage=tax_percentage;
	}
	public static void main(String args[])throws ProductException
	{
		Product p1= new Product("Keyboard",400,2);
		Product p2= new Product("Pendrive",300,2);
		Product p3= new Product("Camera",3000,1);
		CartOperation cart = new ShoppingCart(10);
		//cart.removeFromCart(p3);
		cart.addToCart(p1);
		cart.addToCart(p2);
		cart.addToCart(p3);
		cart.removeFromCart(p1);
		System.out.println(cart.getInvoiceAmount());
		System.out.println(cart);
	}

	
	public float addToCart(Product p)
	{
		float cost;
		shop.add(p);
		cost=(p.price*p.quantity)+((tax_percentage/100)*p.price*p.quantity);
		invoiceAmount =invoiceAmount +cost;
		return cost;
	}
	
	public void removeFromCart(Product p)
	{
		float cost;
		try
		{
			if(shop.size()==0)
			{
				throw new ProductException("No Items to remove");
			}
			else
			{
				shop.remove(p);
				cost=(p.price*p.quantity)+((tax_percentage/100)*p.price*p.quantity);
				invoiceAmount =invoiceAmount -cost;
			}
		}
			catch(ProductException e)
		{
		System.out.println(e);
		}
	}
	
	public float getInvoiceAmount()
	{
		return invoiceAmount;
	}
	public String toString()
	{
		String name="";int i;
		String name_list[] = new String [shop.size()];
		Product p=null;
		for(i=0;i<shop.size();i++)
		{
			p=shop.get(i);
		     name_list[i]=p.name;
	}
		for(String n :name_list)
			name=name+n;
		return name;
			
	}
	
}