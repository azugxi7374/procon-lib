void add(int adl, int adr, long x, long k, int l, int si, int len) {
		int r = l + len;
		if (adl <= l && r <= adr) {
			// ok
			segX[si] = (segX[si] + x) % mod;
			segK[si] = (segK[si] + k) % mod;
		} else if (adl < r && l < adr) {
			add(adl, adr, x, k, l, si * 2 + 1, len / 2);
			add(adl, adr, x, k, l + len / 2, si * 2 + 2, len - len / 2);
		}
	}

	void get(int gi, int l, int si, int len) {
		int r = l + len;
		if (l <= gi && gi < r) {
			if (len > 1) {
				get(gi, l, si * 2 + 1, len / 2);
				get(gi, l + len / 2, si * 2 + 2, len - len / 2);
			}
			getX = (getX + segX[si]) % mod;
			getK = (getK + segK[si]) % mod;
		}
	}