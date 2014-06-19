#include<stdio.h>

int countSetBits(int n)
{
    unsigned int count = 0;
    while (n)
    {
      n &= (n-1) ;
      count++;
    }
    return count;
}
 
void bucketsort(int (*p)[2],int n){
  
   int i,j=0,count[n][10],k;
   for(i=0;i<n;i++)
   count[i][0]=0;
   for(i=0;i<9;i++){
   count[p[i][0]][0]++;
   count[p[i][0]][count[p[i][0]][0]]=p[i][1];
   }
  for(i=0;i<n;i++){
   k=1;
   for(;count[i][0];count[i][0]--){
     printf("%d  ",count[i][k]);
      k++;
}
}

}

/* Program to test function countSetBits */
int main()
{
   int n,i,j=1,res,k=0;
   scanf("%d",&n);
   for(i=1;i<n;i++){
    j=2*j;
    if(n<j)
    {k=i+1;
     break;
}
else if(n==j)
{k=i+2;
break;
}
}

   int arr[n][2];
   for(i=0;i<n;i++)
  {
     res=countSetBits(i+1);
     arr[i][1]=i+1;
     arr[i][0]=res; 
}
  bucketsort(arr,k);
    return 0;
}
