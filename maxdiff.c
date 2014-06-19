#include<stdio.h>
main(){
int min,max,i,j,n,k=0;
int arr[]={10,4,2,7,13,-1,11,-2,6,5};
k=sizeof(arr)/sizeof(arr[0]);
int prev=k-1;
min=max=arr[k-1];
for(n=k-2;n>=0;n--)
{if(min>arr[n])
 {
 min=arr[n];
 i=n;
 }
 else if(max<arr[n]){
 if(j>i){
  prev=j;}
  max=arr[n];
  j=n;
} 


 else if((max-arr[n])>(arr[prev]-min))
{i=n;
prev=j;
min=arr[i];

}
}

printf("%d %d",prev,i);
}
