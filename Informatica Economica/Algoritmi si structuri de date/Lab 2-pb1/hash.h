#ifndef HASH_H_INCLUDED
#define HASH_H_INCLUDED
void hash_init(int T[], int m);
int hash_prim(int k, int m);
int hash_probef(int k, int i, int m);
int hash_insert(int T[], int k, int m);
int hash_search(int T[],int k,int m);
int hash_delete(int T[], int k, int m);
void hash_print(int T[],int m);

#endif // HASH_H_INCLUDED
