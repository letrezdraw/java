public class one
{
    public static void main (String[] args)
    {
        if (args.length == 0)
        {
            System.err.println("Plz enter a number as arrgument");
            return;
        }
        else
        {
            int myNumber = Integer.parseInt(args[0]);

            System.out.println(myNumber);
        }
    }
}