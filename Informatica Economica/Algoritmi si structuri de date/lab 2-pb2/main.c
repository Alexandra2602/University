#include <stdio.h>
#include <stdlib.h>
#include "LISTA.h"
int main()
{
    // j e locatia curenta, k e cheia, m lungimea tabelei
    t_lista t[100];
    int m,k,j;
    printf("Functia de dispersie h(k)=k%m \n");
    printf("Lungimea tabelei de dispersie m= ");
    scanf("%d", &m);
    init_hashtable(t,m);
    printf("Dati numere pana la citirea lui 0 \n");
    printf("k="); scanf("%d",&k);
    while(k!=0)
    {
        j=chained_hash_insert(t,k,m);
        printf("Tabela actualizata: \n");
        print_hashtable(t,m);
        printf("k="); scanf("%d", &k);
    }
    printf("Cautare cheie: ");
    printf("Introduceti cheia elementului pentru cautare: ");
    scanf("%d", &k);
    j=chained_hash_search(t,k,m);
    if(j>-1) printf("Cheia %d gasita la locatia %d\n",k,j);
    else printf("Cheia %d nu a fost gasita \n",k);
    printf("Cheia pentru stergere: ");
    scanf("%d",&k);
    j=chained_hash_delete(t,k,m);
    if(j>-1)
    {
        printf("Cheia %d a fost stearsa de la locatia %d\n",k,j);
        print_hashtable(t,m);
    }
    else printf("Cheia %d nu a fost gasita \n",k);
    return 0;
}
