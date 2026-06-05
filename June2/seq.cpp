#include<iostream>
#include<vector>
using namespace std;
int missingSeq(vector <int> &arr)
{
    int n=arr.size();
    int sum=n*(n-1)/2;
    for(int i=0;i<n;i++)
    {
        if(arr[i]>0&&arr[i]<n)
            sum-=arr[i];
    }

    return sum;
    

}

int main()
{
vector<int> a={3,4,-1,1};
int res=missingSeq(a);
cout<<res;

}