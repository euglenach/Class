#include <stdio.h>
 
int main(void){
 
    int a, b, r;
 
    scanf("%d,%d",&a,&b);

    if(a<b){
        printf("a<b");
        return -1;
    }
 

    r=a%b;
    while(r!=0){
        a=b;
        b=r;
        r=a%b;
        printf("a=%d,b=%d,r=%d\n",a,b,r);
    }
 
    printf("GCM:%d\n", b);
 
    return 0;
}
