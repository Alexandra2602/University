#include <stdio.h>
#include <stdlib.h>

typedef struct nod_arb{
    int key;
    struct nod_arb *left, *right, *parent;
}t_nod_arb;

typedef struct{
    t_nod_arb *root;
}t_arbore;

t_nod_arb *make_root(t_arbore *a, int key)
{
    a->root=(t_nod_arb*)malloc(sizeof(t_nod_arb));
    a->root->key=key;
    a->root->left=NULL;
    a->root->right=NULL;
    a->root->parent=NULL;
    return a->root;
}
t_nod_arb *create_node(int key)
{
 t_nod_arb *n=(t_nod_arb*)malloc(sizeof(t_nod_arb));
 n->key=key;
 n->left=NULL;
 n->right=NULL;
 n->parent=NULL;
 return n;
}
void inorder_walk(t_nod_arb *root)
{
    if (root !=0)
    {
        inorder_walk(root->left);
        printf("%d ",root->key);
        inorder_walk(root->right);
    }
}
void postorder_walk(t_nod_arb *root)
{
    if (root!=0)
    {
        postorder_walk(root->left);
        postorder_walk(root->right);
        printf("%d ",root->key);
    }
}
void preorder_walk(t_nod_arb *root)
{
    if (root!=0)
    {
        printf("%d ", root->key);
        preorder_walk(root->left);
        preorder_walk(root->right);
    }
}
t_nod_arb *tree_min(t_nod_arb *n)
{
    while(n->left !=0) n=n->left;
    return n;
}
t_nod_arb *tree_max(t_nod_arb *n)
{
    while (n->right!=0) n=n->right;
    return n;
}
t_nod_arb *tree_succesor(t_nod_arb *n)
{
    t_nod_arb *y;
    if (n->right!=NULL) return tree_min(n->right);
    y=n->parent;
    while (y!=NULL && n==y->right)
    {
        n=y;
        y=y->parent;
    }
    return y;
}
void tree_insert(t_arbore *a,t_nod_arb *n)
{
    t_nod_arb *y; t_nod_arb *x;
    y=NULL;
    x=a->root;
    while(x!=0)
    {
        y=x;
        if( n->key <x->key) x=x->left;
        else x=x->right;
    }
    n->parent=y;
    if(y==NULL) a->root=n;
    else if (n->key< y->key) y->left=n;
    else y->right=n;
}
t_nod_arb *tree_search(t_nod_arb *n,int key)
{
    if (n==NULL || key==n->key) return n;
    if (key<n->key) return tree_search(n->left, key);
    else return tree_search(n->right, key);
}
int it_tree_search(t_nod_arb *n, int key)
{
    while(n!=NULL && key!=n->key)
    {
        if(key< n->key) n=n->left;
        else n=n->right;
    }
    return n;
}
void transplant(t_arbore *a, t_nod_arb *u, t_nod_arb *v)
{
    if (u->parent==NULL) a->root=v;
    else if (u==u->parent->left) u->parent->left=v;
    else u->parent->right=v;
    if (v!=NULL) v->parent=u->parent;
}

void tree_delete(t_arbore *a, t_nod_arb *n)
{
    t_nod_arb *y;
    if (n->left==NULL) transplant(&a,n,n->right);
    else if (n->right==NULL) transplant(a, n, n->right);
    else
    {
        y=tree_min(n->right);
        if(y->parent!=n)
        {
            transplant(a, y,y->right);
            y->right=n->right;
            y->right->parent=y;
        }
        transplant(a,n,y);
        y->left=n->left;
        y->left->parent=y;
    }
}

int main()
{
    t_arbore *t;
    t_nod_arb *n; t_nod_arb *r; t_nod_arb *s;
    int x;
    printf("Nodul radacina cu cheia x= ");
    scanf("%d", &x);
    r=make_root(&t,x);
    printf("Introduceti x pana la citirea lui 0: \n");
    printf("x= ");
    scanf("%d",&x);
    while(x!=0)
    {
        n=create_node(x);
        tree_insert(&t,n);
        scanf("%d", &x);
    }
    printf(" In-order-walk: \n");
    inorder_walk(r);
    printf("\n Pre-order-walk \n");
    preorder_walk(r);
    printf("\n Post-order-walk \n");
    postorder_walk(r);
    printf("\n");
    printf(" Regasire nod cu cheia x= ");
    scanf("%d",&x);
    n=it_tree_search(r,x);
    if (n!=NULL) printf("Nodul cu cheia %d a fost gasit iterativ \n", n->key);
    else printf("Nodul nu a fost gasit iterativ\n ");
    n=tree_search(r,x);
    if (n!=NULL) printf("Nodul cu cheia %d a fost gasit recursiv \n", n->key);
    else printf("Nodul nu a fost gasit recursiv \n");
    n=tree_min(r);
    printf("\nTree minimum= %d", n->key);
    n=tree_max(r);
    printf("\nTree maximum= %d", n->key);
    printf("\nSuccesorul lui x= ");
    scanf("%d", &x);
    n=tree_search(r,x);
    s=tree_succesor(n);
    if (s!=NULL) printf("Nodul succesor: %d \n", s->key);
    else printf("NULL \n");
    printf("Stergere nod cu cheia x= \n");
    scanf("%d", &x);
    n=tree_search(r,x);
    if(n!=NULL)
    {
        tree_delete(t,n);
        printf("Nod sters \n");
        inorder_walk(t);
    }
    else printf("\n Nod negasit !");
    return 0;
}
