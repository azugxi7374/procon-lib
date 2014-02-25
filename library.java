
// n>0
// 12345->5
int digLen(long n) {
	int len = 1;
	while (true) {
		if (1 <= n && n < 10) {
			return len;
		}
		len++;
		n /= 10;
	}
}

// (13579,1)->7, n>=0
int digIdx(long n, int k) {
	long a = 1;
	for (int i = 0; i < k; i++) {
		a *= 10;
	}
	return (int) (n / a % 10);
}

// 23456->10000, n>0
long dBase(long n) {
	long ret = 1;
	for (;; ret *= 10) {
		if (1 <= n && n < 10) {
			return ret;
		}
		n /= 10;
		ret *= 10;
	}
}

// a>>b, a<<b
long shift(long a, int b, long base) {
	for (int i = 0; i < b; i++) {
		a *= base;
	}
	for (int i = 0; i < -b; i++) {
		a /= base;
	}
	return a;
}

