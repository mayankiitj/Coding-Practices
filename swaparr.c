#include<stdio.h>
main(){
int a[]={1,2,3,4,5,6,7,8,9,10,11,12};
int i,j,k,k1,val,temp,cur;
i=sizeof(a)/sizeof(a[0]);
j=i/3;
for(k=1;k<i;k++){
if(k%3==0)
val=k/3;
else if(k%3==1)
val=j+k/3;
else
val=k/3+(2*j);

if(val>k){
temp=a[val];
a[val]=a[k];
a[k]=temp;

}
else {while(val<k)
{if(val%3==1)
val=val/3+j;
else if(val%3==2)
val=val/3+(2*j);
else 
val=val/3;
}
temp=a[val];
a[val]=a[k];
a[k]=temp;
}

for(k1=0;k1<i;k1++)
printf("%d ",a[k1]);
printf("\n");
}

}
