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
          p->next=(node *)malloc(sizeof(node));
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
      printf("\n");                 
}


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
      if(k==0) 
      exit(0);
      a=delQueue();
      push1(a);
  
    b=length(rear);
    for(count=0;count<b;count++)
            { 
         if((rear->data)<(front1->data)){
         a=delQueue();
         push1(a);
       } 
        else{
          a=delQueue();
          push(a);
        
}
                 
                  }
       
   if(length(rear)==0)
    exit(0);      
   while(rear1!=NULL){
         a=delQueue1();
         push(a);
     }
        front1=NULL;
     print(rear);

    sortqueue(k);
 }

void intersectqueue(){
      int i,intsect,k;
      int c=length(rear)-length(rear1);
      for(i=0;i<c;i++)
      rear=rear->next;
      in:  if(rear->data==rear1->data){
      intsect=rear->data;

  while(c>0){
      rear=rear->next;
      rear1=rear1->next;
    if(rear->data!=rear1->data)
     goto in;
     c--;}   }
   else
     {rear=rear->next;
      rear1=rear1->next;
     goto in;
      }
       printf("%d",intsect);
}


void circle(node *p){
   node *q,*r;
   q=p;
   r=p;
   while(q->next!=NULL&&r->next!=NULL){
       if(q->next==r->next->next){
        printf("Cycle exists\n");
        exit(0);}
     q=q->next;
     r=r->next->next;
      }
   printf("Doesn't exist\n");
} 

void pairswap(node *head){
   node *p,*q,*temp,*k;
   p=head;
   q=head->next;
   head=head->next;
   while(q->next!=NULL&&p->next!=NULL){
     temp=q->next;
     q->next=p;
     p->next=temp;

     temp=p;
     p=p->next;
     if(p->next!=NULL){
           q=p->next;
           temp->next=q;}
   }
  if(p->next!=NULL){
     q->next=p;
     p->next=NULL;}

  print(head);
}

int addlist(node *p,node *q,int k){
   int carry=0;

   if(k>0&&p->next!=NULL&&q->next!=NULL)
    carry=addlist(p->next,q,k-1);
  else if(p->next!=NULL&&q->next!=NULL&&k<=0){
    carry=addlist(p->next,q->next,k-1);
  }
  if(k<=0){
   printf("%d",(p->data+q->data+carry)%10);
   return (p->data+q->data+carry)/10;}
  else{
   printf("%d",(p->data+carry)%10);
   return (p->data+carry)/10;}

}
node* reverse(node *head)
{
  node *p,*q,*r,*temp;
  int c=0;
  p=NULL;
  q=head;
  r=head->next;
  while(r!=NULL&&q->next!=NULL){
    temp=p;
    p=q;
    if(p==NULL){
         p->next=NULL;
               }
    else
         p->next=temp;

    q=r;
   if(r->next!=NULL)
   {
       r=r->next;
   }


  }
  q->next=p;
  return q;
}

node *getmid(node *head,int a){
node *p=head;
while(a>1){
p=p->next;
a--;
}

return p;
}

node *alternate(node *p,node *q){
node *head,*tail,*ret=q;
while(q->next!=NULL){
head=q->next;
tail=p;
q->next=p;
p=p->next;
tail->next=head;
q=head;
}
if(p!=ret){
q->next=p;
p->next=NULL;}
return ret;
}
node *subtract(node *p,node* q){
   if(p==NULL)
      return q;
   else
     q= subtract(p->next,q);
   if(length(p)<=length(q))
   q->data= p->data-q->data ;
   return q->next;
}
int main(){
    node *head,*p,*mid;
    int i,j,a;

	push(7);
	push(9);
	push(5);
	push(3);
	push(4);

	push1(8);
	push1(3);
	push1(4);
	push1(6);
	i=length(rear);
	j=length(rear1); 
	//if(i-j>=0)
	//a=addlist(rear,rear1,i-j);
	//else
	//a=addlist(rear1,rear,j-i);
	//if(a>0)
	//printf("%d",a);
	head= createlist();
	i=length(head);
	//p=getmid(head,i/2);
	//mid=p->next;
	//mid=reverse(mid);
	//p->next = mid;
	//print(head);
	//head=alternate(head,mid);
	p=subtract(head,head);
	print(head);
	//head->next->next->next->next->next=head->next;
	//circle(head);
	//pairswap(head);
	//int a=length(rear);
	//print(rear);
	//sortqueue(a);
	//print(rear1);
	//intersectqueue();

             }

