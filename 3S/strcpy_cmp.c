#include <stdio.h>
#include <string.h>

#define MAXLEN 64

int main(void){
	char s1[]="Network";
    char s2[MAXLEN],s3[MAXLEN];
	int i;

    for(i=0;s1[i]!='\0';i++){
        s2[i]=s1[i];
    }
	s2[i]=s1[i];
    
    strcpy(s3,s1);

    if(!(strcmp(s2,s3)))printf("s2=s3\n");
	
	return 0;
}
