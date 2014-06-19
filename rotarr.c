#include<stdio.h>
main(){
int *p,*b,*c;
int n,i,k;
scanf("%d",&n);
int a[n];
for(i=0;i<n;i++)
scanf("%d",&a[i]);
scanf("%d",&k);
p=a;
b=(p+k);
c=p;
p=b;
for(i=0;i<k;i++){
printf("%d ",*p);
p++;}
p=c;
n=n-k;
while(n>0)
{
printf("%d ",*p);
p++;
n--;}
printf("\n");

}
