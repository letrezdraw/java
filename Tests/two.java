import java.util.Scanner;

class product{
    int id;
    String name;
    double price;

    product(int id, String name, double price)
    {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    void display()
    {
        System.out.println("ID : "+this.id+" ,Name : "+this.name+" ,price : "+this.price);
    }
}


public class two {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a product number : ");
        int n = sc.nextInt();

        product[] products = new product[n];

        for (int i=0; i < n; i++)
        {
            System.out.println("Enter details for product "+(i+1)+" :");
            System.out.println("ID : ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.println("Name: ");
            String name = sc.nextLine();
            System.out.println("Price :");
            Double price = sc.nextDouble();
            products[i] = new product(id, name, price);
        }

        product minPriceProduct = products[0];
        for(int i = 1; i < n; i++)
        {
            if(products[i].price < minPriceProduct.price)
            {
                minPriceProduct = products[i];
            }
        }
        System.out.println("product with minimum price : "+ minPriceProduct.name);
        sc.close();
    }

}
