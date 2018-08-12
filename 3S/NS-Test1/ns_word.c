#include <stdio.h>

int main(void){
	char text[1000];
    FILE *f1,*f2;
	int i=0,j=0;
    int printCnt=0;

    f1 = fopen("NS.txt","r");
    f2 = fopen("word.txt","w");
    if(f1==NULL||f2==NULL){  //例外処理
        printf("Can not open file.");
        return -1;
    }

    while((text[j]=fgetc(f1))!=EOF)j++;  //text配列にNS.txtの内容の入れる
    text[j]='\0';  //配列の最後にヌル文字をいれる

    while(text[i]!='\0'){
        fprintf(f2,"[");
        while(!(text[i]==' '||text[i]=='.'||text[i]==','||text[i]=='\n')){  //こいつらがくるまで文字を表示
            fprintf(f2,"%c",text[i]);
            i++;
        }
        while(text[i]==' '||text[i]=='.'||text[i]==','||text[i]=='\n')　　//連続でこいつらがきても良いように
		i++;
        
        printCnt++; //単語を表示した回数

        fprintf(f2,"]");
        if(printCnt>=5){  //単語を5回表示したら改行
            fprintf(f2,"\n");
            printCnt=0;
        }
    }
	
    fclose(f1);
    fclose(f2);
	return 0;
}
