#include <stdio.h>

int binary(int data[],int size, int n);
void output(int n,int ans);

int main(void){
	int data[20];
	int seed,i,j,tmp,n,ans;
	int size = sizeof(data)/sizeof(int);
	
	printf("seed?");
	scanf("%d",&seed);
	srand(seed);
	
	////////////
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
	///////////
	
	printf("Search Number?");
	scanf("%d",&n);
	
	ans = binary(data,size,n);
	
	output(n,ans);
	
	return 0;
}

int binary(int data[],int size, int n){
	int left=0;
	int right = size;
	int m = (int)(left+right)/2;
	
	while(1){
		if(data[m]==n){
			return m;
		}
		
		if(data[m]<n){
			left=++m;
		}
		else if(data[m]>n){
			right=--m;
		}
		if(left>right)return -1;
	}
}

void output(int n,int ans){
	if(ans==-1)printf("%d, is not found.\n",n);
	else printf("%d is found in data[%d].\n",n,ans);
}

/*
seed?10
96 9 79 26 19 78 76 72 48 8 24 74 29 74 45 82 21 39 72 69 
08 09 19 21 24 26 29 39 45 48 69 72 72 74 74 76 78 79 82 96 
Search Number?69
69 is found in data[10].

seed?20
12 59 98 60 97 82 63 42 41 82 51 25 48 10 45 10 66 8 80 60 
08 10 10 12 25 41 42 45 48 51 59 60 60 63 66 80 82 82 97 98 
Search Number?70
70, is not found.


*/
