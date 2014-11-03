#include <stdio.h>

#define MAXLINE 100
#define STARTPOS 8

int getline (char line[], int lim);
void prtline (char outlines[], char inptlines[], int k);

int main()
{
	int len;
	int j = 0;
	char line[MAXLINE];
	char outln[MAXLINE];
	while ((len = getline(line, MAXLINE)) > 0){
		prtline(outln, line, j);
		if (len > STARTPOS)
            j += (len - STARTPOS);
	}
	printf("%s", outln);
return 0;
}

int getline (char s[], int lim)
{
	int i;
	char c;
	for (i = 0; i < lim - 1 && (c = getchar()) != EOF && c != '\n'; ++i)
		s[i] = c;
	if (c == '\n'){
		s[i] = c;
		i++;
	}
	s[i] = '\0';
	return i;
}

void prtline (char outlines[], char inptlines[], int k)
{
	int i;
	i = STARTPOS;

	while ((outlines[k] = inptlines[i]) != '\0'){
        ++i;
        ++k;
	}
	k++;
	outlines[k] = '\n';
}
