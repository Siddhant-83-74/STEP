#include<iostream>
#include<vector>
using namespace std;
int moveZeroes(vector <int> &nums)
{
int slow=0;
    for(int fast=1;fast<nums.size();fast++)
    {
        if(nums[slow]==0&&nums[fast]!=0)
        {
            int temp=nums[slow];
            nums[slow]=nums[fast];
            nums[fast]=temp;
        }

        if(nums[slow]!=0)
            slow++;
    }
    

}

int main()
{
vector<int> a={3,4,0,1};
for(int i=0;i<a.size();i++)
    cout<<a[i]<<endl;
cout<<endl;
moveZeroes(a);

for(int i=0;i<a.size();i++)
    cout<<a[i]<<endl;

}