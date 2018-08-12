#include <stdio.h>

typedef struct{
	int gakuban;
	int kamoku1;
	int kamoku2;
	float heikin;
}gakusei;

int main(void){
	
	int i;
	gakusei ns_2nen[4];
	
	for(i=0;i<4;i++){
		printf("gakuban,kamoku1,kamoku2,heikin\n");
		scanf("%d,%d,%d",&ns_2nen[i].gakuban,&ns_2nen[i].kamoku1,&ns_2nen[i].kamoku2);
	}
	for(i=0;i<4;i++){
		ns_2nen[i].heikin = (ns_2nen[i].kamoku1+ns_2nen[i].kamoku2)/2.0;
	}
	printf("gakuban  heikin\n");
	for(i=0;i<4;i++){
		printf("%d   ",ns_2nen[i].gakuban);
		printf("%.1f\n",ns_2nen[i].heikin);
	}
	
	
	return 0;
}

/*[output]
gcc strucut2.c
./a.out
gakuban,kamoku1,kamoku2,heikin
1732001,54,76
gakuban,kamoku1,kamoku2,heikin
1732002,99,100
gakuban,kamoku1,kamoku2,heikin
1732003,43,78
gakuban,kamoku1,kamoku2,heikin
1732004,99,67
gakuban  heikin
1732001   65.0
1732002   99.5
1732003   60.5
1732004   83.0
*/
