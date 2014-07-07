#include<stdio.h>
main(){
int i,j,k=0;
int a[10];
scanf("%d",&j);
for(i=0;i<10;i++)
a[i]=0;
for(i=9;i>0&&j>1;i--){
if(j%i==0){
a[k]=i;
k++;
j=j/i;
i++;
continue;
}

}
for(i=k-1;i>=0;i--)
printf("%d",a[i]);

}
