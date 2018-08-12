#include <stdio.h>

int sum(int,int,int);

struct Score{
    char* code;
    int mid;
    int fin;
    int report;
};

int main(){
    int i,total;
    struct Score nsgroup[6]={{"NS16202",20,40,15},{"NS16303",15,40,30},
                            {"NS16404",10,15,5},{"NS16505",20,25,25},
                            {"NS16606",20,30,10},{"NS16707",30,40,30}};
    
    for(i=0;i<6;i++){
        total = sum(nsgroup[i].mid,nsgroup[i].fin,nsgroup[i].report);
        if(total>=60){
            printf("%s [%d]\n",nsgroup[i].code,total);
        }
    }

    return 0;

}
                        
int sum(int m,int f,int r){
    return m+f+r;
}
