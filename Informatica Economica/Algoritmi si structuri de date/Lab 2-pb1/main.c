#include <stdio.h>
#include <stdlib.h>
#include "hash.h"

int main()
{
    int T[10], m,j,k;
    printf("Lungimea tabelei: ");
    scanf("%d", &m);

    hash_init(T,m);
    printf("Dati numere pana la citirea lui 0\n");
    scanf("%d",&k);
    while(k!=0)
    {
        j=hash_insert(T,k,m);
        printf("Cheia inserata la locatia %d\n",j);
        scanf("%d", &k);
    }
    hash_print(T,m);
    printf("Cautare cheie: ");
    scanf("%d",&k);
    j= hash_search(T,k,m);
    if(j>-1) printf("Cheia gasita la locatia %d", j);
    else printf("Cheia nu a fost gasita");
    printf("Stergere cheie: ");
    scanf("%d",&k);
    j=hash_delete(T,k,m);
    if(j>-1)
    {
        printf("Cheia stearsa de la locatia: %d ",j);
        hash_print(T,m);
    }
    else printf("Cheia nu a fost stearsa ");
    return 0;
}
