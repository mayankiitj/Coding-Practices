#include<stdio.h>
int josephus(int n,int k)
   { if (n ==1)
      return 1;
    else
      return ((josephus(n-1,k)+k-1) % n)+1;}
int power(int a,int b){
  int i=0,res=1;
  for(;i<b;i++)
   res=res*a;
  return res;}
main(){
 //printf("%d\n", josephus(5,3));
  int i=0,j=0,k,n,count=0,index,min=9,dig,no;
  double res=0;
  scanf("%d",&dig);
  scanf("%d",&no);
  k=no;

while(i<=j){
  i=k%10;
  j=(k%100-i)/10;
  k=k/10;
  count++;
           }


  n=count;
  k=no;
  while(count>0){
   i=k%10;
   k=k/10;
    if(i<min&&i>j)
{    min=i;
     index=n-count;
}
   count--;
}


for(k=dig-1;k>=0;k--)
{ if(k>n)
 {  printf("%d",no/power(10,k));
    no=no-((no/power(10,k))*power(10,k));
 }
  else if(k==n){
    min=no/power(10,index);
    min=min%10;
    printf("%d",min);
    break;     }
}

for(k=0;k<n;k++){
  if(k==index)
    printf("%d",(no/power(10,n))%10);

  else{
    min=(no/power(10,k))%10;
    printf("%d",min);
      }
                     }


}
