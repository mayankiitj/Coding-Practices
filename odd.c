#include<stdio.h>
main(){
int a[]={2,2,3,3,3,4,4,4,4,5,5,7,7,7,7,7};
int s =sizeof(a)/sizeof(int);

int res=0,p=a[s-1],k=s,i=0,j=0;
while(--s>0){
p=p^a[s-1];
}

while(p!=0)
{
if(p&1==1)
break;
else
res++;
p=p>>1;
}
while(--k>=0){
if(a[k]>>res&1==1){
i=i^a[k];
}
else{
j=j^a[k];}
}
printf("%d %d ",i,j);
}
