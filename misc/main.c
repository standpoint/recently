#include <stdio.h>

float farenheit (int C);

int main(){

    int i;

    for (i = 0; i < 10; ++i)
        printf("C = %2d, F = %5.2f\n", i, farenheit(i));
    return 0;

}

float farenheit (int C){

    return 9./5.*C+32;

}
