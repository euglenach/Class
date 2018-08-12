 
#include <stdio.h>

typedef struct{
	int gakuban;
	int kamoku1;
	int kamoku2;
	float heikin;
}gakusei;

int main(void){
	
	int i,gaku,flag=0,left=0,right,mid;
	gakusei ns_2nen[20];
	FILE *fp;
	fp = fopen("data.txt","r");
	if(fp==NULL){
		printf("File Error.\n");
		return -1;
	}
	for(i=0;i<20;i++){
		fscanf(fp,"%d",&ns_2nen[i].gakuban);
		fscanf(fp,"%d",&ns_2nen[i].kamoku1);
		fscanf(fp,"%d",&ns_2nen[i].kamoku2);
	}
	
	for(i=0;i<20;i++){
		ns_2nen[i].heikin=(ns_2nen[i].kamoku1+ns_2nen[i].kamoku2)/2.0;
	}
	
	printf("Please Gakuban\n");
	scanf("%d",&gaku);
	
	right=19;
	mid = (int)(left+right)/2;
	while(1){
		if(ns_2nen[mid].gakuban==gaku){
			flag=1;
			break;
		}
		
		if(ns_2nen[mid].gakuban<gaku){
 			left=++mid;
		}
		else if(ns_2nen[i].gakuban>gaku){
			right=--mid;
		}
		
		if(left>right)break;
	}
	
	if(flag){
		printf("gakuban   heikin\n");
		printf("%d  %.1f\n",ns_2nen[mid].gakuban,ns_2nen[mid].heikin);
	}else{
		printf("Not Found.\n");
	}
	
	fclose(fp);
	
	return 0;
}



/*
[output]
gcc binary_search3.c
./a.out
Please Gakuban
1732777
gakuban   heikin
1732777  72.0

./a.out
Please Gakuban
1732000
Not Found.

*/
