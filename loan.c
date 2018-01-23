#include <stdio.h>
#include <math.h>
#include <stdlib.h>


struct loan{
    double INTEG;
    double B;
    double P;
}
object[100];

int main(int argc, char *argv[]){
  
    float final, r, p, in, l, c, balance, interest, pay_num, loan;
    
    interest = atoi(argv[2]);
    loan = atoi(argv[1]);
    in = interest/1200;
    pay_num = atoi(argv[3]);
    r = pow(1 + (in), pay_num);
    object[0].B = loan;
    final = loan * ((interest/12/100 * r)/(r - 1));
    printf(" Montly payment should be %.2f\n", final);
    printf("======================AMORTIZATION SCHEDULE=======================\n");
    printf("#\t  Payment\t  Principal\t  Interest\t  Balance\t\n");
    int i;
    for(i = 1; i <= pay_num; i++){
        object[i].INTEG = object[i-1].B * in;
        object[i].P = final - object[i].INTEG;
        object[i].B = object[i-1].B - object[i].P;
        printf("%d \t  %.2f \t  %.2f \t  %.2f  \t  %.2f \t\n", i, final, object[i].P, object[i].INTEG, object[i].B);
    }
    return 0;
}
