#include <stdio.h>
#include <stdlib.h>

int main(void){
	
	int data[10];
	int i, j, k, min,m, tmp,seed,cnt=0;
	int size=sizeof(data)/sizeof(int);
	
	printf("seed?");
	scanf("%d",&seed);
	srand(seed);
	
	for(i=0;i<size;i++){
		data[i]=rand()%100+1;
		printf("%d ",data[i]);
	}
	printf("\n");
	
	for(i=0;i<size-1;i++){
		min = data[i];
		k=i;
		for(j=i+1;j<size;j++){
			if(data[j]<min){
				min = data[j];
				k=j;
			}
		}
		tmp = data[i];
		data[i] = data[k];
		data[k] = tmp;
		
		for(m=0;m<size;m++){
			printf("%02d ",data[m]);
		}
		cnt++;
		printf("\n");
	}
	
	printf("Count:%d\n",cnt);
	
	
	return 0;
}

/*
seed?10
96 9 79 26 19 78 76 72 48 8 
08 09 79 26 19 78 76 72 48 96 
08 09 79 26 19 78 76 72 48 96 
08 09 19 26 79 78 76 72 48 96 
08 09 19 26 79 78 76 72 48 96 
08 09 19 26 48 78 76 72 79 96 
08 09 19 26 48 72 76 78 79 96 
08 09 19 26 48 72 76 78 79 96 
08 09 19 26 48 72 76 78 79 96 
08 09 19 26 48 72 76 78 79 96 
Count:9
*/