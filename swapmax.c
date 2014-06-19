#include<stdio.h>
#include<stdlib.h>
int glob=1;
 int * swap(int *arr,int count)
 {
    int i,temp;

  for(i=count;i>0;i--)
   {
     temp=arr[i];
     arr[i]=arr[i-1];
     arr[i-1]=temp;}
    return arr;
 }
  void max(int n,int *arr,int a)
 {
      int big=0,i,count;
      if(n>0){
        for(i=0;i<=n;i++)
  {
          if(big<arr[i])
   {
           big=arr[i];
            count=i;
    } 
  }
      n=n-count;
      printf("%d",arr[count]);
      arr=swap(arr,count);
      
      a=a-1;
      max(n,arr+glob,a);
 }
      else{
      int m=0;
     
      while(m<a)
    {printf("%d",arr[m]);
     m++;
      
    }
      exit(0);}
 }
  main()
 {
    int i,j,k,a;
    int *arr;
    scanf("%d",&k);
    scanf("%d",&a);
    arr = malloc(a * sizeof(int ));
      for(i=0;i<a;i++)
        scanf("%d",&arr[i]);
    max(k,arr,a);

 }
