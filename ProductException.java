package main;

public class ProductException extends Exception
{
	static final long serialVersionUID = -127902024009412L;
String error;
ProductException(String error)
{
System.out.println(error);

}
}
