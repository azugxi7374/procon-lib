// if(b>=0) then a<<b else a>>b
long shift(long a, int b, long base) {
	for (int i = 0; i < b; i++) {
		a *= base;
	}
	for (int i = 0; i < -b; i++) {
		a /= base;
	}
	return a;
}