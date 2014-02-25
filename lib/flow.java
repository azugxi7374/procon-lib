// /////////////////////////////////////
// flow
// call : flow(start, goal, INF, new boolean[N], cap, nei)
long flow(int idx, int goal, int mf, boolean[] done, int[][] cap, LinkedList<Integer>[] nei) {
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
