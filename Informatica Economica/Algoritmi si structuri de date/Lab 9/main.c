#include <stdio.h>
#include <stdlib.h>
#include <limits.h>


int N;
typedef struct nod_lista{
    enum {white, black, gray} color;
    int d,f;
    int cheie;
    struct nod_lista *next, *prev;
}t_nod_lista;


typedef struct{
    t_nod_lista *head;
}t_lista;

void makenull(t_lista *lista)
{
    lista->head=(t_nod_lista *)malloc(sizeof(t_nod_lista));
    lista->head->next=lista->head->prev=NULL;
}

t_nod_lista *list_search(t_lista lista, int k)
{
    t_nod_lista *x=lista.head->next;
    while(x && (x->cheie!=k))
        x=x->next;
    return x;
}

void list_insert(t_lista *lista, t_nod_lista *x)
{
    if(x==NULL)
        return;
    x->next=lista->head->next;
    if(lista->head->next!=NULL)
        lista->head->next->prev=x;
    lista->head->next=x;
    x->prev=lista->head;
}

void list_delete(t_lista *lista, t_nod_lista *x)
{
    if(x==NULL)
        return;
    if(x->prev!=NULL)
        x->prev->next=x->next;
    else
        lista->head=x->next;
    if(x->next!=NULL)
        x->next->prev=x->prev;
}

void list_print(t_lista lista)
{
    t_nod_lista *x=lista.head->next;
    if(x==NULL)
        printf("Lista vida\n");
    else
        while(x)
        {
            printf("%d", x->cheie);
            x=x->next;
        }
}

void list_free(t_lista *lista)
{
    t_nod_lista *x=lista->head->next;
    while(x)
    {
        list_delete(lista, x);
        free(x);
        x=lista->head->next;
    }
    free(lista->head);
}



void init_lista(t_lista G[], int n)
{
    int i;
    for(i=1;i<=n;i++)
        makenull(&G[i]);
}

void print_lista(t_lista G[], int n)
{
    t_nod_lista *nod;
    int i;
    for(i=1;i<=n;i++)
    {
        nod=G[i].head->next;
        printf("%d: ",i);
        while(nod!=NULL)
        {
            printf("%d", nod->cheie);
            nod=nod->next;
        }
        printf("\n");
    }
}

void print_path(t_lista G[], t_nod_lista *s, t_nod_lista *v)
{
    if(v==s)
        printf("%d",s->cheie);
    else
    {
        if(v->prev==NULL)
            printf("Nu exista cale.");
        else
        {
            print_path(G,s,v->prev);
            printf("%d",v->cheie);
        }
    }
}

void enqueue(t_nod_lista *q[], t_nod_lista *s, int r)
{
        r++;
        q[r]=s;
}

t_nod_lista *dequeue(t_nod_lista *q[], int r)
{
    t_nod_lista *u=q[0];
    int i;
    for(i=0;i<r;i++)
        q[i]=q[i+1];
    r--;
    return u;
}

void breadth_first_search(t_lista G[], int s, int n)
{
    t_nod_lista *q[100], *u, *v,*ns;
    int i, k;
    for(i=1;i<=n;i++)
    {
        u=G[i].head;
        while(u!=NULL)
        {
        if(u->cheie!=s)
        {
            u->color=white;
            u->d=INT_MAX;
            u->prev=NULL;
        }
        u=u->next;
        }
    }
    ns=G[s].head->next;

    ns->color=gray;
    ns->d=0;
    ns->prev=NULL;
    k=1;
	q[k]=ns;
	while (k>0)
	{
		u=q[1];
		for (i=1;i<k;i++)
		    q[i]=q[i+1];
		k--;
		  v=G[u->cheie].head;
		  while (v!=NULL)
		  {
		  	if (v->color==white)
		  	{

		  		v->color=gray;
		  		v->d=u->d+1;
		  		v->prev=u;
		  		k++;
		  		q[k]=v;
			  }
		  	v=v->next;
		  }
		  u->color=black;
		  printf("%d",u->cheie);

	}

}

void dfs_visit(t_lista G[], t_nod_lista *u, int time)
{
    time++;
    u->d=time;
    u->color=gray;
    t_nod_lista *v;
    v=G[u->cheie].head->next;
    while(v!=NULL){
        if(v->color==white)
    {
        v->prev=u;
        printf("%d",v->cheie);
        dfs_visit(G,v,time);
    }
    v=v->next;
    }
    u->color=black;
    time++;
    u->f=time;
}

void depth_first_search(t_lista G[], int n)
{
    int time, i;
    t_nod_lista *u;
    for(i=1;i<=n;i++)
    {
        u=G[i].head;
        while(u!=NULL){
        u->color=white;
        u->prev=NULL;
        u=u->next;
        }
    }
    time=0;
    for(i=1;i<=n;i++)
    {
        u=G[i].head;
        while(u!=NULL){
        if(u->color==white)
            {dfs_visit(G,u,time);
            u=u->next;}
        }
    }
}

void insert_vecini(t_lista G[], int n, int ns)
{
    t_nod_lista *nod;
    int nv;
    printf("Nod sursa %d: ", ns);
    G[ns].head->cheie=ns;
    printf("\nDati vecinii nodului sursa\n");
    do
    {
        printf("    Vecin cu %d: ", ns);
        scanf("%d", &nv);
        if((nv>0) && (nv<=n) && (nv!=ns))
        {
            nod=(t_nod_lista*)malloc(sizeof(t_nod_lista));
            nod->cheie=nv;
            list_insert(&G[ns], nod);
        }
    }while(nv>0);
}

void dfs_visit_top(t_lista G[], t_nod_lista *u, int *time, t_lista topo, int n)
{
    (*time)++;
    u->d=*time;
    u->color=gray;
    t_nod_lista *v;
    v=G[u->cheie].head;
    while(v!=NULL){
        if(v->color==white)
    {
        v->prev=u;
        dfs_visit_top(G,v,time,topo,n);
    }
    v=v->next;
    }
    u->color=black;
    (*time)++;
    u->f=*time;
    list_insert(&topo,u);
}

t_lista top_sort(t_lista G[], int n)
{
    int i,time;
    t_lista topo;
    makenull(&topo);
    t_nod_lista *u;
    for(i=1;i<=n;i++)
    {
        u=G[i].head;
        while(u!=NULL){
        u->color=white;
        u->prev=NULL;
        u=u->next;}
    }
    time=0;
    for(i=1;i<=n;i++)
    {
        u=G[i].head;
        while(u!=NULL){
        if(u->color==white)
            dfs_visit_top(G,u,&time,topo,n);
        u=u->next;}
    }
    return topo;
}

int main()
{
    t_lista G[100];
    t_lista topology;
    int n,i,n1,n2;
    printf("Numar de noduri= ");
    scanf("%d", &n);
    init_lista(G,n);
    for(i=1;i<=n;i++)
        insert_vecini(G,n,i);
    printf("\nLista adiacenta: ");
    print_lista(G,n);
    printf("\nParcurgere in latime: ");
    printf("\nNod de start: ");
    scanf("%d", &n1);
    breadth_first_search(G,n1,n);
    printf("\nCalea cea mai scurta: ");
    printf("\nNod de start: ");
    scanf("%d", &n1);
    printf("\nNod de final: ");
    scanf("%d", &n2);
    print_path(G,G[n1].head,G[n2].head);
    printf("\nParcurgere in adancime: ");
    depth_first_search(G,n);
    printf("\nSortare topologica: ");
    topology=top_sort(G,n);
    list_print(topology);
    return 0;
}
