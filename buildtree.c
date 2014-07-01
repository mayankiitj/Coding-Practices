#include<stdio.h>
#include<stdlib.h>
const int SIZE = 5;
int a[] = {1,2,3,4,5};
int arr[][5] =
{{1,0,2,0,4},
 {0,0,0,0,0},
 {0,0,3,0,0},
 {0,0,0,0,0},
 {0,0,0,0,5}};
struct node
{
    int data;
    struct node* left;
    struct node* right;
};

struct node* newnode(int data,int i,int j)
{ //int a=i,b=j;
  int k=binarysrch(i,j,data);
  struct node* nod = (struct node*)malloc(sizeof(struct node));
  nod->data = data;
  if(i<=(k-1))
  nod->left =newnode(arr[i][k-1],i,k-1) ;
 else
  nod->left=NULL;
 if(j>=(k+1)){
   nod->right =newnode(arr[k+1][j],k+1,j) ;
}
else
  nod->right =NULL;
 
  return(nod);
}

int binarysrch(int m,int n,int val){
   int i=m,j=n,mid=0,count=0;
  while(i<=j){
   mid =(i+j)/2;
   if(a[mid]==val)
    return mid;
   else if(a[mid]>val)
    j=mid;
   else if(i==j)
   break;
   else
    i=mid;
   count++;
}
  return 0;

}
main(){
int i=0,j=SIZE-1,len,count,k=0;
struct node *root;
root=newnode(arr[i][j],i,j);
printf("%d",root->left->right->data);
}
