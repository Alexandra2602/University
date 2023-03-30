#include <stdio.h>
#include <stdlib.h>
#include "stiva.h"
int main()
{
    t_stiva s;
    int e=-1;//elementul care se doreste a fi inserat

    printf("\n\tIMPLEMENTARE STIVA CU SIR\n");
    init_stack(&s,10);

    //inserare elemente in stiva prin operatia push()
    while(e!=0)
    {
        printf("\nElementul de inserat (0 pentru oprire):");
        scanf("%d",&e);
        push(&s,e);
        print_stack(s);
    }
    //stergere elemente din stiva prin operatia pop()
    while(!stack_empty(s))
    {
        pop(&s);
        print_stack(s);
    }
    free_stack(&s);
    return 0;
}

