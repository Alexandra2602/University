#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include "sortari.h"

void insertion_sort(int a[],int n)
{
    int j,key,i;
    for(j=2;j<=n;j++)
    {
        key=a[j];
        i=j-1;
        while (i>0 && a[i]>key)
        {
            a[i+1]=a[i];
            i=i-1;
        }
        a[i+1]=key;
    }
}
void merge (int a[], int p,int q, int r)
{
    int left[100],right[100], n1,n2,i,j,k;
    n1=q-p+1;
    n2=r-q;
    for(i=1;i<=n1;i++)
    {
        left[i]=a[p+i-1];
    }
    for(j=1;j<=n2;j++)
    {
        right[j]=a[q+j];
    }
    left[n1+1]=INT_MAX;
    right[n2+1]=INT_MAX;
    i=1;
    j=1;
    for(k=p;k<=r;k++)
    {
        if( left[i]<=right[j])
        {
            a[k]=left[i];
            i=i+1;
        }
        else
        {
            a[k]=right[j];
            j=j+1;
        }
    }
}
void merge_sort(int a[], int p, int r)
{
    int q;
    q=0;
    if(p<r)
    {
        q=(p+r)/2;
        merge_sort(a,p,q);
        merge_sort(a,q+1,r);
        merge(a,p,q,r);
    }
}
int partition(int a[],int p, int r)
{
    int x,i,j,aux;
    x=a[r];
    i=p-1;
    for(j=p;j<=r-1;j++)
    {
        if(a[j]<=x)
        {
            i=i+1;
            aux=a[i];
            a[i]=a[j];
            a[j]=aux;
        }
    }
    a[r]=a[i+1];
    a[i+1]=x;
    return i+1;
}

void quick_sort(int a[],int p, int r)
{
    int q;
    q=0;
    if(p<r)
    {
        q=partition(a,p,r);
        quick_sort(a,p,q-1);
        quick_sort(a,q+1,r);
    }
}
int left(int x)
{
    return 2*x;
}
int right(int x)
{
    return 2*x+1;
}
int heap_size;
void max_heapify(int a[],int x)
{
    int l,r,largest,aux;
    l=left(x);
    r=right(x);
    if(l<=heap_size && a[l]>a[x])
    {
        largest=l;
    }
    else
    {
        largest =x;
    }
    if( r<=heap_size && a[r]>a[largest])
    {
        largest=r;
    }
    if(largest!=x)
    {
        aux=a[x];
        a[x]=a[largest];
        a[largest]=aux;
        max_heapify(a,largest);
    }
}
void build_max_heap(int a[], int n)
{
    int i;
    heap_size=n;
    for(i=n/2;i>=1;i--)
    {
        max_heapify(a,i);
    }
}
void heap_sort(int a[],int n)
{
    int i,aux;
    build_max_heap(a,n);
    for(i=n;i>=2;i--)
    {
        aux=a[1];
        a[1]=a[i];
        a[i]=aux;
        heap_size=heap_size-1;
        max_heapify(a,1);
    }
}
