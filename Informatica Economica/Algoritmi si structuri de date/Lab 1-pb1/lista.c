#include "lista.h"
#include <stdlib.h>
#include <stdio.h>

void makenull(t_lista *lista)
{
    // trebuie sa se transmita adresa unei variabile de tipul t_lista
        if (lista != NULL ) lista->head = NULL;
        else printf("Makenull: Eroare, s-a transmis un argument NULL\n");
}

void print(t_lista lista)
{
    t_nod_lista *t = lista.head;
    printf("elementele listei sunt: ");
    while (t != NULL)
    {
        printf("%d ", t->cheie);
        t = t->next;
    }
    printf("\n");
}

int search(t_lista lista, int k, t_nod_lista **retval)
{
    // retval este o variabila de tipul output
    // in retval se incarca pointer catre elementul din lista care contine valoarea cautata
    t_nod_lista *t = lista.head;
    while (t!=NULL && t->cheie != k) t = t->next;
    *retval = t;  // se incarca in retval pointer catre elementul de lista gasit
    if (t != NULL) return 1; // element gasit
    else return 0;
}

int first(t_lista lista, t_nod_lista **retval)
{
    *retval = lista.head;
    if (*retval == NULL) // lista goala
        return 0;
    else return 1;
}

int insert_first(t_lista *lista, t_nod_lista* x)
{
    x->next = lista->head;
    if (lista->head != NULL) lista->head->prev = x;
    lista->head = x;
    x->prev = NULL;
    return 1;
}

int insert_first_cheie(t_lista *lista, int key)
{
    t_nod_lista *x = (t_nod_lista*)malloc(sizeof(t_nod_lista));
    x->cheie = key;
    return insert_first(lista, x);
}

int delete_nod(t_lista *lista, t_nod_lista *x)
{
    if (x->prev != NULL) x->prev->next = x->next;
    else lista->head = x->next;
    if (x->next != NULL) x->next->prev = x->prev;
    return 1;
}

int delete_cheie(t_lista *lista, int k)
{
    t_nod_lista *x;
    int gasit = search(*lista, k, &x);
    if (gasit)
    {
        delete_nod(lista, x); // aici se foloseste elementul x
        free(x);
    }
    return gasit;
}

void elibereaza_memorie(t_lista *lista)
{
    t_nod_lista *t = lista->head;
    while (t!=NULL)
    {
        delete_nod(lista, t);
        free(t);
        t = lista->head;
    }
}
