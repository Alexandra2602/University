#include <stdio.h>
#include <stdlib.h>
#include "LISTA.h"
void makenull(t_lista *l)
{
    l->head=(t_nod_lista *)malloc(sizeof(t_nod_lista));
    l->head->next=l->head->prev=NULL;
}
void init_hashtable( t_lista t[], int m)
{
    int j;
    for(j=0;j<=m-1;j++)
    {
        makenull(&t[j]);
    }
}
int hash_function(int k,int m)
{
    return k%m;
}
void list_insert(t_lista *l, t_nod_lista *x)
{
    if(x==NULL) return;
    x->next=l->head->next;
    if(l->head->next!=NULL )l->head->next->prev=x;
    l->head->next=x;
    x->prev=l->head;
}
int chained_hash_insert(t_lista t[], int k,int m)
{
    t_nod_lista *x;
    int j=hash_function(k,m);
    x=(t_nod_lista*)malloc(sizeof(t_nod_lista));
    x->cheie=k;
    list_insert(&t[j],x);
    return j;
}
void list_print(t_lista *l)
{
    t_nod_lista *x;
    x=l->head->next;
    if(x==NULL) printf("lista e vida \n");
    while(x!=0)
    {
        printf("%d\n", x->cheie);
        x=x->next;
    }
}
void print_hashtable(t_lista t[], int m)
{
    int j;
    for(j=0;j<=m-1;j++)
    {
        if(t[j].head->next!=NULL)
        {
            printf("t[%d]: ",j);
            list_print(&t[j]);
            printf("\n");
        }
    }
}
t_nod_lista* list_search(t_lista*l, int k)
{
    t_nod_lista *x;
    x=l->head;
    while(x!=0 &&x->cheie!=k)
        x=x->next;
    return x;
}
int chained_hash_search(t_lista t[], int k, int m)
{
    t_nod_lista *x;
    int j;
    j=hash_function(k,m);
    x=list_search(&t[j],k);
    if(x!=0) return j;
    else return -1;
}
void list_delete(t_lista *l, t_nod_lista *x)
{
    if(x->prev!=0) x->prev->next=x->next;
    else l->head->next=x->next;
    if(x->next!=0) x->next->prev=x->prev;
}
int chained_hash_delete(t_lista t[], int k, int m)
{
    int j;
    t_nod_lista *x;
    j=hash_function(k,m);
    x=list_search(&t[j],k);
    if(x!=NULL)
    {
        list_delete(&t[j],x);
        return j;
    }
    else return -1;
}
