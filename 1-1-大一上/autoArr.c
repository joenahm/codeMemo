int* arr(int uIn){
	int *b=0;
	static int *a=0;
	static int i=0;
	static int j=0;

	if(!i){
		a=(int*)malloc(sizeof(int));
	}
	a[i]=uIn;
	b=(int*)malloc((i+1)*sizeof(int));
	for(j=0;j<=i;j++){
		b[j]=a[j];
	}
	free(a);
	i++;
	a=(int*)malloc((i+1)*sizeof(int));
	for(j=0;j<i;j++){
		a[j]=b[j];
		a[j+1]='\0';
	}
	free(b);
	return a;
}