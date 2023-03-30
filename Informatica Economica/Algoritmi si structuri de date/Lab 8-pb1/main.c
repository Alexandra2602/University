#include <stdio.h>
#include <stdlib.h>
#include "greedy.h"
int main()
{
    int sol_rec[100], sol_iter[100],f[100],s[100];
    int n,lenght_sol_it,lenght_sol_rec,i;
    printf("Introduceti nr de activitati: ");
    scanf("%d",&n);
    printf("Introduceti inceputul activitatilor: \n ");
    read_array(s,n);
    printf("Introduceti sfarsitul activitatilor: \n");
    read_array(f,n);
    f[0]=0;
    lenght_sol_rec=recursive_activity_selector(s,f,0,n,sol_rec);
    printf("Solutia recursiva: ");
    print_array(sol_rec, lenght_sol_rec);

    lenght_sol_it=greedy_activity_selector(s,f,n,sol_iter);
    printf ("\nSolutia iterativa: ");
    print_array(sol_iter,lenght_sol_it);
    return 0;
}
