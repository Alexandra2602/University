#ifndef LISTA_H_INCLUDED
#define LISTA_H_INCLUDED

typedef struct nod_lista {
    int cheie;
    struct nod_lista *next, *prev;
} t_nod_lista;

typedef struct {
    t_nod_lista *head;
} t_lista;

void makenull(t_lista *lista);
int first(t_lista lista, t_nod_lista **retval);
void print(t_lista lista);
int search(t_lista lista, int k, t_nod_lista **retval);
int insert_first(t_lista *lista, t_nod_lista *x);
int insert_first_cheie(t_lista *lista, int key);
int delete_nod(t_lista *lista, t_nod_lista *x);
int delete_cheie(t_lista *lista, int k);
void elibereaza_memorie(t_lista *lista);


#endif // LISTA_H_INCLUDED
