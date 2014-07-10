/*sort array having 01 without counting*/
#include<stdio.h>
int arr[]={0,1,1,0,0,1,1,1,0,1};
main(){
int i=0,j,s,count=0;
s=sizeof(arr)/sizeof(int);
j=s-1;
while(i<j){
while(arr[i]==0){
i++;}
if(i<j){
while(arr[j]==1){
j--;
}}
if(arr[i]==1&&arr[j]==0){
count=arr[i];
arr[i]=arr[j];
arr[j]=count;}
}
for(i=0;i<s;i++)
printf("%d ",arr[i]);

}
