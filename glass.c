#include<stdio.h>
int power(int a,int b){
if(a<b)
return -1;
int res=0;
while(a>0){
res=a+res;
a--;}
return res+b;

}
main(){
float vol=0,sum=0,count=0;
int j=0,row,col,i;
scanf("%f",&vol);
scanf("%d %d",&row,&col);
int tot=power(row,col)+1;
float overflow[tot],cont[tot];
for(i=0;i<tot;i++){
overflow[i]=0;
cont[i]=0;
}
if(vol>1)
{cont[0]=1;
overflow[0]=vol-1;
}
else
{cont[0]=vol;
 overflow[0]=0;
}
printf("i=0 j=0 cont=%f flow=%f\n",cont[0],overflow[0]);
vol-=cont[0];
for(i=1;i<=row;i++){

for(j=0;j<i+1;j++){
sum=0;
count++;
if(power(i-1,j)>=0&&overflow[power(i-1,j)]>0){
sum=sum+overflow[power(i-1,j)]/2;
}
if(j-1>=0&&power(i-1,j-1)>=0 && overflow[power(i-1,j-1)]>0 ){
sum=sum+overflow[power(i-1,j-1)]/2;

}
if(sum>1)
{cont[power(i,j)]=1;
 overflow[power(i,j)]=sum-1;
}
else{
cont[power(i,j)]=sum;
overflow[power(i,j)]=0;
}
printf("i=%d j=%d contain=%f flow=%f\n",i,j,cont[power(i,j)],overflow[power(i,j)]);
}

}


}
