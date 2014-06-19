#include<stdio.h>
#include<math.h>
#include<stdlib.h>
int *prime(int number){
int *arr=(int *)malloc(((number/2)+1)*sizeof(int));
int i,j,count=0;
for(i=0;i<=number/2;i++)
arr[i]=0;
j=number;
for(i=2;i<=j/2;i++){
while(number%i==0&&number>1){
number=number/i;
count++;}
arr[i]=count;
count=0;
}
return arr;
}

main(){
int fact,y,i,j=1;
scanf("%d %d",&fact,&y);
if(y<=fact){
printf("yes\n");
exit(0);
}
int *arr=prime(y);

for(i=2;i<=y/2;i++){
while(arr[i]>0){
if(fact<i*j){
printf("no\n");
exit(0);
}
arr[i]--;
j++;
}
j=1;
}
printf("yes");
}
