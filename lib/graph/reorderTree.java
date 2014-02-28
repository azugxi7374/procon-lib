// !! par[root] = root !!
// 根→葉で昇順&&自分以下のノードが連番になるよう変換
// O(n)
// (root = i, par[i] <= i で確認済み)
void reorder(int[] par, int[] conv) {
	int n = par.length;

	// root, chlist
	int root = 0;
	Queue<Integer>[] chQ = new ArrayDeque[n];
	for (int i = 0; i < n; i++) {
		chQ[i] = new ArrayDeque<Integer>();
	}
	for (int i = 0; i < n; i++) {
		if (par[i] == i) {
			root = i;
		} else {
			chQ[par[i]].add(i);
		}
	}

	Deque<Integer> S = new ArrayDeque<Integer>();
	int next = 0;
	conv[root] = next++;
	S.push(root);

	while (S.size() > 0) {
		int p = S.peek();
		if (chQ[p].size() == 0) {
			S.pop();
		} else {
			int ch = chQ[p].poll();
			conv[ch] = next++;
			S.push(ch);
		}
	}

	int[] oldpar = Arrays.copyOf(par, par.length);
	for (int i = 0; i < n; i++) {
		par[conv[i]] = conv[oldpar[i]];
	}
}