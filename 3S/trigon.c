#include <stdio.h>
#include <math.h>

#define PI 3.14159265

double deg2rad(int);

struct trigon{
	double sin;
	double cos;
 	double tan;
};

int main(void){
	
	struct trigon result;
	
	int degree,i;
	double rad;
	FILE *f;
	
	if((f=fopen("result.txt","a"))==NULL){
		printf("Cannot open file:result.txt");
		return -1;
	}
	
	printf("Please Degree\n");
	scanf("%d",&degree);
	
	rad = deg2rad(degree);
	
	result.sin = sin(rad);
	result.cos = cos(rad);
	result.tan = tan(rad);
	
	fprintf(f,"sin%d:%lf\n",degree,result.sin);
	fprintf(f,"cos%d:%lf\n",degree,result.cos);
	if(degree==90||degree==270)
		fprintf(f,"tan%d:Not defined\n",degree);
	else
		fprintf(f,"tan%d:%lf\n",degree,result.tan);
	
	fclose(f);
	
	return 0;
}

double deg2rad(int deg){
	double ra = deg * PI / 180;
	return  ra;
}

[output]

cat result.txt

sin30:0.500000
cos30:0.866025
tan30:0.577350
sin90:1.000000
cos90:0.000000
tan:Not defined
