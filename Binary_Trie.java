static class Node { Node l, r; int val; }

	static class BinaryTrie
	{
		Node root = new Node();
		
		void update(int x, int d) { update(root, 30, d, x); }
		
		void update(Node cur, int bit, int d, int x)
		{
			cur.val += d;
			if(bit == -1)
				return;
			Node nxt;
			if((x & 1<<bit) == 0)
			{
				nxt = cur.l;
				if(nxt == null)
					nxt = cur.l = new Node();
			}
			else
			{
				nxt = cur.r;
				if(nxt == null)
					nxt = cur.r = new Node();
			}
			update(nxt, bit - 1, d, x);
		}
		
		int query(int x) { return query(root, 30, x, 0); }
		
		int query(Node cur, int bit, int x, int ans)		//empty?? TODO
		{
			if(bit == -1)
				return ans;
			if((x & 1<<bit) == 0)
			{
				//need 1
				if(cur.r != null && cur.r.val > 0)
					return query(cur.r, bit - 1, x, ans<<1|1);
				return query(cur.l, bit - 1, x, ans<<1);
			}
			else
			{
				//need 0
				if(cur.l != null && cur.l.val > 0)
					return query(cur.l, bit - 1, x, ans<<1|1);
				return query(cur.r, bit - 1, x, ans<<1);
			}
		}
	}
