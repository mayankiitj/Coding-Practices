/*Given an array of integers and a number x, find the smallest subarray with sum greater than the given value.*/

#include<stdio.h>
main(){
int arr[]={1, 4, 45, 6, 0, 19};
int i,j,k,count=0,m,n=100,high=0,low=0;
scanf("%d",&k);
m=sizeof(arr)/sizeof(int);
while(high <m){
while(count<k&&high<m){
count=count+arr[high++];
//if(count<k)
//high++;
}

printf("%d  %d\n",high,low);
while(count>=k)
{count=count-arr[low];
low++;
if(n>high-low&&count>k){
n=high-low;}}

printf("%d  ",n);
}}
