#include<stdio.h>
#include<math.h>
int fact(int n){
int res=1;
while(n>1){
res=res*n;
n--;
}
return res;
}

main(){
int arr[5]={1,2,3,4,5};
int i,j,k,min=0,count=0,size=4;
char a[6];
scanf("%s",a);
for(i=0;i<5;i++){
for(j=i+1;j<5;j++){
if(a[i]>a[j])
min++;}
count+=min*fact(size);
min=0;
size--;
}
printf("%d",count+1);}
