#include <stdio.h> 
#include <math.h>
int main(){
    float final, loan, interest, pay_num, r, p, in, l, c, balance;
    
    
    printf("Enter amount of loan : ");
    scanf("%f", &loan);
    printf("Enter Interest rate per year : ");
    scanf("%f", &interest);
    printf("Enter number of payments : ");
    scanf("%f", &pay_num);
    
    r = pow(1 + (interest/12/100), pay_num);
    balance = loan;
    final = loan * ((interest/12/100 * r)/(r - 1));
    printf(" Montly payment should be %.2f\n", final);
    printf("======================AMORTIZATION SCHEDULE=======================\n");
    printf("#\t  Payment\t  Principal\t  Interest\t  Balance\t\n");
    int i;
    for(i = 1; i <= pay_num; i++){
        in = balance * (interest/12/100);
        p = final - in;
        balance -= final;
        balance += in;
        printf("%d \t  %.2f \t  %.2f \t  %.2f  \t  %.2f \t\n", i, final, p, in, balance);
    }
}
