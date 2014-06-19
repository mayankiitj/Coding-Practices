#include<stdio.h>
int arr[7][2]={{7,2},{1,3},{2,6},{4,4},{5,1},{8,9},{6,8}};
void bucketsort(int (*p)[2],int n){
  
   int i,j=0,count[9][2],k;
   for(i=0;i<9;i++)
   count[i][0]=0;
   for(i=0;i<7;i++){
   count[p[i][0]][0]=p[i][0];
   count[p[i][0]][1]=p[i][1];
   }
  
  for(i=0;i<9;i++){
if (count[i][0]>0) 
   {arr[j][0]=count[i][0];
    arr[j++][1]=count[i][1]; 
}
}

}

int main()
{
   int n,i,j=1,res,k=0;
   scanf("%d %d",&i,&j);
   bucketsort(arr,7);
    
for(k=0;k<7;k++){
if(arr[k][1]>=i&&arr[k][1]<=j){
printf("%d",arr[k][0]);
break;}}
return 0;
}
