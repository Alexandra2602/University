#include <stdio.h>
#include <stdlib.h>
#include "hash.h"

void hash_init(int T[], int m)
{
    int j;
    for(j=0;j<=m-1;j++) T[j]=-1;
}
int hash_prim(int k, int m)
{
    return k%m;
}
int hash_probef(int k, int i, int m)
{
    return (hash_prim(k,m)+i)%m;
}
int hash_insert(int T[], int k, int m)
{
    int j,i=0;
    do
    {
        j=hash_probef(k,i,m);
        if (T[j]==-1)
        {
            T[j]=k;
            return j;
        }
        else i=i+1;

    }while (i!=m);
     return -1;
}
int hash_search(int T[],int k,int m)
{
    int j,i=0;
    do
    {
        j=hash_probef(k,i, m);
        if (T[j]==k) return j;
        i=i+1;
    }while(i!=m && T[j]!=-1);
    return -1;
}
int hash_delete(int T[], int k, int m)
{
    int j;
    j=hash_search(T, k,m);
    if(j>-1)
    {
        T[j]=-1;
        return j;
    }
    else return -1;
}
void hash_print(int T[],int m)
{
    int j;
    for(j=0;j<=m-1;j++) printf("%d", T[j]);
}

