#include <stdio.h>

int binary(int data[],int size, int n);
void output(int n,int ans);

int main(void){
	int data[]={3,5,6,9,11,14,16,19,21,33};//ソート済み
	int size = sizeof(data)/sizeof(int);
	int n;
	int ans;
	
	printf("Search Number?");
	scanf("%d",&n);
	
	ans = binary(data,size,n);
	
	output(n,ans);
	
	
	return 0;
}

int binary(int data[],int size, int n){
	int left=0;
	int right = size - 1;
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

// [output]
// Search Number?33
// 33 is found in data[9].

// Search Number?12
// 12, is not found.
