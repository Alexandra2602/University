#include "coada.h"
#include <stdio.h>
#include <stdlib.h>

void init_queue(t_coada *q, int init_size)
{
    q->data=(int*)malloc(init_size*sizeof(int));//initializeaza componenta sirul de date "data" al structurii de tip coada
    q->head=0;
    q->tail=0;
    q->length=0;
}
void free_queue(t_coada *q)
{
    free(q->data);
    q->data=NULL;
    q->head=q->tail=-1;
}
int queue_empty(t_coada q)
{
    if (q.length==0)
        return 1;//true, the queue is empty
    else return 0;//false
}
void enqueue(t_coada *q, int e)
{
    q->data[q->tail]=e;//se pun elemente incepand cu pozitia 0
    q->length++;
    if(q->tail==q->length)
        q->tail=1;
    else q->tail++;

}
int dequeue(t_coada *q)
{
    int e;//elementul care va fi sters din coada
    e=q->data[q->head];

    //in locul elementului care il sterg pun -1
    q->data[q->head]=-1;

    q->length--;
    if(q->head==q->length)
        q->head=1;
    else q->head++;
    return e;//returneaza elementul sters
}
void print_queue(t_coada q)
{
    int i;
    printf("\nContinut coada:");
    for (i=0;i<20;i++)
    {
        if (q.data[i]>0)
            printf("%d ", q.data[i]);
        else printf("* ");
    }
    printf("\nQ.head este %d, Q.tail este %d iar Q.length este %d\n", q.head, q.tail, q.length);
}
