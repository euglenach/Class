#include <stdio.h>

int main(void){
	char text[]="It is good to see to you.Thank you coming.";
	int i=0;

    while(text[i]!='\0'){
        printf("[");
        while(!(text[i]==0x20||text[i]==0x2e)){
            printf("%c",text[i]);
            i++;
        }
        while(text[i]==0x20||text[i]==0x2e)
		i++;//スペース、コロンが何連続でてきても対応するための処理
        printf("]\n");
    }
	
	return 0;
}

/*

[output]

[It]
[is]
[good]
[to]
[see]
[to]
[you]
[Thank]
[you]
[coming]

*/
