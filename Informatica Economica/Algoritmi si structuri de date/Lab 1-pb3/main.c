#include <stdio.h>
#include <stdlib.h>
#include "coada.h"
int main ()
{
    t_coada q;
    //variabila "e" -> elementul care se doreste a fi inserat in coada
    //valoare initiala -1 ->coada este goala
    int e;
    int s=-1;
    printf("\n\t IMPLEMENTARE COADA CU SIR\n");
    init_queue(&q,10);
    while (s)
    {
        printf("\nMeniu principal\n");
        printf("1-pt inserare\n");
        printf("2-pt stergere\n");
        printf("3-pt afisare\n");
        printf("0-pt iesire din program\n\n");
        printf("Introduceti optiunea dvs.:");
        scanf("%d", &s);
        switch(s){
            case 1: printf("Element de inserat in coada:");
                    scanf("%d",&e);
                    enqueue(&q, e);
                    break;
            case 2: if(!queue_empty(q))
                        dequeue(&q);
                    break;
            case 3: print_queue(q);
                    break;
        }
    }
    free_queue(&q);
    return 0;
}
