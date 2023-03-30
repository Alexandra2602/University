#include <stdio.h>
#include <stdlib.h>
#include "greedy.h"

int recursive_activity_selector(int s[],int f[],int k, int n, int a[])
{
    static int na=0;
    int m;
    m=k+1;
    while(m<=n && s[m]<f[k])
    {
        m=m+1;
    }
    if(m<=n)
    {
        na=na+1;
        a[na]=m;
        recursive_activity_selector(s,f,m,n,a);
    }
    return na;
}
int greedy_activity_selector(int s[],int f[],int n, int a[])
{
    static int na=0;
    int k=0,m;
    for(m=1;m<=n;m++)
    {
        if (s[m]>f[k])
        {
            na=na+1;
            a[na]=m;
            k=m;
        }
    }
    return na;
}
void read_array(int v[],int n)
{
    int i;
    for(i=1;i<=n;i++)
        scanf("%d", &v[i]);
}
void print_array(int v[],int n)
{
    int i;
    for(i=1;i<=n;i++)
        printf("%d ",v[i]);
}

