#ifndef LISTA_H_INCLUDED
#define LISTA_H_INCLUDED

typedef struct nod_lista
{
    int cheie;
    struct nod_lista *next, *prev;
}t_nod_lista;

typedef struct
{
    t_nod_lista *head;
}t_lista;

void makenull(t_lista *l);
void list_insert(t_lista *l,t_nod_lista *x);
void list_print(t_lista *l);
t_nod_lista* list_search(t_lista*l, int k);
void list_delete(t_lista *l, t_nod_lista *x);

void init_hashtable( t_lista t[], int m);
int hash_function(int k,int m);
int chained_hash_insert(t_lista t[], int k,int m);
void print_hashtable(t_lista t[], int m);
int chained_hash_search(t_lista t[], int k, int m);
int chained_hash_delete(t_lista t[], int k, int m);

#endif // LISTA_H_INCLUDED
