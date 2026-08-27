#include <stdio.h>

void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

void broken_swap(int a, int b) {
    // This doesn't swap the caller's variables.
    // 'a' and 'b' here are local copies
    // so swapping them only changes the copies, not the
    // original variables back in main() no pointers means
    // no access to the original memory addresses
    int temp = a;
    a = b;
    b = temp;
}

int main() {
    int x = 10, y = 20;

    printf("Before swap: x = %d, y = %d\n", x, y);
    swap(&x, &y);
    printf("After swap: x = %d, y = %d\n", x, y);

    printf("\nCalling broken_swap...\n");
    broken_swap(x, y);
    printf("After broken_swap: x = %d, y = %d\n", x, y);

    return 0;
}