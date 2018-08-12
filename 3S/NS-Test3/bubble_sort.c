#include <stdio.h>
#include <stdlib.h>

int main(void){
	int data[20];
	int seed,i,j,tmp;
	int size=sizeof(data)/sizeof(int);
	
	printf("seed?");
	scanf("%d",&seed);
	srand(seed);
	
	for(i=0;i<size;i++){
		data[i]=rand()%100+1;
		printf("%d ",data[i]);
	}
	
	for(i=0;i<(size-1);i++){
		for(j=(size-1);j>i;j--){
			if(data[j]<data[j-1]){
				tmp = data[j];
				data[j] = data[j-1];
				data[j-1] = tmp;
			}
		}
	}
	printf("\n");
	for(i=0;i<size;i++){
		printf("%02d ",data[i]);
	}
	printf("\n");
	
	return 0;
	
}
