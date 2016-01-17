#include <stdio.h>
#include <string.h>

char m [1001], t [1001];

int parse (int n)
{
	int s = n+1, b = 0, d = 0;

	n++;		if (m [n] == 'x') b += parse (n);	b++;
	n += b;		if (m [n] == 'x') b += parse (n);	b++;
	n = s + b;	if (m [n] == 'x') d += parse (n);	d++;
	n += d;		if (m [n] == 'x') d += parse (n);	d++;

	strncpy (t, m + s, b);
	strncpy (m + s, m + s + b, d);
	strncpy (m + s + d, t, b);

	return (b + d);
}

int main ()
{
	int t;						scanf ("%d", &t);
	while (t --) {				scanf ("%s", m);
		if (m [0] == 'x') parse (0);
		printf ("%s\n", m);
	}
	return 0;
}
