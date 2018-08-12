#include <stdio.h>

int linear(int data[],int size,int n);

void output(int n,int ans);

int main(void){
	
	int data[]={3,9,8,2,1,4,6,5,7};
	int size = sizeof(data)/sizeof(int);
	int n;
	int ans;
	
	printf("Seach Number?");
	scanf("%d",&n);
	
	ans = linear(data,size,n);
	
	output(n,ans);
	
	return 0;
}

int linear(int data[],int size,int n){
	int i;
	
	for(i=0;i<size;i++){
		if(data[i]==n){
			return i;
		}
	}
	
	return -1;
}

void output(int n,int ans){
	if(ans==-1)printf("%d, is not found.\n",n);
	else printf("%d is found in data[%d].\n",n,ans);
}
