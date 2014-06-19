#include<stdio.h>
#include<math.h>
main(){
int arr[10]={2,3,4,-7,5,8,-3,-6,-4,3};
int i,j,count=0,b[10];
b[0]=arr[0];
arr[0]=0;
for(i=1;i<10;i++)
{
  b[i]=b[i-1]+arr[i];
  arr[i]=0;
}
for(i=0;i<10;i++)
{j=b[i]%10;
if(arr[j]==0)
arr[j]=i-1;

else if(count<(i-arr[j]-1)&&b[arr[j]+1]==b[i]){
count=i-arr[j]-1;
}

 
}
printf("%d ",count);
}
