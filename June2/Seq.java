public class Seq
{
    static int isSeq(int arr[])
    {
        int n=arr.length;
        int sum=n*(n+1)/2;
        for(int i=0;i<n;i++)
        {
            if(arr[i]>0&&arr[i]<n)
                sum-=arr[i];
        }
        return sum;
    }

    public static void main(String args[])
    {

        int a[]={2,3,-1,1};
        System.out.println(isSeq(a));
    }

}