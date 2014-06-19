#include<stdio.h>
main(){
int a[11]={3,2,5,3,1,4,2,2,9,7},i,j,k,n=0;

for(i=1;i<=10;i++){
if(a[a[i]]>0&&a[i]>0)
{k=a[i];
a[i]=a[a[i]];
a[k]=-k;}
else if(a[i]>0&&a[a[i]]<0)
a[a[i]]--;
}
for(i=1;i<=10;i++){
if((a[i]>0&&a[a[i]]<0)&&a[i]!=i){
a[a[i]]--;
printf("Not present %d \n",i);
}
else if(a[i]==i)
printf("value=%d repetation=1\n",i);
else{
a[i]=-a[i]-i+1;
printf("value=%d repetation=%d\n",i,a[i]);}
}

}
void getDuplicate(int arr[],int size)
{
    int pos = 0;
    int desiredPos = 0;
    while(pos < size)
    {
        if(arr[pos] <= 0){
          pos++;
         continue;
} 
        desiredPos = arr[pos] -1;
        if(arr[desiredPos] > 0)
        {
            arr[pos] = arr[desiredPos];
            arr[desiredPos] = -1;
        }
        else
        {
            arr[desiredPos]--;
            arr[pos] = 0;
            pos++;
        }
    }
}
