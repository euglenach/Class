#include <stdio.h>
#include <string.h>
//MY NUMBER IS 1732118.

int main(void){

    int i,cnt=0;
    char str[]="A0B1C2D3E4F5G6H7I8J9K";

    for(i=0;str[i]!='\0';i++){
        if(str[i]=='8'){
            printf("%c %c",str[i-1],str[i+1]);
            break;
        }
    }

    return 0;

}
