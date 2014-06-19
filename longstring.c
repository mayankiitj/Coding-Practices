#include<stdio.h>
#include<string.h>
main(){
char a[]="abcdefcbhjklm";
int i,prev,final=0,cur=-1,count=0;
int size=strlen(a);
int b[26];
for(i=0;i<26;i++)
b[i]=-1;
for(i=0;i<size;i++){
if(b[a[i]-97]==-1||b[a[i]-97]<cur)
{ 
  b[a[i]-97]=i;
 
  count++;}
else
{
if(final<count) 
final=count;
count=count-b[a[i]-97];
b[a[i]-97]=i;
cur=i;
}
}
if(final<count) 
final=count;
printf("%d",final);
}
