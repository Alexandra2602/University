#include <stdio.h>
#include <stdlib.h>
int nr_sol=0;


void Tipareste_Solutie(int x[], int n)
{
    int i,j;
    printf("\n");
    printf("Solutia %d este: \n", nr_sol);
    for(i=1;i<=n;i++)
    {
        for(j=1;j<=n;j++)
        {
            if(x[i]==j) printf("R  ");
            else printf(".  ");
        }
        printf("\n");
    }

}
int Se_Ataca(int x[], int pos)
{
    int i;
    for(i=1;i<=pos-1;i++)
    {
        if (x[i]==x[pos] || abs(x[i]-x[pos])==abs(i-pos)) return 1;
    }
    return 0;
}

void Dame(int x[], int n)
{
    int k,i;
    k=1;
    for(i=1;i<=n;i++)
    {
        x[i]=0;
    }
    while (k>0)
    {
        if(k>n)
        {

            nr_sol=nr_sol+1;
            Tipareste_Solutie(x,n);
            k=k-1;
        }
        else
        {
            x[k]=x[k]+1;
            if(x[k]<=n)
            {
                if (! Se_Ataca(x,k)) k=k+1;
            }
                else
                {
                    x[k]=0;
                    k=k-1;
                }
            }
        }
    }
int main()
{
    int n, x[100];

    printf("Introduceti nr. de dame: ");
    scanf("%d", &n);
    Dame(x,n);
    printf("Nr de solutii este %d\n",nr_sol);
    return 0;
}



