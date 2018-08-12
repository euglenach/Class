#include <stdio.h>
#include <stdlib.h>

int main(void){
	
	int data[10];
	int i, j, k,tmp,seed,cnt=0;
	int size=sizeof(data)/sizeof(int);
	
	printf("seed?");
	scanf("%d",&seed);
	srand(seed);
	
	for(i=0;i<size;i++){
		data[i]=rand()%100+1;
		printf("%d ",data[i]);
	}
	printf("\n");
	
	for(i=1;i<size;i++){
		tmp = data[i];
		for(j=i;j>0&&data[j-1]>tmp;j--){
			data[j]=data[j-1];
		}
		data[j] = tmp;
		for(k=0;k<size;k++){
			printf("%02d ",data[k]);
		}
		printf("\n");
		cnt++;
	}
	
	
	printf("Count:%d\n",cnt);
	
	
	return 0;
}

/*
seed?4
2 84 75 27 64 38 26 64 29 86 
02 84 75 27 64 38 26 64 29 86 
02 75 84 27 64 38 26 64 29 86 
02 27 75 84 64 38 26 64 29 86 
02 27 64 75 84 38 26 64 29 86 
02 27 38 64 75 84 26 64 29 86 
02 26 27 38 64 75 84 64 29 86 
02 26 27 38 64 64 75 84 29 86 
02 26 27 29 38 64 64 75 84 86 
02 26 27 29 38 64 64 75 84 86 
Count:9
*/