#include<stdio.h>
main(){
int a=4,b=4,i=0,j=0,mina=0,minb=0,count=0;
int arr[][5]={{1,2,3,4,5},{16,17,18,19,6},{15,24,25,20,7},{14,23,22,21,8},{13,12,11,10,9}};
while(a>=mina&&b>=minb){
if(i==mina&&j==minb)
{for(j=minb;j<=b;j++)
printf("%d ",arr[i][j]);
mina++;
j--;
}
else if(j==b&&i<a)
{for(i=mina;i<=a;i++)
printf("%d ",arr[i][j]);
b--;
i--;
}
else if(a==i&&b==j-1){
for(j=b;j>=minb;j--)
printf("%d ",arr[i][j]);
a--;
j++;
}
else if(i==a+1&&j==minb){
for(i=i-1;i>=mina;i--)
printf("%d ",arr[i][j]);
minb++;
i++;
j++;
}



}


}
