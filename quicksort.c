#include<stdio.h>
int x []={5,11,6,18,2,5,3,12};
int arr[8];
void swap (int *a, int *b) {
int tmp=*a;
*a=*b;
*b=tmp; }

void partition ( int low, int high) {
int i = low+1, j = high;
int pivot = x[low];
if (low >= high) 
return;

while (i<j) {
  while ((x[i]<pivot) && (i<high)) i++;
  while ((x[j]>=pivot) && (j>low)) j--;
  if (i<j) 
  {  swap (&x[i], &x[j]);
     swap (&arr[i], &arr[j]);
   } }

if (j==high && pivot<arr[j]) {
swap (&x[j], &x[low]);
swap (&arr[i], &arr[j]);

partition ( low, high-1); }
else
if (i==low+1){
partition ( low+1, high);
}
else {
swap (&x[j], &x[low]);
swap (&arr[i], &arr[j]);
partition ( low, j-1);
partition (j+1, high); } }

main()
{
int i,j,k=0,count=0;

for(i=0;i<8;i++){
if(i%2==0)
arr[i]=0;
else
arr[i]=1;
}
partition(0,7);
for(i=0;i<8;i++){
if(arr[i]==0){
k++;
if(count<k)
count=k;
j=x[i];
}
else
k--;
}
printf("%d %d",count,j);

}
