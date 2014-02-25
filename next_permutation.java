// ////////////////////////////////////
// next_permutation
boolean next_permutation(int[] p) {
	int n = p.length;
	int i1, i2;
	for (i1 = n - 2; i1 >= 0 && p[i1] > p[i1 + 1]; i1--) {}
	if (i1 == -1) {
		p = null;
		return false;
	}
	for (i2 = n - 1; p[i1] > p[i2]; i2--) {}
	int tmp = p[i1];
	p[i1] = p[i2];
	p[i2] = tmp;
	for (int i = i1 + 1; i < i1 + n - i; i++) {
		int j = i1 + n - i;
		tmp = p[i];
		p[i] = p[j];
		p[j] = tmp;
	}
	return true;
}