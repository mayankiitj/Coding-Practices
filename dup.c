 #include<stdio.h>
 #include<string.h>
 main(){
 int i,j,k,m;
  scanf("%d",&i);
 int arr[100],count=0;
  for(j=0;j<100;j++)
   arr[j]=0;
 char s[i][10];
  for(j=0;j<i;j++){
   scanf("%s",s[j]);
}
 for(j=0;j<i;j++){
  for(k=0;k<strlen(s[j]);k++){
     if(arr[s[j][k]]==1){
count++;}
arr[s[j][k]]++;
}
printf("%d\n",count);
count=0;
 for(m=0;m<100;m++)
   arr[m]=0;
}
}

