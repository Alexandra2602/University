#ifndef STIVA_H_INCLUDED
#define STIVA_H_INCLUDED

typedef struct stiva {
    int top;
    int *data;
}t_stiva;

void init_stack(t_stiva *s, int init_size);
void free_stack(t_stiva *s);
int stack_empty(t_stiva s);
void push(t_stiva *s, int e);
int pop(t_stiva *s);
void print_stack(t_stiva s);


#endif // STIVA_H_INCLUDED
