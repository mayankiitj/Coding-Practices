#include<stdio.h>
#include<stdlib.h>
int a,k;
int ** allzero(int **p,int i,int j){
int a1 ,b;

for(a1=0;a1<a;a1++){
 p[a1][j]=0;
}
for(a1=0;a1<k;a1++){
 p[i][a1]=0;
}
return(p);
}
main(){
int i,j;
scanf("%d %d",&a,&k);

int **arr = malloc(a * sizeof(int *));

for(i = 0; i < a; i++) {
    arr[i] = malloc(k * sizeof(int));
}
int count[a][k];
for(i=0;i<a;i++){
 for(j=0;j<k;j++){
  count[i][j]=0;
}}
for(i=0;i<a;i++){
 for(j=0;j<k;j++){
   scanf("%d",&arr[i][j]);
  if(arr[i][j]==0)
    count[i][j]=1;
}}
for(i=0;i<a;i++){
 for(j=0;j<k;j++){
 if(count[i][j]==1)
   arr=allzero(arr,i,j);
}}
for(i=0;i<a;i++){
 for(j=0;j<k;j++)
printf("%d ",arr[i][j]);
printf("\n");}
}
