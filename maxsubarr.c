#include<stdio.h>
#include<stdlib.h>
main(){
int a,b=5,count,i,j,k,max=0;
int arr[]= {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
scanf("%d",&k);
for(i=0;i<10;i++){
if(i-count>=k){
max=0;
i=i-k;
b=1;
continue;}
if(arr[i]>max){
max=arr[i];
count=i;}
if(i>2&&b>=k){
printf("%d\n",max);}
b++;
}

}
