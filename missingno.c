#include<stdio.h>
int binary(int *arr,int k,int p){
int i=k,j=p,cnt=(i+j)/2;
while(i<j&&cnt!=i&&cnt!=j){
if(arr[cnt]-arr[i]!=cnt-i)
{
j=cnt;
printf("j=%d\n" ,j);
}
else {
i=cnt;
printf("i=%d\n" ,i);}

cnt=(i+j)/2;}

return i;
}
main()
{
int arr[]={1,9,10,11,12,13,14,18,19};
int i=binary(arr,0,8);

printf("%d\n" ,arr[i]+1);
}
