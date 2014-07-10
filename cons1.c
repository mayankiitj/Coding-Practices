/*Given a positive integer N, count all possible distinct binary strings of length N such that there are no consecutive 1′s.*/
#include<stdio.h>
main(){
int n;
scanf("%d",&n);
int a[n],b[n];
int i=1,j,k;
a[0]=b[0]=1;
while(i<n){
a[i]=a[i-1]+b[i-1];
b[i]=a[i-1];
i++;
}
printf("%d",a[n-1]+b[n-1]);
}
