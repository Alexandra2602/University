#include <stdlib.h>
#include <stdio.h>
#include "stiva.h"

void init_stack(t_stiva *s, int init_size)
{
    //initializeaza componenta sirul de date "data" al structurii de tip stiva
    s->data=(int*)malloc(init_size*sizeof(int));
    s->top=0;//initial nu exista niciun element in stiva
}
void free_stack(t_stiva *s)
{
    free(s->data);
    s->data=NULL;
    s->top=-1;
}
void push(t_stiva *s, int e)
{
    s->top=s->top+1;
    s->data[s->top]=e;
}
void print_stack(t_stiva s)
{
    int i;
    if (!stack_empty(s))
     {

            printf("\nContinut stiva:");
            for(i=1;i<=s.top;i++)
            printf("%d ",s.data[i]);
     }
}
int stack_empty(t_stiva s)
{
    if(s.top==0)
        return 1;
    else return 0;
}
int pop(t_stiva *s)
{
    int e;
    if (stack_empty(*s))
    {
        printf("The stack is empty!\n");
        return -1;
    }
    else
    {
        e=s->data[s->top];
        s->data[s->top]=0;
        s->top=s->top-1;
        //pop() returneaza elementul care se sterge din stiva
        return e;
    }
}
