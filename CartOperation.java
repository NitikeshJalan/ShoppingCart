package main;

public interface CartOperation
{
float getInvoiceAmount();
float addToCart(Product p);
void removeFromCart(Product p)throws ProductException;


}
