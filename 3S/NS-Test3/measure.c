#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main(void){

    int data[11000];
    int seed,i,j,tmp;
    int size=sizeof(data)/sizeof(int);
    unsigned long int start;
    unsigned long int end;
    unsigned long int elapsed;

    printf("seed?");
    scanf("%d",&seed);
    srand(seed);

    for(i=0;i<size;i++){
		data[i]=rand()%100+1;
	}

    /////////////
    start = clock();

    for(i=0;i<(size-1);i++){
		for(j=(size-1);j>i;j--){
			if(data[j]<data[j-1]){
				tmp = data[j];
				data[j] = data[j-1];
				data[j-1] = tmp;
			}
		}
	}

    end = clock();
    ///////////////

    elapsed = end - start;

    printf("START TIME: %lu\n",start);
    printf("END TIME: %lu\n",end);
    printf("ELAPSED TIME: %lu\n",elapsed);
    

    return 0;
}
