#include<stdio.h>
#include<stdlib.h>
 struct list{
         int data;
         struct list *next;}*rear, *front,*rear1,*front1;
  typedef struct list node;
  int delQueue()
{
      node *temp, *var=rear;
     int k= rear->data;
      if(var==rear)
      {
             rear = rear->next;
             free(var);
      }
      else
      printf("\nQueue Empty");
   return k;
}
 int delQueue1()
{
      node *temp, *var=rear1;
     int k= rear1->data;
      if(var==rear1)
      {
             rear1 = rear1->next;
             free(var);
      }
      else
      printf("\nQueue Empty");

return k;
}

void push(int value)
{
     node *temp;
     temp=(node *)malloc(sizeof(node));
     temp->data=value;
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
void push1(int value)
{
     node *temp;
     temp=(node *)malloc(sizeof(node));
     temp->data=value;
     if (front1 == NULL)
     {
           front1=temp;
           front1->next=NULL;
           rear1=front1;
     }
     else
     {
           front1->next=temp;
           front1=front1->next;
           front1->next=NULL;
     }
}

 node * createlist()
  {
      int k,n;
      node *p,*head;
      scanf("%d",&n);
      for(k=0;k<n;k++){
         if(k==0)
   {
          head=(node *)malloc(sizeof(node));
          p=head;
    }
         else
   {
          p->next=(node *)malloc(sizeof(node));;
          p=p->next;
   }
    printf("data\n");
    scanf("%d",&p->data);
   }
     p->next=NULL;
     return(head);
   }
 void print(node *head){
    while (head!=NULL){
    printf("%d ",head->data);
    head=head->next;  }
      printf("\n");                 }
 int length (node *head){
    int count=0;
   if(head==NULL)
   return 0;
     while(head!=NULL){
     count++;
     head=head->next;}
   return count;
                       } 
  void sortqueue(int k)
 {    int a,b=0,count=0,i=0;
      node *p;
   
      a=delQueue();
      push1(a);
     
      b=length(rear);
    print(rear1);
    for(count=1;count<b;count++)
            { p=rear; 
         if((p->data)<a){
         a=delQueue();
         push1(a);} 
        else{
          a=delQueue();
          push(a);}
                 
                  }
        if(k==length(rear1)) 
         exit(0);   
       while(rear1!=NULL){
         a=delQueue1();
         push(a);}

     print(rear);
sortqueue(k);
 }
 
 int main(){
    node *head,*p;
push(5);
push(3);
push(9);
push(7);
   // head= createlist();
int a=length(rear);
print(rear);
sortqueue(a);
print(rear1);
             }
