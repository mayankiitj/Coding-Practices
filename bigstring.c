#include<stdio.h>
#include<string.h>
int arr[26];
void arr_zero(int arr[26]){
   int j;
   for(j=0;j<26;j++)
     arr[j]=0;
}
 
main(){

 char str[50];
  int count=0;
  scanf("%s",str);
  int i,j=1,k,min=0,max=0,n,res=0,m=0;
  arr_zero(arr);
  for(i=0;i<strlen(str);i++){
   k=str[i]-97;
   arr[k]=i;
   if(i==0)
    arr[k]=27;
   for(j=i+1;j<strlen(str);j++){
    n=str[j]-97;
   
   if(arr[n]==0)
    arr[n]=j;
   else
    break;
}
  for(k=0;k<=j;k++)
  {if(arr[k]!=0)
   {count++;
   //printf("%d ",k);
}
   else{
   if(res<count){
    min=m;
    res=count;}
    m=arr[k+1];
    count=0;} 
  
  
}
 if(res<count)
  res=count;
  count=0;
  i=arr[n];
  arr_zero(arr);
 
}

printf("%d",res);
}
