#include<stdio.h>
main(){
int a[11]={1,4,5,7,8,9,2,3,6,10,11};
int i,j,k,count=0;
for(i=1;i<11;i++){
if(a[i]<a[i-1])
j=i;
}
count=j;
for(i=0;i<count||j<11;){
if(a[i]<=a[j])
{printf("%d ",a[i]);
i++;
}
else if(a[i]>a[j])
{printf("%d ",a[j]);
j++;
}
if(i==count)
{while(j<11){
printf("%d ",a[j]);
j++;}
}
if(j==11)
while(i<count){
printf("%d ",a[i]);
i++;}
}
}
