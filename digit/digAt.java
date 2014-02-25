// !! n>=0 && k>=0
// (12345, 1)->4, (123, 5)->0
int digAt(long n, int i) {
	while (i > 0) {
		n /= 10;
		i--;
	}
	return (int) (n % 10);
}