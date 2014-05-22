#include <stdio.h>
#include <stdlib.h>
 

struct node
{
    int data;
    struct node* left;
    struct node* right;
};
struct list{
         struct node *d;
         struct list *next;}*rear, *front;
        typedef struct list list;

struct node *delQueue()
{
      list *temp, *var=rear;
     struct node *k= rear->d;
      if(var==rear)
      {
             rear = rear->next;
             free(var);
      }
      else
      printf("\nQueue Empty");
   return k;
}
void push(struct node  *value)
{
     list *temp;
     temp=(list *)malloc(sizeof(list));
     temp->d=value;
     if (front == NULL)
     {
           front=temp;
           front->next=NULL;
           rear=front;
     }
     else
     {
           front->next=temp;
           front=front->next;
           front->next=NULL;
     }
}

struct node* newNode(int data)
{
  struct node* node = (struct node*)
                       malloc(sizeof(struct node));
  node->data = data;
  node->left = NULL;
  node->right = NULL;
 
  return(node);
}
void inorder(struct node *root)
{
     if(root!=NULL){inorder(root->left);
     printf("%d\n",root->data);
     inorder(root->right);

}}
int height(struct node* node)
{
   if (node==NULL)
       return 0;
   else
   {
     /* compute the height of each subtree */
     int lheight = height(node->left);
     int rheight = height(node->right);
 
     /* use the larger one */
     if (lheight > rheight)
         return(lheight+1);
     else return(rheight+1);
   }
} 
void printGivenLevel(struct node* root, int level)
{
  if(root == NULL)
    return;
  if(level == 1)
    printf("%d ", root->data);
  else if (level > 1)
  {
    printGivenLevel(root->left, level-1);
    printGivenLevel(root->right, level-1);
  }
}

void printLevelOrder(struct node* root)
{
  int h = height(root);
  int i;
  for(i=1; i<=h; i++)
    printGivenLevel(root, i);
}    
 

 int number_root(struct node *root,int k){
 if(root==NULL)
 return k-1;
 else{
 k=number_root(root->left,k+1);
 k=number_root(root->right,k+1);
  }


}
 void bfs(struct node *root){
   struct node *p;
   int h=number_root(root,1);
   
   if(root==NULL){
     return;}

   else{
   push(root);
   while(h>0){
     if(rear->d->left!=NULL)
     push(rear->d->left);
     if(rear->d->right!=NULL)
     push(rear->d->right);
     p=delQueue();
     printf("%d ",p->data);
     h--;
}
}
}

int righttree(struct node *root,int ht,int k){
   if(root==NULL){
   ht=ht-1;
   if(k<ht)
   return ht;
   else
   return k;}
   else{
     //printf("k=%d ht=%d ",k,ht);
     if(k<ht)
     printf("%d ",root->data);
     k=righttree(root->right,ht+1,k);
     k=righttree(root->left,ht+1,k);
    if(k<ht)
   return ht;
   else
   return k;
     }

     }    
int main()
{ int k;
  struct node *root = newNode(4);
  root->left        = newNode(2);
  root->right       = newNode(5);
  root->left->left  = newNode(1);
  root->right->right= newNode(6);
  root->left->right = newNode(3);
  printf("Level Order traversal of binary tree is \n");
  //printLevelOrder(root);
  bfs(root);
  k=righttree(root,1,0);
  printf("\n");
  inorder(root);

  return 0;
}
