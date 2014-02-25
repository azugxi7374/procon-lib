// !! n>=0 !!
// 0->0, 456->400
long highestDigit(long n) {
	long k = 1;
	while (n / k >= 10) {
		k *= 10;
	}
	return k * (n / k);
}