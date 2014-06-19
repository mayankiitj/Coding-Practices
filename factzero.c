#include<stdio.h>
#include<math.h>
main(){
int i,count=0;
double j,k;
scanf("%d",&i);
j=5;
k=1;
while(i/pow(j,k)){
count=count+(int)(i/pow(j,k));
k++;
}
printf("%d",count);}
