#include<stdio.h>
int arr[]={1, 11, 8, 9, 10, 14};
main(){
int s=sizeof(arr)/sizeof(int);
int i,j,current,max=0,low=0,high=0;
for(i=1;i<s;i++){
low=0;
high=0;
for(j=0;j<i;j++){
if(arr[j]<arr[i]&&arr[j]>low)
low=arr[j];
}
for(j=i+1;j<s;j++){
if(arr[j]>arr[i]&&arr[j]>high)
high=arr[j];
}
current=high*low*arr[i];
if(current>max){
max=current;
printf("%d %d %d\n",low,high,arr[i]);
}
}
printf("%d",max);
}
