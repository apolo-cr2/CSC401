#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int sortAnalysis(int array[], int n);
void fillArrayRand(int array[], int size);

int main(void){
	printf("Sort Analysis Algorithm\n");
	int size = 2000;		//size. Change to find runtime.
	int array[size];
	fillArrayRand(array,size);
	printf("Array size: %d - Count: %d\n", size, sortAnalysis(array,size));		//calls method
	
	return 0;
}

// sortAnalysis Method
// Input:  array[0...n-1] of n orderable elements
// Output: Total # of key comparisons made
int sortAnalysis(int A[], int n){
	int count = 0;
	for(int i=1; i<=n-1 ; i++){
		int v = A[i];
		int j = i-1;
		while(j>=0 && A[j]>v){
			//wrong count++ location
			A[j+1] = A[j];
			j = j-1;
			count++;	//correct location
		}
		A[j+1] = v;
	}
	// Print test
	//for(int i=0; i<n ; i++){
	//	printf("A[%d]:\t%d\n",i,A[i]);
	//}
	return count;
}

void fillArrayRand(int array[],int size){
	srand(time(0));
	for(int i=0; i<size; i++){
		array[i] = rand();
	}
	return;
}
