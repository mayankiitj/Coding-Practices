#include<stdio.h>
main(){
double a,b,c=0,d;
int i,j;
scanf("%lf",&a);
d=a;
b=(c+d)/2;
while(a-(b*b)>.05||(b*b)-a>.05){
b=(c+d)/2;
if(b*b>a){
d=b;
}
else
c=b;
}
printf("%lf",b);
}
