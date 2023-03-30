#include <stdio.h>
#include <stdlib.h>

int main()
{
    int n,a[100];
    scanf ("%d",&n);
    read_array(a, n);
    //insertion_sort(a,n);
    //merge_sort(a,1,n);
    //quick_sort(a,1,n);
    heap_sort(a,n);
    print_array(a,n);
    return 0;
}
