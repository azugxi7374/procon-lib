import java.util.*;

class Library1 {

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

	// /////////////////////////////////////
	// gcd
	long gcd(long a, long b) {
		if (a % b == 0) {
			return b;
		} else {
			return gcd(b, a % b);
		}
	}

	// /////////////////////////////////////
	// powlong
	// a ^ b % mod
	long powlong(long a, long b, long mod) {
		long ret = 1;
		while (b != 0) {
			if ((b & 1) == 1) {
				ret *= a;
				ret %= mod;
			}
			b >>= 1;
			a = a * a % mod;
		}
		return ret;
	}

	// /////////////////////////////////////
	// maxFlow ...?
	long maxFlow(int idx, int goal, int mf, boolean[] done, int[][] cap, LinkedList<Integer>[] nei) {
		done[idx] = true;
		if (idx == goal) {
			// ok
			return mf;
		} else {
			for (int ni : nei[idx]) {
				long f;
				if (!done[ni] && cap[idx][ni] > 0 && (f = maxFlow(ni, goal, Math.min(mf, cap[idx][ni]), done, cap, nei)) > 0) {
					// ok
					cap[idx][ni] -= f;
					cap[ni][idx] += f;
					return f;
				}
			}
			return 0;
		}
	}
}
