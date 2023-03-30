#include <stdio.h>
#include <stdlib.h>
#include "arbore_rb.h"

int main()
{
    t_rb_arbore *t;
    t_rb_node *n;
    int x;
    printf("Root= ");
    scanf("%d",&x);
    make_root(&t,x);
    printf("Introduceti x pana la scrierea lui 0:  \n");
    printf("x= ");
    scanf("%d", &x);
    while(x!=0)
    {
        n=create_node(x);
        rb_insert(&t,n);
        printf("\n In order walk intermediar: ");
        inorder_walk(t);
        printf("\nx= ");
        scanf("%d", &x);
    }
    printf("In-order walk: ");
    inorder_walk(t);
    printf("\n");

    printf("Cauta nod cu cheia x= ");
    scanf("%d",&x);
    n=tree_search(&t->root,x);
    if (n!=NULL) printf("\n Nodul cu cheia %d a fost gasit", n->key);
    else printf("Nodul nu a fost gasit");

    return 0;
}
