#include <stdio.h>

typedef struct{
	int gakuban;
	int kamoku1;
	int kamoku2;
	float heikin;
}gakusei;

int main(void){
	
	int i,gaku,flag=0;
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
	
	for(i=0;i<20;i++){
		if(ns_2nen[i].gakuban==gaku){
			flag=1;
			break;
		}
	}
	
	if(flag){
		printf("gakuban   heikin\n");
		printf("%d  %.1f\n",ns_2nen[i].gakuban,ns_2nen[i].heikin);
	}else{
		printf("Not Found.\n");
	}
	
	fclose(fp);
	
	return 0;
}

/*
[output]
gcc linear_search3.c
./a.out
Please Gakuban
1732777
gakuban   heikin
1732777  72.0

./a.out

Please Gakuban
1732000
Not Found.
