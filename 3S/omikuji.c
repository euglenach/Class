#include <stdio.h>
#include <stdlib.h>

int fortune(int);

int main(void){
	
	char* result[5]={"Worst luck","Bad luck","Good luck","Better luck","Excellent luck"};
	int seed;
	int kuji;
	
	printf("plz seed\n");
	scanf("%d",&seed);
	
	kuji = fortune(seed);

	printf("%s\n",result[kuji]);
	
	return 0;
}

int fortune(int seed){
	
	int ran;
	srand(seed);
	ran = rand()%100+1;
	
	if(ran<=5)return 4; //大吉
	if(ran<=25)return 3; //中吉
	if(ran<=75)return 2; //吉
	if(ran<=95)return 1; //凶
	if(ran<=100)return 0; //大凶
}

/*[output]

plz seed
1
Bad luck

plz seed
2
Bad luck

plz seed
3
Good luck

plz seed
4
Excellent luck

plz seed
5
Bad luck
*/

