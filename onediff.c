#include<stdio.h>
main(){
int a;
int arr[]={4 ,3 ,2 ,3 ,2, 1 ,2 ,3 ,4, 5 ,6};
scanf("%d",&a);
int i=0;
while(i<11){

if(arr[i]-a==0)
{
printf("%d",i);
break;
}
else if(arr[i] - a <0)
i+=a-arr[i];
else
i+=arr[i]-a;
}

}
